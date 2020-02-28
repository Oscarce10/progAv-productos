<%@page import="controlador.Facade"%>
<%@page import="modelo.dto.ProductoDTO"%>

<%

    ProductoDTO prod = null;
    if (request.getParameter("id") != null) {
        Facade ob = new Facade();
        prod = ob.read(Integer.parseInt(request.getParameter("id")));
        System.out.println("Nombre: " + prod.getNombre());
    }

%>

<div class="modal-header">
    <h5 class="modal-title">Borrar Producto</h5>
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
<div class="modal-body">
    <p>¿Esta segro que desea eliminar el producto?</p>
    <p><%out.print(prod.getId() + " - " + prod.getNombre());%></p>
    <p>Una vez eliminado no se podra recuperar</p>
</div>
<div class="modal-footer">
    
    <a href="ProductoCTO?menu=Producto&accion=del&id=${ob.getId()}" class="btn btn-danger">Eliminar producto</a>
    <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
</div>