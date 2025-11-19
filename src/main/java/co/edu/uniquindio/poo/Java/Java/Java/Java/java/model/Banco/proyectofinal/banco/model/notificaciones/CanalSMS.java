package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

/*Clase que implementa el canal de notificación para vía SMS.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class CanalSMS implements CanalNotificacion {
    
    /*Método que envía un mensaje a través de SMS.
    */
    @Override public void enviar(String destino, String mensaje) {
        System.out.println("[SMS] a " + destino + ": " + mensaje);
    }
}
