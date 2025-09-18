package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Zoologico;

import java.util.ArrayList;


public abstract class Zoologico {
    private String nombre;
    private Gato gato;
    private Perro perro;
    private Vaca vaca;
    private Tortuga tortuga;
    private Leon leon;
    private ArrayList<Animal> listaAnimales = new ArrayList<>();

    public Zoologico(String nombre, Gato gato, Perro perro, Vaca vaca, Tortuga tortuga, Leon leon) {
        this.nombre = nombre;
        this.gato = gato;
        this.perro = perro;
        this.vaca = vaca;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Gato getGato() {
        return gato;
    }

    public void setGato(Gato gato) {
        this.gato = gato;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Vaca getVaca() {
        return vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }

    public String getNombre() {
        return nombre;
    }

    public Tortuga getTortuga() {
        return tortuga;
    }

    public void setTortuga(Tortuga tortuga) {
        this.tortuga = tortuga;
    }

    public Leon getLeon() {
        return leon;
    }

    public void setLeon(Leon leon) {
        this.leon = leon;
    }

    public void setListaAnimales(ArrayList<Animal> listaAnimales) {
        this.listaAnimales = listaAnimales;
    }

    public ArrayList<Animal> getListaAnimales() {
        return listaAnimales;
    }

    @Override
    public String toString() {
        return "Zoologico [nombre=" + nombre + ", gato=" + gato + ", perro=" + perro + ", vaca=" + vaca + "]";
    }  
    
    public String registrarAnimal(Animal nuevoAnimal){
        String resultado = "";
        Animal AnimalEncontrado= null;
        AnimalEncontrado= buscarAnimal(nuevoAnimal.getNombre());
        if(AnimalEncontrado == null){
            listaAnimales.add(nuevoAnimal);
            resultado= "Animal registrado con exito";
        } else {
            resultado= "El animal ya se encuentra registrado";
        }
        return resultado;
    }

    public Animal buscarAnimal(String nombre){
        Animal resultado= null;
        for(int i=0; i<listaAnimales.size(); i++){
        Animal animalAux=listaAnimales.get(i);
            if(animalAux.getNombre().equals(nombre)){
            resultado= animalAux;
            break;
            }
        }
        for(int i=0; i<listaAnimales.size(); i++){
        Animal animalAux=listaAnimales.get(i);
            // para añadirlo en la posiciÖn deseada poner (x, nuevoEstudiante)
            if(animalAux.getNombre().equals(nombre)){
            resultado= animalAux;
            break;
            }
        }
       return resultado;
    }
    public String eliminarAnimal(String nombre){
        Animal animalEncontrado=null;

        animalEncontrado= buscarAnimal(nombre);
        if(animalEncontrado != null){
            listaAnimales.remove(animalEncontrado);
            System.out.println("Animal eliminado con exito");
            return "Animal eliminado con exito";
        }
        return "El animal no se encuentra registrado";
    }

        public String actulizarMascota(String nombre, String nuevaEspecie){
        Animal animalEncontrado=null;
        String resultado="";
        animalEncontrado= buscarAnimal(nombre);
        if(animalEncontrado != null){
            animalEncontrado.setEspecie(nuevaEspecie);
            resultado="Animal actualizado con exito";
        } else {
            resultado="El animal no se encuentra registrado";
        }
        return resultado;
    }
}
