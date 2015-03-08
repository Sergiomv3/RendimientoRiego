package com.example.sergio.rendimientoriego;

import java.util.Calendar;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Sector {

    private String nombre;
    private int diaRiego;
    private int numOlivos;
    private String zona;

    public Sector(String nombre, int diaRiego, int numOlivos, String zona) {
        this.nombre = nombre;
        this.diaRiego = diaRiego;
        this.numOlivos = numOlivos;
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiaRiego() {
        return diaRiego;
    }

    public void setDiaRiego(int diaRiego) {
        this.diaRiego = diaRiego;
    }

    public int getNumOlivos() {
        return numOlivos;
    }

    public void setNumOlivos(int numOlivos) {
        this.numOlivos = numOlivos;
    }

    @Override
    public String toString() {
        return zona+" - "+nombre+", "+numOlivos+" olivos";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sector sector = (Sector) o;

        if (diaRiego != sector.diaRiego) return false;
        if (numOlivos != sector.numOlivos) return false;
        if (nombre != null ? !nombre.equals(sector.nombre) : sector.nombre != null) return false;
        if (zona != null ? !zona.equals(sector.zona) : sector.zona != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + diaRiego;
        result = 31 * result + numOlivos;
        result = 31 * result + (zona != null ? zona.hashCode() : 0);
        return result;
    }
}


