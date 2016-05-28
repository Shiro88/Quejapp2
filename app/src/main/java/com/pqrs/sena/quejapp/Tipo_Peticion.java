package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Tipo_Peticion {
    public static String TABLA="tpeticion";
    public static String CLAVE_ID_TIPO_PETICION="IdTPeticion";
    public static String CLAVE_DESCRIPCION_TIPO_PETICION="DescripcionTPeticion";

    public int intIdTPeticion;
    public String strDescripcionTPeticion;

    public int getIntIdTPeticion() {
        return intIdTPeticion;
    }

    public void setIntIdTPeticion(int intIdTPeticion) {
        this.intIdTPeticion = intIdTPeticion;
    }

    public String getStrDescripcionTPeticion() {
        return strDescripcionTPeticion;
    }

    public void setStrDescripcionTPeticion(String strDescripcionTPeticion) {
        this.strDescripcionTPeticion = strDescripcionTPeticion;
    }
}
