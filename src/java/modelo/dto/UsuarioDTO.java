/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.io.Serializable;

/**
 *
 * @author Estudiante
 */
public class UsuarioDTO implements Serializable{
    private int id, tipo;
    String nombre, apellido, correo, clave;

    public UsuarioDTO(int id, int tipo, String nombre, String apellido, String correo, String clave) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public UsuarioDTO(int tipo, String nombre, String apellido, String correo, String clave) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public UsuarioDTO() {
    }

    public UsuarioDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "SesionDTO{" + "id=" + id + ", tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", clave=" + clave + '}';
    }
    
    
}


