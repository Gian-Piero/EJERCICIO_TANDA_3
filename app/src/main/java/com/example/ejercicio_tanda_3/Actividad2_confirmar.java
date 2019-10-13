package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actividad2_confirmar extends AppCompatActivity {

    private TextView txtInfo;
    private Button btnVolver;
    private int aciertos;
    private int errores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2_confirmar);

        txtInfo = findViewById(R.id.textInfo);

        Bundle extras = getIntent().getExtras();
        String resultado = extras.getString("resultado");
        aciertos = extras.getInt("aciertos");
        errores= extras.getInt("errores");
        txtInfo.setText("El resultado de la operacion es " + resultado);

        btnVolver = findViewById(R.id.buttonVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volverActividad2();
            }
        });

    }

    public void volverActividad2()
    {
        Intent intent = new Intent();
        intent.putExtra("acierto", aciertos);
        intent.putExtra("errore", errores);
        setResult(RESULT_OK, intent);
        finish();
    }


}
