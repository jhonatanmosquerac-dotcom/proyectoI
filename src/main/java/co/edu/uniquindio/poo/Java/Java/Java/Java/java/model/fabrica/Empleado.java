package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.fabrica;

import java.util.ArrayList;

public class Empleado {
   private String nombre;
    private String apellidos;
    private double salario;
    private String departamento;
    private Fabrica ownedByFabricaAutos;
    private ArrayList<Venta> listaVentas;

    /**
     * Constructor para crear un nuevo empleado.
     *
     * @param nombre              Nombre del empleado.
     * @param apellidos           Apellidos del empleado.
     * @param salario             Salario del empleado.
     * @param departamento        Departamento en el que trabaja el empleado.
     * @param ownedByFabricaAutos Fábrica a la que pertenece el empleado.
     */
    public Empleado(String nombre, String apellidos, double salario, String departamento,
                    Fabrica ownedByFabricaAutos) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.salario = salario;
        this.departamento = departamento;
        this.ownedByFabricaAutos = ownedByFabricaAutos;
        this.listaVentas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene los apellidos del empleado.
     *
     * @return Apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece los apellidos del empleado.
     *
     * @param apellidos Apellidos a asignar.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Obtiene el salario del empleado.
     *
     * @return Salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     *
     * @param salario Salario a asignar.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Obtiene el departamento del empleado.
     *
     * @return Departamento en el que trabaja el empleado.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento del empleado.
     *
     * @param departamento Departamento a asignar.
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene la fábrica a la que pertenece el empleado.
     *
     * @return Fábrica propietaria del empleado.
     */
    public Fabrica getOwnedByFabricaAutos() {
        return ownedByFabricaAutos;
    }

    /**
     * Establece la fábrica a la que pertenece el empleado.
     *
     * @param ownedByFabricaAutos Fábrica a asignar.
     */
    public void setOwnedByFabricaAutos(Fabrica ownedByFabricaAutos) {
        this.ownedByFabricaAutos = ownedByFabricaAutos;
    }

    /**
     * Obtiene la lista de ventas realizadas por el empleado.
     *
     * @return Lista de ventas.
     */
    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    /**
     * Establece la lista de ventas realizadas por el empleado.
     *
     * @param listaVentas Lista de ventas a asignar.
     */
    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
}

