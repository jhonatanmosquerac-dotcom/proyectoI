package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

/*Interfaz que define el comportamiento de un canal de notificación.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public interface CanalNotificacion {
    void enviar(String destino, String mensaje);
}
