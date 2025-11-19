package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaDeposito;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;

 
/**
* Clase que representa un depósito en una cuenta virtual, 
* extiende de la clase Transaccion y utiliza la estrategia de depósito para realizar la operación.
*
*@author DANIEL GIL, JHONATAN MOSQUERA.
*/


public class Deposito extends Transaccion {

    /*Constructor de la clase Deposito
    *
    *@param destino     Cuenta que recibe el dinero.
    *@param monto       Cantidad del dinero que se enviara.
    */
    public Deposito(CuentaVirtual destino, double monto) {
        super(null, destino, monto);
        this.estrategia = new EstrategiaDeposito();
    }

    /*Metodo que ejecuta la transacción de depósito si es valida*/
    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaDestino.depositar(monto);
        return true;
    }

    /*Metodo que envia la notificación del depósito realizado*/
    @Override
    public String enviarNotificacion() {
        return "Depósito de " + (int) monto + " en cuenta " + cuentaDestino.getNumeroCuenta();
    }
}