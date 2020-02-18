/*
Clase Facade que llevara toda la logica de negocio y sera pasador entre la interface y el modelo
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelo.dao.ClientaDAO;
import modelo.dao.ProductoDAO;
import modelo.dto.ClienteDTO;
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
    
    public void delete(int id){
        ProductoDAO dao = new ProductoDAO();
        dao.delete(id);
    }
    
    
    
    
    public boolean crearCliente(ClienteDTO ob){
        boolean rta = false;
        if(ob != null){
            ClientaDAO dao = new ClientaDAO();
            rta = dao.create(ob);
        }
        return rta;
    }
    
    public List<ClienteDTO> listarclientes(){
        List<ProductoDTO> list = null;
        ProductoDAO dao = new ProductoDAO();
        list = dao.readAll();
        return list;
    }
    
    public ClienteDTO read(int id){
        ClientaDAO dao = new ClientaDAO();
        ClientaDAO clie = dao.read(id);
        return clie;
    }
    
    public boolean update(ClienteDTO clie){
        ClienteDAO dao = new ClienteDAO();
        return dao.update(clie);
    }    
    
    public void delete(int id){
        ClienteDAO dao = new ClienteDAO();
        dao.delete(id);
    }
}
