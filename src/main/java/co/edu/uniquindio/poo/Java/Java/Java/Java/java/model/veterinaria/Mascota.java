package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria;

import java.util.Arrays;

public class Mascota {

    String nombre;
    String idMascota;
    byte edad;
    String [] listaEnfermedades;
    String raza;
    String especie;
    String color;
    public Mascota(String nombre, String idMascota, byte edad, String[] listaEnfermedades, String raza, String especie,
            String color) {
        this.nombre = nombre;
        this.idMascota = idMascota;
        this.edad = edad;
        this.listaEnfermedades = listaEnfermedades;
        this.raza = raza;
        this.especie = especie;
        this.color = color;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdMascota() {
        return idMascota;
    }
    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }
    public byte getEdad() {
        return edad;
    }
    public void setEdad(byte edad) {
        this.edad = edad;
    }
    public String[] getListaEnfermedades() {
        return listaEnfermedades;
    }
    public void setListaEnfermedades(String[] listaEnfermedades) {
        this.listaEnfermedades = listaEnfermedades;
    }
    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Mascota [nombre=" + nombre + ", idMascota=" + idMascota + ", edad=" + edad + ", listaEnfermedades="
                + Arrays.toString(listaEnfermedades) + ", raza=" + raza + ", especie=" + especie + ", color=" + color
                + "]";
    }
    
}
