package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaTransferencia;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;

/*Clase que representa una transferencia entre dos cuentas virtuales,
 * extiende de la clase Transaccion y utiliza la estrategia de transferencia
 * para realizar la operación deseada.
 *
 * @author DANIEL GIL, JHONATAN MOSQUERA.
 */

public class Transferencia extends Transaccion {

    /*Constructor de la clase Transferencia
    *
    *@param origen      Cuenta de la cual se retira el dinero.
    *@param destino     Cuenta que recibe el dinero.
    *@param monto       Cantidad de dinero a transferir.
    */
    public Transferencia(CuentaVirtual origen, CuentaVirtual destino, double monto) {
        super(origen, destino, monto);
        this.estrategia = new EstrategiaTransferencia();
    }

    /*método ejecutar sobrescrito de la clase Transaccion*/
    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);
        return true;
    }

    /*método enviarNotificacion sobrescrito de la clase Transaccion*/
    @Override
    public String enviarNotificacion() {
        return "Transferencia de " + (int) monto + " de " +
                cuentaOrigen.getNumeroCuenta() + " a " + cuentaDestino.getNumeroCuenta();
    }
}

