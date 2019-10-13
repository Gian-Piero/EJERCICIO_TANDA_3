package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarActividad01(View view) {
        Intent intent = new Intent(this, Actividad_1.class);
        startActivity(intent);
    }

    public void iniciarActividad02(View view) {
        Intent intent = new Intent(this, Actividad_2.class);
        startActivity(intent);
    }

    public void iniciarActividad03(View view) {
        Intent intent = new Intent(this, Actividad_3.class);
        startActivity(intent);
    }

    public void iniciarActividad04(View view) {
        Intent intent = new Intent(this, Actividad_4.class);
        startActivity(intent);
    }
}
