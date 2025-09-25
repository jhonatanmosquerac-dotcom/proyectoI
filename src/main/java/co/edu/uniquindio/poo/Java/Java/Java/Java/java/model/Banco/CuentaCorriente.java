package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

public class CuentaCorriente extends Cuenta {
    private float sobreGiro= 0;

    public CuentaCorriente(float saldo, int numConsignaciones, int numRetiros, float tasaAnual, float comisionMensual, float limiteDescubierto) {
        super(saldo, numConsignaciones, numRetiros, tasaAnual, comisionMensual);
    }

    public float getSobreGiro() {
        return sobreGiro;
    }
    public void setSobreGiro(float sobregiro) {
        this.sobreGiro = sobregiro;
    }
    @Override
    public String toString() {
        return "CuentaCorriente [sobregiro=" + sobreGiro + "]";
    }

    public int retirar( float monto) {
        if (monto < getSaldo()) {
            setSaldo(getSaldo() - monto);
            setNumRetiros(getNumRetiros() + 1);
        }else {
        sobreGiro= getSaldo() - monto;
        System.out.println("Fondos insuficientes para el retiro, se ha utilizado el sobregiro por lo que su deuda es de: " + Math.abs(sobreGiro));
        return 0;
    }          
        return 1;
    }

    public int consignar(float monto){
        if(sobreGiro >= monto){
            sobreGiro += monto;
            System.out.println("Se ha abonado al sobregiro, su deuda actual es de: " + Math.abs(sobreGiro));
            return 1;
        } else {
            setSaldo(getSaldo() + (monto - Math.abs(sobreGiro)));
            sobreGiro = 0;
            System.out.println("Se ha abonado al sobregiro y el excedente se ha consignado a la cuenta. Su saldo actual es de: " + getSaldo());
            return 1;
        }
    }

    public void extractoMensual() {
        setSaldo(getSaldo() - getComisionMensual());
    }

    public String imprimirEstadoCuenta(){
        return "Saldo actual: " + getSaldo() + "Número de transacciones: " + (getNumConsignaciones() + getNumRetiros()) +"Comisión mensual: " + getComisionMensual() + "Sobregiro actual: " + Math.abs(sobreGiro);
    }
}
