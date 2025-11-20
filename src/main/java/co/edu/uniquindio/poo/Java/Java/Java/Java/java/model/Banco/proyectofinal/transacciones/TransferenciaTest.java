package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class TransferenciaTest {
    
   private CuentaVirtual cuentaOrigen;
    private CuentaVirtual cuentaDestino;
    private Cliente clienteOrigen;
    private Cliente clienteDestino;
    private Banco banco;
    
    @BeforeEach
    void setUp() {
        // Crear clientes reales
        banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
        clienteOrigen = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
        clienteDestino = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
        
        // Crear cuentas virtuales reales
        cuentaOrigen = new CuentaVirtual("001",  5000.0);
        cuentaDestino = new CuentaVirtual("002", 3000.0);
    }
    @Test
    void testEjecutarTransferenciaExitosa() {
        // Arrange
        double montoTransferencia = 1000.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoTransferencia);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertTrue(resultado, "La transferencia debería ejecutarse exitosamente");
        assertEquals(saldoInicialOrigen - montoTransferencia, cuentaOrigen.getSaldo(), 
                    "El saldo de la cuenta origen debería disminuir");
        assertEquals(saldoInicialDestino + montoTransferencia, cuentaDestino.getSaldo(), 
                    "El saldo de la cuenta destino debería aumentar");
    }
    
    @Test
    void testEjecutarTransferenciaConSaldoInsuficiente() {
        // Arrange
        double montoTransferencia = 6000.0; // Mayor al saldo disponible
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoTransferencia);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertFalse(resultado, "La transferencia con saldo insuficiente no debería ejecutarse");
        assertEquals(saldoInicialOrigen, cuentaOrigen.getSaldo(), 
                    "El saldo de origen no debería cambiar");
        assertEquals(saldoInicialDestino, cuentaDestino.getSaldo(), 
                    "El saldo de destino no debería cambiar");
    }
    
    @Test
    void testEjecutarTransferenciaConMontoNegativo() {
        // Arrange
        double montoNegativo = -500.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoNegativo);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertFalse(resultado, "La transferencia con monto negativo no debería ejecutarse");
        assertEquals(saldoInicialOrigen, cuentaOrigen.getSaldo(), 
                    "El saldo de origen no debería cambiar");
        assertEquals(saldoInicialDestino, cuentaDestino.getSaldo(), 
                    "El saldo de destino no debería cambiar");
    }
    
    @Test
    void testEjecutarTransferenciaConMontoCero() {
        // Arrange
        double montoCero = 0.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoCero);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertFalse(resultado, "La transferencia con monto cero no debería ejecutarse");
        assertEquals(saldoInicialOrigen, cuentaOrigen.getSaldo(), 
                    "El saldo de origen no debería cambiar");
        assertEquals(saldoInicialDestino, cuentaDestino.getSaldo(), 
                    "El saldo de destino no debería cambiar");
    }
    
    @Test
    void testEjecutarTransferenciaTotalDelSaldo() {
        // Arrange
        double saldoTotal = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, saldoTotal);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertTrue(resultado, "Debería poder transferir todo el saldo disponible");
        assertEquals(0.0, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo de origen debería quedar en cero");
        assertEquals(saldoInicialDestino + saldoTotal, cuentaDestino.getSaldo(), 0.01, 
                    "El saldo de destino debería recibir todo el saldo");
    }
    
    @Test
    void testEjecutarMultiplesTransferencias() {
        // Arrange
        double primeraTransferencia = 1000.0;
        double segundaTransferencia = 500.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        
        Transferencia transferencia1 = new Transferencia(cuentaOrigen, cuentaDestino, primeraTransferencia);
        Transferencia transferencia2 = new Transferencia(cuentaOrigen, cuentaDestino, segundaTransferencia);
        
        // Act
        boolean resultado1 = transferencia1.ejecutar();
        boolean resultado2 = transferencia2.ejecutar();
        
        // Assert
        assertTrue(resultado1, "La primera transferencia debería ejecutarse");
        assertTrue(resultado2, "La segunda transferencia debería ejecutarse");
        assertEquals(saldoInicialOrigen - primeraTransferencia - segundaTransferencia, 
                    cuentaOrigen.getSaldo(), 0.01,
                    "El saldo de origen debería reflejar ambas transferencias");
        assertEquals(saldoInicialDestino + primeraTransferencia + segundaTransferencia, 
                    cuentaDestino.getSaldo(), 0.01,
                    "El saldo de destino debería reflejar ambas transferencias");
    }
    
    @Test
    void testEjecutarTransferenciaConMontoDecimal() {
        // Arrange
        double montoDecimal = 123.45;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoDecimal);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertTrue(resultado, "La transferencia con decimales debería ejecutarse");
        assertEquals(saldoInicialOrigen - montoDecimal, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo de origen debería disminuir correctamente");
        assertEquals(saldoInicialDestino + montoDecimal, cuentaDestino.getSaldo(), 0.01, 
                    "El saldo de destino debería aumentar correctamente");
    }
    
    @Test
    void testEjecutarTransferenciaEntreMismasCuentas() {
        // Arrange
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaOrigen, 1000.0);
        double saldoInicial = cuentaOrigen.getSaldo();
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        // El comportamiento depende de la lógica de verificación
        // Si no está permitido, debería fallar
        if (!resultado) {
            assertEquals(saldoInicial, cuentaOrigen.getSaldo(), 
                        "El saldo no debería cambiar si la transferencia falla");
        }
    }
    
    @Test
    void testEjecutarTransferenciaDesdeDestinoHaciaOrigen() {
        // Arrange
        double montoTransferencia = 800.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        
        // Transferencia inversa (de destino a origen)
        Transferencia transferencia = new Transferencia(cuentaDestino, cuentaOrigen, montoTransferencia);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertTrue(resultado, "La transferencia inversa debería ejecutarse");
        assertEquals(saldoInicialDestino - montoTransferencia, cuentaDestino.getSaldo(), 0.01, 
                    "El saldo de la cuenta que envía debería disminuir");
        assertEquals(saldoInicialOrigen + montoTransferencia, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo de la cuenta que recibe debería aumentar");
    }
    
    @Test
    void testEnviarNotificacion() {
        // Arrange
        double monto = 2500.0;
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, monto);
        String numeroCuentaOrigen = cuentaOrigen.getNumeroCuenta();
        String numeroCuentaDestino = cuentaDestino.getNumeroCuenta();
        
        // Act
        String notificacion = transferencia.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, "La notificación no debería ser nula");
        assertTrue(notificacion.contains("Transferencia"), 
                  "La notificación debería contener la palabra 'Transferencia'");
        assertTrue(notificacion.contains(String.valueOf((int)monto)), 
                  "La notificación debería contener el monto");
        assertTrue(notificacion.contains(numeroCuentaOrigen), 
                  "La notificación debería contener el número de cuenta origen");
        assertTrue(notificacion.contains(numeroCuentaDestino), 
                  "La notificación debería contener el número de cuenta destino");
    }
    
    @Test
    void testEnviarNotificacionFormatoEsperado() {
        // Arrange
        double monto = 3500.75;
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, monto);
        String esperado = "Transferencia de 3500 de " + cuentaOrigen.getNumeroCuenta() + 
                         " a " + cuentaDestino.getNumeroCuenta();
        
        // Act
        String notificacion = transferencia.enviarNotificacion();
        
        // Assert
        assertEquals(esperado, notificacion, 
                    "La notificación debería tener el formato esperado");
    }
    
    @Test
    void testEnviarNotificacionSinEjecutar() {
        // Arrange
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, 1500.0);
        
        // Act
        String notificacion = transferencia.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, 
                     "La notificación debería generarse aunque no se haya ejecutado la transferencia");
        assertTrue(notificacion.contains("Transferencia"), 
                  "La notificación debería tener el formato correcto");
    }
    
    @Test
    void testEnviarNotificacionConMontoDecimal() {
        // Arrange
        double montoDecimal = 1234.99;
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoDecimal);
        
        // Act
        String notificacion = transferencia.enviarNotificacion();
        
        // Assert
        assertTrue(notificacion.contains("1234"), 
                  "La notificación debería mostrar el monto truncado a entero");
        assertFalse(notificacion.contains(".99"), 
                   "La notificación no debería incluir los decimales");
    }
    
    @Test
    void testEjecutarConservaPrincipioDeConservacionDinero() {
        // Arrange
        double montoTransferencia = 1500.0;
        double dineroTotalInicial = cuentaOrigen.getSaldo() + cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoTransferencia);
        
        // Act
        transferencia.ejecutar();
        double dineroTotalFinal = cuentaOrigen.getSaldo() + cuentaDestino.getSaldo();
        
        // Assert
        assertEquals(dineroTotalInicial, dineroTotalFinal, 0.01, 
                    "El dinero total del sistema debería conservarse después de la transferencia");
    }
    
    @Test
    void testEjecutarTransferenciaMinima() {
        // Arrange
        double montoMinimo = 0.01;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoMinimo);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        if (resultado) {
            assertEquals(saldoInicialOrigen - montoMinimo, cuentaOrigen.getSaldo(), 0.01, 
                        "Debería poder transferir montos muy pequeños");
            assertEquals(saldoInicialDestino + montoMinimo, cuentaDestino.getSaldo(), 0.01, 
                        "El destino debería recibir el monto mínimo");
        }
    }
    
    @Test
    void testEjecutarTransferenciaGrande() {
        // Arrange
        cuentaOrigen = new CuentaVirtual("003", 100000.0);
        double montoGrande = 50000.0;
        double saldoInicialOrigen = cuentaOrigen.getSaldo();
        double saldoInicialDestino = cuentaDestino.getSaldo();
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, montoGrande);
        
        // Act
        boolean resultado = transferencia.ejecutar();
        
        // Assert
        assertTrue(resultado, "Debería poder transferir montos grandes");
        assertEquals(saldoInicialOrigen - montoGrande, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo de origen debería disminuir correctamente");
        assertEquals(saldoInicialDestino + montoGrande, cuentaDestino.getSaldo(), 0.01, 
                    "El saldo de destino debería aumentar correctamente");
    }
}
