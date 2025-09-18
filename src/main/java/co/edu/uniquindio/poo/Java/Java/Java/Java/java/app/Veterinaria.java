package co.edu.uniquindio.poo.Java.Java.Java.Java.java.app;

import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria.Mascota;

public class Veterinaria {
    // ingresar el nombre, idMascota, edad, enfermedades de la mascota, raza, especie y color.
    public static void main(String[] args) {
        Mascota mascota1= new Mascota("Martin", "E132", (byte) 4, new String[] {"sarna"} , "pastor aleman", "perro", "marron");
        System.out.println(mascota1.getNombre() + " " + mascota1.getIdMascota() + " " + mascota1.getEdad() + " " + mascota1.getListaEnfermedades()+"\n");

        Mascota mascota2= new Mascota("peluchin", "123B", (byte)3, new String[] {"covid"}, "siames", "gato", "blanco");
        System.out.println(mascota2.getNombre() + " " + mascota2.getIdMascota() + " " + mascota2.getEdad() + " " + mascota2.getListaEnfermedades()+"\n");

        Mascota mascota3= new Mascota("chanchito feliz", "456C", (byte)5, new String[] {"sarna", "gripa"}, "mini pig", "cerdo", "rosado");
        System.out.println(mascota3.getNombre() + " " + mascota3.getIdMascota() + " " + mascota3.getEdad() + " " + mascota3.getListaEnfermedades()+"\n");

        Mascota mascota4= new Mascota("firulais", "789D", (byte)4, new String[] {"covid", "sarna"}, "labrador", "perro", "blanco");
        System.out.println(mascota4.getNombre() + " " + mascota4.getIdMascota() + " " + mascota4.getEdad() + " " + mascota4.getListaEnfermedades()+"\n");
    }


}
