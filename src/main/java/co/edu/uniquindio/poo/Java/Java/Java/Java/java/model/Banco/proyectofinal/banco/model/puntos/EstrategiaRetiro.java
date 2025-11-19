package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.RangoCliente;
/*Clase que implementa la estrategia de puntuación para retiros.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

// Retiro: 1 punto cada 200; si BRONCE y monto < 100 -> 0
public class EstrategiaRetiro implements IEstrategiaPuntuacion {
    @Override
    public int calcularPuntos(Transaccion transaccion, Cliente cliente) {
        if (cliente.getRango() == RangoCliente.BRONCE && transaccion.getMonto() < 100) {
            return 0;
        }
        int base = (int) (transaccion.getMonto() / 200);
        return (int) Math.floor(base * ReglaPuntos.multiplicadorPorRango(cliente.getRango()));
    }
}