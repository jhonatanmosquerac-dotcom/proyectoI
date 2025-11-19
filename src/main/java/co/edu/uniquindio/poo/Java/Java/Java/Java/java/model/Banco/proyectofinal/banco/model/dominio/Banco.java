package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.GestorTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.PlanificadorTransacciones;
import co.edu.uniquindio.poo.proyectofinal.banco.model.servicios.ReporteGasto;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.*;
import model.transacciones.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*Clase que representa un banco con sus clientes, cuentas y servicios.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class Banco {
    private String nombre;
    private String contacto;
    private String email;
    private String nit;
    private String ubicacionSedeFisica;
    private List<Cliente> listaClientes;
    private List<CuentaVirtual> listaCuentas;
    private List<Beneficio> listaBeneficios;
    private GestorTransaccion gestor;
    private PlanificadorTransacciones planificador;

    /*Constructor de la clase Banco.
    * @param nombre                Nombre del banco.
    * @param contacto              Información de contacto del banco.
    * @param email                 Correo electrónico del banco.
    * @param nit                   Número de identificación tributaria del banco.
    * @param ubicacionSedeFisica   Ubicación de la sede física del banco.
    */

    public Banco(String nombre, String contacto, String email, String nit,String ubicacionSedeFisica) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.email = email;
        this.nit = nit;
        this.ubicacionSedeFisica = ubicacionSedeFisica;
        this.listaClientes = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
        this.listaBeneficios = new ArrayList<>();
        this.gestor = new GestorTransaccion();
        this.planificador = new PlanificadorTransacciones(gestor);
    }

    /** Getters y setters de los atributos de la clase Banco.
    */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContacto() {
        return contacto;
    }
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getUbicacionSedeFisica() {
        return ubicacionSedeFisica;
    }
    public void setUbicacionSedeFisica(String ubicacionSedeFisica) {
        this.ubicacionSedeFisica = ubicacionSedeFisica;
    }
    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    public List<CuentaVirtual> getListaCuentas() {
        return listaCuentas;
    }
    public void setListaCuentas(List<CuentaVirtual> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }
    public List<Beneficio> getListaBeneficios() {
        return listaBeneficios;
    }
    public void setListaBeneficios(List<Beneficio> listaBeneficios) {
        this.listaBeneficios = listaBeneficios;
    }
    public GestorTransaccion getGestor() {
        return gestor;
    }
    public void setGestor(GestorTransaccion gestor) {
        this.gestor = gestor;
    }
    public PlanificadorTransacciones getPlanificador() {
        return planificador;
    }
    public void setPlanificador(PlanificadorTransacciones planificador) {
        this.planificador = planificador;
    }

    /* Métodos para agregar, buscar, eliminar y actualizar clientes y cuentas.
    * (CRUD)
    */

    /* Método que agrega un cliente a la lista de clientes */
    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    /* Método que agrega una cuenta a la lista de cuentas */
    public void agregarCuenta(CuentaVirtual cuenta) {
        listaCuentas.add(cuenta);
    }
    /* Método que agrega un beneficio a la lista de beneficios */
    public void agregarBeneficio(Beneficio beneficio) {
        listaBeneficios.add(beneficio);
    }

    /* Método que busca un cliente por su ID */
    public Cliente buscarClientePorId(String id) {
        return listaClientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    /* Método que elimina un cliente por su ID */
    public boolean eliminarCliente(String id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            listaClientes.remove(cliente);
            return true;
        }
        return false;
    }

    /* Método que busca una cuenta por su número en la lista de cuentas de un cliente */
    public CuentaVirtual buscarCuenta(Cliente cliente, String numeroCuenta) {
        return cliente.getListaCuentas().stream()
                .filter(c -> c.getNumeroCuenta().equals(numeroCuenta))
                .findFirst()
                .orElse(null);
    }
    /* Método que elimina una cuenta de la lista de cuentas de un cliente */
    public boolean eliminarCuenta(Cliente cliente, String numeroCuenta) {
        CuentaVirtual cuenta = buscarCuenta(cliente, numeroCuenta);
        if (cuenta != null) {
            cliente.getListaCuentas().remove(cuenta);
            return true;
        }
        return false;
    }

    /**
     *  public boolean actualizarCliente(String id, String nuevoNombre) {
     *      Cliente cliente = buscarClientePorId(id);
     *      if (cliente != null) {
     *          Cliente actualizado = new Cliente(nuevoNombre, cliente.getId());
     *          actualizado.setPuntos(cliente.getPuntos());
     *          actualizado.actualizarRango();
     *          clientes.remove(cliente);
     *          clientes.add(actualizado);
     *          return true;
     *       }
     *      return false;
     *  }
     *
     */

    // Operaciones básicas

    /* Métodos para realizar un deposito*/
    public void realizarDeposito(Cliente cliente, CuentaVirtual cuenta, double monto) {
        Transaccion deposito = new Deposito(cuenta, monto);
        gestor.ejecutarTransaccion(deposito, cliente);
    }
    /* Métodos para realizar un retiro*/
    public void realizarRetiro(Cliente cliente, CuentaVirtual cuenta, double monto) {
        Transaccion retiro = new Retiro(cuenta, monto);
        gestor.ejecutarTransaccion(retiro, cliente);
    }

    /* Métodos para realizar una transferencia*/
    public void realizarTransferencia(Cliente cliente, CuentaVirtual origen, CuentaVirtual destino, double monto) {
        Transaccion transferencia = new Transferencia(origen, destino, monto);
        gestor.ejecutarTransaccion(transferencia, cliente);
    }

    // Programar transacciones

    /* Método para programar un deposito futuro
    */

    public void programarDeposito(Cliente cliente, CuentaVirtual destino, double monto, int dias) {
        TransaccionProgramada tp = new TransaccionProgramada(
                null, destino, monto,
                LocalDate.now().plusDays(dias),
                false, 0, TipoTransaccion.DEPOSITO
        );
        planificador.agregar(tp);
    }

    /* Método para ejecutar transacciones programadas
    */

    public void ejecutarTransaccionesProgramadas(Cliente cliente) {
        planificador.ejecutarPendientes(cliente);
    }

    // Reportes

    /* Método para generar un reporte de gasto */
    public void generarReporteGasto(Cliente cliente, LocalDate inicio, LocalDate fin) {
        ReporteGasto reporte = new ReporteGasto(cliente, inicio, fin);
        reporte.imprimirReporte();
    }

    /* Método que permite canjear un beneficio por un cliente */
    public boolean canjearBeneficio(Cliente cliente, String nombreBeneficio) {
        return listaBeneficios.stream()
                .filter(b -> b.getNombre().equalsIgnoreCase(nombreBeneficio))
                .findFirst()
                .map(b -> b.canjear(cliente))
                .orElse(false);
    }

    /* Método to string que representa el banco y sus atributos*/

    @Override
    public String toString() {
        return "Banco{" +
                "nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                ", email='" + email + '\'' +
                ", nit='" + nit + '\'' +
                ", ubicacionSedeFisica='" + ubicacionSedeFisica + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaCuentas=" + listaCuentas +
                ", gestor=" + gestor +
                ", planificador=" + planificador +
                '}';
    }
}
