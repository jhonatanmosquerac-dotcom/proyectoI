package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.uniersidad;

public class Estudiante {

    private String nombre;
    private String apellido;
    private String numeroIdentificacion;
    private byte edad;
    private String correo;
    public Estudiante(String nombre, String apellido, String numeroIdentificacion, byte edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.edad = edad;
        this.correo = correo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
    public byte getEdad() {
        return edad;
    }
    public void setEdad(byte edad) {
        this.edad = edad;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", numeroIdentificacion="
                + numeroIdentificacion + ", edad=" + edad + ", correo=" + correo + "]";
    }

}
