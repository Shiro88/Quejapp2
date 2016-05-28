package com.pqrs.sena.quejapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class activity_buscar_pqrs extends AppCompatActivity  implements View.OnClickListener{
    EditText edtBusquedaNumeroFicha;
    EditText edtNumeroDocumento;
    Button btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_buscar_pqrs);
        edtBusquedaNumeroFicha=(EditText)findViewById(R.id.edtBusquedaNumeroFicha);
        edtNumeroDocumento=(EditText)findViewById(R.id.edtNumeroDocumento);
        btnBuscar=(Button)findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(this);
        
    }
    @Override
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.mi_menu_buscar, m);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mItem){
        switch(mItem.getItemId()){
            case R.id.mi_item_menu_login:
                enviarMensajeToast("uno", Toast.LENGTH_SHORT);
                cambiarActividad(MainActivity.class);
                break;
            case R.id.mi_item_menu_registrar:
                enviarMensajeToast("Ya estas aqui", Toast.LENGTH_SHORT);
                cambiarActividad(registrar_pqrs.class);
                break;
            case R.id.mi_item_menu_buscar:
                enviarMensajeToast("Ya estas aqui",Toast.LENGTH_SHORT);

                break;
            default:
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
        buscarPQRS();
    }

    private void buscarPQRS() {
        Pqrs miPqrs= new Pqrs();
        WebService miws = new WebService();
        miws.consultar_registro(miPqrs.getRequestParamsConsultar(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //AQUI LOGICA PARA LA RESPUESTA DEL SERVIDOR
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
