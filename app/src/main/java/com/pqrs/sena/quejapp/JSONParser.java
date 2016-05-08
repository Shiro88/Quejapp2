package com.pqrs.sena.quejapp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
/**
 * Created by ColsutecR on 20/04/2016.
 */
public class JSONParser extends AppCompatActivity implements View.OnClickListener {
    Button btnRegistrar;
    EditText edtNombreCompleto;
    EditText edtApellidos;
    Spinner spnTipoDocumento;
    EditText edtNumeroDocumento;
    EditText edtNombreUsuario;
    EditText edtContraseña;
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
        enviarDatos(edtNombreCompleto.getText().toString(), edtApellidos.getText().toString(), spnTipoDocumento.getSelectedItem().toString(), edtNumeroDocumento.getText().toString(), edtNombreUsuario.getText().toString(), edtContraseña.getText().toString());
    }


    private void enviarDatos(String Nombres, String Apellidos, String TipoDocumento, String NumeroDocumento, String NombreUsuario, String Contraseña) {
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://www.movilessena.com/Quejapp/Insert.php?";
        String parametros="&nombres="+Nombres+"&apellidos="+Apellidos+"&identificacion"+NumeroDocumento+"&tipodocumento"+TipoDocumento+"&nombreusuario"+NombreUsuario+"&contraseña"+Contraseña;
        client.put(url + parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    String resultado = new String(responseBody);
                    Toast.makeText(JSONParser.this, "Comunicacion correcta:" + resultado, Toast.LENGTH_LONG).show();
                    //txv_cath_error.setText(resultado);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                //Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
               // txv_cath_error.setText(error.getMessage().toString());

            }
        });

    }


    @Override
    public void onClick(View v) {
        salvar(v);
    }
}



