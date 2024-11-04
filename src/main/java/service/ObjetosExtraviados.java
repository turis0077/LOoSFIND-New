package service;

<<<<<<< HEAD
import model.ObjetoPerdido;
import java.util.List;

=======
import java.util.List;

import model.ObjetoPerdido;

>>>>>>> eevee
public class ObjetosExtraviados {

    private DatabaseService databaseService;

<<<<<<< HEAD
    public ObjetosExtraviados() {
        this.databaseService = new DatabaseService();
    }

    // Método para registrar un objeto perdido
=======
    public ObjetosExtraviados(String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7, boolean aBoolean) {
        this.databaseService = new DatabaseService();
    }

    // Metodo para registrar un objeto perdido
>>>>>>> eevee
    public void registrarObjeto(ObjetoPerdido objeto) {
        databaseService.registrarObjeto(objeto);
    }

<<<<<<< HEAD
    // Método para obtener todos los objetos perdidos
=======
    // Metodo para obtener todos los objetos perdidos
>>>>>>> eevee
    public List<ObjetoPerdido> obtenerTodosLosObjetos() {
        return databaseService.obtenerTodosLosObjetos();
    }
}
