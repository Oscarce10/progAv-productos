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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <th scope="row"><%out.print(prod.getId());%>;</th>
    <td><%out.print(prod.getNombre());%>;</td>
    <td>$<%out.print(prod.getDescripcion());%>;</td>
    <td><%out.print(prod.getUnidades());%>;</td>
    <td><%out.print(prod.getValor());%>;</td>
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
</body>
</html>
