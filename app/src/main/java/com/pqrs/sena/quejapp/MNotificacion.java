package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 * Clase para obtener el medio de notificacion de la respuesta
 */
public class MNotificacion {
    public static final String TABLA="mnotificacion";
    public static final String CLAVE_ID_MEDIO_NOTIFICACION="IdMNotificacion";
    public static final String CLAVE_DESCRIPCION="Descripcion";

    public int intIdMNOtificacion;
    public String strDescripcion;

    public int getIntIdMNOtificacion() {
        return intIdMNOtificacion;
    }

    public void setIntIdMNOtificacion(int intIdMNOtificacion) {
        this.intIdMNOtificacion = intIdMNOtificacion;
    }

    public String getStrDescripcion() {
        return strDescripcion;
    }

    public void setStrDescripcion(String strDescripcion) {
        this.strDescripcion = strDescripcion;
    }
}
