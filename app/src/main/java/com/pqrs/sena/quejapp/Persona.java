package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Persona {
    public static final String TABLA="Persona";
    public static final String CLAVE_NOMBRE="Nombres";
    public static final String CLAVE_APELLIDOS="Apellidos";
    public static final String CLAVE_IDENTIFICACION="Identificacion";
    public static final String CLAVE_TIPO_IDENTIFICACION="TipoIdentificacion";
    public static final String CLAVE_CORREO="Correo";
    public static final String CLAVE_DIRECCION="Direccion";
    public static final String CLAVE_GENERO="Genero";


    public int intId_Persona;
    public String strNombres;
    public String strApellidos;
    public String strIdentificacion;
    public String strTipoIdentificacion;
    public String strCorreo;
    public String strDireccion;
    public String strGenero;

    public int getIntId_Persona() {
        return intId_Persona;
    }

    public void setIntId_Persona(int intId_Persona) {
        this.intId_Persona = intId_Persona;
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

    public void setStrTipoIdentificacion(String strTipoIdentificacion) {
        this.strTipoIdentificacion = strTipoIdentificacion;
    }

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
}
