package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model;

public enum Especialidad {
    MEDICINA_INTERNA("Medicina Interna"),
    CIRUGIA("Cirugia"),
    DERMATOLOGIA("Dermatologia"),
    URGENCIAS("Urgencias");

    private final String nombre;
    Especialidad(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
