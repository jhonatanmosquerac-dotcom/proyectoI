package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

public class Frecuente extends Cliente{

    private int puntosFidelidad;
    private double descuentoCompras= 0.5;
    public Frecuente(String nombre, String cedula, String direccion, int puntosFidelidad, double descuentoCompras) {
        super(nombre, cedula, direccion);
        this.puntosFidelidad = puntosFidelidad;
        this.descuentoCompras = descuentoCompras;
    }
    public int getPuntosFidelidad() {
        return puntosFidelidad;
    }
    public void setPuntosFidelidad(int puntosFidelidad) {
        this.puntosFidelidad = puntosFidelidad;
    }
    public double getDescuentoCompras() {
        return descuentoCompras;
    }
    public void setDescuentoCompras(double descuentoCompras) {
        this.descuentoCompras = descuentoCompras;
    }
    @Override
    public String toString() {
        return "Frecuente [puntosFidelidad=" + puntosFidelidad + ", descuentoCompras=" + descuentoCompras + "]";
    }

}
