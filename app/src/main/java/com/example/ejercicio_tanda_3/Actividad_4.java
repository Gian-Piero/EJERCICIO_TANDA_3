package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Actividad_4 extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtdni;
    private RadioGroup btnGroupCausa;
    private String causa;
    private CheckBox chckUrgente;
    private String tipoUrgencia = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4);
        chckUrgente = findViewById(R.id.checkBoxUrgencia);
        txtNombre = findViewById(R.id.editTextNombre);
        txtApellido = findViewById(R.id.editTextApellido);
        txtdni = findViewById(R.id.editDni);
    }

    public void finalizar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void inciarCitaMedica(View view) {
        Intent intent = new Intent(this, Actividad_4_ElegirCiudad.class);


        //Causa marcada
        btnGroupCausa = findViewById(R.id.btnGroup);
        int radioButtonID = btnGroupCausa.getCheckedRadioButtonId();
        View radioButton = btnGroupCausa.findViewById(radioButtonID);
        int idx = btnGroupCausa.indexOfChild(radioButton);
        RadioButton r = (RadioButton) btnGroupCausa.getChildAt(idx);
        causa = r.getText().toString();

        if (chckUrgente.isChecked())
            tipoUrgencia = "con urgencia";

        intent.putExtra("nombre", txtNombre.getText().toString());
        intent.putExtra("apellido", txtApellido.getText().toString());
        intent.putExtra("dni", txtdni.getText().toString());
        intent.putExtra("causa", causa);
        intent.putExtra("urgente", tipoUrgencia);

        startActivity(intent);
    }
}
