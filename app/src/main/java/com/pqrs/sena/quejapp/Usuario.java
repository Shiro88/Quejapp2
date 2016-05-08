package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Usuario extends Persona {
    public static final String TABLA="usuario";
    public static final String CLAVE_NOMBRE_USUARIO="nombreusuario";
    public static final String CLAVE_CONTRASEÑA="contrasenia";

    public String strNombreUsuario;
    public String strContrsenia;

    public String getStrNombreUsuario() {
        return strNombreUsuario;
    }

    public void setStrNombreUsuario(String strNombreUsuario) {
        this.strNombreUsuario = strNombreUsuario;
    }

    public String getStrContrsenia() {
        return strContrsenia;
    }

    public void setStrContrsenia(String strContrsenia) {
        this.strContrsenia = strContrsenia;
    }
}
