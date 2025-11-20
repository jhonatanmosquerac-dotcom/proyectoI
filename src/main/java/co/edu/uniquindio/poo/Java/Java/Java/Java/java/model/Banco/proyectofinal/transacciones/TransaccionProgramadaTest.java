package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TransaccionProgramadaTest {

    private CuentaVirtual cuentaOrigen;
    private CuentaVirtual cuentaDestino;
    private LocalDate fechaFutura;
    private LocalDate fechaPasada;

    @BeforeEach
    void setUp() {
        cuentaOrigen = new CuentaVirtual("001", 1000.0);
        cuentaDestino = new CuentaVirtual("002", 500.0);
        fechaFutura = LocalDate.now().plusDays(5);
        fechaPasada = LocalDate.now().minusDays(1);
    }

    @Test
    void testConstructorTransaccionProgramada() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, fechaFutura,
                true, 7, TipoTransaccion.TRANSFERENCIA
        );

        assertNotNull(transaccion);
        assertEquals(fechaFutura, transaccion.getFechaEjecucion());
        assertTrue(transaccion.isRecurrente());
        assertEquals(7, transaccion.getFrecuenciaDias());
        assertEquals(TipoTransaccion.TRANSFERENCIA, transaccion.getTipoTransaccion());
        assertFalse(transaccion.isEjecutada());
    }

    @Test
    void testEjecutarTransferenciaFechaFutura() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, fechaFutura,
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        boolean resultado = transaccion.ejecutar();

        assertFalse(resultado);
        assertFalse(transaccion.isEjecutada());
        assertEquals(1000.0, cuentaOrigen.getSaldo());
        assertEquals(500.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarTransferenciaFechaPasada() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, fechaPasada,
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertTrue(transaccion.isEjecutada());
        assertEquals(900.0, cuentaOrigen.getSaldo());
        assertEquals(600.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarTransferenciaFechaActual() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 200.0, LocalDate.now(),
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertTrue(transaccion.isEjecutada());
        assertEquals(800.0, cuentaOrigen.getSaldo());
        assertEquals(700.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarDepositoFechaPasada() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                null, cuentaDestino, 150.0, fechaPasada,
                false, 0, TipoTransaccion.DEPOSITO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertTrue(transaccion.isEjecutada());
        assertEquals(650.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarRetiroFechaPasada() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, null, 100.0, fechaPasada,
                false, 0, TipoTransaccion.RETIRO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertTrue(transaccion.isEjecutada());
        assertEquals(900.0, cuentaOrigen.getSaldo());
    }

    @Test
    void testEjecutarTransaccionYaEjecutada() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, fechaPasada,
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        transaccion.ejecutar();
        boolean resultadoSegundaEjecucion = transaccion.ejecutar();

        assertFalse(resultadoSegundaEjecucion);
        assertEquals(900.0, cuentaOrigen.getSaldo());
        assertEquals(600.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarTransferenciaSaldoInsuficiente() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 1500.0, fechaPasada,
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        boolean resultado = transaccion.ejecutar();

        assertFalse(resultado);
        assertFalse(transaccion.isEjecutada());
        assertEquals(1000.0, cuentaOrigen.getSaldo());
        assertEquals(500.0, cuentaDestino.getSaldo());
    }

    @Test
    void testEjecutarRetiroSaldoInsuficiente() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, null, 1500.0, fechaPasada,
                false, 0, TipoTransaccion.RETIRO
        );

        boolean resultado = transaccion.ejecutar();

        assertFalse(resultado);
        assertFalse(transaccion.isEjecutada());
        assertEquals(1000.0, cuentaOrigen.getSaldo());
    }

    @Test
    void testProximaFechaTransaccionRecurrente() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, LocalDate.of(2024, 1, 1),
                true, 7, TipoTransaccion.TRANSFERENCIA
        );

        LocalDate proximaFecha = transaccion.proximaFecha();

        assertNotNull(proximaFecha);
        assertEquals(LocalDate.of(2024, 1, 8), proximaFecha);
    }

    @Test
    void testProximaFechaTransaccionNoRecurrente() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, LocalDate.of(2024, 1, 1),
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        LocalDate proximaFecha = transaccion.proximaFecha();

        assertNull(proximaFecha);
    }

    @Test
    void testProximaFechaConFrecuenciaDias30() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, LocalDate.of(2024, 1, 15),
                true, 30, TipoTransaccion.DEPOSITO
        );

        LocalDate proximaFecha = transaccion.proximaFecha();

        assertEquals(LocalDate.of(2024, 2, 14), proximaFecha);
    }

    @Test
    void testEnviarNotificacionTransferencia() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 250.0, LocalDate.of(2024, 5, 15),
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        String notificacion = transaccion.enviarNotificacion();

        assertNotNull(notificacion);
        assertTrue(notificacion.contains("Transacción programada"));
        assertTrue(notificacion.contains("TRANSFERENCIA"));
        assertTrue(notificacion.contains("250"));
        assertTrue(notificacion.contains("2024-05-15"));
        assertTrue(notificacion.contains("002"));
    }

    @Test
    void testEnviarNotificacionDeposito() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                null, cuentaDestino, 100.0, LocalDate.of(2024, 3, 20),
                false, 0, TipoTransaccion.DEPOSITO
        );

        String notificacion = transaccion.enviarNotificacion();

        assertTrue(notificacion.contains("DEPOSITO"));
        assertTrue(notificacion.contains("100"));
        assertTrue(notificacion.contains("002"));
    }

    @Test
    void testEnviarNotificacionRetiro() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, null, 75.0, LocalDate.of(2024, 6, 10),
                false, 0, TipoTransaccion.RETIRO
        );

        String notificacion = transaccion.enviarNotificacion();

        assertTrue(notificacion.contains("RETIRO"));
        assertTrue(notificacion.contains("75"));
        assertTrue(notificacion.contains("001"));
    }

    @Test
    void testToString() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 100.0, LocalDate.of(2024, 1, 1),
                true, 7, TipoTransaccion.TRANSFERENCIA
        );

        String resultado = transaccion.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("TransaccionProgramada"));
        assertTrue(resultado.contains("fechaEjecucion=2024-01-01"));
        assertTrue(resultado.contains("frecuenciaDias=7"));
        assertTrue(resultado.contains("esRecurrente=true"));
        assertTrue(resultado.contains("tipoTransaccion=TRANSFERENCIA"));
    }

    @Test
    void testTransaccionRecurrenteMultiplesEjecuciones() {
        LocalDate fecha = LocalDate.now().minusDays(14);
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 50.0, fecha,
                true, 7, TipoTransaccion.TRANSFERENCIA
        );

        boolean primeraEjecucion = transaccion.ejecutar();
        assertTrue(primeraEjecucion);
        assertEquals(950.0, cuentaOrigen.getSaldo());
        assertEquals(550.0, cuentaDestino.getSaldo());

        transaccion.setEjecutada(false);
        transaccion.setFechaEjecucion(transaccion.proximaFecha());
        
        boolean segundaEjecucion = transaccion.ejecutar();
        assertTrue(segundaEjecucion);
        assertEquals(900.0, cuentaOrigen.getSaldo());
        assertEquals(600.0, cuentaDestino.getSaldo());
    }

    @Test
    void testDepositoMontoGrande() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                null, cuentaDestino, 10000.0, fechaPasada,
                false, 0, TipoTransaccion.DEPOSITO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertEquals(10500.0, cuentaDestino.getSaldo());
    }

    @Test
    void testTransferenciaMontoExactoSaldo() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 1000.0, fechaPasada,
                false, 0, TipoTransaccion.TRANSFERENCIA
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertEquals(0.0, cuentaOrigen.getSaldo());
        assertEquals(1500.0, cuentaDestino.getSaldo());
    }

    @Test
    void testRetiroMontoExactoSaldo() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, null, 1000.0, fechaPasada,
                false, 0, TipoTransaccion.RETIRO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertEquals(0.0, cuentaOrigen.getSaldo());
    }

    @Test
    void testTransaccionRecurrenteFrecuencia1Dia() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, cuentaDestino, 10.0, LocalDate.of(2024, 1, 1),
                true, 1, TipoTransaccion.TRANSFERENCIA
        );

        LocalDate proximaFecha = transaccion.proximaFecha();

        assertEquals(LocalDate.of(2024, 1, 2), proximaFecha);
    }

    @Test
    void testTransaccionDepositoConOrigenNull() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                null, cuentaDestino, 300.0, fechaPasada,
                false, 0, TipoTransaccion.DEPOSITO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertEquals(800.0, cuentaDestino.getSaldo());
    }

    @Test
    void testTransaccionRetiroConDestinoNull() {
        TransaccionProgramada transaccion = new TransaccionProgramada(
                cuentaOrigen, null, 200.0, fechaPasada,
                false, 0, TipoTransaccion.RETIRO
        );

        boolean resultado = transaccion.ejecutar();

        assertTrue(resultado);
        assertEquals(800.0, cuentaOrigen.getSaldo());
    }
}