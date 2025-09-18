package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cita{

    private LocalDate fecha;
    private double costo;
    private String hora;
    private String motivo;
    private String observaciones;
    private String estado;
    private double duracion;
    private String codigo;
    private ArrayList<Cita> listaCitas;

    public Cita(String codigo, LocalDate fecha, double costo, String hora, String motivo, String observaciones,
            String estado, double duracion) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.costo = costo;
        this.hora = hora;
        this.motivo = motivo;
        this.observaciones = observaciones;
        this.estado = estado;
        this.duracion = duracion;
        this.listaCitas = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cita [fecha=" + fecha + ", costo=" + costo + ", hora=" + hora + ", motivo=" + motivo
                + ", observaciones=" + observaciones + ", estado=" + estado + ", duracion=" + duracion + ", codigo="
                + codigo + "]";
    }

    public boolean cumpleFecha(){
        boolean resultado = false;
        LocalDate fechaInicio = LocalDate.parse("2024-06-01");
        LocalDate fechaFin = LocalDate.parse("2024-12-31");
        if(fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin)){
            resultado = true;
        }
        return resultado;
    }

    public boolean tieneVeterinario(Veterinario veterinario, String nombres){
        boolean resultado = false;
        if(veterinario.getNombres().equals(nombres)){
            resultado = true;
        }
        return resultado;
    }

}