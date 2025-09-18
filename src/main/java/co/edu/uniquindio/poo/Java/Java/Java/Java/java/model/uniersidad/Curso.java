package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.uniersidad;
import java.util.ArrayList;

/*
 * Este metodo permite registrar a un estudiante en caso de que no exista
 * @param nuevoEstudiante
 * @return
 */
public class Curso {
    private String nombre;
    private String codigo;
    private String descripcion;
    private int creditos;
    private String semestre;
    private ArrayList<Estudiante> listaEstudiantes;
    public Curso(String nombre, String codigo, String descripcion, int creditos, String semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.semestre = semestre;
        this.listaEstudiantes = new ArrayList<>();
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
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    
    public String registrarEstudiante(Estudiante nuevoEstudiante){
        String resultado = "";
        Estudiante estudianteEncontrado= null;
        estudianteEncontrado= buscarEstudiante(nuevoEstudiante.getNumeroIdentificacion());
        if (estudianteEncontrado == null) {
            listaEstudiantes.add(nuevoEstudiante);
            resultado = "Estudiante registrado exitosamente.";
        } else {
            resultado = "El estudiante ya está registrado en el curso.";
        }
        return resultado;
    }

    public Estudiante buscarEstudiante(String numeroIdentificacion) {
       Estudiante resultado= null;
        for(int i=0; i<listaEstudiantes.size(); i++){
            Estudiante estudianteAux=listaEstudiantes.get(i);
            // para añadirlo en la posiciÖn deseada poner (x, nuevoEstudiante)
             if(estudianteAux.getNumeroIdentificacion().equals(numeroIdentificacion)){
            resultado= estudianteAux;
            break;
            }
        }
       return resultado;
    }
}