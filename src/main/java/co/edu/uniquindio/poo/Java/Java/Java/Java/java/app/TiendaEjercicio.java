package co.edu.uniquindio.poo.Java.Java.Java.Java.java.app;

import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda.Alimenticio;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda.DetalleFactura;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda.Electrodomestico;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda.Empresa;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda.Frecuente;

import java.time.LocalDate;

public class TiendaEjercicio {
    public static void main(String[] args) {

        Empresa tienda = new Empresa("Mi Tienda", "123456789");

        // Registrar cliente frecuente (5% de descuento)
        Frecuente cliente1 = new Frecuente("Juan", "123456789", "juan@mail.com", 0, 0.5);

        // Registrar productos
        Alimenticio producto1 = new Alimenticio("Arroz", "001", 10000.0, LocalDate.of(2025, 11, 29));
        Electrodomestico producto2 = new Electrodomestico("Waflera", "002", 250000.0, 2);

        // Registrar cliente y productos en la empresa
        System.out.println(tienda.registrarCliente(cliente1));
        System.out.println(tienda.registrarProducto(producto1));
        System.out.println(tienda.registrarProducto(producto2));

        // Crear detalle de factura
        DetalleFactura detalle1 = new DetalleFactura(1, LocalDate.now(), producto1, 3, cliente1);
        DetalleFactura detalle2 = new DetalleFactura(2, LocalDate.now(), producto2, 1, cliente1);

        System.out.println(cliente1 + "\n" + detalle1 + "\n" + detalle2);
}
}