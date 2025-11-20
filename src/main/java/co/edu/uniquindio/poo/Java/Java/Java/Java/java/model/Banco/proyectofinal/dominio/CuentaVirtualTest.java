package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.SaldoInsuficienteException;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoMonedero;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transferencia;


import static org.junit.jupiter.api.Assertions.*;

class CuentaVirtualTest {

    
    @Test
    void testAgregarMonedero() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("DNJSNDKAJ", TipoMonedero.AHORRO, cuenta);
        cuenta.agregarMonedero(monedero);
        assertEquals(1, cuenta.getListaMonederos().size());
        assertTrue(cuenta.getListaMonederos().contains(monedero));
    }

    @Test
    void testDepositarMontoValido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        cuenta.depositar(500);

        assertEquals(1500, cuenta.getSaldo());
    }

    @Test
    void testDepositarMontoInvalido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);

        assertThrows(MontoInvalidoException.class, () -> cuenta.depositar(0));
        assertThrows(MontoInvalidoException.class, () -> cuenta.depositar(-50));
    }

    @Test
    void testRetirarMontoValido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        cuenta.retirar(300);

        assertEquals(700, cuenta.getSaldo());
    }

    @Test
    void testRetirarMontoInvalido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);

        assertThrows(MontoInvalidoException.class, () -> cuenta.retirar(0));
        assertThrows(MontoInvalidoException.class, () -> cuenta.retirar(-10));
    }

    @Test
    void testRetirarSaldoInsuficiente() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);

        assertThrows(SaldoInsuficienteException.class, () -> cuenta.retirar(2000));
    }

    @Test
    void testRegistrarTransaccion() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        CuentaVirtual cuenta2 = new CuentaVirtual("456", 2000);
        Transferencia t = new Transferencia(cuenta, cuenta2, 500);
        cuenta.registrarTransaccion(t);
        assertEquals(1, cuenta.getListaTransacciones().size());
        assertTrue(cuenta.getListaTransacciones().contains(t));
    }
}
