package com.example.sergio.rendimientoriego;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.todddavies.components.progressbar.ProgressWheel;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    /***** VARIABLES GLOBALES******/
    private ProgressWheel pw; // Progress Wheel
    private int progresoRendimiento = 0;
    private double porcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pw = (ProgressWheel) findViewById(R.id.progreso);
        pw.setProgress(10);
        Timer temporizador = new Timer();
        temporizador.schedule(new RemindTask(),100);
    }
    class RemindTask extends TimerTask {
        public void run() {
              while (progresoRendimiento<350) {
                  progresoRendimiento++;
                  porcentaje = progresoRendimiento;
                  porcentaje = ((porcentaje/360)*100);
                  double aux=Math.rint(porcentaje*100)/100;
                  porcentaje=aux;

                  pw.setText(String.valueOf(porcentaje+" %"));
                  pw.setProgress(progresoRendimiento);
                  try {
                      Thread.sleep(20);
                  } catch (InterruptedException e) {

                      e.printStackTrace();
                  }
              }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
