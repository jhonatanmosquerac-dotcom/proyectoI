package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.fabrica;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta {

    private String codigo;
	private LocalDate fecha;
	private double total;
	private Fabrica ownedByFabricaAutos;
	private ArrayList<Automovil> listaAutomoviles;
	private Empleado empleado;
	
	public Venta(String codigo, LocalDate fecha, double total, Fabrica ownedByFabricaAutos, Empleado empleado) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.total = total;
		this.ownedByFabricaAutos = ownedByFabricaAutos;
		this.empleado = empleado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Fabrica getOwnedByFabricaAutos() {
		return ownedByFabricaAutos;
	}

	public void setOwnedByFabricaAutos(Fabrica ownedByFabricaAutos) {
		this.ownedByFabricaAutos = ownedByFabricaAutos;
	}

	public ArrayList<Automovil> getListaAutomoviles() {
		return listaAutomoviles;
	}

	public void setListaAutomoviles(ArrayList<Automovil> listaAutomoviles) {
		this.listaAutomoviles = listaAutomoviles;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + ", ownedByFabricaAutos="
				+ ownedByFabricaAutos + ", listaAutomoviles=" + listaAutomoviles + ", empleado=" + empleado + "]";
	}
	
	public double calcularVenta() {
		double total = 0;
		
		for (Automovil automovil : listaAutomoviles) {
			total += automovil.getPrecioBase()+(0.1 *automovil.getPrecioBase());
		}
		
		return total;
	}
	
}

