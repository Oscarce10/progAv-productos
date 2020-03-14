/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Hashing;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.AdministradorDTO;

/**
 *
 * @author USER
 */
public class AdministradorDAO extends Obligacion<AdministradorDTO>{

    
    public AdministradorDAO() {
        super("administrador", "nombre, apellido, correo, clave, salt", "?, ?, ?, ?, ?", "", "");
    }
    

    @Override
    public boolean create(AdministradorDTO ob) {
        System.out.println(this.getSQL_INSERT());
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(this.getSQL_INSERT());
            ps.setString(1, ob.getNombre());
            ps.setString(2, ob.getApellido());
            ps.setString(3, ob.getCorreo());
            ps.setString(4, ob.getClave());
            ps.setString(5, ob.getSalt());
            System.out.println(ps.toString());
            if(ps.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public List<AdministradorDTO> readAll() {
        PreparedStatement ps;
        List <AdministradorDTO> adm = null;
        try {            
            ps = con.getCon().prepareStatement(this.getSQL_READALL());
            ResultSet rs;
            rs = ps.executeQuery();
            while(rs.next()){
               adm.add(new AdministradorDTO(
                       rs.getInt(1), 
                       rs.getString(2), 
                       rs.getString(3), 
                       rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return adm;
    }

    @Override
    public AdministradorDTO read(AdministradorDTO administrador) {
        try {
            PreparedStatement ps;
            ps = con.getCon().prepareStatement("SELECT * FROM administrador WHERE id = ?");
            ps.setInt(1, administrador.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                administrador.setNombre(rs.getString("nombre"));
                administrador.setApellido(rs.getString("apellido"));
                administrador.setCorreo(rs.getString("correo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administrador;
    }

    @Override
    public boolean update(AdministradorDTO prod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(AdministradorDTO id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public AdministradorDTO checkAdm(AdministradorDTO adm){
        AdministradorDTO res = null;
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement("SELECT correo, clave, salt FROM administrador WHERE correo LIKE ?");
            ps.setString(1, adm.getCorreo());
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
                AdministradorDTO ad = new AdministradorDTO(rs.getString(1), rs.getString(2), rs.getString(3));
                ps = con.getCon().prepareStatement("SELECT * FROM administrador WHERE correo LIKE ? AND clave LIKE ?");
                ps.setString(1, adm.getCorreo());
                ps.setString(2, Hashing.generarClave(ad.getSalt(), adm.getClave()));
                rs = ps.executeQuery();
                if(rs.next()){
                    res = new AdministradorDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("correo"));
                }
            }
        } catch (SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
}
