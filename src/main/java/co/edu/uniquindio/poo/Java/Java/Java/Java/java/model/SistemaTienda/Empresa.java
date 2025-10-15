package co.edu.uniquindio.poo.Java.Java.Java.Java.java.model.SistemaTienda;

import java.util.LinkedList;
import java.util.List;

public class Empresa {

    private String nombreEmpresa;
    private String nit;
    private List<Factura> facturas;
    private List<Cliente> clientes;
    private List<Producto> productos;
    private DetalleFactura detalleFactura;

    public Empresa(String nombreEmpresa, String nit) {

    if(nombreEmpresa.isEmpty() || nit.isEmpty()){
        throw new IllegalArgumentException("Nombre de la empresa y NIT son obligatorios");
    }
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
        this.facturas = new LinkedList<>();
        this.clientes = new LinkedList<>();
        this.productos = new LinkedList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Facturadora [nombreEmpresa=" + nombreEmpresa + ", nit=" + nit + ", facturas=" + facturas + ", clientes="
                + clientes + ", productos=" + productos + "]";
    }

    public String registrarCliente(Cliente nuevoCliente){
        String resultado = "";
        Cliente clienteEncontrado = null;
        clienteEncontrado = buscarCliente(nuevoCliente.getCedula());
        if(clienteEncontrado == null){
            clientes.add(nuevoCliente);
            resultado= "Cliente registrado con exito";
        } else {
            resultado= "El cliente ya se encuentra registrado";
        }
        return resultado;
    }

    public Cliente buscarCliente(String cedula){
        Cliente clienteEncontrado = null;
        boolean encontrado = false;
        for(int i=0; i<clientes.size() && !encontrado; i++){
            if(clientes.get(i).getCedula().equals(cedula)){
                clienteEncontrado = clientes.get(i);
                encontrado = true;
            }
        }
        return clienteEncontrado;
    }

    public String eliminarCliente(String cedula){
        String resultado = "";
        Cliente clienteEncontrado = null;
        clienteEncontrado = buscarCliente(cedula);
        if(clienteEncontrado != null){
            clientes.remove(clienteEncontrado);
            resultado= "Cliente eliminado con exito";
        } else {
            resultado= "El cliente no se encuentra registrado";
        }
        return resultado;
    }

    public String registrarProducto(Producto nuevoProducto){
        String resultado = "";
        Producto productoEncontrado = null;
        productoEncontrado = buscarProducto(nuevoProducto.getCodigo());
        if(productoEncontrado == null){
            productos.add(nuevoProducto);
            resultado= "Producto registrado con exito";
        } else {
            resultado= "El producto ya se encuentra registrado";
        }
        return resultado;
    }

    public Producto buscarProducto(String codigo){
        Producto productoEncontrado = null;
        boolean encontrado = false;
        for(int i=0; i<productos.size() && !encontrado; i++){
            if(productos.get(i).getCodigo().equals(codigo)){
                productoEncontrado = productos.get(i);
                encontrado = true;
            }
        }
        return productoEncontrado;
    }

    public String eliminarProducto(String codigo){
        String resultado = "";
        Producto productoEncontrado = null;
        productoEncontrado = buscarProducto(codigo);
        if(productoEncontrado != null){
            productos.remove(productoEncontrado);
            resultado= "Producto eliminado con exito";
        } else {
            resultado= "El producto no se encuentra registrado";
        }
        return resultado;
    }


public String registrarFactura(){
    String resultado = "";
    Factura facturaEncontrada = null;
    facturaEncontrada = buscarFactura(detalleFactura.getNumero());
    if (facturaEncontrada == null) {
        facturas.add(detalleFactura);
        resultado = "Factura registrada con exito";
    } else {
        resultado = "La factura ya se encuentra registrada";
    }
    return resultado;
}

        public Factura buscarFactura(int numeroFactura){
        Factura facturaEncontrada = null;
        boolean encontrado = false;
        for(int i=0; i<facturas.size() && !encontrado; i++){
            if(facturas.get(i).getNumero() == numeroFactura){
                facturaEncontrada = facturas.get(i);
                encontrado = true;
            }
        }
        return facturaEncontrada;
    }

   public void generarFactura(){
    
   }

   public String eliminarFactura(int numeroFactura){
        String resultado = "";
        Factura facturaEncontrada = null;
        facturaEncontrada = buscarFactura(numeroFactura);
        if(facturaEncontrada != null){
            facturas.remove(facturaEncontrada);
            resultado= "Factura eliminada con exito";
        } else {
            resultado= "La factura no se encuentra registrada";
        }
        return resultado;
    }
}
