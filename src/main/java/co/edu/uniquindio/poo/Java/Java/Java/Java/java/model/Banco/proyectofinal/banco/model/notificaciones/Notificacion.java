package co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones;

/*Clase que representa una notificación en el sistema de notificaciones e 
* implementa la interfaz Observador para recibir actualizaciones de mensajes.
*
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class Notificacion implements Observador {
    private String ultimoMensaje;

    /*Método que actualiza la notificación con un nuevo mensaje.
    */

    @Override
    public void actualizar(String mensaje) {
        this.ultimoMensaje = mensaje;
    }
    
    /*Getter y setter del atributo ultimoMensaje.
    */
    public String getUltimoMensaje() {
        return ultimoMensaje;
    }
    public void setUltimoMensaje(String ultimoMensaje) {
        this.ultimoMensaje = ultimoMensaje;
    }
}