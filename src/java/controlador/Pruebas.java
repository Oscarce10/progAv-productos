/*
Luego probaremos que toda la persistencia esté funcionando correctamente, para ello crearemos una clase Prueba con un
“main” donde realizaremos las pruebas de listar la tabla producto, */
package controlador;

import java.util.List;
import modelo.dto.ProductoDTO;

/**
 *
 * @author USER
 */
public class Pruebas {
    
    public static void main(String[] args) {
        Facade ob = new Facade();
        List<ProductoDTO> list = null;
        list = ob.listarProductos();
        if(list != null){
            for(ProductoDTO producto: list){
                System.out.println(producto);
            }
        }
        else{
            System.out.println("No hay productos");
        }
    }
    
}
