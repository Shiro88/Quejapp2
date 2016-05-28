package com.pqrs.sena.quejapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;


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

    public registro_usuario_fragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_registro_usuario_fragment, container, false);
        btnRegistrar= (Button) view.findViewById(R.id.btnRegistrarse);
        edtNombreCompleto = (EditText) view.findViewById(R.id.edt_nombre_completo);
        edtApellidos = (EditText) view.findViewById(R.id.edt_apellidos);
        edtNumeroDocumento = (EditText) view.findViewById(R.id.edtnumero_documento);
        spnTipoDocumento = (Spinner) view.findViewById(R.id.spntipodocumento);
        edtNombreUsuario =(EditText) view.findViewById(R.id.edt_nombreusuario);
        edtContraseña =(EditText) view.findViewById(R.id.edt_contraseña);
        btnRegistrar.setOnClickListener(this);
        return view;
    }
    public void salvar(View view){
        // enviarDatos(edtNombreCompleto.getText().toString(), edtApellidos.getText().toString(), spnTipoDocumento.getSelectedItem().toString(), edtNumeroDocumento.getText().toString(), edtNombreUsuario.getText().toString(), edtContraseña.getText().toString());

        HashMap<String,String> miHash= new HashMap<>();
        miHash.put("tabla","usuario");
        miHash.put("nombre",edtNombreCompleto.getText().toString());
        miHash.put("apellido",edtApellidos.getText().toString());
        miHash.put("tipoDocumento",spnTipoDocumento.getSelectedItem().toString());
        miHash.put("numeroDocumento",edtNumeroDocumento.getText().toString());
        miHash.put("nombreUsuario",edtNombreUsuario.getText().toString());
        miHash.put("clave",edtContraseña.getText().toString());
        enviarDatos("objeto",miHash);

    }

    public void enviarDatos(String clave,Object value){
        AsyncHttpClient cliente= new AsyncHttpClient();
        String url="http://www.movilessena.com/Quejapp/Insert.php";
        //String url="http://www.movilessena.com/Quejapp/Insert.php?";
        RequestParams rpMisParametos=new RequestParams();
        rpMisParametos.put(clave,value);
        cliente.post(url, rpMisParametos, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String resultado = new String(responseBody);
                Toast.makeText(getContext(), resultado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void enviarDatos(String nombrecompleto, String Apellidos,  String NumeroDocumento,String TipoDocumento ,String NombreUsuario, String Contrasenia) {
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://www.movilessena.com/Quejapp/Insert.php?";
        String parametros="&nombres="+nombrecompleto+"&apellidos="+Apellidos+"&identificacion="+NumeroDocumento+"&tipodocumento="+TipoDocumento+"&nombreusuario="+NombreUsuario+"&contrasenia="+Contrasenia;
        client.post(url + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String resultado = new String(responseBody);
                    Toast.makeText(getActivity(), "Comunicacion correcta:" + resultado, Toast.LENGTH_LONG).show();

                    //txv_cath_error.setText(resultado);
                }
                else{
                    Toast.makeText(getContext(),"Status Code" + statusCode,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getActivity(),statusCode + error.getMessage(),Toast.LENGTH_LONG).show();
                // txv_cath_error.setText(error.getMessage().toString());

            }
        });

    }


    public void onClick(View v) {
        salvar(v);
    }
}


