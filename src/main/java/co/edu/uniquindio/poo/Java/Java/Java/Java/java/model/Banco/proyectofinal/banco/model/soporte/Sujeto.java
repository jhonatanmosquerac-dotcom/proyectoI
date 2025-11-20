package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.Observador;

import java.util.List;

/*Interfaz que representa un sujeto en el patrón de diseño observador.
* Permite suscribir, desuscribir y notificar a los observadores.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public interface Sujeto {
    void suscribir(Observador obs);
    void desuscribir(Observador obs);
    void notificar(String mensaje);
    List<Observador> getObservadores();
}
