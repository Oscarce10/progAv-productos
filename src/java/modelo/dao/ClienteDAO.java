/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.ClienteDTO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Estudiante
 */
public class ClienteDAO {
    private static final String SQL_INSERT = "INSERT INTO cliente"
            + "(nit, razon_social, nombre_rl, apellido_rl,"
            + "num_doc_rl,telefono,celular,correo,direccion,"
            + "tipo_persona,descripcion) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    
    private static final String SQL_READ = "SELECT * FROM cliente WHERE id = ?;";
    
    private static final String SQL_READALL = "SELECT * FROM cliente;";
    
    private static final String SQL_UPDATE = "UPDATE cliente SET nit = ?, "
            + "razon_social = ?, nombre_rl = ?, apellido_rl = ?, num_doc_rl = ?, "
            + "telefono = ?, celular = ?, correo = ?, "
            + "direccion = ?,tipo_persona = ?,descripcion = ? "
            + "  WHERE id = ?;";
    
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id = ?;";
    
    public static final ConexionMysql con = ConexionMysql.getInstance();
    
    public boolean create(ClienteDTO c){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, c.getNit());
            ps.setString(2, c.getRazon_social());
            ps.setString(3, c.getNombre_rl());
            ps.setString(4, c.getApellido_rl());
            ps.setString(5, c.getNum_doc_rl());
            ps.setString(6, c.getTelefono());
            ps.setString(7, c.getCelular());
            ps.setString(8, c.getCorreo());
            ps.setString(9, c.getDireccion());
            ps.setString(10,String.valueOf(c.getTipo_persona()));
            ps.setString(11, c.getDescripcion());
            
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public List<ClienteDTO> readAll(){
        List<ClienteDTO> list = null;
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                ClienteDTO ob = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
                        , rs.getString(5),rs.getString(6),rs.getString(7)
                        ,rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12).charAt(0));
                list.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        
        return list;
        
    }
    
    public ClienteDTO read(int id){
        PreparedStatement ps;
        ClienteDTO clie = null;
        try {            
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clie = new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
                        , rs.getString(5),rs.getString(6),rs.getString(7)
                        ,rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12).charAt(0));
                System.out.println(clie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return clie;
    }
    
    public boolean update(ClienteDTO c){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setString(1, c.getNit());
            ps.setString(2, c.getRazon_social());
            ps.setString(3, c.getNombre_rl());
            ps.setString(4, c.getApellido_rl());
            ps.setString(5, c.getNum_doc_rl());
            ps.setString(6, c.getTelefono());
            ps.setString(7, c.getCelular());
            ps.setString(8, c.getCorreo());
            ps.setString(9, c.getDireccion());
            ps.setString(10,String.valueOf(c.getTipo_persona()));
            ps.setString(11, c.getDescripcion());
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }
    
    public void delete(int id){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
    }
}