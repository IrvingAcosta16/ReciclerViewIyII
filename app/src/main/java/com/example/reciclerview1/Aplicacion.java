package com.example.reciclerview1;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;


public class Aplicacion extends Application {
    public static ArrayList<AlumnoItem> alumnos;
    private AlumnoAdapter adaptador;

    public ArrayList<AlumnoItem> getAlumnos() {
        return alumnos;
    }

    public AlumnoAdapter getAdaptador() {
        return adaptador;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        alumnos = AlumnoItem.llenarAlumnos();
        adaptador = new AlumnoAdapter(alumnos, this);
        Log.d("", "onCreate: tamaño array list " + alumnos.size());
    }

}
