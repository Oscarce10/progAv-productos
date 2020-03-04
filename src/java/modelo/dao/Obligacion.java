/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexiones.ConexionMysql;
import java.util.List;

/**
 *
 * @author Estudiante
 */
// Esto aplica java generic para hacer el dao de cualquier tabla
public abstract class Obligacion <cualquiercosa>{  
    
    private final String SQL_INSERT;
    
    private final String SQL_READ;
    
    private final String SQL_READALL;
    
    private final String SQL_UPDATE;
    
    private final String SQL_DELETE;
    
    public final static ConexionMysql con = ConexionMysql.getInstance();

    public Obligacion() {
        this.SQL_DELETE = null;
        this.SQL_INSERT = null;
        this.SQL_READ = null;
        this.SQL_UPDATE = null;
        this.SQL_READALL = null;
    }

    
    public Obligacion(String tabla, String columns, String values, String where, String set) {        
        this.SQL_INSERT = "INSERT INTO " + tabla
            + "(" + columns + ") VALUES(" + values + ");";
        this.SQL_READ = "SELECT * FROM " + tabla + " WHERE " + where + ";";
        this.SQL_READALL = "SELECT * FROM " + tabla + ";";
        this.SQL_UPDATE = "UPDATE " + tabla + " SET " + set + ";";
        this.SQL_DELETE = "DELETE FROM " + tabla + " WHERE " + where + ";";
    }
            
    public abstract boolean create(cualquiercosa ob);
    public abstract List<cualquiercosa> readAll();
    public abstract cualquiercosa read(cualquiercosa id);
    public abstract boolean update(cualquiercosa prod);
    public abstract void delete(cualquiercosa id);

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

    public String getSQL_READ() {
        return SQL_READ;
    }

    public String getSQL_READALL() {
        return SQL_READALL;
    }

    public String getSQL_UPDATE() {
        return SQL_UPDATE;
    }

    public String getSQL_DELETE() {
        return SQL_DELETE;
    }
    
    
}
