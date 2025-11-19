package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Retiro;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transferencia;

/*Clase que verifica la validez de una transacción bancaria.
* Realiza comprobaciones como monto válido y saldo suficiente.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class VerificadorTransaccion {

    /*Método que verifica la validez de una transacción.
    */
   
    public ResultadoVerificacion verificar(Transaccion t) {
        if (t.getMonto() <= 0) {
            return new ResultadoVerificacion(false, "Monto inválido");
        }
        if (t instanceof Retiro || t instanceof Transferencia) {
            if (t.getCuentaOrigen().getSaldo() < t.getMonto()) {
                return new ResultadoVerificacion(false, "Saldo insuficiente");
            }
        }
        return new ResultadoVerificacion(true, "Verificación exitosa");
    }
}
