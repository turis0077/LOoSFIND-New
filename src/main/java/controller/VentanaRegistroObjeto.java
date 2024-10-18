package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.ObjetoPerdido;
import service.ObjetosExtraviados;

public class VentanaRegistroObjeto {

    @FXML
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
    }
}
