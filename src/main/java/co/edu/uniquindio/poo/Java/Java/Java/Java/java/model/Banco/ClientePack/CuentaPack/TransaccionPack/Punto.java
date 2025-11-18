package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model;

public class Punto {

    private int puntos= 0;

    public Punto(int puntos) {
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    @Override
    public String toString() {
        return "Punto [puntos=" + puntos + "]";
    }
}
