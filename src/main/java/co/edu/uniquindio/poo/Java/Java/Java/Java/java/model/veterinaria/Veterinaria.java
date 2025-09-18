package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.veterinaria;
import java.util.ArrayList;

public class Veterinaria {

    private String nombre;
    private String ubicacion;
    private String nit;
    private ArrayList<Mascota> listaMascota;
    private ArrayList<Cita> listaCitas;

    public Veterinaria(String nombre, String ubicacion, String nit) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.listaMascota = new ArrayList<>();
        this.listaCitas = new ArrayList<>();
    }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String registrarMascota(Mascota nuevaMascota){
        String resultado = "";
        Mascota mascotaEncontrada= null;
        mascotaEncontrada= buscarMascota(nuevaMascota.getIdMascota());
        if (mascotaEncontrada == null) {
            listaMascota.add(nuevaMascota);
            resultado = "Mascota registrada exitosamente.";
        } else {
            resultado = "La mascota ya está registrada en el curso.";
        }
        return resultado;
    }

    public Mascota buscarMascota(String idMascota) {
       Mascota resultado= null;
        for(int i=0; i<listaMascota.size(); i++){
        Mascota mascotaAux=listaMascota.get(i);
            // para añadirlo en la posiciÖn deseada poner (x, nuevoEstudiante)
            if(mascotaAux.getIdMascota().equals(idMascota)){
            resultado= mascotaAux;
            break;
            }
        }
       return resultado;
    }
    public String eliminarMascota(String idMascota){
        Mascota mascotaEncontrada=null;

        mascotaEncontrada= buscarMascota(idMascota);
        if(mascotaEncontrada != null){
            listaMascota.remove(mascotaEncontrada);
            System.out.println("Mascota eliminada con exito");
            return "Mascota eliminada con exito";
        }
        return "La mascota no se encuentra registrada";
    }

        public String actulizarMascota(String idMascota, Mascota nuevoNombre) {
            String resultado= " ";
            Mascota mascotaEncontrada= null;
            mascotaEncontrada= buscarMascota(idMascota);
            if(mascotaEncontrada != null){
                int posicion= listaMascota.indexOf(mascotaEncontrada);
                listaMascota.set(posicion, nuevoNombre);
                resultado= "Mascota actualizada con exito";
            } else {
                resultado= "La mascota no se encuentra registrada";
            }
            return resultado;
        }
    
        public ArrayList<Mascota> obtenerMascotasde1a5(){
            ArrayList<Mascota> mascotasde1a5= new ArrayList<>();
            for(Mascota mascotaAux : listaMascota){
                if(mascotaAux.getEdad()>=1 && mascotaAux.getEdad()<=5){
                    mascotasde1a5.add(mascotaAux);
                }
            }
            return mascotasde1a5;
        }

        public ArrayList<Mascota> obtenerMascotasFechaVet(){
            ArrayList<Mascota> resultado= new ArrayList<>();
            for(Cita citaAux : listaCitas){
             boolean cumpleFecha= citaAux.cumpleFecha();
             boolean cumpleVeterinario= citaAux.tieneVeterinario("Juan Perez");
             if(cumpleFecha== true && cumpleVeterinario==true){
                 resultado.add(citaAux.getMascota());
             }
        }
        return resultado;
    }
}