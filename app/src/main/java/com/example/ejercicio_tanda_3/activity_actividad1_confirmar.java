package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_actividad1_confirmar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_confirmar);
        TextView txtDatos = findViewById(R.id.txtDatos);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido= extras.getString("apellido");

        txtDatos.setText("Hola " + nombre.toUpperCase() + " " + apellido.toUpperCase() + ", ¿Aceptas las condiciones?");


    }

    public void verEstado(View view) {
        Intent resultadoIntent = new Intent();
        switch(view.getId()) {
            case R.id.btnAceptar:
                resultadoIntent.putExtra("resultado", "ACEPTADO");
                setResult(RESULT_OK, resultadoIntent);
                finish();
                break;
            case R.id.btnRechazar:
                resultadoIntent.putExtra("resultado", "RECHAZADO");
                setResult(RESULT_OK, resultadoIntent);
                finish();
                break;
            default:
        }
    }
}
