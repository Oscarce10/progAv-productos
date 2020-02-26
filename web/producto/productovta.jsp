<%@page import="modelo.dto.ProductoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" >

    <div class="row">
        <div class="col-4" id="registro-producto">

        </div>


        <div class="col-8">
            <table id="table" class="table table-striped table-dark">
                <thead>
                    <tr>
                        <th scope="col">#</th>                    
                        <th scope="col">Nombre</th>
                        <th scope="col">Descripcion</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ob" items="${lista_productos}">
                        <tr id="prod${ob.getId()}">
                            <th scope="row">${ob.getId()}</th>
                            <td>${ob.getNombre()}</td>
                            <td>${ob.getDescripcion()}</td>
                            <td>${ob.getUnidades()}</td>
                            <td>${ob.getValor()}</td>
                            <td>
                                <span id="edit${ob.getId()}">
                                    <a id="opc_editar${ob.getId()}" href="#" data-toggle="tooltip" data-placement="top" title="Editar producto">
                                        <i class="fas fa-edit" style="color: #DF691A;"></i>
                                    </a>
                                </span>

                                <span id="delete${ob.getId()}">
                                    <a href="ProductoCTO?menu=Producto&accion=del&id=${ob.getId()}" data-toggle="tooltip" data-placement="top" title="Eliminar producto">
                                        <i class="fas fa-trash-alt" style="color: #FF1F1B;"></i>
                                    </a>
                                </span>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    document.title = "Productos";
</script>

<script>
    <c:forEach var="ob" items="${lista_productos}">
    $("#edit${ob.getId()}").click(function () {
        $("#registro-producto").load("indexAjax.jsp?pid=producto/form_producto.jsp&edit=true&id=${ob.getId()}");
        $("#opc_editar${ob.getId()}").tooltip('hide');

    });
    </c:forEach>
    
</script>
