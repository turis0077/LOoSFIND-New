package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ObjetoPerdido;
import service.ObjetosExtraviados;

public class VentanaRegistroObjeto {

    @FXML
    private TextField colorField;
    @FXML
    private TextField formaField;
    @FXML
    private TextField tipoField;
    @FXML
    private TextField ubicacionField;
    @FXML
    private TextArea descripcionField;
    @FXML
    private Button guardarButton;
    @FXML
    private Button regresarButton;

    private ObjetosExtraviados objetosExtraviados;
    private Stage stagePrincipal;

    public void setObjetosExtraviados(ObjetosExtraviados objetosExtraviados, Stage stagePrincipal) {
        this.objetosExtraviados = objetosExtraviados;
        this.stagePrincipal = stagePrincipal;
    }

    @FXML
    public void guardarObjeto() {
        ObjetoPerdido objeto = new ObjetoPerdido(
                colorField.getText(),
                formaField.getText(),
                tipoField.getText(),
                ubicacionField.getText(),
                descripcionField.getText()
        );
        objetosExtraviados.guardarObjeto(objeto);
    }

    @FXML
    public void regresarAlMenuPrincipal() {
        objetosExtraviados.mostrarVentanaPrincipal(stagePrincipal);
    }
}
