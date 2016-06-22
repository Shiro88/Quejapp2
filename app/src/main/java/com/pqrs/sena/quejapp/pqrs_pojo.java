package com.pqrs.sena.quejapp;

/**
 * Created by hernando on 21/06/2016.
 */
public class pqrs_pojo {
    private String fecha;
    private String descripcion;
    private String estado;
    private String codigo;

    public pqrs_pojo(String fecha, String descripcion, String estado, String codigo) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.codigo = codigo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }
}
