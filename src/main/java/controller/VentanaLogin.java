package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.DatabaseService;

import java.io.IOException;

public class VentanaLogin {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    private Stage primaryStage;

    private DatabaseService dbService = new DatabaseService(); // Asegura inicialización aquí

    public VentanaLogin() {
        // Constructor vacío
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void loginButton() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Campos vacíos", "Por favor, completa todos los campos", Alert.AlertType.WARNING);
            return;
        }

        // Verificar si el usuario y contraseña existen en la base de datos
        boolean accesoPermitido = dbService.verificarCredenciales(username, password);

        if (accesoPermitido) {
            accesoMenuPrincipal();
        } else {
            showAlert("Error de inicio de sesión", "El nombre de usuario o la contraseña son incorrectos.", Alert.AlertType.ERROR);
        }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void accesoMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaPrincipal.fxml"));
            Parent mainRoot = loader.load();
            primaryStage.setScene(new Scene(mainRoot));
            primaryStage.setTitle("Ventana Principal");
            primaryStage.show();
        } catch (IOException e) {
            showAlert("Error", "Error al cargar la ventana principal", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @FXML
    public void registerButton() {
        openRegisterWindow();
    }

    public void openRegisterWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaRegisterUsuario.fxml"));
            Parent registerRoot = loader.load();
            
            Stage registerStage = new Stage();
            registerStage.setTitle("Registro de usuario");
            registerStage.setScene(new Scene(registerRoot));
            registerStage.show();
        } catch (IOException e) {
            showAlert("Error", "Error al cargar la ventana de registro", Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }
}
