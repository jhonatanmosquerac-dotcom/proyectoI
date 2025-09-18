package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria;

public class Propietario {

    private String nombres;
    private String identificacion;
    private String telefono;
    private String direccion;
    private String apellidos;

    public Propietario(String nombres, String identificacion, String telefono, String direccion, String apellidos) {
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.direccion = direccion;
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Propietario [nombres=" + nombres + ", identificacion=" + identificacion + ", telefono=" + telefono
                + ", direccion=" + direccion + ", apellidos=" + apellidos + "]";
    }
    
}
