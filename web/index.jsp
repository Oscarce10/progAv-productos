<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/styles.css">  
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<body>    
    <%@include file="nav.html" %>

    <% try {
            if (request.getParameter("pid") != null) { %>
    <% String p = request.getParameter("pid");%>
    <jsp:include page="<%= p%>" ></jsp:include>
    <% } else {
            request.getRequestDispatcher("/indexServlet").forward(request, response);
                }%>
    <% } catch (Exception e) {
            request.getRequestDispatcher("/").forward(request, response);
            //You should return after redirecting.
            return;
            }%>


    
    <script type="text/javascript" src="js/script.js"></script>
</body>
</html>