package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.URL;
import java.util.Arrays;
import org.apache.tomcat.util.codec.binary.Base64;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("     \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" \thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" \thref=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" \thref=\"css/normalize.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" \thref=\"css/styles.css\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    ");

        //
        //URL url = new URL(request.getRequestURL().toString());
        //String query = url.getQuery();
                
        if (request.getParameter("pid") != null) {
            System.out.println("pid: " + request.getParameter("pid"));
            // Decodificar base64
            byte[] byteArray = Base64.decodeBase64(request.getParameter("pid").getBytes());
            String pid = new String(byteArray);

            if (request.getParameter("nos") != null || request.getParameter("nos") == null
                    && session.getAttribute("id") != null) {
                request.getRequestDispatcher(pid).forward(request, response);
            } else {
                response.sendRedirect("Location: index.php");
            }
        } else {
            session.setAttribute("id", "lol");
            request.getRequestDispatcher("test.jsp").forward(request, response);
            System.out.println(session.getAttribute("id"));
        }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/script.js\"></script>\r\n");
      out.write("</body>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
