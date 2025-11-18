package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.Banco;

public record Retirar (double cantidad, String cuentaOrigen){

    public double generarRetiro(){
        double resultado = 0;

        resultado = cantidad - cantidad;
        System.out.println("Retiro exitoso: " + resultado);
        return resultado;

    }
}
