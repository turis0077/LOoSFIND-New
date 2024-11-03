package com.service;

public class ObjetosExtraviados { //Clase de registro de objetos extraviado
    //Atributos
    private String id;
    private String tipo_objeto;
    private String color;
    private String dimensiones;
    private String forma;
    private String fecha;
    private String ubicacion;
    private String estado;
    private boolean enSecretaria; 

    //Constructor
    public ObjetosExtraviados(String id, String tipo_objeto, String color, String dimensiones, String forma, String fecha, String ubicacion, String estado, boolean enSecretaria){
        this.id = id;
        this.tipo_objeto = tipo_objeto;
        this.color = color;
        this.dimensiones = dimensiones;
        this.forma = forma;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.enSecretaria = enSecretaria;
    }

    //Metodo encargado de generar un id aleatorio
    public void idUnicoObjeto() {
        if (tipo_objeto != null && !tipo_objeto.isEmpty() && fecha != null) {
            String safeTipoObjeto = tipo_objeto.length() >= 3 ? tipo_objeto.substring(0, 3) : tipo_objeto + "XX".substring(0, 3 - tipo_objeto.length());
            this.id = safeTipoObjeto + fecha.replace("-", "");  // Concatenar directamente para formar el ID
        } else {
            throw new IllegalArgumentException("Tipo de objeto debe tener al menos 1 caracter y la fecha no debe ser nula.");
        }
    }

    //Get del numero de identificacion
    public String getId(){
        return id;
    }
    
    //Get de tipo de objeto
    public String getTipobjeto(){
        return tipo_objeto;
    }

    //Get de color
    public String getColor(){
        return color;
    }

    //Get de tamaño
    public String getDimensiones(){
        return dimensiones;
    }

    //Get de forma
    public String getForma(){
        return forma;
    }

    //Get de fecha
    public String getFecha(){
        return fecha;
    }
    
    //Get de locación
    public String getUbicacion(){
        return ubicacion;
    }

    //Get de estado
    public String getEstado(){
        return estado;
    }

    //Get de secretaría
    public boolean getEnSecretaria(){
        return enSecretaria;
    }

    //set del numero de identificacion
    public void setId(String id) {
        this.id = id;
    }
    
    //set de tipo de objeto
    public void setTipobjeto(String tipobjeto) {
        this.tipo_objeto = tipobjeto;
    }

    //Set de color
    public void setColor(String color) {
        this.color = color;
    }

    //Set de tamaño
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    //Set de forma
    public void setForma(String forma) {
        this.forma = forma;
    }

    //Set de fecha
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Set de locación
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //Set de estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Set de secretaría
    public void setEnSecretaria(boolean EnSecretaria) {
        this.enSecretaria = enSecretaria;
    }
}