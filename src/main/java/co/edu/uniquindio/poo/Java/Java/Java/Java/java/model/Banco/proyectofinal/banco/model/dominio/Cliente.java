package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.Notificacion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.Observador;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.SistemaPuntos;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.RangoCliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.Sujeto;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Clase que representa un cliente del banco, en implemeta la interfaz Sujeto para el patrón observador
* 
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class Cliente implements Sujeto {
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String id;
    private Banco ownedByBanco;
    private int puntos;
    private RangoCliente rango = RangoCliente.BRONCE;
    private SistemaPuntos sistemaPuntos = new SistemaPuntos();
    private List<Notificacion> listaNotificaciones = new ArrayList<>();
    private List<CuentaVirtual> listaCuentas = new ArrayList<>();
    private HistorialTransacciones historialT = new HistorialTransacciones();
    private List<Observador> observadores = new ArrayList<>();

    /*Constructor de la clase Cliente.
    * @param nombre                Nombre del cliente.
    * @param apellidos             Apellidos del cliente.
    * @param correo                Correo electrónico del cliente.
    * @param telefono              Teléfono del cliente.
    * @param fechaNacimiento       Fecha de nacimiento del cliente.
    * @param id                    Identificación del cliente.
    * @param ownedByBanco         Banco al que pertenece el cliente.
    */

    public Cliente(String nombre, String apellidos, String correo, String telefono, LocalDate fechaNacimiento, String id, Banco ownedByBanco) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.id = id;
        this.ownedByBanco = ownedByBanco;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Banco getOwnedByBanco() {
        return ownedByBanco;
    }
    public void setOwnedByBanco(Banco ownedByBanco) {
        this.ownedByBanco = ownedByBanco;
    }
    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public RangoCliente getRango() {
        return rango;
    }
    public void setRango(RangoCliente rango) {
        this.rango = rango;
    }
    public SistemaPuntos getSistemaPuntos() {
        return sistemaPuntos;
    }
    public void setSistemaPuntos(SistemaPuntos sistemaPuntos) {
        this.sistemaPuntos = sistemaPuntos;
    }
    public List<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }
    public void setListaNotificaciones(List<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }
    public List<CuentaVirtual> getListaCuentas() {
        return listaCuentas;
    }
    public void setListaCuentas(List<CuentaVirtual> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    public HistorialTransacciones getHistorialT() {
        return historialT;
    }
    public void setHistorialT(HistorialTransacciones historialT) {
        this.historialT = historialT;
    }
    public void setObservadores(List<Observador> observadores) {
        this.observadores = observadores;
    }
    public double consultarSaldo() {
        return listaCuentas.stream().mapToDouble(CuentaVirtual::getSaldo).sum();
    }

    // Métodos para gestionar cuentas

    /* Método que agrega una cuenta al cliente y establece la relación bidireccional */
    public void addCuenta(CuentaVirtual c) {
        c.setCliente(this);
        listaCuentas.add(c);
    }

    /* Método que consulta el historial de transacciones del cliente */
    public List<Transaccion> consultarHistorial() {
        return historialT.getListaTransacciones();
    }

    /* Método que actualiza el rango del cliente basado en sus puntos */
    public void actualizarRango() {
        if (puntos >= 2000) rango = RangoCliente.ORO;
        else if (puntos >= 1000) rango = RangoCliente.PLATA;
        else rango = RangoCliente.BRONCE;
    }

    /* Métodos para gestionar observadores */

    /* Método para suscribir un observador */
    @Override
    public void suscribir(Observador obs) {
        observadores.add(obs);
    }

    /* Método para desuscribir un observador */
    @Override
    public void desuscribir(Observador obs) {
        observadores.remove(obs);
    }

    /* Método para notificar a todos los observadores con un mensaje */
    @Override
    public void notificar(String mensaje) {
        observadores.forEach(o -> o.actualizar(mensaje));
    }

    /* Método para obtener la lista de observadores */
    @Override
    public List<Observador> getObservadores() {
        return observadores;
    }

    /* Método para agregar una notificación al cliente y suscribirla como observador */
    public void agregarNotificacion(Notificacion n) {
        listaNotificaciones.add(n);
        suscribir(n);
    }
    /* Método to string que representa el cliente y sus atributos*/
    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", id='" + id + '\'' +
                ", ownedByBanco=" + ownedByBanco +
                ", puntos=" + puntos +
                ", rango=" + rango +
                ", sistemaPuntos=" + sistemaPuntos +
                ", listaNotificaciones=" + listaNotificaciones +
                ", listaCuentas=" + listaCuentas +
                ", historialT=" + historialT +
                ", observadores=" + observadores +
                '}';
    }
}
