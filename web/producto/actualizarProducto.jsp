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
<form action="ProductoCTO?menu=Producto" method="POST">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">
                    <% if (Boolean.valueOf(request.getParameter("edit"))) {%>
                    Editar producto
                    <% } else {%>
                    Agregar producto
                    <%}
                    %>
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">


                <input type="hidden" class="form-control" id="id" name="id" value="<%out.print((prod != null) ? prod.getId() : "");%>">
                <div class="form-group">
                    <label for="exampleFormControlInput1">Nombre</label>
                    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Arroz" name="nombre" required
                           value="<%out.print((prod != null) ? prod.getNombre() : "");%>">
                </div>

                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Descripcion del producto</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descripcion"
                              required><%out.print((prod != null) ? prod.getDescripcion() : "");%></textarea>
                </div>

                <div class="form-group">
                    <label for="exampleFormControlInput1">Cantidad</label>
                    <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="25" name="unidades"
                           required value="<%out.print((prod != null) ? prod.getUnidades() : "");%>">
                </div>

                <div class="form-group">
                    <label for="exampleFormControlInput1">Valor</label>
                    <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1250" name="valor" required
                           value="<%out.print((prod != null) ? prod.getValor() : "");%>">
                </div>



            </div>
            <div class="modal-footer">
                <div class="form-group">
                    <% if (Boolean.valueOf(request.getParameter("edit"))) {%>
                    <button type="submit" class="btn btn-secondary" name="accion" value="update" id="actualizar">Actualizar</button>
                    <%} else { %>
                    <button type="submit" class="btn btn-primary" name="accion" value="agregar" id="agregar">Agregar</button>
                    <%}%>

                </div>

            </div>
        </div>
    </div>
</form>
