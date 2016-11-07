package com.calyrsoft.apps.mapacoursera;

/**
 * Created by calyr on 11/6/16.
 */
public class Punto {

    private Double longitud;
    private Double latitud;
    private String titulo;
    private String descripcion;

    public float getHue() {
        return hue;
    }

    public void setHue(float hue) {
        this.hue = hue;
    }

    private float hue;

    public Punto(Double latitud, Double longitud, String titulo, String descripcion, float hue) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.hue = hue;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
