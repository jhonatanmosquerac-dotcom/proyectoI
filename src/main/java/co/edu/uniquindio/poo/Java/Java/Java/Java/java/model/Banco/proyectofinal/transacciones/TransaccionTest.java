package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.IEstrategiaPuntuacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaDeposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaRetiro;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaTransferencia;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.VerificadorTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TransaccionTest {
    
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
    void testConstructorDeposito() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Assert
        assertNull(deposito.getCuentaOrigen(), "La cuenta origen debería ser nula en un depósito");
        assertNotNull(deposito.getCuentaDestino(), "La cuenta destino no debería ser nula");
        assertEquals(1000.0, deposito.getMonto(), "El monto debería ser el especificado");
        assertNotNull(deposito.getFecha(), "La fecha no debería ser nula");
        assertNotNull(deposito.getVerificador(), "El verificador no debería ser nulo");
    }
    
    @Test
    void testConstructorRetiro() {
        // Arrange & Act
        Retiro retiro = new Retiro(cuentaOrigen, 500.0);
        
        // Assert
        assertNotNull(retiro.getCuentaOrigen(), "La cuenta origen no debería ser nula");
        assertNull(retiro.getCuentaDestino(), "La cuenta destino debería ser nula en un retiro");
        assertEquals(500.0, retiro.getMonto(), "El monto debería ser el especificado");
        assertNotNull(retiro.getFecha(), "La fecha no debería ser nula");
        assertNotNull(retiro.getVerificador(), "El verificador no debería ser nulo");
    }
    
    @Test
    void testConstructorTransferencia() {
        // Arrange & Act
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, 2000.0);
        
        // Assert
        assertNotNull(transferencia.getCuentaOrigen(), "La cuenta origen no debería ser nula");
        assertNotNull(transferencia.getCuentaDestino(), "La cuenta destino no debería ser nula");
        assertEquals(2000.0, transferencia.getMonto(), "El monto debería ser el especificado");
        assertNotNull(transferencia.getFecha(), "La fecha no debería ser nula");
        assertNotNull(transferencia.getVerificador(), "El verificador no debería ser nulo");
    }
    
    @Test
    void testGetMonto() {
        // Arrange
        double montoEsperado = 1500.0;
        Deposito deposito = new Deposito(cuentaDestino, montoEsperado);
        
        // Act
        double montoObtenido = deposito.getMonto();
        
        // Assert
        assertEquals(montoEsperado, montoObtenido, "El monto debería ser el mismo");
    }
    
    @Test
    void testGetFechaNoEsNula() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        LocalDateTime fecha = deposito.getFecha();
        
        // Assert
        assertNotNull(fecha, "La fecha no debería ser nula");
    }
    
    @Test
    void testGetFechaEsReciente() {
        // Arrange
        LocalDateTime antes = LocalDateTime.now();
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        LocalDateTime despues = LocalDateTime.now();
        
        // Act
        LocalDateTime fecha = deposito.getFecha();
        
        // Assert
        assertTrue(fecha.isAfter(antes.minusSeconds(1)) && fecha.isBefore(despues.plusSeconds(1)),
                  "La fecha debería estar entre el antes y después de crear la transacción");
    }
    
    @Test
    void testGetCuentaOrigen() {
        // Arrange & Act
        Retiro retiro = new Retiro(cuentaOrigen, 500.0);
        
        // Assert
        assertEquals(cuentaOrigen, retiro.getCuentaOrigen(), 
                    "La cuenta origen debería ser la especificada");
    }
    
    @Test
    void testGetCuentaDestino() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Assert
        assertEquals(cuentaDestino, deposito.getCuentaDestino(), 
                    "La cuenta destino debería ser la especificada");
    }
    
    @Test
    void testGetVerificador() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        VerificadorTransaccion verificador = deposito.getVerificador();
        
        // Assert
        assertNotNull(verificador, "El verificador no debería ser nulo");
        assertInstanceOf(VerificadorTransaccion.class, verificador, 
                        "El verificador debería ser una instancia de VerificadorTransaccion");
    }
    
    @Test
    void testGetEstrategia() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        IEstrategiaPuntuacion estrategia = deposito.getEstrategia();
        
        // Assert
        assertNotNull(estrategia, "La estrategia no debería ser nula");
        assertInstanceOf(EstrategiaDeposito.class, estrategia, 
                        "La estrategia debería ser de tipo EstrategiaDeposito");
    }
    
    @Test
    void testSetEstrategia() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        IEstrategiaPuntuacion nuevaEstrategia = new EstrategiaRetiro();
        
        // Act
        deposito.setEstrategia(nuevaEstrategia);
        
        // Assert
        assertEquals(nuevaEstrategia, deposito.getEstrategia(), 
                    "La estrategia debería ser la nueva estrategia asignada");
    }
    
    @Test
    void testGetTipoTransaccion() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        deposito.setTipoTransaccion(TipoTransaccion.DEPOSITO);
        
        // Act
        TipoTransaccion tipo = deposito.getTipoTransaccion();
        
        // Assert
        assertEquals(TipoTransaccion.DEPOSITO, tipo, 
                    "El tipo de transacción debería ser DEPOSITO");
    }
    
    @Test
    void testSetTipoTransaccion() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        deposito.setTipoTransaccion(TipoTransaccion.DEPOSITO);
        
        // Assert
        assertEquals(TipoTransaccion.DEPOSITO, deposito.getTipoTransaccion(), 
                    "El tipo de transacción debería ser el asignado");
    }
    
    @Test
    void testGetTipoRetornaDepositoParaDeposito() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        TipoTransaccion tipo = deposito.getTipo();
        
        // Assert
        assertEquals(TipoTransaccion.DEPOSITO, tipo, 
                    "getTipo() debería retornar DEPOSITO para un objeto Deposito");
    }
    
    @Test
    void testGetTipoRetornaRetiroParaRetiro() {
        // Arrange & Act
        Retiro retiro = new Retiro(cuentaOrigen, 500.0);
        TipoTransaccion tipo = retiro.getTipo();
        
        // Assert
        assertEquals(TipoTransaccion.RETIRO, tipo, 
                    "getTipo() debería retornar RETIRO para un objeto Retiro");
    }
    
    @Test
    void testGetTipoRetornaTransferenciaParaTransferencia() {
        // Arrange & Act
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, 2000.0);
        TipoTransaccion tipo = transferencia.getTipo();
        
        // Assert
        assertEquals(TipoTransaccion.TRANSFERENCIA, tipo, 
                    "getTipo() debería retornar TRANSFERENCIA para un objeto Transferencia");
    }
    
    @Test
    void testCalcularPuntosConEstrategia() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        int puntos = deposito.calcularPuntos(clienteDestino);
        
        // Assert
        assertTrue(puntos >= 0, "Los puntos calculados deberían ser no negativos");
    }
    
    @Test
    void testCalcularPuntosSinEstrategia() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        deposito.setEstrategia(null);
        
        // Act
        int puntos = deposito.calcularPuntos(clienteDestino);
        
        // Assert
        assertEquals(0, puntos, "Sin estrategia, los puntos deberían ser 0");
    }
    
    @Test
    void testCalcularPuntosConDiferentesEstrategias() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        int puntosDeposito = deposito.calcularPuntos(clienteDestino);
        
        Retiro retiro = new Retiro(cuentaOrigen, 1000.0);
        int puntosRetiro = retiro.calcularPuntos(clienteOrigen);
        
        // Assert
        // Los puntos pueden variar según la estrategia
        assertTrue(puntosDeposito >= 0, "Los puntos del depósito deberían ser no negativos");
        assertTrue(puntosRetiro >= 0, "Los puntos del retiro deberían ser no negativos");
    }
    
    @Test
    void testToString() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        String resultado = deposito.toString();
        
        // Assert
        assertNotNull(resultado, "toString() no debería retornar nulo");
        assertTrue(resultado.contains("Transaccion"), 
                  "toString() debería contener 'Transaccion'");
        assertTrue(resultado.contains("monto"), 
                  "toString() debería contener 'monto'");
        assertTrue(resultado.contains("1000.0"), 
                  "toString() debería contener el valor del monto");
    }
    
    @Test
    void testToStringContieneInformacionCompleta() {
        // Arrange
        Transferencia transferencia = new Transferencia(cuentaOrigen, cuentaDestino, 2500.0);
        
        // Act
        String resultado = transferencia.toString();
        
        // Assert
        assertTrue(resultado.contains("fecha"), "toString() debería contener 'fecha'");
        assertTrue(resultado.contains("cuentaOrigen"), "toString() debería contener 'cuentaOrigen'");
        assertTrue(resultado.contains("cuentaDestino"), "toString() debería contener 'cuentaDestino'");
        assertTrue(resultado.contains("verificador"), "toString() debería contener 'verificador'");
        assertTrue(resultado.contains("estrategia"), "toString() debería contener 'estrategia'");
    }
    
    @Test
    void testMontoEsInmutable() {
        // Arrange
        double montoInicial = 1500.0;
        Deposito deposito = new Deposito(cuentaDestino, montoInicial);
        
        // Act
        double monto1 = deposito.getMonto();
        double monto2 = deposito.getMonto();
        
        // Assert
        assertEquals(monto1, monto2, "El monto debería ser inmutable");
        assertEquals(montoInicial, monto1, "El monto debería mantener su valor inicial");
    }
    
    @Test
    void testFechaEsInmutable() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        
        // Act
        LocalDateTime fecha1 = deposito.getFecha();
        LocalDateTime fecha2 = deposito.getFecha();
        
        // Assert
        assertEquals(fecha1, fecha2, "La fecha debería ser inmutable");
    }
    
    @Test
    void testCambiarEstrategiaMultiplesVeces() {
        // Arrange
        Deposito deposito = new Deposito(cuentaDestino, 1000.0);
        IEstrategiaPuntuacion estrategia1 = new EstrategiaRetiro();
        IEstrategiaPuntuacion estrategia2 = new EstrategiaTransferencia();
        
        // Act
        deposito.setEstrategia(estrategia1);
        assertEquals(estrategia1, deposito.getEstrategia(), "Debería tener la primera estrategia");
        
        deposito.setEstrategia(estrategia2);
        assertEquals(estrategia2, deposito.getEstrategia(), "Debería tener la segunda estrategia");
        
        deposito.setEstrategia(null);
        assertNull(deposito.getEstrategia(), "La estrategia debería poder ser null");
    }
    
    @Test
    void testTransaccionConMontoDecimal() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1234.56);
        
        // Assert
        assertEquals(1234.56, deposito.getMonto(), 0.001, 
                    "El monto decimal debería conservarse con precisión");
    }
    
    @Test
    void testTransaccionConMontoCero() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 0.0);
        
        // Assert
        assertEquals(0.0, deposito.getMonto(), "El monto cero debería ser válido");
    }
    
    @Test
    void testTransaccionConMontoGrande() {
        // Arrange & Act
        Deposito deposito = new Deposito(cuentaDestino, 1000000.0);
        
        // Assert
        assertEquals(1000000.0, deposito.getMonto(), "Debería manejar montos grandes");
    }
    
    @Test
    void testVerificadorEsUnicoParaCadaTransaccion() {
        // Arrange & Act
        Deposito deposito1 = new Deposito(cuentaDestino, 1000.0);
        Deposito deposito2 = new Deposito(cuentaDestino, 2000.0);
        
        // Assert
        assertNotSame(deposito1.getVerificador(), deposito2.getVerificador(), 
                     "Cada transacción debería tener su propio verificador");
    }
}
