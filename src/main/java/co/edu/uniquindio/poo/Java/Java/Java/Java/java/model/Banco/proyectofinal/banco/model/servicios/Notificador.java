package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalNotificacion;

import java.util.ArrayList;
import java.util.List;

/*Clase que gestiona la notificación a clientes a través de diferentes canales.
* Permite agregar canales de notificación y enviar mensajes a clientes.
* @autor DANIEL GIL, JHONATAN MOSQUERA.
*/

public class Notificador {

    private List<CanalNotificacion> listaCanales = new ArrayList<>();

    public void agregarCanal(CanalNotificacion canal) {
        listaCanales.add(canal);
    }

    public void notificarCliente(Cliente cliente, String mensaje) {
        for (CanalNotificacion c : listaCanales) {
            c.enviar(cliente.getId(), mensaje);
        }
    }
}
