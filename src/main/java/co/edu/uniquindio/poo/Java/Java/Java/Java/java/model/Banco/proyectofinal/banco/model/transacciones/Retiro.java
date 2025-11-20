package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaRetiro;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;
/**
* Clase que representa un retiro en una cuenta virtual,
* extiende de la clase Transaccion y utiliza la estrategia de retiro para realizar la operación.

*@author DANIEL GIL, JHONATAN MOSQUERA.
*/
public class Retiro extends Transaccion {
    /*Constructor de la clase Retiro
    *@param origen      Cuenta de la cual se retira el dinero.
    *@param monto       Cantidad del dinero que se retirara.
    */
    public Retiro(CuentaVirtual origen, double monto) {
        super(origen, null, monto);
        this.estrategia = new EstrategiaRetiro();
    }
    /*Metodo que ejecuta la transacción de retiro si es valida*/

    @Override
    public boolean ejecutar() {
        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }
        cuentaOrigen.retirar(monto);
        return true;
    }

    /*Metodo que envia la notificación del retiro realizado*/
    @Override
    public String enviarNotificacion() {
        return "Retiro de " + (int) monto + " en cuenta " + cuentaOrigen.getNumeroCuenta();
    }
}
