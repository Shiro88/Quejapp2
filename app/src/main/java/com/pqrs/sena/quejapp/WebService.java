package com.pqrs.sena.quejapp;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Chaquen on 21/05/2016.
 */
public class WebService {
    public String getStrUrl() {
        return strUrl;
    }

    //private String strUrl="http://127.16.179:8082/api.quejapp.com/v1/index.php";
    //private String strUrl="http://mohanpruebas.mohansoft.com/v1/index.php";
    private String strUrl="http://movilessena.com/Quejapp/v1/index.php";

    public AsyncHttpClient miCliente;

    public WebService(){
        this.miCliente=new AsyncHttpClient();
    }

    public void consultar_registro(Context c,HashMap<String,String> mih,AsyncHttpResponseHandler asyncHttpResponseHandler){

        RequestParams rp= new RequestParams();
        rp.put("datos",mih);
        this.miCliente.post(c,this.strUrl,rp, asyncHttpResponseHandler);
    }
    public void consultar_registro_con_parametros(HashMap<String,String> mih,AsyncHttpResponseHandler asyncHttpResponseHandler){
        RequestParams rp= new RequestParams();
        rp.put("datos",mih);
        this.miCliente.post(this.strUrl,rp, asyncHttpResponseHandler);
    }
    public void crear_registro(Context c,HashMap<String,String> mih,AsyncHttpResponseHandler asyncHttpResponseHandler){
        RequestParams rp= new RequestParams();
        rp.put("datos",mih);
        this.miCliente.post(c,this.strUrl,rp, asyncHttpResponseHandler);
    }
    public void actualizar_registro(HashMap<String,String> mih,AsyncHttpResponseHandler asyncHttpResponseHandler){
        RequestParams rp= new RequestParams();
        rp.put("datos",mih);
        this.miCliente.post(this.strUrl, rp, asyncHttpResponseHandler);
    }
    //datos=>contiene los datos de la tabla y operacion a realizar
    public void eliminar_registro(HashMap<String,String> mih,AsyncHttpResponseHandler asyncHttpResponseHandler){
        RequestParams rp= new RequestParams();
        rp.put("datos",mih);
        this.miCliente.post(this.strUrl, rp, asyncHttpResponseHandler);
    }

}
