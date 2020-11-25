/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class Oportunidad {

    private Integer id;
    private models.Cliente cliente;
    private String descripcion;
    private BigDecimal valor;
    private Date fecha;
    private String nivel;
    private String estado;

    private Set<models.Actividad> actividades;

    public Oportunidad() {
        this.descripcion = "";
        this.valor = new BigDecimal(0);
        this.fecha = new Date();
        this.nivel = "";
        this.estado = "";
        this.actividades = new HashSet(0);
    }

    public Oportunidad(models.Cliente cliente, String descripcion, BigDecimal valor, Date fecha, String nivel, String estado) {
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.valor = valor;
        this.fecha = fecha;
        this.nivel = nivel;
        this.estado = estado;
        this.actividades = new HashSet(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public models.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(models.Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
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
        final Oportunidad other = (Oportunidad) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.nivel, other.nivel)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.valor, other.valor)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.actividades, other.actividades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        String idf = String.format("%-5s", id);
        String descripcionf = String.format("%-25s", descripcion);
        String valorf = String.format("%-10s", valor);
        String fechaf = String.format("%-20s", fecha);
        String nivelf = String.format("%-13s", nivel);
        String estadof = String.format("%-30s", estado);
        
        return  "Id: " + idf +
                "Descripción: " + descripcionf +
                "Valor: " + valorf +
                "Fecha: " + fechaf +
                "Nivel: " + nivelf +
                "Estado: " + estadof +"\n";
    }
}
