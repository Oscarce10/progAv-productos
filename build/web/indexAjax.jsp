<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String pid = request.getParameter("pid");%>
        <jsp:include page="<%= pid%>" ></jsp:include>
    </body>
</html>
