package com.pqrs.sena.quejapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Esta variable es global dentro de esta clase
Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        //Aqui agrego el evento onclick
        if (btnIngresar != null) {
            btnIngresar.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this,registrar_pqrs.class));
    }
}
