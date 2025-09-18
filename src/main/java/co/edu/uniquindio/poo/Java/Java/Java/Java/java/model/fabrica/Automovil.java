package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.fabrica;

import java.util.ArrayList;

public class Automovil {
 private String nombre;
    private String modelo;
    private String tipoMotor;
    private String capacidadPasajeros;
    private TipoCarroceria tipoCarroceria;
    private double precioBase;
    private Fabrica ownedByFabricaAutos;
    private ArrayList<Venta> listaVentas;

    /**
     * Constructor de la clase Automovil.
     *
     * @param nombre              Nombre del automóvil.
     * @param modelo              Modelo del automóvil.
     * @param tipoMotor           Tipo de motor (ej. gasolina, eléctrico).
     * @param capacidadPasajeros  Capacidad de pasajeros del automóvil.
     * @param tipoCarroceria      Tipo de carrocería del automóvil.
     * @param precioBase          Precio base del automóvil.
     * @param ownedByFabricaAutos Fábrica que produce este automóvil.
     */
    public Automovil(String nombre, String modelo, String tipoMotor, String capacidadPasajeros,
                     TipoCarroceria tipoCarroceria, double precioBase, Fabrica ownedByFabricaAutos) {
        super();
        this.nombre = nombre;
        this.modelo = modelo;
        this.tipoMotor = tipoMotor;
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipoCarroceria = tipoCarroceria;
        this.precioBase = precioBase;
        this.ownedByFabricaAutos = ownedByFabricaAutos;
        this.listaVentas = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del automóvil.
     *
     * @return Nombre del automóvil.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del automóvil.
     *
     * @param nombre Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el modelo del automóvil.
     *
     * @return Modelo del automóvil.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del automóvil.
     *
     * @param modelo Modelo a asignar.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipo de motor del automóvil.
     *
     * @return Tipo de motor.
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Establece el tipo de motor del automóvil.
     *
     * @param tipoMotor Tipo de motor a asignar.
     */
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    /**
     * Obtiene la capacidad de pasajeros del automóvil.
     *
     * @return Capacidad de pasajeros.
     */
    public String getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Establece la capacidad de pasajeros del automóvil.
     *
     * @param capacidadPasajeros Capacidad a asignar.
     */
    public void setCapacidadPasajeros(String capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * Obtiene el tipo de carrocería del automóvil.
     *
     * @return Tipo de carrocería.
     */
    public TipoCarroceria getTipoCarroceria() {
        return tipoCarroceria;
    }

    /**
     * Establece el tipo de carrocería del automóvil.
     *
     * @param tipoCarroceria Tipo de carrocería a asignar.
     */
    public void setTipoCarroceria(TipoCarroceria tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    /**
     * Obtiene el precio base del automóvil.
     *
     * @return Precio base.
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Establece el precio base del automóvil.
     *
     * @param precioBase Precio a asignar.
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Obtiene la fábrica que posee este automóvil.
     *
     * @return Fábrica propietaria.
     */
    public Fabrica getOwnedByFabricaAutos() {
        return ownedByFabricaAutos;
    }

    /**
     * Establece la fábrica que posee este automóvil.
     *
     * @param ownedByFabricaAutos Fábrica a asignar.
     */
    public void setOwnedByFabricaAutos(Fabrica ownedByFabricaAutos) {
        this.ownedByFabricaAutos = ownedByFabricaAutos;
    }

    /**
     * Obtiene la lista de ventas asociadas a este automóvil.
     *
     * @return Lista de ventas.
     */
    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }

    /**
     * Establece la lista de ventas asociadas a este automóvil.
     *
     * @param listaVentas Lista de ventas a asignar.
     */
    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    /**
     * Retorna una representación en forma de texto del automóvil.
     *
     * @return Información del automóvil como cadena.
     */
    @Override
    public String toString() {
        return "Automovil [nombre=" + nombre + ", modelo=" + modelo + ", tipoMotor=" + tipoMotor
                + ", capacidadPasajeros=" + capacidadPasajeros + ", precioBase=" + precioBase
                + ", ownedByFabricaAutos=" + ownedByFabricaAutos + "]";
    }
}
