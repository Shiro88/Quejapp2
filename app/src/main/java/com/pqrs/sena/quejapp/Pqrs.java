package com.pqrs.sena.quejapp;

import java.util.HashMap;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Pqrs implements  IRequestParams{
    public static final String TABLA="pqrs";
    public static final String CLAVE_ID_PQRS="IdPqrs";
    public static final String CLAVE_FK_ID_SEDE="Fk_Id_Sede";
    public static final String CLAVE_FK_ID_TPETICION="Fk_Id_TPeticion";
    public static final String CLAVE_DESCRIPCION="Descripcion";
    public static final String CLAVE_FK_ID_USUARIO="Fk_Id_Usuario";

    private int intIdPqrs;
    private int intSede;

    public int getIntIdPqrs() {
        return intIdPqrs;
    }

    public void setIntIdPqrs(int intIdPqrs) {
        this.intIdPqrs = intIdPqrs;
    }

    public int getIntSede() {
        return intSede;
    }

    public void setIntSede(int intSede) {
        this.intSede = intSede;
    }

    public int getIntTipoPeticion() {
        return intTipoPeticion;
    }

    public void setIntTipoPeticion(int intTipoPeticion) {
        this.intTipoPeticion = intTipoPeticion;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public int getIntFk_IdUsuario() {
        return intFk_IdUsuario;
    }

    public void setIntFk_IdUsuario(int intFk_IdUsuario) {
        this.intFk_IdUsuario = intFk_IdUsuario;
    }

    private int intTipoPeticion;
    private String strDescripcion;
    private int intFk_IdUsuario;



    @Override
    public HashMap<String, String> getRequestParamsConsultar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);



        mih.put("OPERACION","consultar");
        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsConsultar(String where, String campoUno, String comparador, String campoDos, String orden, String grupo, String limite) {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);

        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));
        mih.put("VALOR_FK_ID_SEDE",Integer.toString(this.getIntSede()));
        mih.put("VALOR_FK_ID_TPETICION",Integer.toString(this.getIntTipoPeticion()));
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",Integer.toString(this.getIntFk_IdUsuario()));

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

    @Override
    public HashMap<String, String> getRequestParamsInsertar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);
        mih.put("VALOR_FK_ID_SEDE",Integer.toString(this.getIntSede()));
        mih.put("VALOR_FK_ID_TPETICION",Integer.toString(this.getIntTipoPeticion()));
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",Integer.toString(this.getIntFk_IdUsuario()));

        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsActualizar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);
        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));
        mih.put("VALOR_FK_ID_SEDE",Integer.toString(this.getIntSede()));
        mih.put("VALOR_FK_ID_TPETICION",Integer.toString(this.getIntTipoPeticion()));
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",Integer.toString(this.getIntFk_IdUsuario()));

        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsEliminar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));


        return mih;
    }
}
