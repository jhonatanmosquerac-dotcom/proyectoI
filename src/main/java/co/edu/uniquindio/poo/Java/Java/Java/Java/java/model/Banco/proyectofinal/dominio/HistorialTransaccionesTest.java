package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transferencia;

public class HistorialTransaccionesTest {
    @Test
    void testRegistrar() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        CuentaVirtual cuenta2 = new CuentaVirtual("456", 2000);
        Transferencia t = new Transferencia(cuenta, cuenta2, 500);
        HistorialTransacciones historial = new HistorialTransacciones();
        historial.registrar(t);
        assertEquals(1, historial.getListaTransacciones().size());
        assertTrue(historial.getListaTransacciones().contains(t));
    }
}
