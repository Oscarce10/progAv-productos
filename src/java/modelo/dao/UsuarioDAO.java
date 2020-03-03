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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Estudiante
 */
public class UsuarioDAO implements Obligacion<UsuarioDTO>{
    
    private static final String SQL_INSERT = "INSERT INTO usuario"
            + "(tipo, nombre, apellido, clave) VALUES(?, ?, ?, ?);";
    
    private static final String SQL_READ = "SELECT * FROM usuario WHERE correo = ?;";
    
    private static final String SQL_READALL = "SELECT * FROM usuario;";
    
    private static final String SQL_UPDATE = "UPDATE usuario SET tipo = ?, nombre = ?, "
            + "apellido = ?, clave = ? WHERE id = ?;";
    
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id = ?;";
    
    public static final ConexionMysql con = ConexionMysql.getInstance();

    @Override
    public boolean create(UsuarioDTO ob) {
        PreparedStatement ps;
        return true;
        
    }

    @Override
    public List<UsuarioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public UsuarioDTO read(UsuarioDTO val) {
        PreparedStatement ps;
        UsuarioDTO usuario = null;
        try {
            ps = con.getCon().prepareStatement(SQL_READ);
            ps.setString(1, val.getCorreo());
            ResultSet rs = ps.executeQuery();
            usuario = new UsuarioDTO(rs.getInt(0), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return usuario;
    }

    @Override
    public boolean update(UsuarioDTO val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(UsuarioDTO val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
