package controller;

import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.scene.control.TextField;
import model.ObjetoPerdido;
import service.ObjetosExtraviados;
=======
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.ObjetoPerdido;
import service.DatabaseService;

>>>>>>> pollito

public class VentanaRegistroObjeto {

    @FXML
<<<<<<< HEAD
    private TextField nombreObjeto;

    @FXML
    private TextField descripcionObjeto;

    @FXML
    private TextField altoField;

    @FXML
    private TextField anchoField;

    @FXML
    private TextField largoField;

    @FXML
    private TextField ubicacionObjeto;

    @FXML
    public void registrarObjeto() {
        String nombre = nombreObjeto.getText();
        String descripcion = descripcionObjeto.getText();
        double alto = Double.parseDouble(altoField.getText()); // Convertir a double
        double ancho = Double.parseDouble(anchoField.getText()); // Convertir a double
        double largo = Double.parseDouble(largoField.getText()); // Convertir a double
        String ubicacion = ubicacionObjeto.getText();

        ObjetoPerdido objeto = new ObjetoPerdido(nombre, descripcion, alto, ancho, largo, "", ubicacion);
        ObjetosExtraviados servicioObjetos = new ObjetosExtraviados();
        servicioObjetos.registrarObjeto(objeto);
=======
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

                ObjetoPerdido nuevoObjeto = new ObjetoPerdido(tipoObjeto, color, tamano, forma, fecha, ubicacion,
                        estado,
                        enSecretaria);

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
        tipoObjetoField.clear();
        colorField.clear();
        dimensionesField.clear();
        formaField.clear();
        fechaField.clear();
        estadoField.clear();
        ubicacionField.clear();
        enSecretariaCheckbox.setSelected(false);
>>>>>>> pollito
    }
}
