package com.pqrs.sena.quejapp;

import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by FAMILIA on 28/05/2016.
 */
public class registrar_pqrs_fragment extends Fragment implements View.OnClickListener{
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        View v= inflater.inflate(R.layout.fragment_registrar_pqrs, container, false);
        try{
            if(v!=null){
                spRegional=(Spinner)v.findViewById(R.id.spRegional);
                spCentro=(Spinner)v.findViewById(R.id.spCentro);
                spSede=(Spinner)v.findViewById(R.id.spSedes);
                spTipoPQRS=(Spinner)v.findViewById(R.id.spTipoPqrs);
                //edtNumeroFicha=(EditText)v.findViewById(R.id.edtNumeroFicha);
                spCategoriaPQRS=(Spinner)v.findViewById(R.id.spCategoriaPQRS);
                chAnonimo=(CheckBox)v.findViewById(R.id.chbAnonimo);
                edtDescripcion=(EditText)v.findViewById(R.id.edtDescripcion);
                btnRegistrar=(Button)v.findViewById(R.id.btnRegistrarPqrs);
                if(btnRegistrar!=null){
                    btnRegistrar.setOnClickListener(this);
                }

            }else{
                Toast.makeText(getContext(),"lo sentimos pero la vista es nula",Toast.LENGTH_SHORT).show();
            }

        }catch (NullPointerException nexp){
            nexp.printStackTrace();

        }
        return v;
    }


    @Override
    public void onClick(View v) {
        WebService ws= new WebService();
        Pqrs mipqrs= new Pqrs();
        ws.crear_registro(getContext(),mipqrs.getRequestParamsInsertar(), new AsyncHttpResponseHandler() {
                @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                //aqui logica de respuesta de servidor
                try {
                    JSONObject jobj=Utilidades.devolverJson(bytes);
                    Utilidades.enviarMensaje(getContext(),jobj.optString("mensaje"));
                }catch (JSONException jexp){
                    Utilidades.enviarMensaje(getContext(),jexp.getMessage().toString());
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                String s=Utilidades.validarCodigo(i,throwable);
                Utilidades.enviarMensaje(getContext(),s);
            }
        });
    }

    public void llenarSpinerConDatos(){
        /*
        spRegional;
        spCentro;
        spSede;
        spTipoPQRS;
        spCategoriaPQRS;
        */
    }
}
