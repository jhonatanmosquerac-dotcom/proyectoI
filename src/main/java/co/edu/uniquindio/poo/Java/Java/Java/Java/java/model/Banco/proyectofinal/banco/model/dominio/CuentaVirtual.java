package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.SaldoInsuficienteException;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.util.ArrayList;
import java.util.List;

/* Clase que representa una cuenta virtual en el sistema bancario 
*   @author DANIEL GIL, JHONATAN MOSQUERA.   
*/

public class CuentaVirtual {
    private final String numeroCuenta;
    private double saldo;
    private List<Monedero> listaMonederos = new ArrayList<>();
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Cliente cliente;

    /* Constructor de la clase CuentaVirtual 
    * @param numeroCuenta      Número de la cuenta virtual.
    * @param saldoInicial      Saldo inicial de la cuenta virtual. 
    */

       public CuentaVirtual(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Getters y Setters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setListaMonederos(List<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }
    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Métodos para gestionar el saldo

    /* Método para depositar dinero en la cuenta virtual 
    */

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto debe mayor a cero");
        }
        saldo += monto;
    }

    /* Método para retirar dinero de la cuenta virtual 
    */

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new MontoInvalidoException("Monto debe ser positivo");
        }
        if (saldo < monto) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
        saldo -= monto;
    }

    /* Método para agregar un monedero a la cuenta virtual 
    */

    public void agregarMonedero(Monedero m) {
        listaMonederos.add(m);
    }

    /* Método para obtener la lista de monederos asociados a la cuenta virtual 
    */
    public List<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    /* Método para registrar una transacción en el historial de la cuenta virtual 
    */

    public void registrarTransaccion(Transaccion t) {
        listaTransacciones.add(t);
    }

    /* Método para obtener la lista de transacciones realizadas en la cuenta virtual 
    */
    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /* Método to string que representa la cuenta virtual y sus atributos*/
    @Override
    public String toString() {
        return "CuentaVirtual{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", listaMonederos=" + listaMonederos +
                ", listaTransacciones=" + listaTransacciones +
                ", cliente=" + cliente +
                '}';
    }
}
