package com.pqrs.sena.quejapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

public class registro_usuario extends AppCompatActivity implements View.OnClickListener  {
    Button btnRegistrar;
    EditText edtNombreCompleto;
    EditText edtApellidos;
    Spinner spnTipoDocumento;
    EditText edtNumeroDocumento;
    EditText edtNombreUsuario;
    EditText edtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        btnRegistrar= (Button) findViewById(R.id.btnRegistrarse);
        edtNombreCompleto = (EditText) findViewById(R.id.edt_nombre_completo);
        edtApellidos = (EditText) findViewById(R.id.edt_apellidos);
        edtNumeroDocumento = (EditText) findViewById(R.id.edtnumero_documento);
        spnTipoDocumento = (Spinner) findViewById(R.id.spntipodocumento);
        edtNombreUsuario =(EditText) findViewById(R.id.edt_nombreusuario);
        edtContraseña =(EditText) findViewById(R.id.edt_contraseña);

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
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(registro_usuario.this, "Comunicacion correcta:" + resultado, Toast.LENGTH_LONG).show();

                    //txv_cath_error.setText(resultado);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Status Code" + statusCode,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(registro_usuario.this,statusCode + error.getMessage(),Toast.LENGTH_LONG).show();
                // txv_cath_error.setText(error.getMessage().toString());

            }
        });

    }


    public void onClick(View v) {
        salvar(v);
    }
}



