package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.RangoCliente;
/*Clase que define las reglas para calcular los puntos según el rango del cliente.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class ReglaPuntos {
    /*Método que devuelve el multiplicador de puntos según el rango del cliente.
    */
    public static double multiplicadorPorRango(RangoCliente rango) {
        return switch (rango) {
            case ORO -> 1.25;
            case PLATA -> 1.10;
            default -> 1.00;
        };
    }
}
