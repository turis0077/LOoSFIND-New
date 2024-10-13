//Imports para hacer la base de datos que guarda usuario y contraseña del usuario en MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import service.DatabaseService;
import model.Usuario;

//Imports para javafx
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;

public class VentanaLogin{ //Clase de ventana del login
    //Atributos
    private TextField txtcorreo;
    private TextField txtpasw;

    DatabaseService sqldatabase = new DatabaseService();
    Connection connection = sqldatabase.ConectarBD();
    Statement statement = connection.createStatement();
    statement.executeUpdate("CREATE TABLE IF NOT EXISTS usuarios (" + "correo VARCHAR(100) NOT NULL, " + "pasw VARCHAR(100) NOT NULL)");

    preparedStatement = connection.preparedStatement("INSERT INTO empleados (nombre, salario) VALUES (?, ?)");

    //Método constructor
    public VentanaLogin(String correo, String pasw){
        this.correo = correo;
        this.pasw = pasw;
    } 

    //Getters y setters
    public String getCorreo(){
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getPasw(){
        return pasw;
    }

    public void setPasw(String pasw){
        this.pasw = pasw;
    }
    
    //Método handleLogin            
    public String handleLogin(boolean inicioRegistrado, String correo, String pasw){//Inicio registrado es un booleano que para true significa que ha salido con éxito el inicio de sesión, mientras que false es que ha fallado la operación.
        if (inicioRegistrado == true){//La cuenta está registrada
            //Comprobar que la cuenta si esté registrada
            //Si el inicio está registrado
                //Retornar un true
            //Si no está registrado el inicio
                //Retornar un false
        }
        else if (inicioRegistrado == false){//La cuenta no está registrada
            //Comprobar que la cuenta no esté registrada
            //Si la cuenta no está registrada
                //hacer el registro de la nueva cuenta y retornar un true
            //Si la cuenta está registrada
                //Retornar un false
        }
    }

    //Método para validar credenciales
    public void validarCredenciales(String correo, String pasw){
        //Comprobar si el usuario está ingresado en la base de datos
            //Leer base de datos y comprobar con un if si la contraseña ingresada coincide con el usuario registrado
        //Si el usuario no está en el MySQL retornar mensaje de error
    }

    sqldatabase.DesconectarBD(connection);
}