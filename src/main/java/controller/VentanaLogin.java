package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    
    // Mapa para almacenar usuarios
    private Map<String, String> users = new HashMap<>();

    public VentanaLogin() {
        // Crear un usuario predeterminado para acceso inmediato
        users.put("devCGS", "uvg12345"); // Usuario predeterminado para el desarrollador
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // Métodos para manejar eventos
    @FXML
    public void loginButton() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Verificar si las credenciales coinciden con un usuario registrado
        if (users.containsKey(username) && users.get(username).equals(password)) {
            accesoMenuPrincipal(); // Abrir la ventana principal si las credenciales son correctas
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de inicio de sesión");
            alert.setHeaderText("Credenciales incorrectas");
            alert.setContentText("El nombre de usuario o la contraseña son incorrectos.");
            alert.showAndWait();
        }
    }

    @FXML
    public void registerButton() {
        openRegisterWindow();
    }

    public void accesoMenuPrincipal() {
        try {
            // Cargar y mostrar la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaPrincipal.fxml"));
            Parent mainRoot = loader.load();
            VentanaPrincipal principalController = loader.getController();
            primaryStage.setScene(new Scene(mainRoot));
            primaryStage.setTitle("Ventana Principal");
            primaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la ventana principal");
            alert.setContentText("No se pudo cargar la ventana principal. Por favor, inténtalo de nuevo.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    public void openRegisterWindow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaRegistro.fxml"));
            Parent registerRoot = loader.load();
            VentanaRegisterUsuario registerUserController = loader.getController();
            
            Stage registerStage = new Stage();
            registerStage.setTitle("Registro de usuario");
            registerStage.setScene(new Scene(registerRoot));
            registerStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la ventana de registro");
            alert.setContentText("No se pudo cargar la ventana de registro. Por favor, inténtalo de nuevo.");
            alert.showAndWait();
        }
    }
}
