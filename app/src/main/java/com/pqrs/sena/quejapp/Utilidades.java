package com.pqrs.sena.quejapp;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Chaquen on 05/06/2016.
 */
public class Utilidades {

    public static JSONObject devolverJson(byte[] responseBody) throws JSONException {
        String str= new String(responseBody);

        JSONObject  json=new JSONObject(str);
        return json;
    }

    public static void enviarMensaje(Context c, String msn) {

        Toast.makeText(c.getApplicationContext(),msn,Toast.LENGTH_LONG).show();
    }

    public static String validarCodigo(int statusCode,Throwable error) {
        String str;
        if(statusCode==302){
            str="Hola no tenemos acceso a internet";
        }else if(statusCode==0){
            str="No se ha podido establecer conexion";
        }else{
            str=Integer.toString(statusCode)+""+error.getMessage();
        }
        return  str;
    }
}
