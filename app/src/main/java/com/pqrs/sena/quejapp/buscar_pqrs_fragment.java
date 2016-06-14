package com.pqrs.sena.quejapp;



import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;



/**
 * A simple {@link Fragment} subclass.
 */
public class buscar_pqrs_fragment extends android.support.v4.app.Fragment implements View.OnClickListener{
    EditText edtBusquedaNumeroFicha;
    EditText edtNumeroDocumento;
    Button btnBuscar;


    public buscar_pqrs_fragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_buscar_pqrs, container, false);
        edtBusquedaNumeroFicha=(EditText)v.findViewById(R.id.edtNumeroFicha);
        edtNumeroDocumento=(EditText)v.findViewById(R.id.edtBusquedaNumeroDocumento);
        btnBuscar=(Button)v.findViewById(R.id.btnBuscar);
        btnBuscar.setOnClickListener(this);
        return  v;
    }
    @Override
    public void onClick(View v) {
        buscarPQRS();
    }
    private void buscarPQRS() {
        Pqrs miPqrs= new Pqrs();
        WebService miws = new WebService();
        miws.consultar_registro(getContext(),miPqrs.getRequestParamsConsultar(), new AsyncHttpResponseHandler() {
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
