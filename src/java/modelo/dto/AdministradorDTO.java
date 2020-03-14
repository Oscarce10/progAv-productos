/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author USER
 */
public class AdministradorDTO {
    private int id;
    private String nombre, apellido, correo, clave, salt;

    public AdministradorDTO() {
    }

    public AdministradorDTO(int id) {
        this.id = id;
    }
    

    public AdministradorDTO(int id, String nombre, String apellido, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    

    public AdministradorDTO(int id, String nombre, String apellido, String correo, String clave, String salt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.salt = salt;
    }
    
    

    public AdministradorDTO(String nombre, String apellido, String correo, String clave, String salt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
        this.salt = salt;
    }

    public AdministradorDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public AdministradorDTO(String correo, String clave, String salt) {
        this.correo = correo;
        this.clave = clave;
        this.salt = salt;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "AdministradorDTO{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", clave=" + clave + ", salt=" + salt + '}';
    }

    
    
    
    
}
