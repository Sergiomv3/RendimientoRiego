package com.example.sergio.rendimientoriego;

import java.util.Calendar;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Sector {
    private String nombre;
    private int diaRiego;
    private int num_Olivos;

    public Sector(int num_Olivos, int diaRiego, String nombre) {
        this.num_Olivos = num_Olivos;
        this.diaRiego = diaRiego;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNum_Olivos() {
        return num_Olivos;
    }

    public void setNum_Olivos(int num_Olivos) {
        this.num_Olivos = num_Olivos;
    }

    public int getDiaRiego() {
        return diaRiego;
    }

    public void setDiaRiego(int diaRiego) {
        this.diaRiego = diaRiego;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "nombre='" + nombre + '\'' +
                ", diaRiego=" + diaRiego +
                ", num_Olivos=" + num_Olivos +
                '}';
    }
}


