package com.pqrs.sena.quejapp;

/**
 * Created by Usaurio on 08/05/2016.
 */
public class Sede {
    public static final String TABLA="sede";
    public static final String CLAVE_ID_SEDE="IdSede";
    public static final String CLAVE_NOMBRE_SEDE="NombreSede";
    public static final String CLAVE_FK_ID_CENTRO="Fk_Id_Centro";

    public int intIdSede;
    public String strNombreSede;
    public int intFk_Id_Centro;

    public int getIntIdSede() {
        return intIdSede;
    }

    public void setIntIdSede(int intIdSede) {
        this.intIdSede = intIdSede;
    }

    public String getStrNombreSede() {
        return strNombreSede;
    }

    public void setStrNombreSede(String strNombreSede) {
        this.strNombreSede = strNombreSede;
    }

    public int getIntFk_Id_Centro() {
        return intFk_Id_Centro;
    }

    public void setIntFk_Id_Centro(int intFk_Id_Centro) {
        this.intFk_Id_Centro = intFk_Id_Centro;
    }
}
