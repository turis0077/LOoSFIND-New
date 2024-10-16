package controller;

import service.DatabaseService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VentanaRegistroObjeto {

    public void registrarObjeto(String nombreObjeto, String descripcion) {
        Connection conexion = DatabaseService.ConectarBD();
        String sql = "INSERT INTO objetos_perdidos (nombre, descripcion) VALUES (?, ?)";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, nombreObjeto);
            statement.setString(2, descripcion);
            statement.executeUpdate();
            System.out.println("Objeto registrado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar objeto: " + e.getMessage());
        } finally {
            DatabaseService.DesconectarBD(conexion);
        }
    }
}
