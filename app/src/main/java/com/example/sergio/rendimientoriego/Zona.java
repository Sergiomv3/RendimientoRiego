package com.example.sergio.rendimientoriego;

import java.util.ArrayList;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Zona {
    private String nombre;
    private ArrayList<Sector> alSectores;

    public Zona(String nombre, ArrayList<Sector> alSectores) {
        this.nombre = nombre;
        this.alSectores = alSectores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Sector> getAlSectores() {
        return alSectores;
    }

    public void setAlSectores(ArrayList<Sector> alSectores) {
        this.alSectores = alSectores;
    }
    public void addSector(Sector sector){
        this.alSectores.add(sector);
    }
    public void removeSector(Sector sector){
        this.alSectores.remove( sector);
    }

    @Override
    public String toString() {
        return "Zona{" +
                "nombre='" + nombre + '\'' +
                ", alSectores=" + alSectores +
                '}';
    }
}
