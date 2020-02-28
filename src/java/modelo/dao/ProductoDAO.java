/*
 Implementación de los DAO, el DAO nos permite usar la conexión a la base de datos y realizar todo el CRUD, ceraremos
una DAO por cada DTO persistente en la base de datos, en el paquete “modelo.dao”
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
import modelo.dto.ProductoDTO;

/**
 *
 * @author USER
 */
public class ProductoDAO {
    
    private static final String SQL_INSERT = "INSERT INTO producto"
            + "(nombre, descripcion, cantidad, valor) VALUES(?, ?, ?, ?);";
    
    private static final String SQL_READ = "SELECT * FROM producto WHERE id = ?;";
    
    private static final String SQL_READALL = "SELECT * FROM producto;";
    
    private static final String SQL_UPDATE = "UPDATE producto SET nombre = ?, "
            + "descripcion = ?, cantidad = ?, valor = ? WHERE id = ?;";
    
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id = ?;";
    
    public static final ConexionMysql con = ConexionMysql.getInstance();
    
    public boolean create(ProductoDTO c){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_INSERT);
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getDescripcion());
            ps.setInt(3, c.getUnidades());
            ps.setInt(4, c.getValor());
            
            if(ps.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    public List<ProductoDTO> readAll(){
        List<ProductoDTO> list = null;
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_READALL);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while(rs.next()){
                ProductoDTO ob = new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                list.add(ob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        
        return list;
        
    }
    
    public ProductoDTO read(int id){
        PreparedStatement ps;
        ProductoDTO prod = null;
        try {            
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                prod = new ProductoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                System.out.println(prod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return prod;
    }
    
    public boolean update(ProductoDTO prod){
        PreparedStatement ps;
        try {
            ps = con.getCon().prepareStatement(SQL_UPDATE);
            ps.setInt(5, prod.getId());
            ps.setString(1, prod.getNombre());
            ps.setString(2, prod.getDescripcion());
            ps.setInt(3, prod.getUnidades());
            ps.setInt(4, prod.getValor());
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
