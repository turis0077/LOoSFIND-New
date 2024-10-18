package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Usuario;
import service.DatabaseService;

public class VentanaUsuario {

    @FXML
    private Label nombreUsuario;

    private Usuario usuarioActual;

    public VentanaUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    @FXML
    public void initialize() {
        nombreUsuario.setText(usuarioActual.getNombre());
    }
}
