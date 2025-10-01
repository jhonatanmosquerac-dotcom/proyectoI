package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

import java.util.ArrayList;

public class Carrera{
    private String nombre;
    private int numeroEstudiantes;
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Materia> listaMaterias;
    public Carrera(String nombre, int numeroEstudiantes) {
        this.nombre = nombre;
        this.numeroEstudiantes = numeroEstudiantes;
        this.listaEstudiantes = new ArrayList<>();
        this.listaMaterias = new ArrayList<>();
    }

    public ArrayList<Estudiante> getListaEstudiantes() { return listaEstudiantes;}
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {this.listaEstudiantes = listaEstudiantes;}

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getNumeroEstudiantes() { return numeroEstudiantes; }
    public void setNumeroEstudiantes(int numeroEstudiantes) { this.numeroEstudiantes = numeroEstudiantes; }

    public ArrayList<Materia> getListaMaterias() { return listaMaterias; }
    public void setListaMaterias(ArrayList<Materia> listaMaterias) { this.listaMaterias = listaMaterias; }

    @Override
    public String toString() {
        return String.format("Carrera{nombre='%s', numeroEstudiantes=%d}", nombre, numeroEstudiantes);
    }
    
    public void registrarMateria(Materia materia) {
        if (materia != null) listaMaterias.add(materia);
    }

    public void registrarProfesor(Profesor profesor) {
        for (Materia materia : listaMaterias) {
            if (materia != null) {
                materia.asignarProfesor(profesor);
            }
        }
    }

    public void eliminarProfesor(Profesor profesor) {
        for (Materia materia : listaMaterias) {
            if (materia != null) {
                materia.getListaProfesores().remove(profesor);
            }
        }
    }

    public void registrarEstudianteMateria(Estudiante estudiante, Materia materia) {
    if (estudiante != null && materia != null) {
        estudiante.inscribirMateria(materia);
    }
}

public ArrayList<Materia> obtenerMateriasDeEstudiante(Estudiante estudiante) {
    if (estudiante != null) {
        return estudiante.getMateriasInscritas();
    }
    return new ArrayList<>();
}


    public ArrayList<Materia> consultarSemestre(String semestre) {
        ArrayList<Materia> materiasDelSemestre = new ArrayList<>();
        for (Materia materia : listaMaterias) {
            if (materia.getSemestre().equalsIgnoreCase(semestre)) {
                materiasDelSemestre.add(materia);
            }
        }
        return materiasDelSemestre;
    }
    
    public void eliminarMateria(Materia materia) {
        if (materia != null) {
            listaMaterias.remove(materia);
        }
    }

    public void registrarEstudiante(Estudiante estudiante) {
        if (estudiante != null) listaEstudiantes.add(estudiante);
    }

    public void actualizarMateria(Materia materiaAntigua, Materia materiaNueva) {
        if (materiaAntigua != null && materiaNueva != null) {
            int index = listaMaterias.indexOf(materiaAntigua);
            if (index != -1) {
                listaMaterias.set(index, materiaNueva);
            }
        }
    }

  public int creditosTotales(Estudiante estudiante) {
    int totalCreditos = 0;
    if (estudiante != null) {
        for (Materia materia : estudiante.getMateriasInscritas()) {
            totalCreditos += materia.getCreditos();
        }
    }
    return totalCreditos;
}
}
