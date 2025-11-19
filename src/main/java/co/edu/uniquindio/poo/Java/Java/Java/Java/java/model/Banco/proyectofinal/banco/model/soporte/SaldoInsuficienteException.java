package co.edu.uniquindio.poo.proyectofinal.banco.model.soporte;

/*Excepción personalizada que se lanza cuando una cuenta no tiene saldo suficiente
*@author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}