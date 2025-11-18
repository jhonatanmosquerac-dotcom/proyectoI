package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

import java.time.LocalDate;

public class Transferir extends Transaccion implements Puntuable {
    public Transferir(double cantidad, Cuenta cuentaOrigen, Cuenta cuentaDestino, LocalDate fecha) {
    super(cantidad, cuentaOrigen, cuentaDestino, fecha);
}

public double generarTransferencia(){
    double resultado= 0;

    resultado= (getCuentaOrigen().getSaldo() - getCantidad()) + getCuentaDestino().getSaldo();
    return resultado;
    }

@Override
public void puntuar() {
}
}
