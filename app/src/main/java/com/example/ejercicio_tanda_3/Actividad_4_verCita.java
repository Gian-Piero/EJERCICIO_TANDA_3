package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Actividad_4_verCita extends AppCompatActivity {

    private String horaElegida = "";
    private String nombre;
    private String apellido;
    private String dni;
    private String causa;
    private String urgencia;
    private String ciudad;
    private String hospital;

    private TextView txtTitulo;
    private TextView txtNombreCompleto;
    private TextView txtInfoCita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4_ver_cita);

        //Recupero datos
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        apellido = extras.getString("apellido");
        dni = extras.getString("dni");
        causa = extras.getString("causa");
        urgencia = extras.getString("urgente");
        horaElegida = extras.getString("hora");
        ciudad = extras.getString("ciudad");
        hospital = extras.getString("hospital");

        txtTitulo = findViewById(R.id.textViewHoraCiudad);
        txtNombreCompleto = findViewById(R.id.textViewNombreApellido);
        txtInfoCita = findViewById(R.id.textViewInfoCita);

        txtTitulo.setText("Cita medica en " + ciudad + " en el hospital " + hospital + " :");
        txtNombreCompleto.setText("Para el paciente " + nombre.toUpperCase() + " " + apellido.toUpperCase() + " con el dni " + dni.toUpperCase());
        txtInfoCita.setText("A las " + horaElegida + " para el tratamiento de " + causa + " " + urgencia);




    }
}
