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

<<<<<<< HEAD
=======
import org.json.JSONException;
import org.json.JSONObject;

>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
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
<<<<<<< HEAD

    }
    public void salvar(View view){
       // enviarDatos(edtNombreCompleto.getText().toString(), edtApellidos.getText().toString(), spnTipoDocumento.getSelectedItem().toString(), edtNumeroDocumento.getText().toString(), edtNombreUsuario.getText().toString(), edtContraseña.getText().toString());

        HashMap<String,String> miHash= new HashMap<>();
        miHash.put("tabla","usuario");
=======
        btnRegistrar.setOnClickListener(this);

    }

    public void onClick(View v) {
        //salvar(v);
        enviarDatosServidor();
    }

    private void enviarDatosServidor() {
        Usuario usuario= new Usuario();
        usuario.setStrNombres(edtNombreCompleto.getText().toString());
        usuario.setStrApellidos(edtApellidos.getText().toString());
        usuario.setStrTipoIdentificacion(spnTipoDocumento.getSelectedItem().toString());
        usuario.setStrIdentificacion(edtNumeroDocumento.getText().toString());
        usuario.setStrCorreo(edtNombreUsuario.getText().toString());
        //usuario.setStrGenero();
        usuario.setStrContrasenia(edtContraseña.getText().toString());
        WebService i_u = new WebService();
        i_u.crear_registro(usuario.getRequestParamsInsertar(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                //aqui manejo la respuesta del servidor
                String str= new String(responseBody);
                try {
                    JSONObject jobj=new JSONObject(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),Integer.toString(statusCode).toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    public void salvar(View view){
        // enviarDatos(edtNombreCompleto.getText().toString(), edtApellidos.getText().toString(), spnTipoDocumento.getSelectedItem().toString(), edtNumeroDocumento.getText().toString(), edtNombreUsuario.getText().toString(), edtContraseña.getText().toString());

        HashMap<String,String> miHash= new HashMap<>();
>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
        miHash.put("nombre",edtNombreCompleto.getText().toString());
        miHash.put("apellido",edtApellidos.getText().toString());
        miHash.put("tipoDocumento",spnTipoDocumento.getSelectedItem().toString());
        miHash.put("numeroDocumento",edtNumeroDocumento.getText().toString());
        miHash.put("nombreUsuario",edtNombreUsuario.getText().toString());
        miHash.put("clave",edtContraseña.getText().toString());
<<<<<<< HEAD
        enviarDatos("objeto",miHash);
        
=======
        enviarDatos("usuario", miHash);

>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
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
<<<<<<< HEAD
                }
                else{
                    Toast.makeText(getApplicationContext(),"Status Code" + statusCode,Toast.LENGTH_LONG).show();
=======
                } else {
                    Toast.makeText(getApplicationContext(), "Status Code" + statusCode, Toast.LENGTH_LONG).show();
>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
<<<<<<< HEAD
                Toast.makeText(registro_usuario.this,statusCode + error.getMessage(),Toast.LENGTH_LONG).show();
=======
                Toast.makeText(registro_usuario.this, statusCode + error.getMessage(), Toast.LENGTH_LONG).show();
>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
                // txv_cath_error.setText(error.getMessage().toString());

            }
        });

    }


<<<<<<< HEAD
    public void onClick(View v) {
        salvar(v);
    }
=======
>>>>>>> 96c9f18f9305059db90128c8fb79522b622790b7
}



