package com.example.reciclerview1;

import java.io.Serializable;
import java.util.ArrayList;


public class AlumnoItem implements Serializable{

    private int id;
    private String carrera;
    private String nombre;
    private String matricula;
    private Integer imageID;

    public AlumnoItem(){ }
    public AlumnoItem(String carrera, String nombre, String matricula, Integer imageID){
        this.carrera = carrera;
        this.nombre = nombre;
        this.matricula = matricula;
        this.imageID = imageID;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public static  ArrayList<AlumnoItem> llenarAlumnos() {
        ArrayList<AlumnoItem> alumnos = new ArrayList<>();
        String carrera = "Ing. Tec. Información";

        alumnos.add(new AlumnoItem(carrera, "MORUA ZAMUDIO ESTEFANO", "2019030344", R.drawable.tci2019030344));
        alumnos.add(new AlumnoItem(carrera, "CARRANZA JAUREGUI CARLOS ALBERTO", "2020030174", R.drawable.tci2020030174));
        alumnos.add(new AlumnoItem(carrera, "CASTRO LOPEZ MARCO ANTONIO ALARID", "2020030176", R.drawable.tci2020030176));
        alumnos.add(new AlumnoItem(carrera, "DURAN VALDEZ JOSHUA DANIEL", "2020030181", R.drawable.tci2020030181));
        alumnos.add(new AlumnoItem(carrera, "GALINDO HERNANDEZ ERNESTO DAVID", "2020030184", R.drawable.tci2020030184));
        alumnos.add(new AlumnoItem(carrera, "CONTRERAS CEPEDA MAXIMILIANO", "2020030189", R.drawable.tci2020030189));
        alumnos.add(new AlumnoItem(carrera, "GOMEZ RUELAS IVÁN ENRIQUE", "2020030199", R.drawable.tci2020030199));
        alumnos.add(new AlumnoItem(carrera, "CRUZ QUINTERO JESUS EDUARDO", "2020030212", R.drawable.tci2020030212));
        alumnos.add(new AlumnoItem(carrera, "VELARDE OVALLE DAVID ANTONIO", "2020030241", R.drawable.tci2020030241));
        alumnos.add(new AlumnoItem(carrera, "LAMAS ARMENTA GUSTAVO ADOLFO", "2020030243", R.drawable.tci2020030243));
        alumnos.add(new AlumnoItem(carrera, "RIVAS LUGO JUAN CARLOS", "2020030249", R.drawable.tci2020030249));
        alumnos.add(new AlumnoItem(carrera, "SALAS MENDOZA ALEJO", "2020030264", R.drawable.tci2020030264));
        alumnos.add(new AlumnoItem(carrera, "SERRANO TORRES CARLOS JAIR", "2020030268", R.drawable.tci2020030268));
        alumnos.add(new AlumnoItem(carrera, "TIRADO ROMERO JESUS TADEO", "2020030292", R.drawable.tci2020030292));
        alumnos.add(new AlumnoItem(carrera, "CARRILLO GARCIA JAIR", "2020030304", R.drawable.tci2020030304));
        alumnos.add(new AlumnoItem(carrera, "ARIAS ZATARAIN DIEGO", "2020030306", R.drawable.tci2020030306));
        alumnos.add(new AlumnoItem(carrera, "VALDEZ MARTINEZ PAOLA EMIRET", "2020030313", R.drawable.tci2020030313));
        alumnos.add(new AlumnoItem(carrera, "IBARRA FLORES SALMA YARETH", "2020030315", R.drawable.tci2020030315));
        alumnos.add(new AlumnoItem(carrera, "LIZARRAGA MALDONADO JUAN ANTONIO", "2020030322", R.drawable.tci2020030322));
        alumnos.add(new AlumnoItem(carrera, "VIERA ROMERO ANGEL ZINEDINE ANASTACIO", "2020030325", R.drawable.tci2020030325));
        alumnos.add(new AlumnoItem(carrera, "TEJEDA PEINADO BLAS ALBERTO", "2020030327", R.drawable.tci2020030327));
        alumnos.add(new AlumnoItem(carrera, "VIERA ROMERO ANGEL RONALDO ANASTACIO", "2020030329", R.drawable.tci2020030329));
        alumnos.add(new AlumnoItem(carrera, "ELIZALDE VARGAS XIOMARA YAMILETH", "2020030332", R.drawable.tci2020030332));
        alumnos.add(new AlumnoItem(carrera, "SALCIDO SARABIA JESUS ANTONIO", "2020030333", R.drawable.tci2020030333));
        alumnos.add(new AlumnoItem(carrera, "RODRIGUEZ SANCHEZ YENNIFER CAROLINA", "2020030389", R.drawable.tci2020030389));
        alumnos.add(new AlumnoItem(carrera, "FLORES PRADO MANUEL ALEXIS", "2020030766", R.drawable.tci2020030766));
        alumnos.add(new AlumnoItem(carrera, "AGUIRRE TOSTADO VICTOR MOISES", "2020030771", R.drawable.tci2020030771));
        alumnos.add(new AlumnoItem(carrera, "DOMINGUEZ SARABIA HALACH UINIC", "2020030777", R.drawable.tci2020030777));
        alumnos.add(new AlumnoItem(carrera, "MACIEL NUÑEZ ENZO ALEJANDRO", "2020030799", R.drawable.tci2020030799));
        alumnos.add(new AlumnoItem(carrera, "BARRON VARGAS JOSE ALBERTO", "2020030808", R.drawable.tci2020030808));
        alumnos.add(new AlumnoItem(carrera, "MARTIN IBARRA GIANCARLO", "2020030819", R.drawable.tci2020030819));
        alumnos.add(new AlumnoItem(carrera, "SANCHEZ OCEGUEDA LUIS ANGEL", "2020030865", R.drawable.tci2020030865));

        return alumnos;

    }
}
