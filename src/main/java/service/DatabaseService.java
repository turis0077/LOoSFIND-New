package service;

import model.ObjetoPerdido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static final String host = "jdbc:mysql://localhost:3306/LOoSFIND_bd";
    private static final String user = "root";
    private static final String pass = "";

    public static Connection ConectarBD() {
        Connection conexion = null;
        System.out.println("Conectando a la base de datos...");

        try {
            conexion = DriverManager.getConnection(host, user, pass);
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

    // Método para registrar un objeto perdido en la base de datos
    public void registrarObjeto(ObjetoPerdido objeto) {
        String query = "INSERT INTO objetos_perdidos (tipo_objeto, color, dimensiones, forma, fecha, ubicacion, estado, en_secretaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, objeto.getTipoObjeto());
            pst.setString(2, objeto.getColor());
            pst.setString(3, objeto.getDimensiones());
            pst.setString(4, objeto.getForma());
            pst.setDate(5, java.sql.Date.valueOf(objeto.getFecha()));  // Asegúrate de que el formato de fecha es correcto
            pst.setString(6, objeto.getUbicacion());
            pst.setString(7, objeto.getEstado());
            pst.setBoolean(8, objeto.isEnSecretaria());

            pst.executeUpdate();
            System.out.println("Objeto registrado exitosamente: " + objeto);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los objetos perdidos
    public List<ObjetoPerdido> obtenerTodosLosObjetos() {
        List<ObjetoPerdido> objetos = new ArrayList<>();
        String query = "SELECT tipo_objeto, color, dimensiones, forma, fecha, ubicacion, estado, en_secretaria FROM objetos_perdidos";

        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                ObjetoPerdido objeto = new ObjetoPerdido(
                        rs.getString("tipo_objeto"),
                        rs.getString("color"),
                        rs.getString("dimensiones"),
                        rs.getString("forma"),
                        rs.getDate("fecha").toString(),
                        rs.getString("ubicacion"),
                        rs.getString("estado"),
                        rs.getBoolean("en_secretaria")
                );
                objetos.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetos;
    }

    // Método para buscar objetos perdidos con palabras clave
    public List<ObjetoPerdido> buscarObjetos(String palabraClave) {
        List<ObjetoPerdido> objetos = new ArrayList<>();
        String query = "SELECT * FROM objetos_perdidos WHERE " +
                       "tipo_objeto LIKE ? OR " +
                       "color LIKE ? OR " +
                       "dimensiones LIKE ? OR " +
                       "forma LIKE ? OR " +
                       "ubicacion LIKE ? OR " +
                       "estado LIKE ?";

        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query)) {

            String keyword = "%" + palabraClave + "%";
            for (int i = 1; i <= 6; i++) {
                pst.setString(i, keyword);
            }

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    ObjetoPerdido objeto = new ObjetoPerdido(
                            rs.getString("tipo_objeto"),
                            rs.getString("color"),
                            rs.getString("dimensiones"),
                            rs.getString("forma"),
                            rs.getDate("fecha").toString(),
                            rs.getString("ubicacion"),
                            rs.getString("estado"),
                            rs.getBoolean("en_secretaria")
                    );
                    objetos.add(objeto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetos;
    }
}
