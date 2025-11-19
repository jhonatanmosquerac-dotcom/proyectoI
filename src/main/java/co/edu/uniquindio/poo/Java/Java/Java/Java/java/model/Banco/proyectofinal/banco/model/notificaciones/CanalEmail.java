package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

/*Clase que implementa el canal de notificación para vía Email.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class CanalEmail implements CanalNotificacion {
    /*Método que envía un mensaje a través de Email.
    */
    @Override public void enviar(String destino, String mensaje) {
        System.out.println("[EMAIL] a " + destino + ": " + mensaje);
    }
}
