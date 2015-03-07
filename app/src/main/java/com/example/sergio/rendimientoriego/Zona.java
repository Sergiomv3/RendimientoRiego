package com.example.sergio.rendimientoriego;

import java.util.ArrayList;
import java.util.Calendar;

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
    public static Zona solana() {
        ArrayList<Sector> sectoresSolana = new ArrayList<>();
        Sector sector = new Sector("Estacion/B.Palo bajo", Calendar.WEDNESDAY, 12725);
        sectoresSolana.add(sector);
        sector = new Sector("Ventilla", Calendar.THURSDAY, 16127);
        sectoresSolana.add(sector);
        sector = new Sector("Vía", Calendar.FRIDAY, 10444);
        sectoresSolana.add(sector);
        sector = new Sector("Mitagalán/Balsa/B.Quiebras", Calendar.SATURDAY, 10200);
        sectoresSolana.add(sector);
        sector = new Sector("L. Encinillas/Quiebras altas", Calendar.SUNDAY, 7695);
        sectoresSolana.add(sector);
        sector = new Sector("B. Palo alto/Chapa", Calendar.SATURDAY, 12751);
        sectoresSolana.add(sector);
        sector = new Sector("Loma del Galgo", Calendar.MONDAY, 13224);
        sectoresSolana.add(sector);

        return new Zona("Solana", sectoresSolana);
    }

    public static Zona llano() {
        ArrayList<Sector> sectoresLlano = new ArrayList<>();
        Sector sector = new Sector("Destiladero", Calendar.WEDNESDAY, 6170);
        sectoresLlano.add(sector);
        sector = new Sector("Barrascales", Calendar.THURSDAY, 6100);
        sectoresLlano.add(sector);
        sector = new Sector("Viñas/Canteras", Calendar.FRIDAY, 15300);
        sectoresLlano.add(sector);
        sector = new Sector("Llano/Campo de Tiro", Calendar.SATURDAY, 18889);
        sectoresLlano.add(sector);
        sector = new Sector("Pedriza", Calendar.SUNDAY, 15373);
        sectoresLlano.add(sector);

        return new Zona("Llano", sectoresLlano);
    }

    public static Zona vinas() {
        ArrayList<Sector> sectoresVinas = new ArrayList<>();
        Sector sector = new Sector("Olla del Pastor", Calendar.SATURDAY, 7917);
        sectoresVinas.add(sector);
        sector = new Sector("Nacimiento", Calendar.SUNDAY, 4842);
        sectoresVinas.add(sector);

        return new Zona("Viñas", sectoresVinas);
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
