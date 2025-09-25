package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

public class CuentaAhorro extends Cuenta {

    private boolean activa;

    public CuentaAhorro(float saldo, int numConsignaciones, int numRetiros, float tasaAnual, float comisionMensual) {
        super(saldo, numConsignaciones, numRetiros, tasaAnual, comisionMensual);
    
        this.activa = saldo >= 10000;
    }

    public boolean isActiva() {
        return activa;
    }   

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    @Override
    public String toString() {
        return "CuentaAhorro [activa=" + activa + "]";
    }

    public int retirar(float monto) {
        if (activa) {
            if (monto <= getSaldo()) {
                setSaldo(getSaldo() - monto);
                setNumRetiros(getNumRetiros() + 1);
                if (getSaldo() < 10000) {
                    activa = false;
                }
                return 1;
            } else {
                System.out.println("Fondos insuficientes para el retiro.");
                return 0;
            }
        } else {
            System.out.println("La cuenta no está activa. No se pueden realizar retiros.");
            return 0;
        }
    }

    public int consignar(float monto) {
        if (monto > 0) {
            setSaldo(getSaldo() + monto);
            setNumConsignaciones(getNumConsignaciones() + 1);
            if (getSaldo() >= 10000) {
                activa = true;
            }
            return 1;
        } else {
            System.out.println("El monto a consignar debe ser positivo.");
            return 0;
        }
    }

    public void extractoMensual() {
        setSaldo(getSaldo() - getComisionMensual());
        if (getSaldo() < 10000) {
            activa = false;
        }
        setNumRetiros(0);
        setNumConsignaciones(0);
    }

    public int consignados(){
        int consignacionesTotales= 0;
        if (getNumConsignaciones() > 1) {
            consignacionesTotales+=1;
        }
            return consignacionesTotales;
    }

    public int retirados(){
        int retirosTotales= 0;
        if (getNumRetiros() > 1) {
            retirosTotales+=1;
        }
            return retirosTotales;
    }

    public int transacciones(){
        int transaccionesTotales= consignados() + retirados();
        return transaccionesTotales;
    }

    public String estadoCuenta() {
        return "Saldo: " + getSaldo() + "Comisión Mensual" + getComisionMensual() + "Transacciones: " + transacciones();
    }

}
