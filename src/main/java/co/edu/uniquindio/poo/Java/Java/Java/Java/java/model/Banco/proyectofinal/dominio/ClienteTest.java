package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.Notificacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.RangoCliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Deposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

public class ClienteTest {

Banco banco = new Banco("BancoX", "123", "mail@mail.com", "999", "Cali");
Cliente cliente = new Cliente(
        "Juan", "Pérez", "correo@mail.com", "300123123",
        LocalDate.now(), "ID1", banco);

CuentaVirtual cuenta = new CuentaVirtual("CV123456", 1000.0);
Notificacion notificacion = new Notificacion();
Transaccion transaccion = new Deposito(cuenta, 100);  


@Test
void testActualizarRango() {
    Banco banco = new Banco("B", "1", "a", "1", "x");
    Cliente cliente = new Cliente("Juan", "p", "c@c.com", "123",
            LocalDate.now(), "1", banco);

    cliente.setPuntos(1500);
    cliente.actualizarRango();

    assertEquals(RangoCliente.PLATA, cliente.getRango());

    cliente.setPuntos(2500);
    cliente.actualizarRango();

    assertEquals(RangoCliente.ORO, cliente.getRango());
}


@Test
void testAddCuenta() {

    cliente.addCuenta(cuenta);

    assertTrue(cliente.getListaCuentas().contains(cuenta));
    assertEquals(cliente, cuenta.getCliente());
}

@Test
void testAgregarNotificacion() {
    Banco banco = new Banco("B", "1", "a", "1", "x");
    Cliente cliente = new Cliente("Juan", "p", "c@c.com", "123",
            LocalDate.now(), "1", banco);

    Notificacion notificacion = new Notificacion();

    cliente.agregarNotificacion(notificacion);

    assertTrue(cliente.getListaNotificaciones().contains(notificacion));
    assertTrue(cliente.getObservadores().contains(notificacion));
}


@Test
void testConsultarSaldo() {
    Banco banco = new Banco("B", "1", "a", "1", "x");
    Cliente cliente = new Cliente("Juan", "p", "c@c.com", "123",
            LocalDate.now(), "1", banco);

    CuentaVirtual c1 = new CuentaVirtual("C1", 1000);
    CuentaVirtual c2 = new CuentaVirtual("C2", 2500);

    cliente.addCuenta(c1);
    cliente.addCuenta(c2);

    assertEquals(3500, cliente.consultarSaldo());
}

@Test
void testDesuscribir() {
    Banco banco = new Banco("B", "1", "a", "1", "x");
    Cliente cliente = new Cliente("Juan", "p", "c@c.com", "123",
            LocalDate.now(), "1", banco);

    Notificacion obs = new Notificacion();

    cliente.suscribir(obs);
    cliente.desuscribir(obs);

    assertFalse(cliente.getObservadores().contains(obs));
}
}
