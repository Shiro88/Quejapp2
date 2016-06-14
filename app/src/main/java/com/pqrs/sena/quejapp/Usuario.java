package com.pqrs.sena.quejapp;

import java.util.HashMap;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Usuario extends Persona implements IRequestParams{
    public static final String TABLA="usuario";
    public static final String CLAVE_ID_USUARIO="IdUsuario";
    public static final String CLAVE_NOMBRE_USUARIO="Nombres";
    public static final String CLAVE_APELLIDO_USUARIO="Apellidos";
    public static final String CLAVE_TIPO_IDENTIFICACION="TipoIdentificacion";
    public static final String CLAVE_DOCUMENTO="Identificacion";
    public static final String CLAVE_CORREO="Correo";
    public static final String CLAVE_DIRECCION="Direccion";
    public static final String CLAVE_GENERO="Genero";




    public static final String CLAVE_CONTRASENIA="contrasenia";

    public int intIdUsuario;
    public String strNombres;
    public String strApellidos;
    public String strIdentificacion;
    public String strTipoIdentificacion;
    public String strCorreo;
    public String strDireccion;
    public String strGenero;

    public String strContrasenia;


    public String getStrContrasenia() {
        return strContrasenia;
    }

    public void setStrContrasenia(String strContrsenia) {
        this.strContrasenia = strContrsenia;
    }
    public int getIntIdUsuario() {
        return intIdUsuario;
    }

    public void setIntId_Persona(int intIdUsuario) {
        this.intIdUsuario = intIdUsuario;
    }

    public String getStrNombres() {
        return strNombres;
    }

    public void setStrNombres(String strNombres) {
        this.strNombres = strNombres;
    }

    public String getStrApellidos() {
        return strApellidos;
    }

    public void setStrApellidos(String strApellidos) {
        this.strApellidos = strApellidos;
    }

    public String getStrIdentificacion() {
        return strIdentificacion;
    }

    public void setStrIdentificacion(String strIdentificacion) {
        this.strIdentificacion = strIdentificacion;
    }

    public String getStrTipoIdentificacion() {
        return strTipoIdentificacion;
    }

    public void setStrTipoIdentificacion(String strTipoIdentificacion) {this.strTipoIdentificacion = strTipoIdentificacion;   }

    public String getStrCorreo() {
        return strCorreo;
    }

    public void setStrCorreo(String strCorreo) {
        this.strCorreo = strCorreo;
    }

    public String getStrDireccion() {
        return strDireccion;
    }

    public void setStrDireccion(String strDireccion) {
        this.strDireccion = strDireccion;
    }

    public String getStrGenero() {
        return strGenero;
    }

    public void setStrGenero(String strGenero) {
        this.strGenero = strGenero;
    }

    @Override
    public HashMap<String, String> getRequestParamsConsultar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_NOMBRE_USUARIO",CLAVE_NOMBRE_USUARIO);
        mih.put("CLAVE_APELLIDO_USUARIO",CLAVE_APELLIDO_USUARIO);
        mih.put("CLAVE_CONTRASENIA",CLAVE_CONTRASENIA);
        mih.put("CLAVE_TIPO_IDENTIFICACION",CLAVE_TIPO_IDENTIFICACION);
        mih.put("CLAVE_DOCUMENTO",CLAVE_DOCUMENTO);
        mih.put("CLAVE_CORREO",CLAVE_CORREO);
        mih.put("CLAVE_DIRECCION",CLAVE_DIRECCION);
        mih.put("CLAVE_GENERO",CLAVE_GENERO);
        mih.put("OPERACION","consultar");
        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsConsultar(String where, String campoUno, String comparador, String campoDos, String orden, String grupo, String limite) {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_USUARIO",CLAVE_ID_USUARIO);
        mih.put("CLAVE_NOMBRE_USUARIO",CLAVE_NOMBRE_USUARIO);
        mih.put("CLAVE_APELLIDO_USUARIO",CLAVE_APELLIDO_USUARIO);
        mih.put("CLAVE_CONTRASENIA",CLAVE_CONTRASENIA);
        mih.put("CLAVE_TIPO_IDENTIFICACION",CLAVE_TIPO_IDENTIFICACION);
        mih.put("CLAVE_DOCUMENTO",CLAVE_DOCUMENTO);
        mih.put("CLAVE_CORREO",CLAVE_CORREO);
        mih.put("CLAVE_DIRECCION",CLAVE_DIRECCION);
        mih.put("CLAVE_GENERO",CLAVE_GENERO);

        mih.put("VALOR_NOMBRE_USUARIO",this.getStrNombres());
        mih.put("VALOR_APELLIDO_USUARIO",this.getStrApellidos());
        mih.put("VALOR_CONTRASENIA",this.getStrContrasenia());
        mih.put("VALOR_TIPO_IDENTIFICACION",this.getStrTipoIdentificacion());
        mih.put("VALOR_DOCUMENTO",this.getStrIdentificacion());
        mih.put("VALOR_CORREO",this.getStrCorreo());
        mih.put("VALOR_DIRECCION",this.getStrDireccion());
        mih.put("VALOR_GENERO",this.getStrGenero());
        mih.put("VALOR_ID_USUARIO", Integer.toString(this.getIntIdUsuario()));
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
        mih.put("CLAVE_NOMBRE_USUARIO",CLAVE_NOMBRE_USUARIO);
        mih.put("CLAVE_APELLIDO_USUARIO",CLAVE_APELLIDO_USUARIO);
        mih.put("CLAVE_CONTRASENIA",CLAVE_CONTRASENIA);
        mih.put("CLAVE_TIPO_IDENTIFICACION",CLAVE_TIPO_IDENTIFICACION);
        mih.put("CLAVE_DOCUMENTO",CLAVE_DOCUMENTO);
        mih.put("CLAVE_CORREO",CLAVE_CORREO);
        mih.put("CLAVE_DIRECCION",CLAVE_DIRECCION);
        mih.put("CLAVE_GENERO",CLAVE_GENERO);


        mih.put("VALOR_NOMBRE_USUARIO",this.getStrNombres());
        mih.put("VALOR_APELLIDO_USUARIO",this.getStrApellidos());
        mih.put("VALOR_CONTRASENIA",this.getStrContrasenia());
        mih.put("VALOR_TIPO_IDENTIFICACION",this.getStrTipoIdentificacion());
        mih.put("VALOR_DOCUMENTO",this.getStrIdentificacion());
        mih.put("VALOR_CORREO",this.getStrCorreo());
        mih.put("VALOR_DIRECCION",this.getStrDireccion());
        mih.put("VALOR_GENERO",this.getStrGenero());
        mih.put("OPERACION","insertar");
        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsActualizar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_USUARIO",CLAVE_ID_USUARIO);
        mih.put("CLAVE_NOMBRE_USUARIO",CLAVE_NOMBRE_USUARIO);
        mih.put("CLAVE_APELLIDO_USUARIO",CLAVE_APELLIDO_USUARIO);
        mih.put("CLAVE_CONTRASENIA",CLAVE_CONTRASENIA);
        mih.put("CLAVE_TIPO_IDENTIFICACION",CLAVE_TIPO_IDENTIFICACION);
        mih.put("CLAVE_DOCUMENTO",CLAVE_DOCUMENTO);
        mih.put("CLAVE_CORREO",CLAVE_CORREO);
        mih.put("CLAVE_DIRECCION",CLAVE_DIRECCION);
        mih.put("CLAVE_GENERO",CLAVE_GENERO);

        mih.put("VALOR_NOMBRE_USUARIO",this.getStrNombres());
        mih.put("VALOR_APELLIDO_USUARIO",this.getStrApellidos());
        mih.put("VALOR_CONTRASENIA",this.getStrContrasenia());
        mih.put("VALOR_TIPO_IDENTIFICACION",this.getStrTipoIdentificacion());
        mih.put("VALOR_DOCUMENTO",this.getStrIdentificacion());
        mih.put("VALOR_CORREO", this.getStrCorreo());
        mih.put("VALOR_DIRECCION",this.getStrDireccion());
        mih.put("VALOR_GENERO",this.getStrGenero());

        mih.put("OPERACION","actualizar");
        return mih;
    }

    @Override
    public HashMap<String, String> getRequestParamsEliminar() {
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA",TABLA);
        mih.put("CLAVE_ID_USUARIO",CLAVE_ID_USUARIO);
        mih.put("VALOR_ID_USUARIO", Integer.toString(this.getIntIdUsuario()));
        mih.put("OPERACION","eliminar");
        return mih;
    }


    public HashMap<String,String> getRequestParamsLogIn(){
        HashMap<String,String> mih= new HashMap<>();
        mih.put("TABLA","login");
        mih.put("OPERACION","consultar");
        mih.put("CLAVE_CORREO",CLAVE_CORREO);
        mih.put("CLAVE_CONTRASENIA",CLAVE_CONTRASENIA);
        mih.put("VALOR_CONTRASENIA",this.getStrContrasenia());
        mih.put("VALOR_CORREO", this.getStrCorreo());
        return    mih;

    }
}
