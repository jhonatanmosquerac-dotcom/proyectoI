package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

/*Clase que implementa la estrategia de puntuación para transferencias.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

// Transferencia: 1 punto cada 100; +2 si destino no pertenece al cliente
public class EstrategiaTransferencia implements IEstrategiaPuntuacion {

    /*Método que calcula los puntos para una transferencia.
    */
   
    @Override
    public int calcularPuntos(Transaccion transaccion, Cliente cliente) {
        int base = (int) (transaccion.getMonto() / 100);
        boolean destinoEsDelCliente = cliente.getListaCuentas().stream()
                .anyMatch(c -> c.getNumeroCuenta().equals(transaccion.getCuentaDestino().getNumeroCuenta()));
        if (!destinoEsDelCliente) base += 2;
        return (int) Math.floor(base * ReglaPuntos.multiplicadorPorRango(cliente.getRango()));
    }
}
