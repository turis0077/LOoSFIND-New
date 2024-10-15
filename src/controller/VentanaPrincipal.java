package com.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class VentanaPrincipal {

    @FXML
    private Button addObject; // Botón para agregar objetos

    @FXML
    private TextField searchField; // Campo de búsqueda

    @FXML
    private TableView<Object> objectTableView; // Tabla para mostrar los objetos registrados

    @FXML
    private TableColumn<Object, String> nameColumn; // Columna de tipo de objeto

    @FXML
    private TableColumn<Object, String> descriptionColumn; // Columna de color

    @FXML
    private TableColumn<Object, String> priceColumn; // Columna de tamaño

    @FXML
    private TableColumn<Object, String> priceColumn1; // Columna de forma

    @FXML
    private TableColumn<Object, String> priceColumn11; // Columna de fecha

    @FXML
    private TableColumn<Object, String> priceColumn111; // Columna de ubicación

    @FXML
    private TableColumn<Object, String> priceColumn1111; // Columna de estado

    @FXML
    private TableColumn<Object, String> priceColumn11111; // Columna de secretaría

    // Lista para almacenar los objetos de la tabla
    private ObservableList<Object> objectList = FXCollections.observableArrayList();

    // Inicialización de la vista y sus componentes
    @FXML
    public void initialize() {
        // Configurar las columnas con los atributos de la clase Object
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        priceColumn1.setCellValueFactory(new PropertyValueFactory<>("shape"));
        priceColumn11.setCellValueFactory(new PropertyValueFactory<>("date"));
        priceColumn111.setCellValueFactory(new PropertyValueFactory<>("location"));
        priceColumn1111.setCellValueFactory(new PropertyValueFactory<>("status"));
        priceColumn11111.setCellValueFactory(new PropertyValueFactory<>("secretary"));

        // Configurar la tabla con la lista observable
        objectTableView.setItems(objectList);
    }

    // Acción al hacer click en el botón "Haz click aqui para agregar un objeto"
    @FXML
    public void addObject(MouseEvent event) {
        // Crear un objeto ficticio para agregar a la tabla (puedes personalizar esto)
        Object newObject = new Object("Objeto", "Rojo", "Grande", "Cuadrado", "12/10/2024", "Edificio B", "Nuevo", "Secretaría A");
        objectList.add(newObject);

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
        ObservableList<Object> filteredList = FXCollections.observableArrayList();
        for (Object obj : objectList) {
            if (obj.getName().toLowerCase().contains(query) || 
                obj.getColor().toLowerCase().contains(query)) {
                filteredList.add(obj);
            }
        }

        // Actualizar la tabla con los resultados filtrados
        objectTableView.setItems(filteredList);
    }
}
