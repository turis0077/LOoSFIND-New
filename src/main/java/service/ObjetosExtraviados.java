package service;

import java.util.List;

import model.ObjetoPerdido;

public class ObjetosExtraviados {

    private DatabaseService databaseService;

    public ObjetosExtraviados(String string, String string1, String string2, String string3, String string4, String string5, String string6, String string7, boolean aBoolean) {
        this.databaseService = new DatabaseService();
    }

    // Metodo para registrar un objeto perdido
    public void registrarObjeto(ObjetoPerdido objeto) {
        databaseService.registrarObjeto(objeto);
    }

    // Metodo para obtener todos los objetos perdidos
    public List<ObjetoPerdido> obtenerTodosLosObjetos() {
        return databaseService.obtenerTodosLosObjetos();
    }
}
