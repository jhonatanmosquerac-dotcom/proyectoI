package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Practica extends Materia {
    private int horasPracticas;
    private int numeroLaboratorios;

    public Practica(String nombre, String codigo, int horasSemana, int creditos, String semestre, int horasPracticas,
            int numeroLaboratorios) {
        super(nombre, codigo, horasSemana, creditos, semestre);
        this.horasPracticas = horasPracticas;
        this.numeroLaboratorios = numeroLaboratorios;
    }

    public int getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(int horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    public int getNumeroLaboratorios() {
        return numeroLaboratorios;
    }

    public void setNumeroLaboratorios(int numeroLaboratorios) {
        this.numeroLaboratorios = numeroLaboratorios;
    }

    @Override
    public String toString() {
        return "Practica [horasPracticas=" + horasPracticas + ", numeroLaboratorios=" + numeroLaboratorios + "]";
    }    
}
