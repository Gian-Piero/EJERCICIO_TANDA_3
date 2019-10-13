package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Actividad_4_ElegirCiudad extends AppCompatActivity {

    private HashMap<String, String> mapaCiudadesHospitales;
    private Spinner spinerCiudades;
    private Spinner spinerHoras;

    private ArrayList<RadioButton> listRadioButtons;
    private RadioButton btnHospital1;
    private RadioButton btnHospital2;
    private RadioButton btnHospital3;
    private RadioButton btnHospital4;
    private RadioButton btnHospital5;

    private RadioGroup btnGroupHospital;

    private String hospital;
    private String ciudad;
    private String horaElegida = "";
    private String nombre;
    private String apellido;
    private String dni;
    private String causa;
    private String urgencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4__elegir_ciudad);

        //Recupero datos
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        apellido = extras.getString("apellido");
        dni = extras.getString("dni");
        causa = extras.getString("causa");
        urgencia = extras.getString("urgente");



        mapaCiudadesHospitales = new HashMap<String, String>();
        cargarMapa();

        spinerCiudades = findViewById(R.id.spinnerCiudades);
        spinerHoras = findViewById(R.id.spinnerHoras);
        final String[] ciudades = new String[] {"Bilbao","Vitoria-Gasteiz","San Sebastian"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, ciudades);

        spinerCiudades.setAdapter(adapter);
        spinerCiudades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvMensaje=(TextView) view;
                cargarHospitales(tvMensaje.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cargarHoras();
    }

    private void cargarMapa(){
        listRadioButtons = new ArrayList<RadioButton>();
        btnHospital1 = findViewById(R.id.radioButtonHospital1);
        btnHospital2 = findViewById(R.id.radioButtonHospital2);
        btnHospital3 = findViewById(R.id.radioButtonHospital3);
        btnHospital4 = findViewById(R.id.radioButtonHospital4);
        btnHospital5 = findViewById(R.id.radioButtonHospital5);
        listRadioButtons.add(btnHospital1);
        listRadioButtons.add(btnHospital2);
        listRadioButtons.add(btnHospital3);
        listRadioButtons.add(btnHospital4);
        listRadioButtons.add(btnHospital5);

        mapaCiudadesHospitales.put("Bilbao", "Hospital Cruz Roja de Bilbao,Clínica IMQ Virgen Blanca,Hospital Universitario de Basurto,Centro Médico Quirónsalud Bilbao,Ignacio del Toro Hospital");
        mapaCiudadesHospitales.put("Vitoria-Gasteiz", "Hospital Vithas San José,Hospital Quirónsalud Vitoria,HUA - Santiago Apóstol,Mutualia Hospital de Alta Resolución,HUA - Txagorritxu");
        mapaCiudadesHospitales.put("San Sebastian","Hospital San Juan De Dios de San Sebastián,Hospital Universitario Donostia,Hospital universitario de Donostia- Edificio Amara,Gipuzkoa Poliklinika,Hospital de Día QuirónSalud Donostia");
    }

    private void cargarHospitales(String ciudadElegida){
        this.ciudad = ciudadElegida;
        String [] hospitales = mapaCiudadesHospitales.get(ciudadElegida).split(",");
        for (int i=0; i<hospitales.length; i++){
            listRadioButtons.get(i).setText(hospitales[i]);
        }
    }

    private void cargarHoras(){
        String [] horas = "08:00,08:30,09:30,10:00,10:30,11:00,11:30,12:00,12:30,13:00,16:00,16:30,17:00,17:30,18:00,18:30,19:00,19:30,20:00,20:30,21:00".split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, horas);
        spinerHoras.setAdapter(adapter);
        spinerHoras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvMensaje=(TextView) view;
                horaElegida = tvMensaje.getText().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    public void verCita(View view) {

        //Hospital Marcado
        btnGroupHospital = findViewById(R.id.btnGroupHospitales);
        int radioButtonID = btnGroupHospital.getCheckedRadioButtonId();
        View radioButton = btnGroupHospital.findViewById(radioButtonID);
        int idx = btnGroupHospital.indexOfChild(radioButton);
        RadioButton r = (RadioButton) btnGroupHospital.getChildAt(idx);
        hospital = r.getText().toString();

        Intent intent = new Intent(this, Actividad_4_verCita.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("dni", dni);
        intent.putExtra("causa", causa);
        intent.putExtra("urgente", urgencia);
        intent.putExtra("hora", horaElegida);
        intent.putExtra("hospital", hospital);
        intent.putExtra("ciudad", ciudad);

        startActivity(intent);
    }
}
