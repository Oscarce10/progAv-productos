<%-- 
    Document   : test2
    Created on : 18/02/2020, 08:03:12 PM
    Author     : USER
--%>

<%@page import="java.util.Arrays"%>
<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>Variables: <br>menu: <% out.print(request.getParameter("menu")); %> <br>email: <% out.print(request.getParameter("email")); %> <br>pass:   <%out.print(request.getParameter("password")); %>  
                    <br>boton:  <%out.print(request.getParameter("boton"));%> </div>
                    
        <% 
            String string = "SmF2YWNvZGVnZWVrcw==";
            // Get bytes from string

                byte[] byteArray = Base64.decodeBase64(string.getBytes());

                // Print the decoded array
                System.out.println(Arrays.toString(byteArray));

                // Print the decoded string 
                String decodedString = new String(byteArray);

                System.out.println(string + " = " + decodedString);
                %>
                    
    </body>
</html>
