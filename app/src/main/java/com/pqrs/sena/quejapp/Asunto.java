package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Asunto {
    public static final String TABLA="asunto";
    public static final String CLAVE_ID_ASUNTO="IdAsunto";
    public static final String CLAVE_DESCRIPCION="DescripcionAsunto";

    public int idAsunto;
    public String DescripcionAsunto;

    public int getIdAsunto() {
        return idAsunto;
    }

    public void setIdAsunto(int idAsunto) {
        this.idAsunto = idAsunto;
    }

    public String getDescripcionAsunto() {
        return DescripcionAsunto;
    }

    public void setDescripcionAsunto(String descripcionAsunto) {
        DescripcionAsunto = descripcionAsunto;
    }



}
