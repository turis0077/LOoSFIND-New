package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    private static final String host = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String pass = "";
    private static final String bd = "LOoSFIND_bd";

    public static Connection ConectarBD() {
        Connection conexion = null;
        System.out.println("Conectando a la base de datos...");

        try {
            conexion = DriverManager.getConnection(host + bd, user, pass);
            System.out.println("Base de datos conectada.");
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }

    public static void DesconectarBD(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Base de datos desconectada.");
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar la base de datos: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
