/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Pablo Martínez y Santiago Ucero.
 */
public class Cliente {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String empresa;
    private String telefono;
    private String email;

    private Set<models.Oportunidad> oportunidades;

    public Cliente() {
        this.nombre = "";
        this.apellidos = "";
        this.empresa = "";
        this.telefono = "";
        this.email = "";
        this.oportunidades = new HashSet(0);
    }

    public Cliente(String nombre, String apellidos, String empresa, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.telefono = telefono;
        this.email = email;
        this.oportunidades = new HashSet(0);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Oportunidad> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(Set<Oportunidad> oportunidades) {
        this.oportunidades = oportunidades;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.oportunidades, other.oportunidades)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", empresa=" + empresa + ", telefono=" + telefono + ", email=" + email + '}';
    }

}
