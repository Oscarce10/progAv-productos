/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;

/**
 *
 * @author Estudiante
 */
// Esto aplica java generic para hacer el dao de cualquier tabla
public interface Obligacion <cualquiercosa>{
    public boolean create(cualquiercosa ob);
    public List<cualquiercosa> readAll();
    public cualquiercosa read(cualquiercosa id);
    public boolean update(cualquiercosa prod);
    public void delete(cualquiercosa id);
}
