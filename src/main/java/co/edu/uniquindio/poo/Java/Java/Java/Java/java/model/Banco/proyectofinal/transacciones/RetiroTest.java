package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class RetiroTest {
    
    private CuentaVirtual cuentaOrigen;
    private Cliente cliente;
    private Banco banco;

    @BeforeEach
    void setUp() {
    banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
    cliente = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
    cuentaOrigen = new CuentaVirtual("CV123456", 1000.0);
    }
    
    @Test
    void testEjecutarRetiroExitoso() {
        // Arrange
        double montoRetiro = 1000.0;
        double saldoInicial = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, montoRetiro);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertTrue(resultado, "El retiro debería ejecutarse exitosamente");
        assertEquals(saldoInicial - montoRetiro, cuentaOrigen.getSaldo(), 
                    "El saldo debería disminuir en el monto retirado");
    }
    
    @Test
    void testEjecutarRetiroConSaldoInsuficiente() {
        // Arrange
        double montoRetiro = 6000.0; // Mayor al saldo disponible
        double saldoInicial = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, montoRetiro);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertFalse(resultado, "El retiro con saldo insuficiente no debería ejecutarse");
        assertEquals(saldoInicial, cuentaOrigen.getSaldo(), 
                    "El saldo no debería cambiar cuando el retiro falla");
    }
    
    @Test
    void testEjecutarRetiroConMontoNegativo() {
        // Arrange
        double montoNegativo = -100.0;
        double saldoInicial = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, montoNegativo);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertFalse(resultado, "El retiro con monto negativo no debería ejecutarse");
        assertEquals(saldoInicial, cuentaOrigen.getSaldo(), 
                    "El saldo no debería cambiar cuando el retiro falla");
    }
    
    @Test
    void testEjecutarRetiroConMontoCero() {
        // Arrange
        double montoCero = 0.0;
        double saldoInicial = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, montoCero);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertFalse(resultado, "El retiro con monto cero no debería ejecutarse");
        assertEquals(saldoInicial, cuentaOrigen.getSaldo(), 
                    "El saldo no debería cambiar");
    }
    
    @Test
    void testEjecutarRetiroTotalDelSaldo() {
        // Arrange
        double saldoTotal = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, saldoTotal);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertTrue(resultado, "Debería poder retirar todo el saldo disponible");
        assertEquals(0.0, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo debería quedar en cero");
    }
    
    @Test
    void testEjecutarMultiplesRetiros() {
        // Arrange
        double primerRetiro = 1000.0;
        double segundoRetiro = 500.0;
        double saldoInicial = cuentaOrigen.getSaldo();
        
        Retiro retiro1 = new Retiro(cuentaOrigen, primerRetiro);
        Retiro retiro2 = new Retiro(cuentaOrigen, segundoRetiro);
        
        // Act
        boolean resultado1 = retiro1.ejecutar();
        boolean resultado2 = retiro2.ejecutar();
        
        // Assert
        assertTrue(resultado1, "El primer retiro debería ejecutarse");
        assertTrue(resultado2, "El segundo retiro debería ejecutarse");
        assertEquals(saldoInicial - primerRetiro - segundoRetiro, 
                    cuentaOrigen.getSaldo(), 0.01,
                    "El saldo debería reflejar ambos retiros");
    }
    
    @Test
    void testEjecutarRetiroQueDejaLaCuentaEnCero() {
        // Arrange
        cuentaOrigen = new CuentaVirtual("002", 1000.0);
        Retiro retiro = new Retiro(cuentaOrigen, 1000.0);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertTrue(resultado, "El retiro que deja la cuenta en cero debería ejecutarse");
        assertEquals(0.0, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo debería quedar exactamente en cero");
    }
    
    @Test
    void testEnviarNotificacion() {
        // Arrange
        double monto = 2500.0;
        Retiro retiro = new Retiro(cuentaOrigen, monto);
        String numeroCuenta = cuentaOrigen.getNumeroCuenta();
        
        // Act
        String notificacion = retiro.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, "La notificación no debería ser nula");
        assertTrue(notificacion.contains("Retiro"), 
                  "La notificación debería contener la palabra 'Retiro'");
        assertTrue(notificacion.contains(String.valueOf((int)monto)), 
                  "La notificación debería contener el monto");
        assertTrue(notificacion.contains(numeroCuenta), 
                  "La notificación debería contener el número de cuenta");
    }
    
    @Test
    void testEnviarNotificacionFormatoEsperado() {
        // Arrange
        double monto = 3500.75;
        Retiro retiro = new Retiro(cuentaOrigen, monto);
        String esperado = "Retiro de 3500 en cuenta " + cuentaOrigen.getNumeroCuenta();
        
        // Act
        String notificacion = retiro.enviarNotificacion();
        
        // Assert
        assertEquals(esperado, notificacion, 
                    "La notificación debería tener el formato esperado");
    }
    
    @Test
    void testEnviarNotificacionSinEjecutar() {
        // Arrange
        Retiro retiro = new Retiro(cuentaOrigen, 1000.0);
        
        // Act
        String notificacion = retiro.enviarNotificacion();
        
        // Assert
        assertNotNull(notificacion, 
                     "La notificación debería generarse aunque no se haya ejecutado el retiro");
        assertTrue(notificacion.contains("Retiro"), 
                  "La notificación debería tener el formato correcto");
    }
    
    @Test
    void testRetiroConMontoDecimal() {
        // Arrange
        double montoDecimal = 250.50;
        double saldoInicial = cuentaOrigen.getSaldo();
        Retiro retiro = new Retiro(cuentaOrigen, montoDecimal);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertTrue(resultado, "El retiro con decimales debería ejecutarse");
        assertEquals(saldoInicial - montoDecimal, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo debería disminuir correctamente con decimales");
    }
    
    @Test
    void testCuentaOrigenNoEsNula() {
        // Arrange & Act
        Retiro retiro = new Retiro(cuentaOrigen, 500.0);
        
        // Assert
        assertNotNull(retiro.getCuentaOrigen(), 
                     "La cuenta origen no debería ser nula");
        assertEquals(cuentaOrigen, retiro.getCuentaOrigen(), 
                    "La cuenta origen debería ser la misma que se pasó al constructor");
    }
    
    @Test
    void testRetiroExactoAlSaldoDisponible() {
        // Arrange
        cuentaOrigen = new CuentaVirtual("003", 2500.0);
        Retiro retiro = new Retiro(cuentaOrigen, 2500.0);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertTrue(resultado, "Debería poder retirar exactamente el saldo disponible");
        assertEquals(0.0, cuentaOrigen.getSaldo(), 0.01, 
                    "El saldo final debería ser cero");
    }
    
    @Test
    void testRetirosPequeniosConsecutivos() {
        // Arrange
        double saldoInicial = cuentaOrigen.getSaldo();
        double montoRetiro = 100.0;
        
        // Act
        for (int i = 0; i < 5; i++) {
            Retiro retiro = new Retiro(cuentaOrigen, montoRetiro);
            retiro.ejecutar();
        }
        
        // Assert
        assertEquals(saldoInicial - (montoRetiro * 5), cuentaOrigen.getSaldo(), 0.01,
                    "El saldo debería reflejar todos los retiros pequeños consecutivos");
    }
    
    @Test
    void testRetiroConCuentaConSaldoCero() {
        // Arrange
        cuentaOrigen = new CuentaVirtual("004", 0.0);
        Retiro retiro = new Retiro(cuentaOrigen, 100.0);
        
        // Act
        boolean resultado = retiro.ejecutar();
        
        // Assert
        assertFalse(resultado, "No debería poder retirar de una cuenta con saldo cero");
        assertEquals(0.0, cuentaOrigen.getSaldo(), 
                    "El saldo debería permanecer en cero");
    }
}
