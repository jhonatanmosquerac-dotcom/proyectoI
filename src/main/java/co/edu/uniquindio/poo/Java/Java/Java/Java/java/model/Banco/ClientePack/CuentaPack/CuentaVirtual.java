package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco.ClientePack.CuentaPack;

public class CuentaVirtual {

    private int numeroCuenta;

    public CuentaVirtual(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaVirtual [numeroCuenta=" + numeroCuenta + "]";
    }

}
