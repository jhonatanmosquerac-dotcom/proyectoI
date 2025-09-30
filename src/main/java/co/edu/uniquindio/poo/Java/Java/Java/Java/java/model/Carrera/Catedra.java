package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Catedra {
    public int horasContratado;
    public String otraEmpresa;
    public Catedra(int horasContratado, String otraEmpresa) {
        this.horasContratado = horasContratado;
        this.otraEmpresa = otraEmpresa;
    }
    public int getHorasContratado() {
        return horasContratado;
    }
    public void setHorasContratado(int horasContratado) {
        this.horasContratado = horasContratado;
    }
    public String getOtraEmpresa() {
        return otraEmpresa;
    }
    public void setOtraEmpresa(String otraEmpresa) {
        this.otraEmpresa = otraEmpresa;
    }
    @Override
    public String toString() {
        return "Catedra [horasContratado=" + horasContratado + ", otraEmpresa=" + otraEmpresa + "]";
    }

}
