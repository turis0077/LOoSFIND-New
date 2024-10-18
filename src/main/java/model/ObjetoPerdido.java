package model;

public class ObjetoPerdido {

    private int id;
    private String tipoObjeto;
    private String color;
    private double alto;
    private double ancho;
    private double largo;
    private String fecha;
    private String ubicacion;

    public ObjetoPerdido(String tipoObjeto, String color, double alto, double ancho, double largo, String fecha, String ubicacion) {
        this.tipoObjeto = tipoObjeto;
        this.color = color;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    // Getters y setters

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
