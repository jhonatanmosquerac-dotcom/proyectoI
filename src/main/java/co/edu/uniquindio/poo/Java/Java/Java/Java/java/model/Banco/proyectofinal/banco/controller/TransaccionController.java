package co.edu.uniquindio.poo.proyectofinal.banco.controller;

import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Banco;
import co.edu.uniquindio.poo.proyectofinal.banco.model.dominio.Cliente;
import javafx.fxml.FXML;

import java.awt.*;

public class TransaccionController {
    @FXML
    private TextField montoField;
    @FXML private TextField origenField;
    @FXML private TextField destinoField;
    @FXML private Label messageLabel;

    private Banco banco;
    private Cliente cliente;

    public void setContext(Banco banco, Cliente cliente) {
        this.banco = banco;
        this.cliente = cliente;
    }

    @FXML private void handleDeposito() {
        double monto = Double.parseDouble(montoField.getText());
        banco.realizarDeposito(cliente, cliente.buscarCuenta(origenField.getText()), monto);
        messageLabel.setText("Depósito realizado");
    }

    @FXML private void handleRetiro() {
        double monto = Double.parseDouble(montoField.getText());
        banco.realizarRetiro(cliente, cliente.buscarCuenta(origenField.getText()), monto);
        messageLabel.setText("Retiro realizado");
    }

    @FXML private void handleTransferencia() {
        double monto = Double.parseDouble(montoField.getText());
        banco.realizarTransferencia(cliente,
                cliente.buscarCuenta(origenField.getText()),
                cliente.buscarCuenta(destinoField.getText()),
                monto);
        messageLabel.setText("Transferencia realizada");
    }
}
