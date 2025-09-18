package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Zoologico;

public class Perro extends Animal {
    private String nombre;
    private String especie;

    public Perro(String nombre, String especie) {
        super(nombre, especie);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

     @Override
    public String toString() {
        return "Perro [nombre=" + nombre + ", especie=" + especie + "]";
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau Guau");
    }
}
