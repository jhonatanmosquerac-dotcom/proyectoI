package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.TransaccionProgramada;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalEmail;
import co.edu.uniquindio.poo.proyectofinal.banco.model.notificaciones.CanalSMS;
import co.edu.uniquindio.poo.proyectofinal.banco.model.puntos.RegistroPuntos;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.MontoInvalidoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*Clase que gestiona la ejecución de transacciones bancarias,
* incluyendo verificación, notificación y registro de puntos.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class GestorTransaccion{
    private List<Transaccion> listaTransacciones = new ArrayList<>();
    private Notificador notificador = new Notificador();

    /*Constructor que inicializa el notificador con canales de comunicación predeterminados.
    */
    public GestorTransaccion() {
        notificador.agregarCanal(new CanalEmail());
        notificador.agregarCanal(new CanalSMS());
    }

    /*Método que ejecuta una transacción bancaria, verifica el monto,
    * notifica a los clientes involucrados y registra puntos.
    */
    public boolean ejecutarTransaccion(Transaccion transaccion, Cliente clienteInvolucrado) {
        // Verificación antes
        if (transaccion.getMonto() <= 0) {
            throw new MontoInvalidoException("Monto inválido");
        }

        boolean ok = transaccion.ejecutar();
        if (!ok) {
            return false;
        }

        listaTransacciones.add(transaccion);

        // Notificar según cuentas implicadas
        String mensage = transaccion.enviarNotificacion();
        if (transaccion.getCuentaOrigen() != null && transaccion.getCuentaOrigen().getCliente() != null) {
            notificador.notificarCliente(transaccion.getCuentaOrigen().getCliente(), mensage);
        }
        if (transaccion.getCuentaDestino() != null && transaccion.getCuentaDestino().getCliente() != null) {
            notificador.notificarCliente(transaccion.getCuentaDestino().getCliente(), mensage);
        }

        // Registrar puntos al cliente indicado (control de negocio)
        if (clienteInvolucrado != null) {
            int puntos = transaccion.calcularPuntos(clienteInvolucrado);
            new RegistroPuntos(clienteInvolucrado).registrar(puntos);
        }

        return true;
    }

    /*Método que devuelve la lista de transacciones realizadas.
    */
    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }
    /*Método que ordena una lista de transacciones programadas por fecha de ejecución.
    */
    public List<TransaccionProgramada> ordenarPorFecha(List<TransaccionProgramada> lista) {
        lista.sort(Comparator.comparing(TransaccionProgramada::getFechaEjecucion));
        return lista;
    }
}
