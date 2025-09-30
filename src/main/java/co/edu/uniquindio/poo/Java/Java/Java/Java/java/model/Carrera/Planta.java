package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Carrera;

public class Planta extends Profesor{
   private String jornada;
   private String proyectoParticipante;
   public Planta(String nombre, String id, String tituloAcademico, String añosExperiencia, String jornada,
        String proyectoParticipante) {
    super(nombre, id, tituloAcademico, añosExperiencia);
    this.jornada = jornada;
    this.proyectoParticipante = proyectoParticipante;
   }
   public String getJornada() {
    return jornada;
   }
   public void setJornada(String jornada) {
    this.jornada = jornada;
   }
   public String getProyectoParticipante() {
    return proyectoParticipante;
   }
   public void setProyectoParticipante(String proyectoParticipante) {
    this.proyectoParticipante = proyectoParticipante;
   }
   @Override
   public String toString() {
    return "Planta [jornada=" + jornada + ", proyectoParticipante=" + proyectoParticipante + "]";
   }
   
}
