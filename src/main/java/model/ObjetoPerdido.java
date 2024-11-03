package model;

public class ObjetoPerdido {

    private String tipoObjeto;
    private String color;
    private String dimensiones;
    private String forma;
    private String fecha;
    private String ubicacion;
    private String estado;
    private boolean enSecretaria;

    public ObjetoPerdido(String tipoObjeto, String color, String dimensiones, String forma, String fecha, String ubicacion,
        String estado, boolean enSecretaria) {
        this.tipoObjeto = tipoObjeto;
        this.color = color;
        this.dimensiones = dimensiones;
        this.forma = forma;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.enSecretaria = enSecretaria;
    }

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
}
