package com.pqrs.sena.quejapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

import static com.pqrs.sena.quejapp.Utilidades.enviarMensaje;


/**
 * A simple {@link Fragment} subclass.
 */
public class registro_usuario_fragment extends Fragment implements View.OnClickListener {
    Button btnRegistrar;
    EditText edtNombreCompleto;
    EditText edtApellidos;
    Spinner spnTipoDocumento;
    EditText edtNumeroDocumento;
    EditText edtNombreUsuario;
    EditText edtContraseña;
    View view;
    String llave="abc";
    public registro_usuario_fragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_registro_usuario_fragment, container, false);
        btnRegistrar= (Button) view.findViewById(R.id.btnRegistrarse);
        edtNombreCompleto = (EditText) view.findViewById(R.id.edt_nombre_completo);
        edtNombreCompleto.setText("Edgar");
        edtApellidos = (EditText) view.findViewById(R.id.edt_apellidos);
        edtApellidos.setText("Guzman");
        edtNumeroDocumento = (EditText) view.findViewById(R.id.edtnumero_documento);
        edtNumeroDocumento.setText("1073684233");
        spnTipoDocumento = (Spinner) view.findViewById(R.id.spntipodocumento);
        edtNombreUsuario =(EditText) view.findViewById(R.id.edt_nombreusuario);
        edtNombreUsuario.setText("eaguzman332@misena.edu.co");
        edtContraseña =(EditText) view.findViewById(R.id.edt_contraseña);
        edtContraseña.setText("123");
        btnRegistrar.setOnClickListener(this);
        return view;
    }


    public void onClick(View v) {
        try{
            enviarDatosServidor(v);
        }catch (Exception exp){
            enviarMensaje(getContext(),"ESTO ES LO QUE PASA POR NO PROGRAMAR BIEN ☻"+exp.getMessage().toString());
        }

    }
    private void enviarDatosServidor(View v) {

        Usuario usuario= new Usuario();
        usuario.setStrNombres(edtNombreCompleto.getText().toString());
        usuario.setStrApellidos(edtApellidos.getText().toString());
        usuario.setStrTipoIdentificacion(spnTipoDocumento.getSelectedItem().toString());
        usuario.setStrIdentificacion(edtNumeroDocumento.getText().toString());
        usuario.setStrCorreo(edtNombreUsuario.getText().toString());
        //usuario.setStrGenero();
        usuario.setStrContrasenia(edtContraseña.getText().toString());

        WebService i_u = new WebService();
        RequestParams r=new RequestParams();
        r.put("datos",usuario.getRequestParamsInsertar());

        i_u.crear_registro(getContext(),usuario.getRequestParamsInsertar(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    JSONObject jobj= Utilidades.devolverJson(responseBody);
                    //Utilidades.enviarMensaje(getContext(),jobj.getString("mensaje"));
                    Utilidades utilidades=new Utilidades();
                    utilidades.guardarPreferences(getContext(), jobj.getString("token"), "USER_CODE");
                    String valor=utilidades.leerPreferences(getContext(),"USER_CODE");
                    Utilidades.enviarMensaje(getContext(), "Registro Exitoso...");
                    Intent intent = new Intent(getActivity().getApplication(), Menu_Principal.class);
                    startActivity(intent);
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


