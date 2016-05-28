package com.pqrs.sena.quejapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class registrar_pqrs extends AppCompatActivity implements View.OnClickListener{
    Spinner spRegional;
    Spinner spCentro;
    Spinner spSede;
    Spinner spTipoPQRS;
    EditText edtNumeroFicha;
    Spinner spCategoriaPQRS;
    CheckBox chAnonimo;
    EditText edtDescripcion;
    Button btnRegistrar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_pqrs);
        spRegional=(Spinner)findViewById(R.id.spRegional);
        spCentro=(Spinner)findViewById(R.id.spCentro);
        spSede=(Spinner)findViewById(R.id.spSedes);
        spTipoPQRS=(Spinner)findViewById(R.id.spTipoPqrs);
        edtNumeroFicha=(EditText)findViewById(R.id.edtNumeroFicha);
        spCategoriaPQRS=(Spinner)findViewById(R.id.spCategoriaPqrs);
        chAnonimo=(CheckBox)findViewById(R.id.chbAnonimo);
        edtDescripcion=(EditText)findViewById(R.id.edtDescripcion);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrarPQRS);
        btnRegistrar.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.mi_menu_registrar, m);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mItem){
        switch(mItem.getItemId()){
            case R.id.mi_item_menu_login:
                enviarMensajeToast("uno",Toast.LENGTH_SHORT);
                cambiarActividad(MainActivity.class);
                break;
            case R.id.mi_item_menu_registrar:
                enviarMensajeToast("Ya estas aqui", Toast.LENGTH_SHORT);

                break;
            case R.id.mi_item_menu_buscar:
                enviarMensajeToast("tres",Toast.LENGTH_SHORT);
                cambiarActividad(activity_buscar_pqrs.class);
                break;
            case R.id.mi_item_menu_registro:
                enviarMensajeToast("tres",Toast.LENGTH_SHORT);
                cambiarActividad(registro_usuario.class);
                break;
            default:
                enviarMensajeToast("No es un item valido ",Toast.LENGTH_SHORT);
                break;
        }
        return true;
    }
    /*Funcion para enviar mensajes de tipoToast*/
    public void enviarMensajeToast(String msn,int tiempoDuracion){
        Toast.makeText(getApplicationContext(),msn,tiempoDuracion).show();
    }
    /*Funcion para enviar a otra actividad*/
    public void cambiarActividad(Class<?> clDestino){
        startActivity(new Intent(getApplicationContext(), clDestino));
    }


    @Override
    public void onClick(View v) {
        registrarPQRS();
    }

    private void registrarPQRS() {

    }


}

