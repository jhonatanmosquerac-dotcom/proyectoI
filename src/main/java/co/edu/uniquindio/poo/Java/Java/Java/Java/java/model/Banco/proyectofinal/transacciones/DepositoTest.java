package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class DepositoTest {
    
    private CuentaVirtual cuentaDestino;
    private Cliente cliente;
    private Banco banco;

    @BeforeEach
    void setUp() {
    banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
    cliente = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
    cuentaDestino = new CuentaVirtual("CV123456", 1000.0);
    }
    
    @Test
    void testEjecutarDepositoExitoso() {
        // Arrange
        double montoDeposito = 500.0;
        double saldoInicial = cuentaDestino.getSaldo();
        Deposito deposito = new Deposito(cuentaDestino, montoDeposito);
        
        // Act
        boolean resultado = deposito.ejecutar();
        
        // Assert
        assertTrue(resultado, "El depósito debería ejecutarse exitosamente");
        assertEquals(saldoInicial + montoDeposito, cuentaDestino.getSaldo(), 
                    "El saldo debería incrementarse en el monto depositado");
    }
    
    @Test
    void testEjecutarDepositoConMontoNegativo() {
        // Arrange
        double montoNegativo = -100.0;
        double saldoInicial = cuentaDestino.getSaldo();
        Deposito deposito = new Deposito(cuentaDestino, montoNegativo);
        
        // Act
        boolean resultado = deposito.ejecutar();
        
        // Assert
        assertFalse(resultado, "El depósito con monto negativo no debería ejecutarse");
        assertEquals(saldoInicial, cuentaDestino.getSaldo(), 
                    "El saldo no debería cambiar cuando el depósito falla");
    }
    
    @Test
    void testEjecutarDepositoConMontoCero() {
        // Arrange
        double montoCero = 0.0;
        double saldoInicial = cuentaDestino.getSaldo();
        Deposito deposito = new Deposito(cuentaDestino, montoCero);
        
        // Act
        boolean resultado = deposito.ejecutar();
        
        // Assert
        assertFalse(resultado, "El depósito con monto cero no debería ejecutarse");
        assertEquals(saldoInicial, cuentaDestino.getSaldo(), 
                    "El saldo no debería cambiar");
    }
    
    @Test
    void testEjecutarMultiplesDepositos() {
        // Arrange
        double primerDeposito = 200.0;
        double segundoDeposito = 300.0;
        double saldoInicial = cuentaDestino.getSaldo();
        
        Deposito deposito1 = new Deposito(cuentaDestino, primerDeposito);
        Deposito deposito2 = new Deposito(cuentaDestino, segundoDeposito);
        
        // Act
        deposito1.ejecutar();
        deposito2.ejecutar();
        
        // Assert
        assertEquals(saldoInicial + primerDeposito + segundoDeposito, 
                    cuentaDestino.getSaldo(), 
                    "El saldo debería reflejar ambos depósitos");
    }
    
    @Test
    void testEnviarNotificacion() {
        // Arrange
        double monto = 1500.0;
        Deposito deposito = new Deposito(cuentaDestino, monto);
        String numeroCuenta = cuentaDestino.getNumeroCuenta();
        
        // Act
        String notificacion = deposito.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, "La notificación no debería ser nula");
        assertTrue(notificacion.contains("Depósito"), 
                  "La notificación debería contener la palabra 'Depósito'");
        assertTrue(notificacion.contains(String.valueOf((int)monto)), 
                  "La notificación debería contener el monto");
        assertTrue(notificacion.contains(numeroCuenta), 
                  "La notificación debería contener el número de cuenta");
    }
    
    @Test
    void testEnviarNotificacionFormatoEsperado() {
        // Arrange
        double monto = 2500.75;
        Deposito deposito = new Deposito(cuentaDestino, monto);
        String esperado = "Depósito de 2500 en cuenta " + cuentaDestino.getNumeroCuenta();
        
        // Act
        String notificacion = deposito.enviarNotificacion();
        
        // Assert
        assertEquals(esperado, notificacion, 
                    "La notificación debería tener el formato esperado");
    }
    
    @Test
    void testEnviarNotificacionSinEjecutar() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        String notificacion = deposito.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, 
                     "La notificación debería generarse aunque no se haya ejecutado el depósito");
        assertTrue(notificacion.contains("Depósito"), 
                  "La notificación debería tener el formato correcto");
    }
    
    @Test
    void testDepositoConMontoDecimal() {
        // Arrange
        double montoDecimal = 123.45;
        double saldoInicial = cuentaDestino.getSaldo();
        Deposito deposito = new Deposito(cuentaDestino, montoDecimal);
        
        // Act
        boolean resultado = deposito.ejecutar();
        
        // Assert
        assertTrue(resultado, "El depósito con decimales debería ejecutarse");
        assertEquals(saldoInicial + montoDecimal, cuentaDestino.getSaldo(), 0.01, 
                    "El saldo debería incrementarse correctamente con decimales");
    }
    
    @Test
    void testCuentaDestinoNoEsNula() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 500.0);
        
        // Assert
        assertNotNull(deposito.getCuentaDestino(), 
                     "La cuenta destino no debería ser nula");
        assertEquals(cuentaDestino, deposito.getCuentaDestino(), 
                    "La cuenta destino debería ser la misma que se pasó al constructor");
    }
}