package mx.itesm.m6_srb_ejer_futbol;

import java.io.Serializable;

/**
 * Created by saul on 12/2/2017.
 */

public class Jugador implements Serializable {
    private String nombre;
    private String posicion;
    private String nacionalidad;
    private int idImagen;

    public Jugador(String nombre, String posicion, String nacionalidad, int idImagen) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.nacionalidad = nacionalidad;
        this.idImagen = idImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
