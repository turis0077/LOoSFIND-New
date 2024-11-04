package service;

import model.ObjetoPerdido;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> pollito
import java.util.ArrayList;
import java.util.List;


=======
import java.util.List;
import java.util.ArrayList;

>>>>>>> pollito
public class DatabaseService {

    private static final String host = "jdbc:mysql://localhost:3306/LOoSFIND_bd";
    private static final String user = "root";
    private static final String pass = "";

<<<<<<< HEAD
    // Método para conectar a la base de datos
=======
>>>>>>> pollito
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

<<<<<<< HEAD
    // Método para desconectar de la base de datos
=======
>>>>>>> pollito
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

<<<<<<< HEAD
<<<<<<< HEAD
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

=======
=======
    // Método para registrar un objeto perdido en la base de datos
>>>>>>> pollito
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
<<<<<<< HEAD
    
>>>>>>> pollito
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
<<<<<<< HEAD

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
=======
    

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
>>>>>>> pollito

            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    objeto = new ObjetoPerdido(
<<<<<<< HEAD
                        rs.getString("tipo_objeto"),
                        rs.getString("color"),
                        rs.getDouble("alto"),
                        rs.getDouble("ancho"),
                        rs.getDouble("largo"),
                        rs.getString("fecha_perdida"),
                        rs.getString("ubicacion")
                    );
=======
                            rs.getString("tipo_objeto"),
                            rs.getString("color"),
                            rs.getString("alto"),
                            rs.getString("ancho"),
                            rs.getString("fecha_perdida"),
                            rs.getString("ubicacion"),
                            rs.getString("estado"),
                            rs.getBoolean("en_secretaria"));
>>>>>>> pollito
                }
            }
=======
>>>>>>> pollito

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
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

=======
=======
    // Método para obtener todos los objetos perdidos
>>>>>>> pollito
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
<<<<<<< HEAD
    
>>>>>>> pollito
=======
>>>>>>> pollito
}
