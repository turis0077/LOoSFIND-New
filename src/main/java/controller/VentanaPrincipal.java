package controller;

<<<<<<< HEAD
import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
=======
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ObjetoPerdido;
import service.DatabaseService;

import java.io.IOException;
import java.util.List;
>>>>>>> pollito
=======
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ObjetoPerdido;
import service.DatabaseService;
>>>>>>> eevee

public class VentanaPrincipal {

    @FXML
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
    private TableView<ObjetoPerdido> objectsTableView;

    @FXML
=======
    private TableView<ObjetoPerdido> objectsTableView;

    @FXML
    private TableColumn<ObjetoPerdido, String> idColumn;
    
    @FXML
>>>>>>> eevee
    private TableColumn<ObjetoPerdido, String> typeColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> colorColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> dimensionsColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> formColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> dateColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> locationColumn;

    @FXML
    private TableColumn<ObjetoPerdido, String> statusColumn;

    @FXML
    private TableColumn<ObjetoPerdido, Boolean> secretariaColumn;
<<<<<<< HEAD
<<<<<<< HEAD
    
>>>>>>> pollito
=======
>>>>>>> pollito
=======
    
>>>>>>> eevee

    @FXML
    private TextField searchField;

    @FXML
    public void initialize() {
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> eevee
        configurarColumnas();
        cargarDatosEnTabla();
    }

<<<<<<< HEAD
    @FXML
    private void buscar() {
        System.out.println("Buscando: " + searchField.getText().trim()); // Verificación en consola
        String palabraClave = searchField.getText().trim();
        if (!palabraClave.isEmpty()) {
            DatabaseService dbService = new DatabaseService();
            List<ObjetoPerdido> resultados = dbService.buscarObjetos(palabraClave);
            objectsTableView.getItems().setAll(resultados);
        } else {
            cargarDatosEnTabla(); // Cargar todos los objetos si el campo de búsqueda está vacío
        }
    }

    private void configurarColumnas() {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("tipoObjeto"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        dimensionsColumn.setCellValueFactory(new PropertyValueFactory<>("dimensiones"));
        formColumn.setCellValueFactory(new PropertyValueFactory<>("forma"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
=======
    private void configurarColumnas() {
        // Configurar las columnas con los atributos de la clase Object
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idColumn.setVisible(false); //permite que la columna id no sea visible
        
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("tipoObjeto"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        formColumn.setCellValueFactory(new PropertyValueFactory<>("forma"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        dimensionsColumn.setCellValueFactory(new PropertyValueFactory<>("dimensiones"));
>>>>>>> eevee
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("estado"));
        secretariaColumn.setCellValueFactory(new PropertyValueFactory<>("enSecretaria"));
    }

    private void cargarDatosEnTabla() {
        DatabaseService dbService = new DatabaseService();
        List<ObjetoPerdido> objetos = dbService.obtenerTodosLosObjetos();

        if (objetos != null) {
            objectsTableView.getItems().setAll(objetos);
        } else {
            System.out.println("No se obtuvieron datos de la base de datos.");
        }
<<<<<<< HEAD
>>>>>>> pollito
=======
>>>>>>> eevee
    }

    @FXML
    public void addObject() {
        System.out.println("Agregar nuevo objeto");
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> eevee
        abrirVentanaRegistroObjeto();
    }

    @FXML
    public void abrirVentanaRegistroObjeto() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/VistaRegistroObjeto.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
>>>>>>> pollito
=======
>>>>>>> eevee
    }
}
