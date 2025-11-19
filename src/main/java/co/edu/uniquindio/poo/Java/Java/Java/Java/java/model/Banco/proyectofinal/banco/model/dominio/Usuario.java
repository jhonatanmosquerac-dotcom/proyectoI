package co.edu.uniquindio.poo.proyectofinal.banco.model.dominio;

/* Clase que representa un usuario del sistema bancario.
* @author DANIEL GIL, JHONATAN MOSQUERA.
*/

public class Usuario {
    private String username;
    private String password;
    private Cliente cliente;

    /* Constructor de la clase Usuario
    *   @param username    Nombre de usuario.
    *   @param password    Contraseña del usuario.
    *   @param cliente     Cliente asociado al usuario.
    */

    public Usuario(String username, String password, Cliente cliente) {
        this.username = username;
        this.password = password;
        this.cliente = cliente;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /* Método para autenticar al usuario */
    
    public boolean autenticar(String user, String pass) {
        return this.username.equals(user) && this.password.equals(pass);
    }
}
