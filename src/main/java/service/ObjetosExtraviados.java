package service;

import model.ObjetoPerdido;
import java.util.List;

public class ObjetosExtraviados {

    private DatabaseService databaseService;

    public ObjetosExtraviados() {
        this.databaseService = new DatabaseService();
    }

    // Método para registrar un objeto perdido
    public void registrarObjeto(ObjetoPerdido objeto) {
        databaseService.registrarObjeto(objeto);
    }

    // Método para obtener todos los objetos perdidos
    public List<ObjetoPerdido> obtenerTodosLosObjetos() {
        return databaseService.obtenerTodosLosObjetos();
    }
}
