package com.example.ficheroaccesoadatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EscribirInterna extends AppCompatActivity implements View.OnClickListener{

    TextView txvResultado,txvPropiedades;
    Button btnSumar;
    EditText etxOperando1,etxOperando2;
    public final String NOMBREFICHERO = "resultado.txt";
    Memoria miMemoria;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escribir_interna);
        txvResultado = (TextView) findViewById(R.id.txvResultado);
        txvPropiedades = (TextView) findViewById(R.id.txvPropiedades);
        btnSumar = (Button) findViewById(R.id.btnSuma);
        btnSumar.setOnClickListener(this);
        etxOperando1 = (EditText) findViewById(R.id.etxOperando1);
        etxOperando2 = (EditText) findViewById(R.id.etxOperando2);

        miMemoria = new Memoria(getApplicationContext());



    }

    @Override
    public void onClick(View view) {
        int r;
        String op1 = etxOperando1.getText().toString();
        String op2 = etxOperando2.getText().toString();
        String texto = "0";
        if (view == btnSumar)
        {
            try {
                r = Integer.parseInt(op1) + Integer.parseInt(op2);
                texto = String.valueOf(r);
            }catch (NumberFormatException e)
            {
                Log.e("Error", e.getMessage());
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG);
            }
            txvResultado.setText(texto);
            if (miMemoria.escribirInterna(NOMBREFICHERO, texto,false,"UTF-8"))
            {
                txvPropiedades.setText(miMemoria.mostrarPropiedadesInterna(NOMBREFICHERO));
            }else
            {
                txvPropiedades.setText("ERROR al escribir en el fichero" + NOMBREFICHERO);
            }

        }
    }
}
