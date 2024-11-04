package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.ObjetoPerdido;
import service.DatabaseService;


public class VentanaRegistroObjeto {

    @FXML
    private TextField idField;
    
    @FXML
    private TextField tipoObjetoField;

    @FXML
    private TextField colorField;

    @FXML
    private TextField dimensionesField;

    @FXML
    private TextField formaField;

    @FXML
    private TextField fechaField;

    @FXML
    private TextField estadoField;

    @FXML
    private TextField ubicacionField;

    @FXML
    private CheckBox enSecretariaCheckbox;

    @FXML
    private Button registrarButton;

    private DatabaseService databaseService = new DatabaseService();
    private String id;

    @FXML
    private void initialize() {
        registrarButton.setOnAction(event -> registrarObjeto());
    }

    public void registrarObjeto() {
        if (camposValidos()) {
            try {
                String tipoObjeto = tipoObjetoField.getText();
                String color = colorField.getText();
                String tamano = dimensionesField.getText();
                String forma = formaField.getText();
                String fecha = fechaField.getText();
                String ubicacion = ubicacionField.getText();
                String estado = estadoField.getText();
                boolean enSecretaria = enSecretariaCheckbox.isSelected();

                ObjetoPerdido nuevoObjeto = new ObjetoPerdido(id, tipoObjeto, color, tamano, forma, fecha, ubicacion,estado,enSecretaria);

                databaseService.registrarObjeto(nuevoObjeto);

                limpiarCampos();

                System.out.println("Objeto registrado exitosamente: " + nuevoObjeto);

            } catch (Exception e) {
                System.err.println("Error al registrar el objeto: " + e.getMessage());
            }
        } else {
            System.out.println("Por favor, complete todos los campos antes de registrar.");
        }
    }

    private boolean camposValidos() {
        return !tipoObjetoField.getText().isEmpty() && !colorField.getText().isEmpty()
                && !dimensionesField.getText().isEmpty() && !formaField.getText().isEmpty()
                && !fechaField.getText().isEmpty() && !ubicacionField.getText().isEmpty()
                && !estadoField.getText().isEmpty();
    }

    private void limpiarCampos() {
        idField.clear();
        tipoObjetoField.clear();
        colorField.clear();
        dimensionesField.clear();
        formaField.clear();
        fechaField.clear();
        estadoField.clear();
        ubicacionField.clear();
        enSecretariaCheckbox.setSelected(false);
    }
}
