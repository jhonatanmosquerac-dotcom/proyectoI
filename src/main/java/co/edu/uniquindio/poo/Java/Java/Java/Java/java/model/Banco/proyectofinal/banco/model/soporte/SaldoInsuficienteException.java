package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

/*Excepción personalizada que extiende de RunTimeException y se lanza cuando una cuenta no tiene saldo suficiente
* para realizar alguna transacción.
*
*@author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}