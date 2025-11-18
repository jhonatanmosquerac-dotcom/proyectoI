package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco.ClientePack.CuentaPack.TransaccionPack;

import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco.ClientePack.CuentaPack.Cuenta;
import java.time.LocalDate;

public class Deposito extends Transaccion implements Puntuable {

    public Deposito(double cantidad, Cuenta cuentaOrigen, Cuenta cuentaDestino, LocalDate fecha, TipoTransaccion tipoTransaccion) {
        super(cantidad, null, cuentaDestino, fecha, tipoTransaccion);
    }
    public String generarDeposito(){
        
        double resultado = 0;
        String mensaje = "Deposito realizado con exito. Nuevo saldo: " + resultado;
    resultado = getCantidad() + getCuentaDestino().getSaldo();
    System.out.println(mensaje);
    return mensaje;
    }

    @Override
    public void puntuar() {
    
        if(generarDeposito().equals(true)){
            Cliente.getPuntos
        }
    }
}