package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Actividad_3_informacion extends AppCompatActivity {

    private TextView txtinformacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_3_informacion);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");
        String sexo = extras.getString("sexo");
        String aficiones = extras.getString("listaAficiones");




        txtinformacion = findViewById(R.id.textInformacion);
        txtinformacion.setText("Tu nombre completos es " + nombre + " " + apellido + ", tu sexo es " + sexo + " y " + aficiones);
    }

    public String pasarAficiones(ArrayList<String> listaAficiones){
        String str="";
        for (int i=0; i<listaAficiones.size(); i++)
        {
            str+= listaAficiones.get(i) + ", ";
        }
        return str;
    }
}
