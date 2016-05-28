package com.pqrs.sena.quejapp;

import java.util.HashMap;

/**
 * Created by Chaquen on 16/05/2016.
 */
public class Regional implements IRequestParams{
    public String getTABLA() {
        return TABLA;
    }

    public static final String TABLA="regional";
    public static final String CLAVE_FK_ID_EMPRESA="FK_Id_Empresa";
    public static final String CLAVE_NOMBRE_REGIONAL="NombreRegional";


    public String getStrIdEmpresa() {
        return strIdEmpresa;
    }

    public void setStrIdEmpresa(String strIdEmpresa) {
        this.strIdEmpresa = strIdEmpresa;
    }

    public String getStrNombreRegional() {
        return strNombreRegional;
    }

    public void setStrNombreRegional(String strNombreRegional) {
        this.strNombreRegional = strNombreRegional;
    }

    public String strIdEmpresa;
    public String strNombreRegional;

    public Regional() {
    }

    public Regional(String strIdEmpresa, String strNombreRegional) {
        this.strIdEmpresa = strIdEmpresa;
        this.strNombreRegional = strNombreRegional;
    }
    public HashMap <String,String> getRequestParamsConsultar(){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("tabla",TABLA);
        mih.put("CLAVE_FK_ID_EMPRESA",CLAVE_FK_ID_EMPRESA);
        mih.put("CLAVE_NOMBRE_REGIONAL",CLAVE_NOMBRE_REGIONAL);
        mih.put("OPERACION","consultar");
        return mih;
    }
    public HashMap <String,String> getRequestParamsConsultar(String where,String campoUno,String comparador,String campoDos,String orden,String grupo,String limite){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("tabla",TABLA);
        mih.put("CLAVE_FK_ID_EMPRESA",CLAVE_FK_ID_EMPRESA);
        mih.put("CLAVE_NOMBRE_REGIONAL",CLAVE_NOMBRE_REGIONAL);
        mih.put("VALOR_FK_ID_EMPRESA",this.getStrIdEmpresa());
        mih.put("VALOR_NOMBRE_REGIONAL",this.getStrNombreRegional());

        mih.put("OPERACION","consultar");
        if(where!=null){
            mih.put("WHERE",where);
        }
        if(campoUno!=null){
            mih.put("CAMPOUNO",campoUno);
        }
        if(campoDos!=null){
            mih.put("CAMPODOS",campoDos);
        }
        if(comparador!=null){
            mih.put("COMPARADOR",comparador);
        }

        if(orden!=null){
            mih.put("ORDER BY",orden);
        }
        if(limite!=null){
            mih.put("LIMIT",limite);
        }
        if(grupo!=null){
            mih.put("GROUP BY",grupo);
        }

        return mih;
    }


    public HashMap<String,String> getRequestParamsInsertar(){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_FK_ID_EMPRESA",CLAVE_FK_ID_EMPRESA);
        mih.put("CLAVE_NOMBRE_REGIONAL",CLAVE_NOMBRE_REGIONAL);
        mih.put("VALOR_FK_ID_EMPRESA",this.getStrIdEmpresa());
        mih.put("VALOR_NOMBRE_REGIONAL",this.getStrNombreRegional());
        mih.put("OPERACION","insertar");
        return mih;
    }
    public HashMap<String,String> getRequestParamsActualizar(){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_FK_ID_EMPRESA",CLAVE_FK_ID_EMPRESA);
        mih.put("CLAVE_NOMBRE_REGIONAL",CLAVE_NOMBRE_REGIONAL);
        mih.put("VALOR_FK_ID_EMPRESA",this.getStrIdEmpresa());
        mih.put("VALOR_NOMBRE_REGIONAL",this.getStrNombreRegional());
        mih.put("OPERACION","actualizar");
        return mih;
    }
    public HashMap<String,String> getRequestParamsEliminar(){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_REGIONAL",CLAVE_FK_ID_EMPRESA);
        mih.put("VALOR_ID_REGIONAL",this.getStrIdEmpresa());
        mih.put("OPERACION","eliminar");
        return mih;
    }

}

