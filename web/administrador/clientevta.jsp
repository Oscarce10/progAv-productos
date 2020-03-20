<%@page import="modelo.dto.ProductoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="nav.jsp"%>

<div class="container">



    <div>
        <table id="table" class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">nit</th>
                    <th scope="col">Razon Social</th>
                    <th scope="col">Representante legal</th>
                    <th scope="col">Doc. Rep. legal</th>
                    <th scope="col">Correo</th>
                    <th scope="col">Tipo Persona</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach var="ob" items="${lista_clientes}">
                    <tr id="prod${ob.getId()}">
                        <th scope="row">${ob.getId()}</th>
                        <th scope="row">${ob.getNit()}</th>
                        <td>${ob.getRazon_social()}</td>
                        <td class="row">${ob.getNombre_rl()} ${ ob.getApellido_rl()}</td>
                        <td>${ob.getNum_doc_rl()}</td>
                        <td>${ob.getCorreo()}</td>
                        <td>${ob.getTipo_persona()}</td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<div class="modal fade" id="actualizarProducto" tabindex="-1"
     role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="modalContent"
             style="background-color: inherit; border: none;"></div>
    </div>
</div>

<div class="modal fade" id="eliminarProducto" tabindex="-1"
     role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content"></div>
    </div>
</div>

<script>
    document.title = "Clientes";
</script>