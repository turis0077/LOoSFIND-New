package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {

    public static Connection ConectarBD(){
        Connection conexion;
        String host = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String pass = "";
        String bd = "LOoSFIND_bd";

        System.out.println("Conectando BD..");

        try {
            conexion = DriverManager.getConnection(host+bd,user,pass);
            System.out.println("BD conectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return conexion;
    }

    public static void DesconectarBD(Connection cb){
        try {
            cb.close();
            System.out.println("Desconectando BD..");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection bd = ConectarBD();
        System.out.println("Consultas finalizadas");
        DesconectarBD(bd);
    }

}
