package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Deposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTransaccionTest {

    @Test
    void testEjecutarTransaccion() {

        // Gestor
        GestorTransaccion gestor = new GestorTransaccion();

        // Datos reales
        Cliente cliente = new Cliente("123", "Juan Perez", "Calle Falsa", "juan@gmail.com",
        LocalDate.of(2000, 2, 10), "111", null);

        CuentaVirtual cuenta = new CuentaVirtual("CV001", 4000);

        // Transacción real
        Deposito deposito = new Deposito(cuenta, 100);

        // Ejecutar
        boolean resultado = gestor.ejecutarTransaccion(deposito, cliente);

        // Verificaciones mínimas reales
        assertTrue(resultado);
        assertEquals(100, cuenta.getSaldo());
        assertEquals(1, gestor.getListaTransacciones().size());
    }

    @Test
    void testOrdenarPorFecha() {
        GestorTransaccion gestor = new GestorTransaccion();

        List<TransaccionProgramada> lista = new ArrayList<>();

        CuentaVirtual cuenta1= new CuentaVirtual("CV01", 40);

        CuentaVirtual cuenta = new CuentaVirtual("CV01", 100);

        TransaccionProgramada t1 =
                new TransaccionProgramada(cuenta, cuenta1, 5000, LocalDate.of(2025, 5, 10), false, 2, TipoTransaccion.TRANSFERENCIA);

        TransaccionProgramada t2 =
                new TransaccionProgramada(cuenta, null, 1000, LocalDate.of(2025, 1, 1), false, 2, TipoTransaccion.RETIRO);

        TransaccionProgramada t3 =
                new TransaccionProgramada(null, cuenta, 1000, LocalDate.of(2025, 12, 15), false, 2, TipoTransaccion.DEPOSITO);

        lista.add(t1);
        lista.add(t2);
        lista.add(t3);

        List<TransaccionProgramada> ordenada = gestor.ordenarPorFecha(lista);

        assertEquals(t2, ordenada.get(0)); // la más antigua
        assertEquals(t1, ordenada.get(1));
        assertEquals(t3, ordenada.get(2));
    }
}