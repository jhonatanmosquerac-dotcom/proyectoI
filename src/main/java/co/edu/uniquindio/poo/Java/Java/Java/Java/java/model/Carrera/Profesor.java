package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Profesor{
    private String nombre;
    private String id;
    private String tituloAcademico;
    private String añosExperiencia;

    public Profesor(String nombre, String id, String tituloAcademico, String añosExperiencia) {
        this.nombre = nombre;
        this.id = id;
        this.tituloAcademico = tituloAcademico;
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTituloAcademico() {
        return tituloAcademico;
    }

    public void setTituloAcademico(String tituloAcademico) {
        this.tituloAcademico = tituloAcademico;
    }

    public String getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setAñosExperiencia(String añosExperiencia) {
        this.añosExperiencia = añosExperiencia;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", tituloAcademico='" + tituloAcademico + '\'' +
                ", añosExperiencia='" + añosExperiencia + '\'' +
                '}';
    }
}
