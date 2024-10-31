package service;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
<<<<<<< HEAD
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaPrincipal.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("LOoSFIND - Objetos Perdidos");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
=======
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/VistaPrincipal.fxml"));
        primaryStage.setTitle("LOoSFIND");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
>>>>>>> pollito
    }

    public static void main(String[] args) {
        launch(args);
    }
}
