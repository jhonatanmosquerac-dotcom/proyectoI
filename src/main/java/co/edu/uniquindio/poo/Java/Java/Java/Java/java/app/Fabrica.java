package co.edu.uniquindio.poo.Java.Java.Java.Java.java.app;

import java.time.LocalDate;
import java.util.ArrayList;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.fabrica.Empleado;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.fabrica.Venta;

public class Fabrica {
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;
    private ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    public Fabrica(String nombre, String direccion, String telefono, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNit() {
        return nit;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    public static void main(String[] args) {
      
    }

    public String registrarAutomovil(Automovil automovil) {
      String resultado=" ";
      Automovil automovilEncontrado=buscarAutomovil(automovil.getNombre());
      if(automovilEncontrado==null) {
          listaAutomoviles.add(automovil);
          resultado="El automovil se ha registrado exitosamente";
        }else {
          resultado="El automovil ya se encuentra registrado";
        }
        return resultado;
    }

    private Automovil buscarAutomovil(String nombre) {
      Automovil automovilEncontrado=null;
      boolean encontrado=false;
      for(int i=0;i<listaAutomoviles.size() && !encontrado;i++) {
        if(listaAutomoviles.get(i).getNombre().equals(nombre)) {
          automovilEncontrado=listaAutomoviles.get(i);
          encontrado=true;
        }
      }
      return automovilEncontrado;
    }

    
}
