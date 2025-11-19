package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/*Clase que gestiona la planificación y ejecución de transacciones programadas.
* Permite agregar transacciones programadas, ejecutar las pendientes y listar las mismas.
* @author DANIEL GIL, JHONATAN MOSQUERA.
 */
public class PlanificadorTransacciones {
    private final List<TransaccionProgramada> pendientes = new ArrayList<>();
    private final GestorTransaccion gestor;

    /*Constructor que inicializa el planificador con un gestor de transacciones.
    * @param gestor         Gestor de transacciones utilizado para ejecutar las transacciones programadas.
    */

    public PlanificadorTransacciones(GestorTransaccion gestor) {
        this.gestor = gestor;
    }
    public void agregar(TransaccionProgramada tp) {
        pendientes.add(tp);
    }

    /*Método que ejecuta las transacciones programadas pendientes para un cliente dado.
    */

    public void ejecutarPendientes(Cliente cliente) {
        List<TransaccionProgramada> ejecutables = new ArrayList<>();
        for (TransaccionProgramada tp : pendientes) {
            if (!LocalDate.now().isBefore(tp.getFechaEjecucion())) {
                ejecutables.add(tp);
            }
        }
        for (TransaccionProgramada tp : ejecutables) {
            boolean ok = gestor.ejecutarTransaccion(tp, cliente);
            pendientes.remove(tp);
            if (ok && tp.isRecurrente()) {
                TransaccionProgramada siguiente = new TransaccionProgramada(
                        tp.getCuentaOrigen(), tp.getCuentaDestino(), tp.getMonto(),
                        tp.proximaFecha(), true, tp.getFrecuenciaDias(), tp.getTipoTransaccion()
                );
                agregar(siguiente);
            }
        }
    }
    /*Metodo que devuelve la lista de transacciones programadas pendientes.
    */
   
    public List<TransaccionProgramada> listarPendientes() { return new ArrayList<>(pendientes); }

}
