package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

/*Clase que implementa el canal de notificación para vía WhatsApp.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class CanalWhatsApp implements CanalNotificacion {
    /*Método que envía un mensaje a través de WhatsApp.
    */
   
    @Override
    public void enviar(String destino, String mensaje) {
        System.out.println("[MENSAJE WHATSAPP] a " + destino + ": " + mensaje);
    }
}
