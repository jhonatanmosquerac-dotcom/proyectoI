package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

public class Movimiento {

    private int accion = 0;

    public Movimiento(int accion) {
        this.accion = accion;
    }
    public int getAccion() {
        return accion;
    }
    public void setAccion(int accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "Movimiento [accion=" + accion + "]";
    }
    
}
