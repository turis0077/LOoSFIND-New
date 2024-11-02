package service;

import model.ObjetoPerdido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

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

    public void registrarObjeto(ObjetoPerdido objeto) {
        String query = "INSERT INTO objetos_perdidos (tipo_objeto, color, dimensiones, forma, fecha, ubicacion, estado, en_secretaria) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query)) {
    
            pst.setString(1, objeto.getTipoObjeto());
            pst.setString(2, objeto.getColor());
            pst.setString(3, objeto.getDimensiones());
            pst.setString(4, objeto.getForma());
            pst.setDate(5, java.sql.Date.valueOf(objeto.getFecha()));
            pst.setString(6, objeto.getUbicacion());
            pst.setString(7, objeto.getEstado());
            pst.setBoolean(8, objeto.isEnSecretaria());
    
            pst.executeUpdate();
            System.out.println("Objeto registrado exitosamente: " + objeto);
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public ObjetoPerdido obtenerObjetoPerdido(int id) {
        ObjetoPerdido objeto = null;
        String query = "SELECT t.nombre AS tipo_objeto, c.nombre AS color, d.alto, d.ancho, d.largo, f.fecha_perdida, u.nombre AS ubicacion, o.estado, o.en_secretaria "
                +
                "FROM objetos_perdidos o " +
                "JOIN tipo_objeto t ON o.tipo_objeto_id = t.id " +
                "JOIN color c ON o.color_id = c.id " +
                "JOIN dimensiones d ON o.dimensiones_id = d.id " +
                "JOIN fecha f ON o.fecha_id = f.id " +
                "JOIN ubicacion u ON o.ubicacion_id = u.id " +
                "WHERE o.id = ?";

        try (Connection con = ConectarBD();
                PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    objeto = new ObjetoPerdido(
                            rs.getString("tipo_objeto"),
                            rs.getString("color"),
                            rs.getString("alto"),
                            rs.getString("ancho"),
                            rs.getString("fecha_perdida"),
                            rs.getString("ubicacion"),
                            rs.getString("estado"),
                            rs.getBoolean("en_secretaria"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objeto;
    }

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
                        rs.getDate("fecha").toString(),  // Convertimos a String
                        rs.getString("ubicacion"),
                        rs.getString("estado"),
                        rs.getBoolean("en_secretaria")
                );
                objetos.add(objeto);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Objetos obtenidos: " + objetos); // Verificación en consola
        return objetos;
    }
    
}
