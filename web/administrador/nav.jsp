<%@page import="org.apache.commons.codec.binary.Base64"%>
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary" id="nav">
    <a class="navbar-brand" href="index.jsp?pid=<%out.print(Base64.encodeBase64String("administrador/inicio.jsp".getBytes()));%>"><i
            class="fas fa-home"></i></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">	
            <li class="nav-item">
                <a class="nav-link active" href="ProductoCTO">Producto</a>
            </li>
            
            <li class="nav-item">
                <a class="nav-link active" href="ClienteCTO">Clientes</a>
            </li>
            <li class="nav-item"><a class="nav-link" href="<%out.print(request.getContextPath());%>/LogoutCTO">Salida</a>
            </li>

        </ul>
        <span class="navbar-text">
        </span>
    </div>
</nav>