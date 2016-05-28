package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class GrupoInteres {
    public static final String TABLA="grupo_de_interes";
    public static final String CLAVE_ID_GRUPO_INTERES="IDGrupoInteres";
    public static final String CLAVE_NOMBRE_GRUPO_INTERES="NombreGrupoInteres";

    public int intIdGrupoInteres;
    public String strNombreGrupoInteres;

    public int getIntIdGrupoInteres() {
        return intIdGrupoInteres;
    }

    public void setIntIdGrupoInteres(int intIdGrupoInteres) {
        this.intIdGrupoInteres = intIdGrupoInteres;
    }

    public String getStrNombreGrupoInteres() {
        return strNombreGrupoInteres;
    }

    public void setStrNombreGrupoInteres(String strNombreGrupoInteres) {
        this.strNombreGrupoInteres = strNombreGrupoInteres;
    }
}
