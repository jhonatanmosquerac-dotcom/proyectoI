package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

public class Cuenta {
    private float saldo;
    private int numConsignaciones=0;
    private int numRetiros=0;
    private float TasaAnual;
    private float comisionMensual= 0;

    public Cuenta(float saldo, int numConsignaciones, int numRetiros, float tasaAnual, float comisionMensual) {
        this.saldo = saldo;
        this.numConsignaciones = numConsignaciones;
        this.numRetiros = numRetiros;
        TasaAnual = tasaAnual;
        this.comisionMensual = comisionMensual;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public float getTasaAnual() {
        return TasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        TasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    @Override
    public String toString() {
        return "Cuenta [saldo=" + saldo + ", numConsignaciones=" + numConsignaciones + ", numRetiros=" + numRetiros
                + ", TasaAnual=" + TasaAnual + ", comisionMensual=" + comisionMensual + "]";
    }

    public int consignar(float monto) {
        if (monto > 0) {
            saldo += monto;
            numConsignaciones++;
            return 1; // Consignación exitosa
        } else {
            System.out.println("El monto a consignar debe ser positivo.");
            return 0; // Consignación fallida
        }
    }

    public int retirar(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            numRetiros++;
            return 1; // Retiro exitoso
        } else {
            System.out.println("Fondos insuficientes o monto inválido para el retiro.");
            return 0; // Retiro fallido
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (TasaAnual / 12) / 100;
        float interes = saldo * interesMensual;
        saldo += interes;
        setSaldo(saldo);
    }
    public void extractoMensual() {
        calcularInteresMensual();
        saldo -= comisionMensual;
    }     

    public String imprimirEstadoCuenta() {
        return "Saldo: " + saldo + "consignaciones" + numConsignaciones + "Retiros" + numRetiros + "Comisión Mensual" + comisionMensual + "tasa anual" + TasaAnual;
    }
}
