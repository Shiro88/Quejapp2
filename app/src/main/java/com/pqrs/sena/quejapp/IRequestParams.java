package com.pqrs.sena.quejapp;



import java.util.HashMap;

/**
 * Created by Chaquen on 25/05/2016.
 */
public interface IRequestParams {
    public HashMap <String,String> getRequestParamsConsultar();
    public HashMap <String,String> getRequestParamsConsultar(String where,String campoUno,String comparador,String campoDos,String orden,String grupo,String limite);
    public HashMap<String,String> getRequestParamsInsertar();
    public HashMap<String,String> getRequestParamsActualizar();
    public HashMap<String,String> getRequestParamsEliminar();
}
