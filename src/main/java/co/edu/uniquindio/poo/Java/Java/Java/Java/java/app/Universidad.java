package co.edu.uniquindio.poo.Java.Java.Java.Java;
import java.util.Scanner;

import co.edu.uniquindio.poo.Java.app.Estudiante;

public class Universidad {

    public static final MIN= 0;
    //agregue nombres, apellidos, edad, identificacion, correo y telefono
    public static void main(String[] args) {
        int cantidad= ingresarEnteroPositivo("ingrese la cantidad de estudiantes: ");
        String [] nombre= ingresarTexto(cantidad,"Ingrese los datos de los estudiantes: ");
        String [] apellido= ingresarTexto(cantidad,"Ingrese los datos de los estudiantes: ");    
        byte [] edad= ingresarByte(cantidad,"Ingrese la edad de los estudiantes: ");    
        String [] identificacion= ingresarTexto(cantidad,"Ingrese los datos de los estudiantes: ");
        String [] correo= ingresarTexto(cantidad,"Ingrese los datos de los estudiantes: ");
        String [] telefono= ingresarTexto(cantidad,"Ingrese los datos de los estudiantes: ");
        Estudiante [] estudiante1= new Estudiante(nombre [], apellido[], edad[], identificacion[], correo[], telefono[]);
        Estudiante [] estudiante2= new Estudiante(nombre [], apellido[], edad[], identificacion[], correo[], telefono[]);
        Estudiante [] estudiante3= new Estudiante(nombre [], apellido[], edad[], identificacion[], correo[], telefono[]);
        Estudiante [] estudiante4= new Estudiante(nombre [], apellido[], edad[], identificacion[], correo[], telefono[]);
        Estudiante [] estudiante5= new Estudiante(nombre [], apellido[], edad[], identificacion[], correo[], telefono[]);
    }

    int ingresarEnteroPositivo(String mensaje, int valorMinimo) {
       int valor=0;
       boolean repetir = true;
        while (repetir) {
           valor = ingresarEntero(mensaje); 
            if (valor <= valorMinimo) {
                System.out.println("El valor no es mayor que "+valorMinimo);
            } else {
                repetir = false; 
            }
        }
        return valor;
    }

    public static int ingresarEntero (String mensaje){
        Scanner scanner= new Scanner(System.in);
        System.out.print(mensaje);
        int entero= scanner.nextInt();
        return entero;
    }
    
    public static String ingresarTexto (String mensaje){
        Scanner scanner= new Scanner(System.in);
        System.out.print(mensaje);
        String texto= scanner.nextLine();
        return texto;
    }

}