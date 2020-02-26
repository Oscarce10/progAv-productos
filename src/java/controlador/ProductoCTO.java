/*
 crearemos nuestro controlador un Servlet con nombre ProductoCTO, quien recibirá las peticiones del usuario e invocara los
métodos del modelo,
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.ProductoDTO;

/**
 *
 * @author USER
 */
public class ProductoCTO extends HttpServlet {

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
        System.out.println("menu: " + menu);
        System.out.println("accion: " + accion);

        if (accion == null && menu == null || accion.equals("listar")) {
            Facade ob = new Facade();
            List<ProductoDTO> list = ob.listarProductos();
            request.setAttribute("lista_productos", list);
            request.getRequestDispatcher("index.jsp?pid=producto/productovta.jsp").forward(request, response);
        } else if (menu.equalsIgnoreCase("Producto")) {
            Facade ob = new Facade();
            switch (accion) {
                case "agregar":
                    String nombre = request.getParameter("nombre");
                    String des = request.getParameter("descripcion");
                    int und = Integer.parseInt(request.getParameter("unidades"));
                    int valor = Integer.parseInt(request.getParameter("valor"));
                    ProductoDTO pr = new ProductoDTO(nombre, des, und, valor);
                    ob.crearProducto(pr);
                    request.getRequestDispatcher("ProductoCTO").forward(request, response);
                    break;

                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    ProductoDTO prod = ob.read(id);
                    request.setAttribute("prod", prod);
                    request.getRequestDispatcher("ProductoCTO?accion=listar").forward(request, response);
                    break;

                case "update":
                    System.out.println("Entra UPDATE");
                    id = Integer.parseInt(request.getParameter("id"));
                    nombre = request.getParameter("nombre");
                    des = request.getParameter("descripcion");
                    und = Integer.parseInt(request.getParameter("unidades"));
                    valor = Integer.parseInt(request.getParameter("valor"));
                    prod = new ProductoDTO(id, nombre, des, und, valor);
                    System.out.println(ob.update(prod));
                    return;

                case "del":
                    ob.delete(Integer.parseInt(request.getParameter("id")));
                    request.getRequestDispatcher("ProductoCTO").forward(request, response);
                    break;

                default:
                    response.sendRedirect("ProductoCTO");
                    return;
            }
        } else {
            response.sendRedirect("ProductoCTO");
            return;
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
