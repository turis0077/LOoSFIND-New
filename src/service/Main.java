package com.service;


import controller.VentanaLogin;
import controller.VentanaPrincipal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // accion que permite iniciar desde login al ejecutar Gradle run
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaLogin.fxml"));
        Parent root = loader.load();

        VentanaLogin loginController = loader.getController();
        loginController.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Inicio de Sesión");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}