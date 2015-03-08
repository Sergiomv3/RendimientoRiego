package com.example.sergio.rendimientoriego;

/**
 * Created by Sergio on 07/03/2015.
 */
public class Util {
    private float num_goteros;
    private float litrosGoteros;
    public Util(){
        this.num_goteros = 4;
        this.litrosGoteros = (float)0.27;
    }
    public Util(int num_goteros, int litrosGoteros) {
        this.num_goteros = num_goteros;
        this.litrosGoteros = litrosGoteros;
    }

    public float getNum_goteros() {
        return num_goteros;
    }

    public void setNum_goteros(int num_goteros) {
        this.num_goteros = num_goteros;
    }

    public float getLitrosGoteros() {
        return litrosGoteros;
    }

    public void setLitrosGoteros(float litrosGoteros) {
        this.litrosGoteros = litrosGoteros;
    }
}
