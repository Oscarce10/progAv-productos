<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="css/superhero.min.css">    
    <link rel="stylesheet" href="css/styles.css">

</head>

<body>
    <% HttpSession sesion = request.getSession(); %>


    <%
        if (request.getParameter("pid") != null && sesion.getAttribute("id") != null && sesion.getAttribute("id") != "") {
        // Create a String.
        String p;
        // Get the bytes from the String, using getBytes() API method of String.
        byte[] byteArray = Base64.decodeBase64(request.getParameter("pid").getBytes());
        p = new String(byteArray);
        System.out.println("p: " + p);
    %>
    <jsp:include page='<%=p%>'></jsp:include>
    <%
        } else {
           %>
    <jsp:include page='inicio.jsp'></jsp:include>
    <%
        }
    %>


    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script
    src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>
</body>
</html>