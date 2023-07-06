package Modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.reciclerview1.AlumnoItem;
import java.util.ArrayList;



public class AlumnosDb implements Persistencia, Proyeccion{
    private Context context;
    private AlumnosDbHelper helper;
    private SQLiteDatabase db;

    public AlumnosDb(Context context, AlumnosDbHelper helper) {
        this.context = context;
        this.helper = helper;
    }

    public AlumnosDb(Context context) {
        this.context = context;
        this.helper = new AlumnosDbHelper(this.context);
    }

    @Override
    public void openDataBase() {
        db = helper.getWritableDatabase();
    }

    @Override
    public void closeDataBase() {
        helper.close();
    }

    @Override
    public long insertAlumno(AlumnoItem alumno) {
        ContentValues values = new ContentValues();

        values.put(DefineTabla.Alumnos.COLUMN_NAME_MATRICULA, alumno.getMatricula());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_CARRERA, alumno.getCarrera());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_FOTO, alumno.getImageID());

        this.openDataBase();
        long num = db.insert(DefineTabla.Alumnos.TABLE_NAME, null, values);
        this.closeDataBase();
        Log.d("agregar", "insertAlumno" + num);

        return num;
    }

    @Override
    public long updateAlumno(AlumnoItem alumno) {
        ContentValues values = new ContentValues();

        values.put(DefineTabla.Alumnos.COLUMN_NAME_MATRICULA, alumno.getMatricula());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_NOMBRE, alumno.getNombre());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_CARRERA, alumno.getCarrera());
        values.put(DefineTabla.Alumnos.COLUMN_NAME_FOTO, alumno.getImageID());

        this.openDataBase();

        long num = db.update(
                DefineTabla.Alumnos.TABLE_NAME,
                values,
                DefineTabla.Alumnos.COLUMN_NAME_ID + alumno.getId(),
                null);

        this.closeDataBase();
        Log.d("agregar", "insertAlumno" + num);

        return num;
    }

    @Override
    public long deleteAlumno(int id) {
        this.openDataBase();

        db.delete(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.COLUMN_NAME_ID + "=?",
                new String[] {String.valueOf(id)});

        return 0;
    }

    @Override
    public AlumnoItem getAlumno(String matricula) {

        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.REGISTRO,
                DefineTabla.Alumnos.COLUMN_NAME_ID + " = ?",
                new String[] {matricula},
                null, null, null
        );

        cursor.moveToFirst();
        AlumnoItem alumno = readAlumno(cursor);

        return alumno;
    }

    @Override
    public ArrayList<AlumnoItem> allAlumnos() {
        db = helper.getWritableDatabase();

        Cursor cursor = db.query(
                DefineTabla.Alumnos.TABLE_NAME,
                DefineTabla.Alumnos.REGISTRO,
                null, null, null, null, null
        );

        ArrayList<AlumnoItem> alumnos = new ArrayList<AlumnoItem>();
        cursor.moveToFirst();

        while(!cursor.isAfterLast()) {
            AlumnoItem alumno = readAlumno(cursor);
            alumnos.add(alumno);
            cursor.moveToNext();
        }

        cursor.close();

        return alumnos;
    }

    @Override
    public AlumnoItem readAlumno(Cursor cursor) {
        AlumnoItem alumno = new AlumnoItem();

        alumno.setId(cursor.getInt(0));
        alumno.setMatricula(cursor.getString(1));
        alumno.setNombre(cursor.getString(2));
        alumno.setCarrera(cursor.getString(3));

        return alumno;
    }

}
