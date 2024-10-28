package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class VentanaPrincipal {

    @FXML
    private TableView<Object> objectsTableView;

    @FXML
    private TableColumn<Object, String> typeColumn;

    @FXML
    private TableColumn<Object, String> colorColumn;

    @FXML
    private TableColumn<Object, String> formColumn;

    @FXML
    private TableColumn<Object, String> dateColumn;

    @FXML
    private TableColumn<Object, String> locationColumn;

    @FXML
    private TextField searchField;

    @FXML
    public void initialize() {
    }

    @FXML
    public void addObject() {
        System.out.println("Agregar nuevo objeto");
    }
}
