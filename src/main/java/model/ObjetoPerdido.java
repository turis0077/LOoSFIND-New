package model;

public class ObjetoPerdido {

<<<<<<< HEAD
<<<<<<< HEAD
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

=======
=======
    private String id;
>>>>>>> eevee
    private String tipoObjeto;
    private String color;
    private String dimensiones;
    private String forma;
    private String fecha;
    private String ubicacion;
    private String estado;
    private boolean enSecretaria;

<<<<<<< HEAD
    public ObjetoPerdido(String tipoObjeto, String color, String dimensiones, String forma, String fecha, String ubicacion,
            String estado, boolean enSecretaria) {
=======
    public ObjetoPerdido(String id, String tipoObjeto, String color, String dimensiones, String forma, String fecha, String ubicacion,
        String estado, boolean enSecretaria) {
        this.id = id;
>>>>>>> eevee
        this.tipoObjeto = tipoObjeto;
        this.color = color;
        this.dimensiones = dimensiones;
        this.forma = forma;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.enSecretaria = enSecretaria;
    }

<<<<<<< HEAD
>>>>>>> pollito
=======
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

>>>>>>> eevee
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

<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> eevee
    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
<<<<<<< HEAD
>>>>>>> pollito
=======
>>>>>>> eevee
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
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> eevee

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isEnSecretaria() {
        return enSecretaria;
    }

    public void setEnSecretaria(boolean enSecretaria) {
        this.enSecretaria = enSecretaria;
    }

    @Override
    public String toString() {
        return "ObjetoPerdido{" +
                "tipoObjeto='" + tipoObjeto + '\'' +
                ", color='" + color + '\'' +
                ", dimensiones='" + dimensiones + '\'' +
                ", forma='" + forma + '\'' +
                ", fecha='" + fecha + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", estado='" + estado + '\'' +
                ", enSecretaria=" + enSecretaria +
                '}';
    }
<<<<<<< HEAD
>>>>>>> pollito
=======

    //Metodo encargado de generar un id aleatorio
    public void idUnicoObjeto() {
        if (tipoObjeto != null && !tipoObjeto.isEmpty() && fecha != null) {
            String safeTipoObjeto = tipoObjeto.length() >= 3 ? tipoObjeto.substring(0, 3) : tipoObjeto + "XX".substring(0, 3 - tipoObjeto.length());
            this.id = safeTipoObjeto + fecha.replace("-", "");  // Concatenar directamente para formar el ID
        } else {
            throw new IllegalArgumentException("Tipo de objeto debe tener al menos 1 caracter y la fecha no debe ser nula.");
        }
    }
>>>>>>> eevee
}
