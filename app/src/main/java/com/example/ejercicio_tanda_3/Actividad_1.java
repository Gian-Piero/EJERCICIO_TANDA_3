package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Actividad_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_1);
    }

    public void volverInicio(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void verificarDatos(View view) {
        TextView txtNombre = findViewById(R.id.editTextNombre);
        TextView txtApellido = findViewById(R.id.editTextApellido);

        Intent intent = new Intent(Actividad_1.this,  activity_actividad1_confirmar.class);
        intent.putExtra("nombre", txtNombre.getText().toString());
        intent.putExtra("apellido", txtApellido.getText().toString());
        startActivityForResult(intent,1234);
    }

    public void onActivityResult (int requestCode, int resultCode, Intent data){
        TextView txtCondicion = findViewById(R.id.textCondiciones);
        if (requestCode==1234 && resultCode==RESULT_OK ) {
            String resultado = data.getExtras().getString("resultado");
            txtCondicion.setText("Aceptas condiciones: " + resultado);
        }
    }
}
