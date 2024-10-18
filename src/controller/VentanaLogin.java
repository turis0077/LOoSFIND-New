//Imports para hacer la base de datos que guarda usuario y contraseña del usuario en MySQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import service.DatabaseService;

//Otros imports
import java.util.*;
import model.Usuario;
import java.util.ArrayList;

public class VentanaLogin{ //Clase de ventana del login
    //List<Usuario> usuarios = new ArrayList<Usuario>();

    //Creación de la base de datos y establecer conexión con la cuenta de MySQL
    DatabaseService sqldatabase = new DatabaseService();
    Connection connection = sqldatabase.ConectarBD();
    Statement statement = connection.createStatement();

    //Método constructor
    public String RegistrarNuevaCuenta(String correo, String pasw){
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (" + "id INT AUTO_INCREMENT PRIMARY KEY, " + "correo AUTO_INCREMENT, " + "pasw AUTO_INCREMENT;");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Usuario (correo, pasw) VALUES (?, ?)");

        //Agregar un if que compruebe si se registró o no la cuenta anteriormente
        preparedStatement.setString(1, correo);
        preparedStatement.setString(2, pasw);
        preparedStatement.executeUpdate();
    } 
    
    //Método que comprueba si una cuenta está registrada            
    public boolean CuentaRegistradaSiNo(String correo){
        boolean cuenreg = null;

        String query = "SELECT * FROM Usuario WHERE correo = ?"; 
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, searchCorreo); 
        findCorreo = preparedStatement.executeQuery();

        //Hacer un if para buscar el correo ingresado en la tabla que retorne un true o false
        
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

    DatabaseService.DesconectarBD(connection);
}