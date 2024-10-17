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
    //Atributos
    private TextField txtcorreo;
    private TextField txtpasw;

    //List<Usuario> usuarios = new ArrayList<Usuario>();

    DatabaseService sqldatabase = new DatabaseService();
    Connection connection = sqldatabase.ConectarBD();
    Statement statement = connection.createStatement();

    //Método constructor
    public VentanaLogin(String correo, String pasw){
        this.correo = correo;
        this.pasw = pasw;

        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (" + "id INT AUTO_INCREMENT PRIMARY KEY, " + "correo AUTO_INCREMENT, " + "pasw AUTO_INCREMENT;");
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Usuario (correo, pasw) VALUES (?, ?)");

        preparedStatement.setString(1, correo);
        preparedStatement.setString(2, pasw);
        preparedStatement.executeUpdate();


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

    statement.DesconectarBD(connection);
}