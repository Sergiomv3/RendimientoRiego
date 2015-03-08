package com.example.sergio.rendimientoriego;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Rendimiento {
    private Calendar fechaInicio, fechaFinal;
    private float litrosInicio, litrosFinal, rendimiento;
    private String zona;
    private Sector sector;

    public Rendimiento(Calendar fechaInicio, float rendimiento, Sector sector, String zona, float litrosInicio, float litrosFinal, Calendar fechaFinal) {
        this.fechaInicio = fechaInicio;
        this.rendimiento = rendimiento;
        this.sector = sector;
        this.zona = zona;
        this.litrosInicio = litrosInicio;
        this.litrosFinal = litrosFinal;
        this.fechaFinal = fechaFinal;
    }



    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public float getLitrosFinal() {
        return litrosFinal;
    }

    public void setLitrosFinal(float litrosFinal) {
        this.litrosFinal = litrosFinal;
    }

    public float getLitrosInicio() {
        return litrosInicio;
    }

    public void setLitrosInicio(float litrosInicio) {
        this.litrosInicio = litrosInicio;
    }

    public Calendar getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Calendar fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Rendimiento{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                ", litrosInicio=" + litrosInicio +
                ", litrosFinal=" + litrosFinal +
                ", rendimiento=" + rendimiento +
                ", zona=" + zona +
                ", sector=" + sector +
                '}';
    }
}
