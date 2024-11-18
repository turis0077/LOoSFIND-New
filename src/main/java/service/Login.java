package service;

public class Login{
    //Atributos
    private String username;
    private String password;

    //Constructor de la clase Login
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasword(String password) {
        this.password = password;
    }
     
    public boolean authenticate() {
        DatabaseService dbService = new DatabaseService();
        return dbService.verificarCredenciales(username, password);
    }
}