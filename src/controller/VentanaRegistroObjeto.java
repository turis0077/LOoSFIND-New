package com.controller;

import service.ObjetosExtraviados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import service.DatabaseService;

public class VentanaRegistroObjeto {

    private Runnable onObjectRegistered;

    public void registrarObjeto(String nombreObjeto, String descripcion) {
        Connection conexion = DatabaseService.ConectarBD();
        String sql = "INSERT INTO objetos_perdidos (tipo_objeto, color, dimensiones, forma, fecha, ubicacion, estado, en_secretaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, tipo_objeto);
            statement.setString(2, color);
            statement.setString(3, dimensiones);
            statement.setString(4, forma);
            statement.setString(5, fecha);
            statement.setString(6, ubicacion);
            statement.setString(7, estado);
            statement.setBoolean(8, enSecretaria);
            statement.executeUpdate();
            System.out.println("Objeto registrado correctamente");

            if (onObjectRegistered != null) {
                onObjectRegistered.run();
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar objeto: " + e.getMessage());
        } finally {
            DatabaseService.DesconectarBD(conexion);
        }
    }

    public void setOnObjectRegistered(Runnable callback) {
        this.onObjectRegistered = callback;
    }

}
