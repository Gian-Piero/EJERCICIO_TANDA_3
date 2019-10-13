package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class Actividad_3 extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private RadioGroup btnGroupSexo;
    private String sexoMarcado;
    private ArrayList<CheckBox> checkBoxes;
    private CheckBox musica;
    private CheckBox lectura;
    private CheckBox deportes;
    private CheckBox viajar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_3);
    }

    public void verResultado(View view) {

        //Nombre y apellidos
        txtNombre = findViewById(R.id.editTextNombre);
        txtApellido = findViewById(R.id.editTextApellido);
        try{
            //Sexo elegido
            btnGroupSexo = findViewById(R.id.groupRadioButtons);
            int radioButtonID = btnGroupSexo.getCheckedRadioButtonId();
            View radioButton = btnGroupSexo.findViewById(radioButtonID);
            int idx = btnGroupSexo.indexOfChild(radioButton);
            RadioButton r = (RadioButton) btnGroupSexo.getChildAt(idx);
            sexoMarcado = r.getText().toString();

            //ArrayList de checkboxes para ver cuales estan seleccionados
            checkBoxes = new ArrayList<CheckBox>();
            musica = findViewById(R.id.checkBoxMusica);
            lectura = findViewById(R.id.checkBoxLectura);
            deportes = findViewById(R.id.checkBoxDeportes);
            viajar = findViewById(R.id.checkBoxViajar);

            checkBoxes.add(musica);
            checkBoxes.add(lectura);
            checkBoxes.add(deportes);
            checkBoxes.add(viajar);

            if (txtNombre.getText().toString().equals(""))
                Toast.makeText(Actividad_3.this, "El nombre no estar vacio", Toast.LENGTH_LONG).show();
            else
            {
                if (txtApellido.getText().toString().equals(""))
                    Toast.makeText(Actividad_3.this, "El apellido no puede estar vacio", Toast.LENGTH_LONG).show();
                else{
                    Intent intent = new Intent(this, Actividad_3_informacion.class);
                    intent.putExtra("nombre", txtNombre.getText().toString());
                    intent.putExtra("apellido", txtApellido.getText().toString());
                    intent.putExtra("sexo", sexoMarcado);
                    intent.putExtra("listaAficiones", listaAficiones());
                    startActivity(intent);
                }
            }
        }
        catch (NullPointerException i)
        {
            Toast.makeText(Actividad_3.this, "Complete todos los campos del formulario", Toast.LENGTH_LONG).show();
        }
    }

    public String listaAficiones(){
        String listaAficiones="";
        boolean tieneAficion = false;
        for (int i=0; i<checkBoxes.size(); i++)
        {
            if (checkBoxes.get(i).isChecked()){
                tieneAficion=true;
                listaAficiones+=checkBoxes.get(i).getText().toString() + ", ";
            }
        }

        if (!tieneAficion)
            return "no tiene aficion";
        else
        {
            listaAficiones = listaAficiones.substring(0,listaAficiones.length()-2);
            return "sus aficiones son " + listaAficiones;
        }
    }
}
