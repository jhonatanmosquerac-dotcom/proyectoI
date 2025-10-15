package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

import java.time.LocalDate;
import java.util.List;

public class Factura {
    private int numero;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetalleFactura> listaDetalles;

    public Factura(int numero, LocalDate fecha, Cliente cliente) {
        if(numero <= 0 || fecha == null || cliente == null){
            throw new IllegalArgumentException("Número de factura debe ser positivo, fecha no puede ser nula, total no puede ser negativo y cliente no puede ser nulo");
        }
        this.numero = numero;
        this.fecha = fecha;
        
        this.cliente = cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Factura [numero=" + numero + ", fecha=" + fecha + "]";
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for(DetalleFactura detalle : listaDetalles){
            subtotal += detalle.getProducto().getPrecio() * detalle.getCantidad();
        }
        return subtotal;
    }
    
    public double calcularTotal(){
        double resultado = 0;
        if(cliente instanceof Frecuente){
            resultado = (calcularSubtotal() * ((Frecuente) cliente).getDescuentoCompras())-calcularSubtotal();
            return resultado;
        }else if(cliente instanceof Corporativo){
            resultado = (calcularSubtotal() * ((Corporativo) cliente).getDescuentoCompras())-calcularSubtotal();
            return resultado;
        }
        return resultado;
    }
}