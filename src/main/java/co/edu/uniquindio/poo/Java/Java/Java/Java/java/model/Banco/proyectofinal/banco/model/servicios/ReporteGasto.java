package co.edu.uniquindio.poo.proyectofinal.banco.model.servicios;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.soporte.TipoTransaccion;
import co.edu.uniquindio.poo.proyectofinal.banco.model.transacciones.Transaccion;

import java.time.LocalDate;

/*Clase que genera reportes de gastos para un cliente en un período específico.
* Permite calcular totales por tipo de transacción y total general.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class ReporteGasto {
    private final Cliente cliente;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;

    /*Constructor que inicializa el reporte con un cliente y un rango de fechas.
    * @param cliente        Cliente para el cual se genera el reporte.
    * @param inicio         Fecha de inicio del período del reporte.
    * @param fin            Fecha de fin del período del reporte.
    */
    public ReporteGasto(Cliente cliente, LocalDate inicio, LocalDate fin) {
        this.cliente = cliente;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
    }
    /*Método que calcula el total de gastos por tipo de transacción en el período especificado.
    */
    public double calcularTotalPorTipo(TipoTransaccion tipo) {
        return cliente.getHistorialT().getListaTransacciones().stream()
                .filter(t -> t.getFecha().toLocalDate().isAfter(fechaInicio.minusDays(1))
                        && t.getFecha().toLocalDate().isBefore(fechaFin.plusDays(1)))
                .filter(t -> t.getTipo() == tipo)
                .mapToDouble(Transaccion::getMonto)
                .sum();
    }

    /*Método que calcula el total general de gastos en el período especificado.
    */
    public double calcularTotalGeneral() {
        return cliente.getHistorialT().getListaTransacciones().stream()
                .filter(t -> t.getFecha().toLocalDate().isAfter(fechaInicio.minusDays(1))
                        && t.getFecha().toLocalDate().isBefore(fechaFin.plusDays(1)))
                .mapToDouble(Transaccion::getMonto)
                .sum();
    }

    /*Método que imprime el reporte de gastos.
    */
    public void imprimirReporte() {
        System.out.println("=== Reporte de gastos de " + cliente.getNombre() + " ===");
        System.out.println("Periodo: " + fechaInicio + " a " + fechaFin);
        System.out.println("Total depósitos: " + calcularTotalPorTipo(TipoTransaccion.DEPOSITO));
        System.out.println("Total retiros: " + calcularTotalPorTipo(TipoTransaccion.RETIRO));
        System.out.println("Total transferencias: " + calcularTotalPorTipo(TipoTransaccion.TRANSFERENCIA));
        System.out.println("Total general: " + calcularTotalGeneral());
    }

}
