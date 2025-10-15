package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

import java.time.LocalDate;

public class Alimenticio extends Producto{

    private LocalDate fechaCaducidad;

    public Alimenticio(String nombre, String codigo, double precio, LocalDate fechaCaducidad) {
        super(nombre, codigo, precio);
        this.fechaCaducidad = fechaCaducidad;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Alimenticio [fechaCaducidad=" + fechaCaducidad + "]";
    }
}
