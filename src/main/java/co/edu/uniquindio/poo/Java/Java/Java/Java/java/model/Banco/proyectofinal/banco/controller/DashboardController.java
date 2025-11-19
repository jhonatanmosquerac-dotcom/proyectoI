package co.edu.uniquindio.poo.proyectofinal.banco.controller;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import javafx.fxml.FXML;

import java.lang.classfile.Label;

public class DashboardController {
    @FXML
    private Label saldoLabel;
    @FXML private Label puntosLabel;

    private Banco banco;
    private Cliente cliente;

    public void setContext(Banco banco, Cliente cliente) {
        this.banco = banco;
        this.cliente = cliente;
        actualizarInfo();
    }

    private void actualizarInfo() {
        saldoLabel.setText("Saldo: " + cliente.consultarSaldo());
        puntosLabel.setText("Puntos: " + cliente.getPuntos());
    }

    @FXML private void handleDeposito() { /* abrir TransaccionView.fxml */ }
    @FXML private void handleRetiro() { /* abrir TransaccionView.fxml */ }
    @FXML private void handleTransferencia() { /* abrir TransaccionView.fxml */ }
    @FXML private void handleBeneficios() { /* abrir BeneficiosView.fxml */ }
    @FXML private void handleLogout() { /* volver a LoginView.fxml */ }

}
