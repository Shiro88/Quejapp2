package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends Fragment implements View.OnClickListener{

    Button btnIngresar;
    EditText edtUsuario;
    EditText edtContrasenia;
    public login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        btnIngresar = (Button) view.findViewById(R.id.btnIngresar);
        edtUsuario=(EditText)view.findViewById(R.id.edt_nombre_usuario_login);
        edtUsuario.setText("eaguzman332@misena.edu.co");
        edtContrasenia=(EditText)view.findViewById(R.id.edt_clave_login);
        edtContrasenia.setText("123");
        //Aqui agrego el evento onclick
        if (btnIngresar != null) {
            btnIngresar.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onClick(View v) {

        /*AQUI LOGICA PARA CONSULTAR AL USUARIO*/
        WebService myWS= new WebService();
        Usuario us=new Usuario();
        us.setStrCorreo(edtUsuario.getText().toString());
        us.setStrContrasenia(edtContrasenia.getText().toString());
        myWS.consultar_registro(getContext(),us.getRequestParamsLogIn(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    /*String str =new String(responseBody);
                    Utilidades.enviarMensaje(getContext(),str);*/
                        JSONObject myJson=Utilidades.devolverJson(responseBody);
                    Utilidades.enviarMensaje(getContext(),myJson.getString("mensaje"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    Utilidades.enviarMensaje(getContext(),e.getMessage().toString());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                String s=Utilidades.validarCodigo(statusCode,error);
                Utilidades.enviarMensaje(getContext(),s);
            }
        });

    }
}
