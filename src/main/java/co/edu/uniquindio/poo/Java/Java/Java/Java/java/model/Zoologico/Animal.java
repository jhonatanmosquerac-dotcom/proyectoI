package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Zoologico;

public abstract class Animal{
    private String nombre;
    private String especie;

    public Animal(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Animal [nombre=" + nombre + ", especie=" + especie + "]";
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public abstract void hacerSonido();
}