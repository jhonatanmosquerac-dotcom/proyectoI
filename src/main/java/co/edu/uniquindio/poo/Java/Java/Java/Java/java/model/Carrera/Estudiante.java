package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;
import java.util.ArrayList;

public class Estudiante{
    private String nombre;
    private String id;
    private String docId;
    private String carrera;
    private String semestre;


    public Estudiante(String nombre, String id, String docId, String carrera, String semestre) {
        this.nombre = nombre;
        this.id = id;
        this.docId = docId;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public Estudiante(String nombre2, int edad) {
        //TODO Auto-generated constructor stub
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

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", docId='" + docId + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre='" + semestre + '\'' +
                '}';
    }

    private ArrayList<Materia> materiasInscritas = new ArrayList<>();

public void inscribirMateria(Materia materia) {
    if (materia != null) materiasInscritas.add(materia);
}

public ArrayList<Materia> getMateriasInscritas() {
    return materiasInscritas;
}

}


