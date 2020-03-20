/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.AdministradorDTO;
import modelo.dto.UsuarioDTO;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author Estudiante
 */
public class ValidarCTO extends HttpServlet {

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
        response.setHeader("Cache-Control", "private, no-cache, no-store, must-revalidate, max-age=0, proxy-revalidate, s-maxage=0"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.

        System.out.println("correo: " + request.getParameter("correo"));
        System.out.println("clave: " + request.getParameter("clave"));
        System.out.println("Registrar: " + request.getParameter("registrar"));
        

        Facade fa = new Facade();
        if (request.getParameter("registrar") != null) {
            try {

                String nombre = "Oscar";
                String apellido = "Cely";
                String correo = "1@a.com";
                String pass = "1";
                // salts are a fundamental principle of password hashing, and so we need one for PBKDF2     
                String salt = Hashing.randomString(20);
                String clave = Hashing.generarClave(salt, pass);

                AdministradorDTO adm = new AdministradorDTO(nombre, apellido, correo, clave, salt);

                if (fa.crearAdministrador(adm)) {
                    System.out.println("Administrador creado!");
                } else {
                    System.out.println("Administrador no creado!");
                }
            } catch (Exception ex) {
                Logger.getLogger(ValidarCTO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else if(request.getParameter("correo") != null && request.getParameter("clave")!= null) {

            UsuarioDTO usuario = new UsuarioDTO(request.getParameter("correo"), request.getParameter("clave"));
            usuario = fa.validar(usuario);
            if (usuario != null) {
                if (usuario.getTipo() == 1) {
                    AdministradorDTO administrador = new AdministradorDTO(usuario.getCorreo(), usuario.getClave());
                    administrador = fa.checkAdmin(administrador);
                    if (administrador != null) {
                        HttpSession sesion = request.getSession();
                        sesion.setAttribute("id", administrador.getId());
                        sesion.setAttribute("correo", administrador.getCorreo());
                        sesion.setAttribute("tipo", "administrador");
                        System.out.println("Sesion creada: " + sesion.getId());
                        System.out.println("Sesion correo: " + sesion.getAttribute("correo"));
                        System.out.println("Sesion tipo: " + sesion.getAttribute("tipo") + "Id: " + sesion.getAttribute("id"));
                        System.out.println(sesion.getAttribute("tipo") != null);

                        request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("administrador/inicio.jsp".getBytes())).forward(request, response);
                        return;
                    } else {
                        request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("inicio.jsp".getBytes()) + "&login=fail").forward(request, response);
                        return;
                    }
                }

            } else {
                System.out.println("El usuario no existe");
                request.getRequestDispatcher("index.jsp?pid=" + Base64.encodeBase64String("inicio.jsp".getBytes()) + "&login=fail").forward(request, response);
                return;
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
