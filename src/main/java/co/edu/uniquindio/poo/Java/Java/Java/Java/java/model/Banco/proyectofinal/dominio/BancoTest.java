package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class BancoTest {

    private Banco banco = new Banco("BancoPrueba", "123456789", "DireccionPrueba", "NIT123456", "CiudadPrueba");
    Cliente cliente = new Cliente("123456789", "Juan Perez", "Calle Falsa 123", "juan.perez@example.com", LocalDate.of(2002,02,12), "12231", banco);
    CuentaVirtual cuenta = new CuentaVirtual("CV123456", 1000.0);
    Beneficio beneficio = new Beneficio("Descuento", 30, "Descuento en compras");
    
    @Test
    void testAgregarBeneficio() {
    banco.agregarBeneficio(beneficio);
    assertTrue(banco.getListaBeneficios().contains(beneficio));
}

    @Test
    void testAgregarCliente() {
    banco.agregarCliente(cliente);
    assertTrue(banco.getListaClientes().contains(cliente));
    }

    @Test
    void testAgregarCuenta() {
    banco.agregarCuenta(cuenta);
    assertTrue(banco.getListaCuentas().contains(cuenta));
    }

    @Test
    void testBuscarClientePorId() {
    banco.buscarClientePorId("123456789");
    assertTrue(banco.getListaClientes().contains(cliente));
    }

    @Test
    void testBuscarCuenta() {
    banco.buscarCuenta(cliente, "CV123456");
    assertTrue(banco.getListaCuentas().contains(cuenta));
    }

    @Test
    void testEliminarCuenta() {
    boolean eliminado = banco.eliminarCuenta(cliente, "CV123456");
    assertTrue(eliminado);
    }
    @Test
    void testEliminarCliente() {
    boolean eliminado = banco.eliminarCliente(cliente.getId());
    assertTrue(eliminado);
    }

}