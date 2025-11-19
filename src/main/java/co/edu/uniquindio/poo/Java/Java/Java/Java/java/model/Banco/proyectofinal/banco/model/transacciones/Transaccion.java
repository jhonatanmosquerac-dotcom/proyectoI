package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.IEstrategiaPuntuacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.VerificadorTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;

import java.time.LocalDateTime;
/*Clase abstracta que representa una transacción bancaria, 
es la clase principal de las transacciones como depósito, retiro y transferencia.
*
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/
public abstract class Transaccion {
    protected final double monto;
    protected final LocalDateTime fecha;
    protected final CuentaVirtual cuentaOrigen;
    protected final CuentaVirtual cuentaDestino;
    protected final VerificadorTransaccion verificador;
    protected IEstrategiaPuntuacion estrategia;
    protected TipoTransaccion tipoTransaccion;

    /*Constructor de la clase Transaccion
    * @param origen      Cuenta de la cual se retira el dinero.
    * @param destino     Cuenta que recibe el dinero.
    * @param monto       Cantidad del dinero que se enviara o retirara.
    */
    protected Transaccion(CuentaVirtual origen, CuentaVirtual destino, double monto) {
        this.cuentaOrigen = origen;
        this.cuentaDestino = destino;
        this.monto = monto;
        this.fecha = LocalDateTime.now();
        this.verificador = new VerificadorTransaccion();
    }

    /*Getters y setters de los atributos de la clase Transaccion.
    */

    public VerificadorTransaccion getVerificador() {
        return verificador;
    }
    public IEstrategiaPuntuacion getEstrategia() {
        return estrategia;
    }
    public void setEstrategia(IEstrategiaPuntuacion estrategia) {
        this.estrategia = estrategia;
    }
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    public double getMonto() {
        return monto;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public CuentaVirtual getCuentaOrigen() {
        return cuentaOrigen;
    }
    public CuentaVirtual getCuentaDestino() {
        return cuentaDestino;
    }

    /*Métodos abstractos que deben ser implementados por las subclases para ejecutar la transacción y enviar notificaciones.*/
    public abstract boolean ejecutar();

    public abstract String enviarNotificacion();
    /**
     * Retorna el tipo de transacción según la subclase que la representa.
    */    
    public TipoTransaccion getTipo() {
        if (this instanceof Deposito) {
            return TipoTransaccion.DEPOSITO;
        }
        if (this instanceof Retiro) {
            return TipoTransaccion.RETIRO;
        }
        if (this instanceof Transferencia) {
            return TipoTransaccion.TRANSFERENCIA;
        }
        return null;
    }
    /* Método que calcula los puntos obtenidos en la transacción para un cliente dado, segun la estrategia asignada */
    public int calcularPuntos(Cliente cliente) {
        return estrategia == null ? 0 : estrategia.calcularPuntos(this, cliente);
    }
    /* Método que devuelve una representación en texto de la transacción */
    @Override
    public String toString() {
        return "Transaccion{" +
                "monto=" + monto +
                ", fecha=" + fecha +
                ", cuentaOrigen=" + cuentaOrigen +
                ", cuentaDestino=" + cuentaDestino +
                ", verificador=" + verificador +
                ", estrategia=" + estrategia +
                ", tipoTransaccion=" + tipoTransaccion +
                '}';
    }
}
