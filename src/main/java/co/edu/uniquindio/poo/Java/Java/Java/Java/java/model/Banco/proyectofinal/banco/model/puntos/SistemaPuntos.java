package co.edu.uniquindio.poo.proyectofinal.banco.model.puntos;

/*Clase que representa el sistema de puntos de un cliente.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class SistemaPuntos {

    /*Atributo que almacena los puntos del cliente.
    */

    private int puntos;

    /*Getter y setter del atributo puntos.
    */

    public int getPuntos() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /*Método que acumula puntos al sistema.
    */
    public void acumular(int puntos) {
        if (puntos > 0) this.puntos += puntos;
    }

    /*Método que reversa puntos del sistema.
    */

    public void reversar(int puntos) {
        this.puntos = Math.max(0, this.puntos - Math.max(0, puntos));
    }
    /*Método toString para representar el sistema de puntos como una cadena.
    */
    @Override
    public String toString() {
        return "SistemaPuntos{" +
                "puntos=" + puntos +
                '}';
    }
}

