package co.edu.uniquindio.poo.Java.Java.Java.Java.java.app;

import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco.Cuenta;
import co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco.CuentaAhorro;

public class Banco{
    public static void main( String[] args ){
    Cuenta Cuenta1 = new CuentaAhorro(50000, 0, 0, 0.05f, 10);
    consignar(Cuenta1, 20000);
    retirar(Cuenta1, 10000);
    String mensaje = imprimirEstadoCuenta(Cuenta1);
    mostrarMensaje(mensaje);  
    }
    
    public static void consignar(Cuenta cuenta, int monto) {
        // Implementación básica: suma el monto al saldo de la cuenta
        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }
    public static void retirar(Cuenta cuenta, int monto) {
        // Implementación básica: resta el monto del saldo de la cuenta si hay fondos suficientes
        if (cuenta.getSaldo() >= monto) {
            cuenta.setSaldo(cuenta.getSaldo() - monto);
        } else {
            System.out.println("Fondos insuficientes para el retiro.");
        }
    }

    public void extractoMensual(Cuenta cuenta) {
        // Implementación básica: resta la comisión mensual del saldo de la cuenta
        cuenta.setSaldo(cuenta.getSaldo() - cuenta.getComisionMensual());
    }

    public static String imprimirEstadoCuenta(Cuenta cuenta) {
        // Implementación básica: devuelve una cadena con el estado de la cuenta
        return "Saldo actual: " + cuenta.getSaldo() + ", Número de transacciones: " + (cuenta.getNumConsignaciones() + cuenta.getNumRetiros()) + ", Comisión mensual: " + cuenta.getComisionMensual();
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}