/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.ClienteDTO;
import modelo.dto.ProductoDTO;

/**
 *
 * @author Estudiante
 */
public class ClienteCTO extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String menu = request.getParameter("menu"); // Indica que proceso o modulo gestionará
        String accion = request.getParameter("accion"); // Indica la accion a ejecutar
        System.out.println(menu);
        System.out.println(accion);
        
        if(menu.equalsIgnoreCase("Cliente")){
            Facade ob = new Facade();
            switch(accion){
                case "Listar":
                    List<ClienteDTO> list = ob.listarClientes();
                    request.setAttribute("lista_clientes", list);
                    break;
                    
                case "agregar":
                    String nombre = request.getParameter("nombre");
                    String des = request.getParameter("descripcion");
                    int und = Integer.parseInt(request.getParameter("unidades"));
                    int valor = Integer.parseInt(request.getParameter("valor"));
                    ClienteDTO cl = new ClienteDTO(nombre, des, und, valor);//llenar con los datos de cliente en DTO
                    if(ob.equals(cl)){
                        System.out.println("Igual");
                        request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar&error=1").forward(request, response);
                        break;
                    }
                        
                    ob.crearProducto(pr);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProductoDTO prod = ob.read(id);
                    request.setAttribute("prod", prod);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar&edit=true").forward(request, response);
                    break;
                    
                    
                case "update":
                    id = Integer.parseInt(request.getParameter("id"));
                    nombre = request.getParameter("nombre");
                    des = request.getParameter("descripcion");
                    und = Integer.parseInt(request.getParameter("unidades"));
                    valor = Integer.parseInt(request.getParameter("valor"));
                    prod = new ProductoDTO(id, nombre, des, und, valor);
                    System.out.println(ob.update(prod));
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "del":                    
                    ob.delete(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("productovta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
