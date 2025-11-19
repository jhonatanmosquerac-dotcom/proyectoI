package co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.CuentaVirtual;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.EstrategiaTransaccionProgramada;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.ResultadoVerificacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;

import java.time.LocalDate;
/*Clase que representa una transacción programada, la cual puede ser recurrente y se ejecuta en una fecha específica,
*extiende de la clase Transaccion y utiliza la estrategia de transacción programada,
* para realizar la operación deseada (deposito, retiro o transferencia).
*
*@author DANIEL GIL, JHONATAN MOSQUERA.
*/
public class TransaccionProgramada extends Transaccion {
    private LocalDate fechaEjecucion;
    private int frecuenciaDias; // si es recurrente, es la frecuenciaDias de los días.
    private boolean esRecurrente;
    private TipoTransaccion tipoTransaccion;
    private boolean ejecutada;
    private int ejecucionesConsecutivas;

    /*Constructor de la clase TransaccionProgramada
    * @param origen           Cuenta de la cual se retira el dinero.
    * @param destino          Cuenta que recibe el dinero.
    * @param monto            Cantidad del dinero que se enviara o retirara.
    * @param fechaEjecucion   Fecha en la que se ejecutará la transacción.
    * @param esRecurrente     Indica si la transacción es recurrente.
    * @param frecuenciaDias   Frecuencia en días para las transacciones recurrentes.
    * @param tipoTransaccion  Tipo de transacción a realizar, depósito, retiro o transferencia.
    */

    public TransaccionProgramada(CuentaVirtual origen, CuentaVirtual destino, double monto, LocalDate fechaEjecucion,
            boolean esRecurrente, int frecuenciaDias, TipoTransaccion tipoTransaccion
    ) {
        super(origen, destino, monto);
        this.fechaEjecucion = fechaEjecucion;
        this.esRecurrente = esRecurrente;
        this.frecuenciaDias = frecuenciaDias;
        this.tipoTransaccion = tipoTransaccion;
        this.estrategia = new EstrategiaTransaccionProgramada();
    }
    /*Getters y setters de los atributos de la clase TransaccionProgramada.*/

    public void setFechaEjecucion(LocalDate fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }
    public int getFrecuenciaDias() {
        return frecuenciaDias;
    }
    public void setFrecuenciaDias(int frecuenciaDias) {
        this.frecuenciaDias = frecuenciaDias;
    }
    public boolean isEsRecurrente() {
        return esRecurrente;
    }
    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }
    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }
    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    public boolean isEjecutada() {
        return ejecutada;
    }
    public void setEjecutada(boolean ejecutada) {
        this.ejecutada = ejecutada;
    }
    public int getEjecucionesConsecutivas() {
        return ejecucionesConsecutivas;
    }
    public void setEjecucionesConsecutivas(int ejecucionesConsecutivas) {
        this.ejecucionesConsecutivas = ejecucionesConsecutivas;
    }
    public LocalDate getFechaEjecucion() {
        return fechaEjecucion;
    }
    public boolean isRecurrente() {
        return esRecurrente;
    }

    public LocalDate proximaFecha() {
        return esRecurrente ? fechaEjecucion.plusDays(frecuenciaDias) : null;
    }

    /*métodos ejecutar sobrescrito de la clase transaccion*/

    @Override
    public boolean ejecutar() {
        if (LocalDate.now().isBefore(fechaEjecucion)) return false;
        if (ejecutada) return false;

        ResultadoVerificacion rv = verificador.verificar(this);
        if (!rv.valido()) {
            System.out.println("Error: " + rv.mensaje());
            return false;
        }

        switch (tipoTransaccion) {
            case DEPOSITO -> cuentaDestino.depositar(monto);
            case RETIRO -> cuentaOrigen.retirar(monto);
            case TRANSFERENCIA -> {
                cuentaOrigen.retirar(monto);
                cuentaDestino.depositar(monto);
            }
        }
        ejecutada = true;
        return true;
    }
    /*método enviarNotificacion sobrescrito de la clase Transaccion*/
    @Override
    public String enviarNotificacion() {
        return "Transacción programada (" + tipoTransaccion + ") de " + (int) monto +
                " ejecutada en fecha " + fechaEjecucion +
                " sobre cuenta " + (tipoTransaccion == TipoTransaccion.RETIRO ? cuentaOrigen.getNumeroCuenta()
                : cuentaDestino.getNumeroCuenta());
    }
    /*To string de la clase transaccion programada */
    @Override
    public String toString() {
        return "TransaccionProgramada{" +
                "fechaEjecucion=" + fechaEjecucion +
                ", frecuenciaDias=" + frecuenciaDias +
                ", esRecurrente=" + esRecurrente +
                ", tipoTransaccion=" + tipoTransaccion +
                ", ejecutada=" + ejecutada +
                ", ejecucionesConsecutivas=" + ejecucionesConsecutivas +
                '}';
    }
}
