/*
Clase Facade que llevara toda la logica de negocio y sera pasador entre la interface y el modelo
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.ProductoDAO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author USER
 */
public class Facade {
    
    public boolean crearProducto(ProductoDTO ob){
        boolean rta = false;
        if(ob != null){
            ProductoDAO dao = new ProductoDAO();
            rta = dao.create(ob);
        }
        return rta;
    }
    
    public List<ProductoDTO> listarProductos(){
        List<ProductoDTO> list = null;
        ProductoDAO dao = new ProductoDAO();
        list = dao.readAll();
        return list;
    }
    
    public ProductoDTO read(int id){
        ProductoDAO dao = new ProductoDAO();
        ProductoDTO prod = dao.read(id);
        return prod;
    }
    
    public boolean update(ProductoDTO prod){
        ProductoDAO dao = new ProductoDAO();
        return dao.update(prod);
    }    
}
