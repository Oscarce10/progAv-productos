<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            // Create a String.
                String pid;
                // Get the bytes from the String, using getBytes() API method of String.
                byte[] byteArray = Base64.decodeBase64(request.getParameter("pid").getBytes());
                pid = new String(byteArray);
        %>
        <jsp:include page="<%= pid%>" ></jsp:include>
    </body>
</html>
