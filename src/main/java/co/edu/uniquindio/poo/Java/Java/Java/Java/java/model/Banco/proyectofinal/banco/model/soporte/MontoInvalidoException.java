package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

/*Excepción personalizada que se lanza cuando el monto de una transacción es inválido.
*
*@author DANIEL GIL, JHONATAN MOSQUERA.
*/
public class MontoInvalidoException extends RuntimeException{
    public MontoInvalidoException(String message) {
        super(message);
    }
}

