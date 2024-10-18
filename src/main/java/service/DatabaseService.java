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

    // Método para conectar a la base de datos
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

    // Método para desconectar de la base de datos
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

    // Método para registrar un objeto perdido con todas las nuevas columnas
    public void registrarObjeto(ObjetoPerdido objeto) {
        String query = "INSERT INTO objetos_perdidos (tipo_objeto_id, color_id, dimensiones_id, fecha_id, ubicacion_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query)) {

            // Asigna los valores de las nuevas columnas a la base de datos
            pst.setString(1, objeto.getTipoObjeto());  // Aquí deberías obtener el ID del tipo de objeto
            pst.setString(2, objeto.getColor());       // Aquí deberías obtener el ID del color
            pst.setDouble(3, objeto.getAlto());        // Dimensiones: Alto
            pst.setDouble(4, objeto.getAncho());       // Dimensiones: Ancho
            pst.setDouble(5, objeto.getLargo());       // Dimensiones: Largo
            pst.setString(6, objeto.getFecha());       // Fecha de pérdida
            pst.setString(7, objeto.getUbicacion());   // Ubicación del objeto
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener un objeto perdido específico
    public ObjetoPerdido obtenerObjetoPerdido(int id) {
        ObjetoPerdido objeto = null;
        String query = "SELECT t.nombre AS tipo_objeto, c.nombre AS color, d.alto, d.ancho, d.largo, f.fecha_perdida, u.nombre AS ubicacion " +
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
                        rs.getDouble("alto"),
                        rs.getDouble("ancho"),
                        rs.getDouble("largo"),
                        rs.getString("fecha_perdida"),
                        rs.getString("ubicacion")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objeto;
    }

    // Método para obtener todos los objetos perdidos
    public List<ObjetoPerdido> obtenerTodosLosObjetos() {
        List<ObjetoPerdido> objetos = new ArrayList<>();
        String query = "SELECT t.nombre AS tipo_objeto, c.nombre AS color, d.alto, d.ancho, d.largo, f.fecha_perdida, u.nombre AS ubicacion " +
                       "FROM objetos_perdidos o " +
                       "JOIN tipo_objeto t ON o.tipo_objeto_id = t.id " +
                       "JOIN color c ON o.color_id = c.id " +
                       "JOIN dimensiones d ON o.dimensiones_id = d.id " +
                       "JOIN fecha f ON o.fecha_id = f.id " +
                       "JOIN ubicacion u ON o.ubicacion_id = u.id";

        try (Connection con = ConectarBD();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                ObjetoPerdido objeto = new ObjetoPerdido(
                    rs.getString("tipo_objeto"),
                    rs.getString("color"),
                    rs.getDouble("alto"),
                    rs.getDouble("ancho"),
                    rs.getDouble("largo"),
                    rs.getString("fecha_perdida"),
                    rs.getString("ubicacion")
                );
                objetos.add(objeto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return objetos;
    }

    // Otros métodos de utilidad si los necesitas

}
