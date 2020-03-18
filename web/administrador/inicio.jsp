<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="controlador.Facade"%>
<%@page import="modelo.dto.AdministradorDTO"%>
<%
    HttpSession sesion = request.getSession();
    System.out.println(sesion.getAttribute("correo"));
    AdministradorDTO administrador = new AdministradorDTO(Integer.parseInt(session.getAttribute("id").toString()));
    Facade obF = new Facade();
    administrador = obF.readAdmin(administrador);
%>

<%@include file="nav.jsp"%>


<div class="container" style="margin-top: 150px;">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header bg-primary text-white">Bienvenido Administrador</div>
                <div class="card-body">
                    <p>Administrador: <% out.print(administrador.getNombre() + " " + administrador.getApellido());%></p>
                    <p>Correo: <% out.print(administrador.getCorreo());%></p>
                    <p>Hoy es: <% out.print(DateTimeFormatter.ofPattern("dd/MM/yyy").format(LocalDate.now()));%></p>
                </div>
            </div>
        </div>
    </div>
</div>
