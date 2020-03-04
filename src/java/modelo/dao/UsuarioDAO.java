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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author Estudiante
 */
public class UsuarioDAO {

    public static final ConexionMysql con = ConexionMysql.getInstance();

    public UsuarioDAO() {
    }

    public UsuarioDTO read(UsuarioDTO usr) {
        PreparedStatement ps;
        ResultSet rs;
        UsuarioDTO usuario = null;
        try {
            ps = con.getCon().prepareStatement("SELECT * FROM administrador WHERE correo LIKE ?");
            ps.setString(1, usr.getCorreo());
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioDTO(1, usr.getCorreo(), usr.getClave());
            } else {
                ps = con.getCon().prepareStatement("SELECT * FROM cliente WHERE correo LIKE ?");
                ps.setString(2, usr.getCorreo());
                rs = ps.executeQuery();
                if (rs.next()) {
                    usuario = new UsuarioDTO(2, usr.getCorreo(), usr.getClave());
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return usuario;
    }

}
