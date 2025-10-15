package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

public abstract class Cliente {

    private String nombre;
    private String cedula;
    private String direccion;

    public Cliente(String nombre, String cedula, String direccion) {
        if(nombre == null || nombre.isBlank() || direccion == null || direccion.isBlank()){
            throw new IllegalArgumentException("Nombre, y dirección son obligatorios");
        }
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Clientes [nombre=" + nombre + ", cedula=" + cedula + ", direccion=" + direccion + "]";
    }
    
}