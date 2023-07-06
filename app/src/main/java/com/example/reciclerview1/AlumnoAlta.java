package com.example.reciclerview1;

import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AlumnoAlta extends AppCompatActivity {

    private Button btnGuardar, btnRegresar;
    private AlumnoItem alumno;
    private EditText txtNombre, txtMatricula, txtGrado;
    private ImageView imgAlumno;
    private TextView lblImagen;
    private String carrera = "Ing. Tec. Información";
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alumno_alta);
        btnGuardar = (Button) findViewById(R.id.btnSalir);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        txtMatricula = (EditText) findViewById(R.id.txtMatricula);
        txtGrado = (EditText) findViewById(R.id.txtGrado);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        imgAlumno = (ImageView) findViewById(R.id.imgAlumno);

        Bundle bundle = getIntent().getExtras();
        alumno = (AlumnoItem) bundle.getSerializable("alumno");
        posicion = bundle.getInt("posicion", posicion);

        if(posicion >= 0) {
            txtMatricula.setText(alumno.getMatricula());
            txtNombre.setText(alumno.getNombre());
            txtGrado.setText(alumno.getCarrera());
            imgAlumno.setImageResource(alumno.getImageID());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alumno == null) {
                    alumno = new AlumnoItem();
                    alumno.setCarrera(carrera);
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setImageID(R.drawable.usuario);

                    if(validar()) {
                        Aplicacion.alumnos.add(alumno);
                        setResult(Activity.RESULT_OK);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), " Falto por capturar datos", Toast.LENGTH_SHORT).show();
                        txtMatricula.requestFocus();
                    }
                }

                if(posicion >= 0) {
                    alumno.setMatricula(txtMatricula.getText().toString());
                    alumno.setNombre(txtNombre.getText().toString());
                    alumno.setCarrera(txtGrado.getText().toString());

                    Aplicacion.alumnos.get(posicion).setMatricula(alumno.getMatricula());
                    Aplicacion.alumnos.get(posicion).setNombre(alumno.getNombre());
                    Aplicacion.alumnos.get(posicion).setCarrera(alumno.getCarrera());

                    Toast.makeText(getApplicationContext(), " Se modifico con exito", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }

    public boolean validar() {
        boolean exito = true;
        Log.d("Nombre", "Validar: " + txtNombre.getText());
        if(txtNombre.getText().toString().equals("") || txtMatricula.getText().toString().equals("") || txtGrado.getText().toString().equals("")) exito = false;

        return exito;

}
}
