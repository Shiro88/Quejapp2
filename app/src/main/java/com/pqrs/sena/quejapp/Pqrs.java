package com.pqrs.sena.quejapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Pqrs implements  IRequestParams{
    public static final String TABLA="pqrs2";
    public static final String CLAVE_ID_PQRS="IdPqrs";
    public static final String CLAVE_FK_ID_SEDE="Fk_Id_Sede";
    public static final String CLAVE_FK_ID_TPETICION="Fk_Id_TPeticion";
    public static final String CLAVE_FK_ID_TCATEGORIA="Fk_Id_TCategoria";
    public static final String CLAVE_DESCRIPCION="Descripcion";
    public static final String CLAVE_FK_ID_USUARIO="Fk_Id_Usuario";
    public static final String CLAVE_CODIGO_PQRS="CodigoPQRS";

    private int intIdPqrs;
    private String strSede;
    private String strTipoPeticion;
    private String strTipoCategoriaPeticion;
    private String strCodigoPqrs;



    public String getStrCodigoPqrs() {
        return strCodigoPqrs;
    }

    public void setStrCodigoPqrs(String strCodigoPqrs) {
        this.strCodigoPqrs = strCodigoPqrs;
    }



    public int getIntIdPqrs() {
        return intIdPqrs;
    }

    public void setIntIdPqrs(int intIdPqrs) {
        this.intIdPqrs = intIdPqrs;
    }

    public String getStrSede() {
        return strSede;
    }

    public void setStrSede(String strSede) {
        this.strSede = strSede;
    }

    public String getStrTipoPeticion() {
        return strTipoPeticion;
    }

    public void setStrTipoPeticion(String strTipoPeticion) {
        this.strTipoPeticion = strTipoPeticion;
    }

    public String getStrTipoCategoriaPeticion() {
        return strTipoCategoriaPeticion;
    }

    public void setStrTipoCategoriaPeticion(String strTipoCategoriaPeticion) {
        this.strTipoCategoriaPeticion = strTipoCategoriaPeticion;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public String getStrFk_IdUsuario() {
        return strFk_IdUsuario;
    }

    public void setStrFk_IdUsuario(String strFk_IdUsuario) {
        this.strFk_IdUsuario = strFk_IdUsuario;
    }

    private String strDescripcion;
    private String strFk_IdUsuario;


    @Override
    public HashMap<String, String> getRequestParamsConsultar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);
        mih.put("CLAVE_CODIGO_PQRS",CLAVE_CODIGO_PQRS);
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
        mih.put("CLAVE_FK_ID_TCATEGORIA",CLAVE_FK_ID_TCATEGORIA);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);

        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));
        mih.put("VALOR_FK_ID_SEDE",this.getStrSede());
        mih.put("VALOR_FK_ID_TPETICION",this.getStrTipoPeticion());
        mih.put("VALOR_FK_ID_TCATEGORIA",this.getStrTipoCategoriaPeticion());
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",this.getStrFk_IdUsuario());

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
        mih.put("OPERACION","insertar");
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);
        mih.put("CLAVE_FK_ID_TCATEGORIA",CLAVE_FK_ID_TCATEGORIA);

        mih.put("VALOR_FK_ID_TCATEGORIA",this.getStrTipoCategoriaPeticion());
        mih.put("VALOR_FK_ID_SEDE",this.getStrSede());
        mih.put("VALOR_FK_ID_TPETICION",this.getStrTipoPeticion());
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",this.getStrFk_IdUsuario());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mih.put("VALOR_FECHA_REGISTRO",simpleDateFormat.format(new Date()));
        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsActualizar() {
        HashMap<String,String> mih= new HashMap<>();

        mih.put("TABLA",TABLA);
        mih.put("OPERACION","actualizar");
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("CLAVE_FK_ID_SEDE",CLAVE_FK_ID_SEDE);
        mih.put("CLAVE_FK_ID_TPETICION",CLAVE_FK_ID_TPETICION);
        mih.put("CLAVE_DESCRIPCION",CLAVE_DESCRIPCION);
        mih.put("CLAVE_FK_ID_USUARIO",CLAVE_FK_ID_USUARIO);
        mih.put("CLAVE_FK_ID_TCATEGORIA",CLAVE_FK_ID_TCATEGORIA);

        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));
        mih.put("VALOR_FK_ID_SEDE",this.getStrSede());
        mih.put("VALOR_FK_ID_TPETICION",this.getStrTipoPeticion());
        mih.put("VALOR_DESCRIPCION",this.getStrDescripcion());
        mih.put("VALOR_FK_ID_USUARIO",this.getStrFk_IdUsuario());
        mih.put("VALOR_FK_ID_TCATEGORIA",this.getStrTipoCategoriaPeticion());

        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsEliminar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("OPERACION","eliminar");
        mih.put("CLAVE_ID_PQRS",CLAVE_ID_PQRS);
        mih.put("VALOR_ID_PQRS", Integer.toString(this.getIntIdPqrs()));


        return mih;
    }
}
