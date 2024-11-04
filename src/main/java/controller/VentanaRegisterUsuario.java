package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class VentanaRegisterUsuario {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    public VentanaRegisterUsuario() {
    }

    @FXML
    public void registerUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos vacíos");
            alert.setHeaderText("Por favor, completa todos los campos");
            alert.showAndWait();
            return;
        }

        // Lógica para registrar el usuario en la base de datos
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registro exitoso");
        alert.setHeaderText("Usuario registrado con éxito");
        alert.setContentText("El usuario " + username + " ha sido registrado.");
        alert.showAndWait();
    }
}