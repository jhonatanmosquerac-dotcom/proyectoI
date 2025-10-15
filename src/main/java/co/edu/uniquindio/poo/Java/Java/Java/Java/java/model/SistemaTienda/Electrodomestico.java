package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

public class Electrodomestico extends Producto {

    private int garantiaMeses;

    public Electrodomestico(String nombre, String codigo, double precio, int garantiaMeses) {
        super(nombre, codigo, precio);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public String toString() {
        return "Electrodomestico [garantiaMeses=" + garantiaMeses + "]";
    }
    
}
