package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
/*Clase que implementa la estrategia de puntuación para depósitos.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

// Depósito: 1 punto cada 100 +1 si monto >= 1000
public class EstrategiaDeposito implements IEstrategiaPuntuacion {
    @Override
    public int calcularPuntos(Transaccion transaccion, Cliente cliente) {
        int base = (int) (transaccion.getMonto() / 100);
        if (transaccion.getMonto() >= 1000) base += 1;
        return (int) Math.floor(base * ReglaPuntos.multiplicadorPorRango(cliente.getRango()));
    }
}
