package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

/* Clase que representa el historial de transacciones.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/
public class HistorialTransacciones {
    private final List<Transaccion> listaTransacciones = new ArrayList<>();

    /* Método para obtener la lista de transacciones en el historial */
    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /* Método para registrar una transacción en el historial */
    public void registrar(Transaccion t) {
        listaTransacciones.add(t);
        if (t.getCuentaOrigen() != null) {
            t.getCuentaOrigen().registrarTransaccion(t);
        }
        if (t.getCuentaDestino() != null) {
            t.getCuentaDestino().registrarTransaccion(t);
        }
    }

    /* Método to string que representa el historial de transacciones y sus atributos*/
    
    @Override
    public String toString() {
        return "HistorialTransacciones{" +
                "listaTransacciones=" + listaTransacciones +
                '}';
    }
}
