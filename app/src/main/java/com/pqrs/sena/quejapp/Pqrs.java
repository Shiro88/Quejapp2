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

    public int intIdPqrs;
    public String strDescripcion;
    public int intFk_Id_Asunto;
    public int intFk_Id_MNotificacion;
    public int intFk_Id_Sede;
    public int intFk_id_TPeticion;



}
