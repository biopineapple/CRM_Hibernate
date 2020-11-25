/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class Actividad {

    private Integer id;
    private models.Oportunidad oportunidad;
    private String tipo;
    private String descripcion;
    private Date fecha;

    public Actividad() {
        this.tipo = "";
        this.descripcion = "";
        this.fecha = new Date();
    }

    public Actividad(String tipo, String descripcion, Date fecha) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public models.Oportunidad getOportunidad() {
        return oportunidad;
    }

    public void setOportunidad(models.Oportunidad id_oportunidad) {
        this.oportunidad = id_oportunidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actividad other = (Actividad) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.oportunidad, other.oportunidad)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        String idf = String.format("%-5s", id);
        String tipof = String.format("%-12s", tipo);
        String descripcionf = String.format("%-25s", descripcion);
        String fechaf = String.format("%-23s", fecha);
        
        return  "Id: " + idf +
                "Tipo: " + tipof +
                "Descripción: " + descripcionf +
                "Fecha: " + fechaf +"\n";
    }

}
