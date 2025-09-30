package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private String codigo;
    private String horasSemana;
    private int creditos;
    private String semestre;
    private ArrayList <Profesor> listaProfesores;
    private List<Materia> listaMaterias = new ArrayList<>();
    private ArrayList<Object> tipoMateria;

    public Materia(String nombre, String codigo, String horasSemana, int creditos, String semestre) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.horasSemana = horasSemana;
        this.creditos = creditos;
        this.semestre = semestre;
        this.tipoMateria = tipoMateria;
        this.listaProfesores = new ArrayList<>();
        this.listaMaterias = new ArrayList<>();
    }

     public List<Materia> getListaMaterias() { return listaMaterias; }
    public void setListaMaterias(List<Materia> listaMaterias) { this.listaMaterias = listaMaterias; }

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

    public String getHorasSemana() {
        return horasSemana;
    }

    public void setHorasSemana(String horasSemana) {
        this.horasSemana = horasSemana;
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

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(ArrayList<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public ArrayList<Object> getTipoMateria() {
        return tipoMateria;
    }
    public void setTipoMateria(ArrayList<Object> tipoMateria) {
        this.tipoMateria = tipoMateria;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", horasSemana='" + horasSemana + '\'' +
                ", creditos=" + creditos +
                ", semestre='" + semestre + '\'' +
                ", listaProfesores=" + listaProfesores +
                '}';
    }
 
    public void asignarProfesor(Profesor profesor) {
        if (listaProfesores == null) {
            listaProfesores = new ArrayList<>();
        }
        listaProfesores.add(profesor);
    }
    public int horasClase(Materia teorica, Materia practica) {
        int horas = 0;
        horas = Integer.parseInt(teorica.getHorasSemana()) + Integer.parseInt(practica.getHorasSemana());
        return horas;
    }

    public ArrayList<Object> listaTipoMateria() {
        if (tipoMateria == null) {
            tipoMateria = new ArrayList<>();
        }
        ArrayList<Practica> practicas = new ArrayList<>();
        ArrayList<Teorica> teoricas = new ArrayList<>();
            if(!tipoMateria.contains(practicas)) {
            tipoMateria.add(practicas);
                }else if(!tipoMateria.contains(teoricas)) {
                tipoMateria.add(teoricas);
                }
        System.out.println("estas son las materias practicas : " + practicas +" y estas son las teoricas : " + teoricas);
        return tipoMateria;
    }

    public void asignarEstudiante(Estudiante estudiante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarEstudiante'");
    }

    public void removerProfesor(Profesor profesor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerProfesor'");
    }

}