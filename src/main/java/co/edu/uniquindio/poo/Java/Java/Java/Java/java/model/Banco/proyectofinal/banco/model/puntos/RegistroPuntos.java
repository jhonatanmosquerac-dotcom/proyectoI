package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;

/*Clase que representa el registro de puntos de un cliente.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class RegistroPuntos {
    private Cliente cliente;
    
    /*Constructor que inicializa el registro de puntos con un cliente.
    */

    public RegistroPuntos(Cliente cliente) {
        this.cliente = cliente;
    }

    /*getter del atributo cliente */
    public Cliente getCliente() {
        return cliente;
    }

    /*Método que registra los puntos obtenidos por el cliente.
    */

    public void registrar(int puntos) {
        cliente.setPuntos(cliente.getPuntos() + Math.max(0, puntos));
        cliente.actualizarRango();
    }

    /*Método toString para representar el registro de puntos como una cadena.
    */
    @Override
    public String toString() {
        return "RegistroPuntos{" +
                "cliente=" + cliente +
                '}';
    }
}
