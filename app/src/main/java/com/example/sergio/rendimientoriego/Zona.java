package com.example.sergio.rendimientoriego;

import com.db4o.Db4oEmbedded;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Zona {

    private String nombre;
    private ArrayList<Sector> sectores;
    private static String ZONA_SOLANA = "Solana";
    private static String ZONA_LLANO = "Llano";
    private static String ZONA_VINAS = "Viñas";


    public Zona(String nombre, ArrayList<Sector> sectores) {
        this.nombre = nombre;
        this.sectores = sectores;
    }

    public static Zona solana() {
        ArrayList<Sector> sectoresSolana = new ArrayList<>();
        Sector sector = new Sector("Estacion/B.Palo bajo", Calendar.WEDNESDAY, 12725, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("Ventilla", Calendar.THURSDAY, 16127, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("Vía", Calendar.FRIDAY, 10444, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("Mitagalán/Balsa/B.Quiebras", Calendar.SATURDAY, 10200, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("L. Encinillas/Quiebras altas", Calendar.SUNDAY, 7695, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("B. Palo alto/Chapa", Calendar.SATURDAY, 12751, ZONA_SOLANA);
        sectoresSolana.add(sector);
        sector = new Sector("Loma del Galgo", Calendar.MONDAY, 13224, ZONA_SOLANA);
        sectoresSolana.add(sector);

        return new Zona("Solana", sectoresSolana);
    }

    public static Zona llano() {
        ArrayList<Sector> sectoresLlano = new ArrayList<>();
        Sector sector = new Sector("Destiladero", Calendar.WEDNESDAY, 6170,ZONA_LLANO);
        sectoresLlano.add(sector);
        sector = new Sector("Barrascales", Calendar.THURSDAY, 6100,ZONA_LLANO);
        sectoresLlano.add(sector);
        sector = new Sector("Viñas/Canteras", Calendar.FRIDAY, 15300,ZONA_LLANO);
        sectoresLlano.add(sector);
        sector = new Sector("Llano/Campo de Tiro", Calendar.SATURDAY, 18889,ZONA_LLANO);
        sectoresLlano.add(sector);
        sector = new Sector("Pedriza", Calendar.SUNDAY, 15373,ZONA_LLANO);
        sectoresLlano.add(sector);

        return new Zona("Llano", sectoresLlano);
    }

    public static Zona vinas() {
        ArrayList<Sector> sectoresVinas = new ArrayList<>();
        Sector sector = new Sector("Olla del Pastor", Calendar.SATURDAY, 7917,ZONA_VINAS);
        sectoresVinas.add(sector);
        sector = new Sector("Nacimiento", Calendar.SUNDAY, 4842,ZONA_VINAS);
        sectoresVinas.add(sector);

        return new Zona("Viñas", sectoresVinas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Sector> getSectores() {
        return sectores;
    }

    public void setSectores(ArrayList<Sector> sectores) {
        this.sectores = sectores;
    }

    public void addSector(Sector sector){
        this.sectores.add(sector);
    }

    public void removeSector(Sector sector){
        this.sectores.remove(sector);
    }


    @Override
    public String toString() {
        return "Zona{" +
                "nombre='" + nombre + '\'' +
                ", sectores=" + sectores +
                '}';
    }
}

