package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

import java.time.LocalDate;

public class Transaccion {

    private double cantidad;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private LocalDate fecha;

    public Transaccion(double cantidad, Cuenta cuentaOrigen, Cuenta cuentaDestino, LocalDate fecha) {
        this.cantidad = cantidad;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.fecha = fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Transaccion [cantidad=" + cantidad + ", cuentaOrigen=" + cuentaOrigen + ", cuentaDestino="
                + cuentaDestino + ", fecha=" + fecha + "]";
    }

}
