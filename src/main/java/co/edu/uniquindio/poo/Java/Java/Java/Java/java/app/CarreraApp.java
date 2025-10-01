package co.edu.uniquindio.poo.Java.Java.Java.Java.java.app;

import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Carrera;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Materia;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Posgrado;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Practica;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Pregrado;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Profesor;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.tipoCurso;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Estudiante;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Planta;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Catedra;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera.Teorica;


public class CarreraApp {
    public static void main(String[] args) {
    // Crear carrera
    Carrera carrera = new Carrera("Ingeniería de Sistemas", 2);

    // Crear profesores
        Profesor prof1 = new Planta("Juan Pérez", "123", "Magíster en Ciencias de la Computación", "10", "Jornada: Diurna", "Proyecto Participante: Desarrollo de Software");
        Profesor prof2 = new Catedra("Laura Gómez", "456", "Licenciatura en Matematicas", "8", 20, "Otra Universidad");

        // Crear materias
    Materia mate1 = new Teorica("matematicas", "asbsd", 3, 4, "1");
    Materia mate2 = new Practica("programacion", "asbdf", 4, 3, "1", 2, 1);

        // Registrar materias en la carrera
    carrera.registrarMateria(mate1);
    carrera.registrarMateria(mate2);

        // Crear estudiante
    Estudiante est1 = new Pregrado("Ana Torres", "789", "11345235454", "Ingeniería de Sistemas", "1", "Ecopetrol", 4.5);
    Estudiante est2 = new Posgrado("Carlos Ruiz", "101", "987654321", "Maestría en IA", "1", "Investigación en IA", tipoCurso.MAESTRIA);

        // Registrar estudiante en la carrera
        carrera.registrarEstudiante(est1);
        carrera.registrarEstudiante(est2);

        // Asignar profesores a las materias
        carrera.registrarProfesor(prof1);
        carrera.registrarProfesor(prof2);

        // Inscribir materias al estudiante
        carrera.registrarEstudianteMateria(est1, mate1);
        carrera.registrarEstudianteMateria(est1, mate2);

        // Mostrar materias inscritas por el estudiante
        for (Materia m : (carrera.obtenerMateriasDeEstudiante(est1))) {
            if(m.equals(mate2)){
                System.out.println("materias:" + m + "profesor:" + prof1); 
        }else if(m.equals(mate1)){
                System.out.println("materias:" + m + "profesor:" + prof2); 
            }
        }
        // Créditos totales
        int totalCreditos = carrera.creditosTotales(est1);
        System.out.println("Créditos totales: " + totalCreditos);
    }
}

