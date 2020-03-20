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
import org.apache.tomcat.util.codec.binary.Base64;

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
        response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate, max-age=0, proxy-revalidate, s-maxage=0"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.
        if (accion == null && menu == null || accion.equals("listar")) {
            Facade ob = new Facade();
            List<ClienteDTO> list = ob.listarClientes();
            request.setAttribute("lista_clientes", list);

            request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("administrador/clientevta.jsp".getBytes())).forward(request, response);
        }
        else if(menu.equalsIgnoreCase("Cliente")){
            Facade ob = new Facade();
            switch(accion){
                                   
                case "agregar":
                    String razon_social = request.getParameter("nombre") + request.getParameter("apellido");
                    ClienteDTO cl = new ClienteDTO(
                            request.getParameter("nit"), 
                            razon_social,
                            request.getParameter("nombre_rl"), 
                            request.getParameter("apellido_rl"),
                            request.getParameter("doc_rl"),
                            request.getParameter("telefono"), 
                            request.getParameter("celular"),
                            request.getParameter("correo"),
                            request.getParameter("direccion"), 
                            request.getParameter("descripcion"),
                            request.getParameter("persona").charAt(0));//llenar con los datos de cliente en DTO                 
                        
                    ob.crearCliente(cl);
                    request.getRequestDispatcher("ClienteCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
                    
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProductoDTO prod = ob.read(id);
                    request.setAttribute("prod", prod);
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar&edit=true").forward(request, response);
                    break;
                    
                    
                case "update":
                    razon_social = request.getParameter("nombre") + request.getParameter("apellido");
                    cl = new ClienteDTO(
                            request.getParameter("nit"), 
                            razon_social,
                            request.getParameter("nombre_rl"), 
                            request.getParameter("apellido_rl"),
                            request.getParameter("doc_rl"),
                            request.getParameter("telefono"), 
                            request.getParameter("celular"),
                            request.getParameter("correo"),
                            request.getParameter("direccion"), 
                            request.getParameter("descripcion"),
                            request.getParameter("persona").charAt(0));
                    System.out.println(ob.update(cl));
                    request.getRequestDispatcher("ClienteCTO?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                    
                case "del":                    
                    ob.deleteCliente(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("ProductoCTO?menu=Producto&accion=Listar").forward(request, response);
                    break;
            }
            
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