package com.example.ficheroaccesoadatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ficheros extends AppCompatActivity implements View.OnClickListener{

    Button btnEscribirInterna,btnEscribirExterna,btnCodificacion,btnLeerFichero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficheros);

        btnEscribirExterna = (Button) findViewById(R.id.btnEscribirExterna);
        btnEscribirExterna.setOnClickListener(this);
        btnEscribirInterna = (Button) findViewById(R.id.btnEscribirInterna);
        btnEscribirInterna.setOnClickListener(this);
        btnCodificacion = (Button) findViewById(R.id.btnCodificacion);
        btnCodificacion.setOnClickListener(this);
        btnLeerFichero = (Button) findViewById(R.id.btnLeerFichero);
        btnLeerFichero.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId())
        {
            case R.id.btnEscribirExterna:
                intent = new Intent(this,EscribirExterna.class);
                startActivity(intent);
                break;
            case R.id.btnEscribirInterna:
                intent = new Intent(this,EscribirInterna.class);
                startActivity(intent);
                break;
            case R.id.btnCodificacion:
                intent = new Intent(this,Codificacion.class);
                startActivity(intent);
                break;
            case R.id.btnLeerFichero:
                intent = new Intent(this,LeerFichero.class);
                startActivity(intent);
                break;
        }
    }
}
