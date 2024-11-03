package com.controller;

import controller.VentanaRegistroObjeto;
import service.DatabaseService;
import service.ObjetosExtraviados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VentanaPrincipal {

    @FXML
    private Button addObject; // Botón para agregar objetos

    @FXML
    private TextField searchField; // Campo de búsqueda

    @FXML
    private TableView<ObjetosExtraviados> objectsTableView; // Tabla para mostrar los objetos registrados

    @FXML
    private TableColumn<ObjetosExtraviados, Integer> idColumn; //columna para el numero de identificacion (no visible)
    
    @FXML
    private TableColumn<ObjetosExtraviados, String> typeColumn; // Columna de tipo de objeto

    @FXML
    private TableColumn<ObjetosExtraviados, String> colorColumn; // Columna de color

    @FXML
    private TableColumn<ObjetosExtraviados, String> sizeColumn; // Columna de tamano

    @FXML
    private TableColumn<ObjetosExtraviados, String> shapeColumn; // Columna de forma

    @FXML
    private TableColumn<ObjetosExtraviados, String> dateColumn; // Columna de fecha

    @FXML
    private TableColumn<ObjetosExtraviados, String> locationColumn; // Columna de ubicacion

    @FXML
    private TableColumn<ObjetosExtraviados, String> estadoColumn; // Columna de estado

    @FXML
    private TableColumn<ObjetosExtraviados, String> secretariaColumn; // Columna de secretaria

    // Lista para almacenar los objetos de la tabla
    private ObservableList<ObjetosExtraviados> objectList = FXCollections.observableArrayList();

    // Inicialización de la vista y sus componentes
    @FXML
    public void initialize() {
        // Configurar las columnas con los atributos de la clase Object
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setVisible(false); //permite que la columna id no sea visible
        
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        shapeColumn.setCellValueFactory(new PropertyValueFactory<>("shape"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        estadoColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        secretariaColumn.setCellValueFactory(new PropertyValueFactory<>("secretary"));

        // Configurar la tabla con la lista observable
        objectsTableView.setItems(objectList);
    }

    public void cargarDatosDesdeBD() {
        Connection conexion = null;

        try {
            conexion = DatabaseService.ConectarBD();
            String query = "SELECT * FROM objetos_perdidos";
            PreparedStatement statement = conexion.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
    
            while (resultSet.next()) {
                ObjetosExtraviados nuevoObjeto = new ObjetosExtraviados(
                resultSet.getString("id"),
                resultSet.getString("tipo_objeto"),
                resultSet.getString("color"),
                resultSet.getString("dimensiones"),
                resultSet.getString("forma"),
                resultSet.getString("fecha"),
                resultSet.getString("ubicacion"),
                resultSet.getString("estado"),
                resultSet.getBoolean("en_secretaria")
            );
            objectList.add(nuevoObjeto);
        }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }
    

    public void abrirVentana(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/view/VistaRegistroObjeto.fxml"));
        Parent root = loader.load();

        VentanaRegistroObjeto registroController = loader.getController();
        registroController.setOnObjectRegistered(this::cargarDatosDesdeBD);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    
    // Acción al hacer click en el botón "Haz click aqui para agregar un objeto"
    @FXML
    public void addObject(MouseEvent event) {
        // Mostrar un mensaje de confirmación
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Objeto Agregado");
        alert.setHeaderText(null);
        alert.setContentText("Se ha agregado un nuevo objeto a la lista.");
        alert.showAndWait();
    }

    // Acción para buscar en la tabla según el texto del campo de búsqueda
    @FXML
    public void search() {
        String query = searchField.getText().toLowerCase();

        // Filtrar la lista de objetos según el texto ingresado
        ObservableList<ObjetosExtraviados> filteredList = FXCollections.observableArrayList();
        for (ObjetosExtraviados obj : objectList) {
            if (obj.getTipobjeto().toLowerCase().contains(query) || 
                obj.getColor().toLowerCase().contains(query)) {
                filteredList.add(obj);
            }
        }

        // Actualizar la tabla con los resultados filtrados
        objectsTableView.setItems(filteredList);
    }


}
