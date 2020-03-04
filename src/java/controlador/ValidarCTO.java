/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import modelo.dto.AdministradorDTO;
import modelo.dto.UsuarioDTO;

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

        System.out.println("correo: " + request.getParameter("correo"));
        System.out.println("clave: " + request.getParameter("clave"));

        Facade fa = new Facade();
        if (request.getParameter("registrar") != null) {
            try {

                String nombre = "Oscar";
                String apellido = "Cely";
                String correo = "1@a.com";
                String pass = "1";

                // salts are a fundamental principle of password hashing, and so we need one for PBKDF2     
                SecureRandom random = new SecureRandom();
                byte[] salt = new byte[20];
                random.nextBytes(salt);
                System.out.println("salt created: " + salt.toString());

                // Next, we'll create a PBEKeySpec and a SecretKeyFactory which we'll instantiate using the PBKDF2WithHmacSHA1 algorithm
                // The third parameter (65536) is effectively the strength parameter. It indicates how many iterations that this algorithm run for, 
                // increasing the time it takes to produce the hash.
                KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, 65536, 64);
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
                byte[] clave = null;
                try {
                    // Finally, we can use our SecretKeyFactory to generate the hash:
                    clave = factory.generateSecret(spec).getEncoded();
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
                }

                AdministradorDTO adm = new AdministradorDTO(nombre, apellido, correo, clave.toString(), salt.toString());
                if (fa.crearAdministrador(adm)) {
                    System.out.println("Administrador creado!");
                } else {
                    System.out.println("Administrador no creado!");
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ValidarCTO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            UsuarioDTO usuario = new UsuarioDTO(request.getParameter("correo"), request.getParameter("clave"));
            usuario = fa.validar(usuario);
            if (usuario != null) {
                System.out.println("El usuario si existe");
                HttpSession sesion = request.getSession();
                sesion.setAttribute("correo", usuario.getCorreo());
                sesion.setAttribute("clave", usuario.getClave());
                sesion.setAttribute("tipo", (usuario.getTipo() == 1) ? "Administrador" : "Cliente");
                System.out.println("Sesion creada: " + sesion.getId());
                System.out.println("Sesion correo: " + sesion.getAttribute("correo"));
                System.out.println("Sesion tipo: " + sesion.getAttribute("tipo"));
            } else {
                System.out.println("El usuario no existe");
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
