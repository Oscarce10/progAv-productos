/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author Estudiante
 */
public class ClienteDTO {
    
    private int id;
    private String nit, razon_social, nombre_rl, apellido_rl, num_doc_rl, telefono, celular, correo, direccion, descripcion;
    private char tipo_persona;

    public ClienteDTO(int id, String nit, String razon_social, String nombre_rl, String apellido_rl, String num_doc_rl, String telefono, String celular, String correo, String direccion, String descripcion, char tipo_persona) {
        this.id = id;
        this.nit = nit;
        this.razon_social = razon_social;
        this.nombre_rl = nombre_rl;
        this.apellido_rl = apellido_rl;
        this.num_doc_rl = num_doc_rl;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.tipo_persona = tipo_persona;
    }

    public ClienteDTO(String nit, String razon_social, String nombre_rl, String apellido_rl, String num_doc_rl, String telefono, String celular, String correo, String direccion, String descripcion, char tipo_persona) {
        this.nit = nit;
        this.razon_social = razon_social;
        this.nombre_rl = nombre_rl;
        this.apellido_rl = apellido_rl;
        this.num_doc_rl = num_doc_rl;
        this.telefono = telefono;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.tipo_persona = tipo_persona;
    }

    public ClienteDTO() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_rl() {
        return nombre_rl;
    }

    public void setNombre_rl(String nombre_rl) {
        this.nombre_rl = nombre_rl;
    }

    public String getApellido_rl() {
        return apellido_rl;
    }

    public void setApellido_rl(String apellido_rl) {
        this.apellido_rl = apellido_rl;
    }

    public String getNum_doc_rl() {
        return num_doc_rl;
    }

    public void setNum_doc_rl(String num_doc_rl) {
        this.num_doc_rl = num_doc_rl;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(char tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    @Override
    public String toString() {
        return "PersonaDTO{" + "id=" + id + ", nit=" + nit + ", razon_social=" + razon_social + ", nombre_rl=" + nombre_rl + ", apellido_rl=" + apellido_rl + ", num_doc_rl=" + num_doc_rl + ", telefono=" + telefono + ", celular=" + celular + ", correo=" + correo + ", direccion=" + direccion + ", descripcion=" + descripcion + ", tipo_persona=" + tipo_persona + '}';
    }

    
    
}
