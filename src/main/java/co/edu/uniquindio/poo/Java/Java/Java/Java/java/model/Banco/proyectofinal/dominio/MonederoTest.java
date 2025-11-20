package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.SaldoInsuficienteException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoMonedero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonederoTest {

    @Test
    void testDepositarMontoValido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        monedero.depositar(500);
        assertEquals(500, monedero.getSaldo());
    }

    @Test
    void testDepositarMontoInvalido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        assertThrows(MontoInvalidoException.class, () -> monedero.depositar(0));
        assertThrows(MontoInvalidoException.class, () -> monedero.depositar(-100));
    }

    @Test
    void testRetirarMontoValido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        monedero.depositar(300);
        monedero.retirar(200);
        assertEquals(100, monedero.getSaldo());
    }

    @Test
    void testRetirarMontoInvalido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        assertThrows(MontoInvalidoException.class, () -> monedero.retirar(0));
        assertThrows(MontoInvalidoException.class, () -> monedero.retirar(-50));
    }

    @Test
    void testRetirarSaldoInsuficiente() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero monedero = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        monedero.depositar(100);
        assertThrows(SaldoInsuficienteException.class, () -> monedero.retirar(200));
    }

    @Test
    void testTransferenciaEntreMonederos() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero origen = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        Monedero destino = new Monedero("Inversion", TipoMonedero.INVERSION, cuenta);
        origen.depositar(300);
        origen.transferirEntreMonederos(destino, 200);
        assertEquals(100, origen.getSaldo());
        assertEquals(200, destino.getSaldo());
    }

    @Test
    void testTransferenciaDestinoNulo() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero origen = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        origen.depositar(200);
        assertThrows(IllegalArgumentException.class, () -> origen.transferirEntreMonederos(null, 50));
    }

    @Test
    void testTransferenciaMontoInvalido() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero origen = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        Monedero destino = new Monedero("Inversion", TipoMonedero.INVERSION, cuenta);
        origen.depositar(200);
        assertThrows(MontoInvalidoException.class, () -> origen.transferirEntreMonederos(destino, 0));
        assertThrows(MontoInvalidoException.class, () -> origen.transferirEntreMonederos(destino, -30));
    }

    @Test
    void testTransferenciaSaldoInsuficiente() {
        CuentaVirtual cuenta = new CuentaVirtual("123", 1000);
        Monedero origen = new Monedero("Ahorros", TipoMonedero.AHORRO, cuenta);
        Monedero destino = new Monedero("Inversion", TipoMonedero.INVERSION, cuenta);
        origen.depositar(50);
        assertThrows(SaldoInsuficienteException.class, () -> origen.transferirEntreMonederos(destino, 200));
    }
}