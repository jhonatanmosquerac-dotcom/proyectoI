package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

public abstract class Producto {

    private String nombre;
    private String codigo;
    private double precio;

    public Producto(String nombre, String codigo, double precio) {
        if(nombre.isBlank() || codigo.isBlank() || precio < 0){
            throw new IllegalArgumentException("Nombre y código son obligatorios, precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio + "]";
    }

}
