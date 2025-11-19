package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

/*Interfaz que define la estrategia de puntuación para transacciones bancarias.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public interface IEstrategiaPuntuacion {
    
    /*Método que calcula los puntos para una transacción.
    */
   
    int calcularPuntos(Transaccion transaccion, Cliente cliente);
}
