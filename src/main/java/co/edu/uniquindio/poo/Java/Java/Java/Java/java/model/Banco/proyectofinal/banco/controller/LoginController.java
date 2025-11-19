package co.edu.uniquindio.poo.proyectofinal.banco.controller;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Usuario;
import com.dlsc.formsfx.model.structure.PasswordField;
import javafx.fxml.FXML;

import java.awt.*;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;

    private Banco banco;

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    @FXML
    private void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        Usuario usuario = banco.buscarUsuario(user);
        if (usuario != null && usuario.autenticar(user, pass)) {
            messageLabel.setText("Bienvenido " + usuario.getCliente().getNombre());
            // TODO: cargar DashboardView.fxml
        } else {
            messageLabel.setText("Usuario o contraseña incorrectos");
        }
    }

    @FXML
    private void handleRegister() {
        String user = usernameField.getText();
        String pass = passwordField.getText();
        Cliente nuevo = new Cliente(user, user); // id = username
        banco.crearUsuario(user, pass, nuevo);
        messageLabel.setText("Usuario registrado exitosamente");
    }
}
