package com.example.sergio.rendimientoriego;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.todddavies.components.progressbar.ProgressWheel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    /***** VARIABLES GLOBALES******/
    private Switch btEmpezar;
    private ProgressWheel pw; // Progress Wheel
    private int progresoRendimiento = 0;
    private double porcentaje;
    private int diaActual;
    private Spinner spinnerSectores;
    private ArrayList<Zona> zonas;
    private ArrayList<Sector> sectorARegar;
    /********VAR BD*************************/
    private ObjectContainer bdZonas;
    private ObjectContainer bdRendimientos;
    private Sector sectorActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEmpezar = (Switch)findViewById(R.id.btEmpezar);
        pw = (ProgressWheel) findViewById(R.id.progreso);
        pw.setProgress(10);
        Timer temporizador = new Timer();
        temporizador.schedule(new RemindTask(),100);

        Calendar calendario = new GregorianCalendar();
        diaActual = calendario.get(Calendar.DAY_OF_WEEK);// 0 es Domingo, 1 es lunes.... asi hasta 6 que es sabado

        if(zonas!=null){
            getZonas();
        }else{
            definirZonas();
        }
        spinnerSectores = (Spinner)findViewById(R.id.spinnerZonas);


        ArrayAdapter<Sector> aaZonas = new ArrayAdapter<Sector>(MainActivity.this,
                android.R.layout.simple_spinner_item, sectorARegar);
        aaZonas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSectores.setAdapter(aaZonas);
        spinnerSectores.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Log.v("NºOlivos: ", sectorARegar.get(position).getNumOlivos() + "");
                sectorActual = sectorARegar.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bdRendimientos = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),
                getExternalFilesDir(null)+"/bdRendimientos.db4o");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bdRendimientos != null) {
            bdRendimientos.close();
        }
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
    public ArrayList<Zona> getZonas(){
        bdZonas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),getExternalFilesDir(null)+"/bdZonas.db4o");
        List<Zona> zo = bdZonas.query(Zona.class);
        zonas = new ArrayList<Zona>();
        for(Zona z: zo){
            zonas.add(z);
        }
        bdZonas.close();
        return zonas;
    }
    public void setZonas(ArrayList<Zona> zonas){
        bdZonas = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), getExternalFilesDir(null) + "/bdZonas.db4o");
        bdZonas.store(zonas);
        bdZonas.commit();
        bdZonas.close();
    }
    public void definirZonas(){
        zonas = new ArrayList<Zona>();
        sectorARegar = new ArrayList<Sector>();
        zonas.add(Zona.llano());
        zonas.add(Zona.solana());
        zonas.add(Zona.vinas());

        for(Zona z : zonas){
            for(Sector s : z.getSectores()){
                if(diaActual == s.getDiaRiego()){
                    sectorARegar.add(s);
                }
            }
        }
    }

    public void botonCalculo(View v){
        if(btEmpezar.isActivated()){
            empezar();
            btEmpezar.setActivated(false);
            btEmpezar.setText(btEmpezar.getTextOff().toString());
            System.out.println("Desactivado");
        }else if(!btEmpezar.isActivated()){
            parar();
            btEmpezar.setActivated(true);
            btEmpezar.setText(btEmpezar.getTextOn().toString());
            System.out.println("Activado");
        }
    }


    private void empezar() {
        // GUARDAR DATOS INICIALES SECTOR SELECCIONADO EN SPINNER
        // COGER LECTURA INICIAL y HORA INICIAL
        EditText etLecturaI;
        Calendar calendario = new GregorianCalendar();
        etLecturaI = (EditText)findViewById(R.id.etLecturaI);
        float lecturaI = Float.valueOf(etLecturaI.getText().toString());
        Calendar fechaI = GregorianCalendar.getInstance();
        Rendimiento rendimiento = new Rendimiento(fechaI,-1,sectorActual,sectorActual.getZona(),lecturaI,-1,null);
        setRendimientos(rendimiento);

    }

    private void parar() {
        // coger ultima lectura
        // coger hora actual
        // coger sector spinner
        // actualizar bdRendimiento
        updateRendimientos();

    }
    private void setRendimientos(Rendimiento r){
        // GUARDAR EN BD

        bdRendimientos.store(r);
        bdRendimientos.commit();

    }
    private void getRendimientos(){

    }
    private void updateRendimientos(){
        ObjectSet<Rendimiento> rendimientos = bdRendimientos.query(
                new Predicate<Rendimiento>() {
                    @Override
                    public boolean match(Rendimiento r) {
                        Calendar calendar = r.getFechaInicio();
                        int dia = calendar.get(Calendar.DAY_OF_MONTH);
                        int mes = calendar.get(Calendar.MONTH);
                        int anio = calendar.get(Calendar.YEAR);
                        Calendar calendarioActual = new GregorianCalendar();
                        int diaActual = calendarioActual.get(Calendar.DAY_OF_MONTH);
                        int mesActual = calendarioActual.get(Calendar.MONTH);
                        int anioActual = calendarioActual.get(Calendar.YEAR);
                        if(dia == diaActual && mes == mesActual && anio == anioActual){
                            return r.getSector().equals(sectorActual);
                        }
                        return false;
                    }
                });
        if (rendimientos.hasNext()){

            Rendimiento r = rendimientos.next();
            Util util = new Util();
            EditText etLecturaf;
            etLecturaf = (EditText)findViewById(R.id.etLecturaF);
            // RENDIMIENTO = (litros reales / litros teoricos ) * 100
            // litrosTeorico = numOlivos*Util.litrosGoteros * mintuos
            // litrosReales = lecturaF - lecturaI
            Calendar calendarF = r.getFechaFinal();
            Calendar calendarI = r.getFechaInicio();
            int horaF = calendarF.get(Calendar.HOUR);
            int minF = calendarF.get(Calendar.MINUTE);
            int horaI = calendarI.get(Calendar.HOUR);
            int minI = calendarI.get(Calendar.MINUTE);
            int difHoras = horaF - horaI;
            int difMin = minF - minI;
            int minutos = (difHoras*60) + difMin;

            float litrosTeoricos = ((r.getSector().getNumOlivos())*util.getLitrosGoteros())*minutos;
            float litrosReales = r.getLitrosFinal() - r.getLitrosInicio();
            float rendimientoFinal = (litrosReales/litrosTeoricos)*100;
            // CALCULAR RENDIMIENTO + ANIMACION
            // AÑADIMOS A BD

            r.setFechaFinal(Calendar.getInstance());
            r.setLitrosFinal(Float.valueOf(etLecturaf.toString()));
            r.setRendimiento(rendimientoFinal);
            pw.setText(String.valueOf(rendimientoFinal));
            bdRendimientos.store(r);
            bdRendimientos.commit();
        }
    }
}
