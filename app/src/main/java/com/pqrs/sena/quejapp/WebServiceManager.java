package com.pqrs.sena.quejapp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

/**
 * Created by FAMILIA on 14/05/2016.
 */
public class WebServiceManager {



    public AsyncHttpClient miAHC;
    public String url;
    public RequestParams misParametros;

    public WebServiceManager() {
        this.url = "http://www.movilessena.com/Quejapp/Insert.php";
    }

    public JSONObject ConsultarDatos(HashMap<String,String> HashConsulta){
        return EnviarDatos(HashConsulta);

    }

    public Boolean RegistrarDatos(){
        return true;
    }
    public Boolean ActualizarDatos(){
        return true;
    }

    public Boolean EliminarDatos(){
        return true;
    }

    private JSONObject EnviarDatos(HashMap<String, String> miHash){
        miAHC = new AsyncHttpClient();
        misParametros = new RequestParams();
        misParametros.put("objeto", miHash);
        final JSONObject[] strStatus = {new JSONObject()};
        miAHC.post(url, misParametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                strStatus[0] = ConvertirJSON(responseBody);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }

        });
        return strStatus[0];

    }

    private JSONObject ConvertirJSON(byte[] miRespuestaByte){
        String strMiRespuesta = new String(miRespuestaByte);
        JSONObject miJson= null;
        try {
            miJson = new JSONObject(strMiRespuesta);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return miJson;
    }
}
