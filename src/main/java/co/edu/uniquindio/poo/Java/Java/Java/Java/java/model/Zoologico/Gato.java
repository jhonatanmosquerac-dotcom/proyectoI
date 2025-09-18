package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Zoologico;

public class Gato extends Animal{
    private String nombre;
    private String especie;

    public Gato(String nombre, String especie) {
      super(nombre, especie);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Gato [nombre=" + nombre + ", especie=" + especie + "]";
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau Miau");
    }
}
