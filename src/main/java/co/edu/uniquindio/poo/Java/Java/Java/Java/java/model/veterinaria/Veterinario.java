package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria;
import java.util.ArrayList;

public class Veterinario {
    
    private String nombres;
    private String identificacion;
    private String telefono;
    private Especialidad especialidad;
    private String correo;
    private String tarjetaProfesional;
    private int horarioAtencion;
    private ArrayList<Veterinario> listaVeterinarios;

    public Veterinario(String nombres, String identificacion, String telefono, Especialidad especialidad,
            String correo, String tarjetaProfesional, int horarioAtencion) {
        this.nombres = nombres;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.correo = correo;
        this.tarjetaProfesional = tarjetaProfesional;
        this.horarioAtencion = horarioAtencion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public void setTarjetaProfesional(String tarjetaProfesional) {
        this.tarjetaProfesional = tarjetaProfesional;
    }

    public int getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(int horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    @Override
    public String toString() {
        return "Veterinario [nombres=" + nombres + ", identificacion=" + identificacion + ", telefono=" + telefono
                + ", especialidad=" + especialidad + ", correo=" + correo + ", tarjetaProfesional=" + tarjetaProfesional
                + ", horarioAtencion=" + horarioAtencion + "]";
    }
    
    public int contarUrgencias() {
        int contador = 0;
        if (listaVeterinarios != null) {
            for (Veterinario auxVeterinario : listaVeterinarios) {
                if (auxVeterinario.getEspecialidad() == Especialidad.URGENCIAS) {
                    contador++;
                }
            }
        }
        return contador;
    }
}