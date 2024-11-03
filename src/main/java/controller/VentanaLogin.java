package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VentanaLogin {

    @FXML
    private Button loginButton;

    private Stage primaryStage;
    
    public VentanaLogin(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private Button registerButton;

    // Métodos para manejar eventos
    @FXML
    public void loginButton() {
        accesoMenuPrincipal();
    }

    @FXML
    public void registerButton() {
        openRegisterWindow();
    }

    public void accesoMenuPrincipal() {
        try {
            // Cargar y mostrar la ventana principal
            FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
            Parent mainRoot = loader.load();
            VentanaPrincipal principalController = loader.getController();
            primaryStage.setScene(new Scene(mainRoot));
            primaryStage.setTitle("Ventana Principal");
            primaryStage.show();
        } catch (IOException e) { //mensaje de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar la ventana principal");
            alert.setContentText("No se pudo cargar la ventana principal. Por favor, inténtalo de nuevo.");
            alert.showAndWait();
        }
    }

    public void openRegisterWindow() {
        Stage newStage = new Stage();
        Pane pane = new Pane(); 
        Scene scene = new Scene(pane, 850, 424);
        newStage.setTitle("Registro de usuario");
        newStage.setScene(scene);
        newStage.show();
    }
}
