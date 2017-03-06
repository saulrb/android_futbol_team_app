package mx.itesm.m6_srb_ejer_futbol;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by saul on 12/2/2017.
 */

public class Equipo implements Serializable{
    private String nombreEquipo;
    private String liga;
    private String directorTecnico;
    private ArrayList<Jugador> jugadores;
    private int idImagen;
    private int intLiga;

    public Equipo(String nombreEquipo, String liga, String directorTecnico,int idImagen) {
        this.nombreEquipo = nombreEquipo;
        this.liga = liga;
        this.directorTecnico = directorTecnico;
        this.idImagen = idImagen;
        jugadores = new ArrayList<Jugador>();
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    public String getDirectorTecnico() {
        return directorTecnico;
    }

    public void setDirectorTecnico(String directorTecnico) {
        this.directorTecnico = directorTecnico;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public void addJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public Jugador findJugador(String nombre){
        Jugador jugador = null;
        for(Jugador jugador1:this.jugadores){
            if(jugador1.getNombre().equalsIgnoreCase(nombre)){
                jugador = jugador1;
            }
        }
        return  jugador;
    }

    public void removeJugador(Jugador jugador){
        this.jugadores.remove(jugador);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getIntLiga() {
        return intLiga;
    }

    public void setIntLiga(int intLiga) {
        this.intLiga = intLiga;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "directorTecnico='" + directorTecnico + '\'' +
                ", idImagen=" + idImagen +
                ", liga='" + liga + '\'' +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                '}';
    }
}
