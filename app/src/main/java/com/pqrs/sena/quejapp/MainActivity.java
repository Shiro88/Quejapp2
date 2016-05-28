package com.pqrs.sena.quejapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

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

        Usuario us= new Usuario();
        WebService ws= new WebService();
        ws.consultar_registro(us.getRequestParamsLog(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //aqui logica para el ingreso
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });




        startActivity(new Intent(MainActivity.this, registrar_pqrs.class));
    }
    public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {
        Boolean cancel=true;
        @Override
        protected String doInBackground(Integer... params) {
            Toast.makeText(getApplicationContext(),"consultando ando",Toast.LENGTH_SHORT).show();
            if(cancel){


            }else{
                Toast.makeText(getApplicationContext(),"Ya has consultado",Toast.LENGTH_SHORT).show();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress){

        }
        @Override
        protected void onPostExecute(String resultado){

        }
    }

}
