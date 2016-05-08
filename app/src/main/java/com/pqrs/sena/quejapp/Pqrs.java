package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Pqrs {
    public static final String TABLA="pqrs";
    public static final String CLAVE_ID_PQRS="IdPqrs";
    public static final String CLAVE_DESCRIPCION="Descripcion";
    public static final String CLAVE_ID_ASUNTO_FK="Fk_Id_Asunto";
    public static final String CLAVE_ID_MEDIO_NOTIFICACION="Fk_Id_MNotificacion";
    public static final String CLAVE_ID_SEDE="Fk_Id_Sede";
    public static final String CLAVE_ID_TIPO_PETICION="Fk_Id_TPeticion";

    //Definicion de atributos de la clase PQRS (Peticiones quejas reclamos y sugerencias
    public int intIdPqrs;
    public String strDescripcion;
    public int intFk_Id_Asunto;
    public int intFk_Id_MNotificacion;
    public int intFk_Id_Sede;
    public int intFk_id_TPeticion;


    public int getIntIdPqrs() {
        return intIdPqrs;
    }

    public void setIntIdPqrs(int intIdPqrs) {
        this.intIdPqrs = intIdPqrs;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }

    public int getIntFk_Id_Asunto() {
        return intFk_Id_Asunto;
    }

    public void setIntFk_Id_Asunto(int intFk_Id_Asunto) {
        this.intFk_Id_Asunto = intFk_Id_Asunto;
    }

    public int getIntFk_Id_MNotificacion() {
        return intFk_Id_MNotificacion;
    }

    public void setIntFk_Id_MNotificacion(int intFk_Id_MNotificacion) {
        this.intFk_Id_MNotificacion = intFk_Id_MNotificacion;
    }

    public int getIntFk_Id_Sede() {
        return intFk_Id_Sede;
    }

    public void setIntFk_Id_Sede(int intFk_Id_Sede) {
        this.intFk_Id_Sede = intFk_Id_Sede;
    }

    public int getIntFk_id_TPeticion() {
        return intFk_id_TPeticion;
    }

    public void setIntFk_id_TPeticion(int intFk_id_TPeticion) {
        this.intFk_id_TPeticion = intFk_id_TPeticion;
    }




}
