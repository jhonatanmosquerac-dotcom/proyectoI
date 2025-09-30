package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Posgrado extends Estudiante {
    private String temaInvestigacion;
    private tipoCurso curso;

    public Posgrado(String nombre, String id, String docId, String carrera, String semestre, String temaInvestigacion,
            tipoCurso curso) {
       super(nombre, id, docId, carrera, semestre);
        this.temaInvestigacion = temaInvestigacion;
        this.curso = curso;
    }
    public Posgrado(String nombre2, int edad, String temaInvestigacion, tipoCurso curso) {
        super(nombre2, edad);
        this.temaInvestigacion = temaInvestigacion;
        this.curso = curso;
    }
    public String getTemaInvestigacion() {
        return temaInvestigacion;
    }
    public void setTemaInvestigacion(String temaInvestigacion) {
        this.temaInvestigacion = temaInvestigacion;
    }
    public tipoCurso getCurso() {
        return curso;
    }
    public void setCurso(tipoCurso curso) {
        this.curso = curso;
    }
    @Override
    public String toString() {
        return "Posgrado [temaInvestigacion=" + temaInvestigacion + ", curso=" + curso + "]";
    }
}
