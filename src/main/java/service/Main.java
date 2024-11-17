package service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.VentanaLogin;
import java.io.IOException; // Importación de IOException0

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar el archivo FXML y obtener el controlador
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaLogin.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de VentanaLogin y asignar el primaryStage
            VentanaLogin loginController = loader.getController();
            loginController.setPrimaryStage(primaryStage);

            primaryStage.setTitle("LOoSFIND");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
