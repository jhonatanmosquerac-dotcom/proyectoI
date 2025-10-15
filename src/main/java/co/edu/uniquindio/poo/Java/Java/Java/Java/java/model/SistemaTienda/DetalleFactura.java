package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

import java.time.LocalDate;
public class DetalleFactura extends Factura{
    private Producto producto;
    private int cantidad;

    public DetalleFactura(int numero, LocalDate fecha, Producto producto, int cantidad, Cliente cliente) {
        super(numero, fecha, cliente);
        if(producto == null || cantidad <= 0){
            throw new IllegalArgumentException("Producto no puede ser nulo y la cantidad debe ser mayor a cero");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return "DetalleFactura [producto=" + producto + ", cantidad=" + cantidad + ", subtotal=" + calcularSubtotal() + "]";
    }


}
