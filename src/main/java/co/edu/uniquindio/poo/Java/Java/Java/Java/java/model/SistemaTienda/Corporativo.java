package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

public class Corporativo extends Cliente{

    private String nombreEmpresa;
    private String nit;
    private double descuentoCompras;

    public Corporativo(String nombre, String cedula, String direccion, String nombreEmpresa, String nit, double descuentoCompras) {
        super(nombre, cedula, direccion);
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.descuentoCompras = descuentoCompras;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public double getDescuentoCompras() {
        return descuentoCompras;
    }

    public void setDescuentoCompras(double descuentoCompras) {
        this.descuentoCompras = descuentoCompras;
    }

    @Override
    public String toString() {
        return "Corporativo [nombreEmpresa=" + nombreEmpresa + ", nit=" + nit + ", descuentoCompras=" + descuentoCompras
                + "]";
    }

}
