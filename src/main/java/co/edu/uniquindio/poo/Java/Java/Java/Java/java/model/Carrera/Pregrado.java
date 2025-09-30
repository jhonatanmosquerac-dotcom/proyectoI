package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Pregrado extends Estudiante {
    private String beca;
    private double promedioAcumulado;
    
    public Pregrado(String nombre, String id, String docId, String carrera, String semestre, String beca,
            double promedioAcumulado) {
        super(nombre, id, docId, carrera, semestre);
        this.beca = beca;
        this.promedioAcumulado = promedioAcumulado;
    }
    public String getBeca() {
        return beca;
    }
    public void setBeca(String beca) {
        this.beca = beca;
    }
    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }
    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }
    @Override
    public String toString() {
        return "Pregrado [beca=" + beca + ", promedioAcumulado=" + promedioAcumulado + "]";
    }

}
