package com.example.ejercicio_tanda_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Actividad_2 extends AppCompatActivity {

    public static int CORRECTOS = 0;
    public static int INCORRECTOS = 0;
    private EditText txtValor1;
    private EditText txtValor2;
    private EditText txtResultado;
    private Button btnComprobar;

    private TextView txtCorrectas;
    private TextView txtIncorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_2);

        txtValor1 = findViewById(R.id.editTextValor1);
        txtValor2 = findViewById(R.id.editTextValor2);
        txtResultado = findViewById(R.id.editTextResultado);
        txtCorrectas = findViewById(R.id.textCorrectas);
        txtIncorrectas = findViewById(R.id.textIncorrectas);

        ponerNumeroAleatorios();

        btnComprobar = findViewById(R.id.buttonComprobar);
        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor1 = Integer.parseInt(txtValor1.getText().toString());
                int valor2 = Integer.parseInt(txtValor2.getText().toString());
                try{
                    int resultado = Integer.parseInt(txtResultado.getText().toString());
                    String strResultado = "";
                    if (resultado == (valor1+valor2)){
                        strResultado = "CORRECTA";
                        Actividad_2.CORRECTOS++;
                    }
                    else
                    {
                        strResultado = "INCORRECTA";
                        Actividad_2.INCORRECTOS++;
                    }
                    crearIntento(strResultado);
                }catch (NumberFormatException e)
                {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Rellena el resultado", Toast.LENGTH_SHORT);
                    toast1.show();
                }



            }
        });
    }

    public void crearIntento(String str)
    {
        Intent intent = new Intent(this, Actividad2_confirmar.class);
        intent.putExtra("resultado", str);
        intent.putExtra("aciertos", CORRECTOS);
        intent.putExtra("errores", INCORRECTOS);
        startActivityForResult(intent,1234);
    }

    public void ponerNumeroAleatorios(){
        int valor1 =  (int)((Math.random()*101));
        int valor2 =  (int)((Math.random()*101));

        txtValor1.setText(valor1+ "");
        txtValor2.setText(valor2 + "");
        txtResultado.setText("");
    }


    public void cambiarTextos(int aciertos, int errores)
    {
        txtCorrectas.setText("PREGUNTAS CORRECTAS : " + Actividad_2.CORRECTOS);
        txtIncorrectas.setText("INCORRECTAS : " + Actividad_2.INCORRECTOS);
    }

    public void onActivityResult (int requestCode, int resultCode, Intent data){
        if (requestCode==1234 && resultCode==RESULT_OK ) {
            int aciertos = data.getExtras().getInt("acierto");
            int errores = data.getExtras().getInt("errore");
            cambiarTextos(aciertos, errores);
            ponerNumeroAleatorios();
        }
    }
}
