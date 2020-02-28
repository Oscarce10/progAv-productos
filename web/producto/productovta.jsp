<%@page import="org.apache.tomcat.util.codec.binary.Base64"%>
<%@page import="modelo.dto.ProductoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="container" >



    <div>
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
                        <td class="cotainer-fuid">
                            <span id="edit${ob.getId()}" class="edit-icon">
                                <a id="opc_editar${ob.getId()}" href="indexAjax.jsp?pid=<%out.print(Base64.encodeBase64String("producto/actualizarProducto.jsp".getBytes()));%>&edit=true&id=${ob.getId()}" data-toggle="modal" data-target="#actualizarProducto">
                                    <i class="fas fa-edit" style="color: #DF691A;" data-toggle='tooltip' class='tooltipLink' data-placement='top' 
                                       data-original-title='Editar producto' 
                                       ></i>
                                </a>
                            </span>
                            <span id="delete${ob.getId()}" class="col-4">
                                
                                <a href="indexAjax.jsp?pid=<%out.print(Base64.encodeBase64String("producto/eliminarProducto.jsp".getBytes()));%>&id=${ob.getId()}" data-toggle="modal" data-target="#eliminarProducto">
                                    <i class="fas fa-trash-alt" style="color: #FF1F1B;" data-toggle="tooltip" data-placement="top" title="Eliminar producto"></i>
                                </a>
                            </span>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <a class="btn btn-success" href="indexAjax.jsp?pid=<%out.print(Base64.encodeBase64String("producto/actualizarProducto.jsp".getBytes()));%>&agregar=true" role="button" data-toggle="modal" data-target="#actualizarProducto">Agregar Producto</a>
</div>

<div class="modal fade" id="actualizarProducto" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" id="modalContent" style="background-color: inherit; border: none;"></div>
    </div>
</div>

<div class="modal fade" id="eliminarProducto" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">      
    </div>
  </div>
</div>

<script>
    document.title = "Productos";
</script>

