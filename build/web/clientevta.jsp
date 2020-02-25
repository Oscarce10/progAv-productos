<%-- 
    Document   : productovta
    Created on : 13/02/2020, 09:54:00 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" 	href="css/normalize.css">
        <link rel="stylesheet" href="css/superhero.min.css">
        <link rel="stylesheet" 	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" 	href="css/styles.css">
        <title>JSP Page</title>
        <!-- https://tailwindcss.com/ Framework -->
        <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Lexend+Deca|Lexend+Giga&display=swap" rel="stylesheet">
    </head>
    <body>
        <%@include file="index.jsp" %>
        <br>

        <div class="container">
            <div class="row">
                <div class="col-4" id="form">
                    <form action="ClienteCTO?menu=Cliente" method="POST">
                        <input type="hidden" class="form-control" id="exampleFormControlInput1" name="id" value="${cli.getId()}">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Nombre</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Arroz" name="nombre" required value="${prod.getNombre()}">
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlTextarea1">Descripcion del producto</label>
                            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="descripcion" required>${prod.getDescripcion()}</textarea>
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput1">Cantidad</label>
                            <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="25" name="unidades" required value="${prod.getUnidades()}">
                        </div>

                        <div class="form-group">
                            <label for="exampleFormControlInput1">Valor</label>
                            <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1250" name="valor" required value="${prod.getValor()}">
                        </div>
                        <div class="form-group">
                            <% if(Boolean.valueOf(request.getParameter("edit"))){%>
                            <button type="submit" class="btn btn-secondary" name="accion" value="update">Actualizar</button>
                            <%} else{ %>
                            <button type="submit" class="btn btn-primary" name="accion" value="agregar">Agregar</button>
                            <%}%>
                            
                        </div>
                        
                        
                    </form>
                </div>


                <div class="col-8">
                    <table id="table" class="table table-striped table-dark">
                        <thead>
                            <tr>  
                                <th scope="col">Nit</th>
                                <th scope="col">Razon Social</th>
                                <th scope="col">Telefono</th>
                                <th scope="col">Celular</th>
                                <th scope="col">Correo</th>
                                <th scope="col">Representante Legal</th>
                                <th scope="col">Doc. Rep. legal</th>
                                <th scope="col">Descripcion</th>
                                <th scope="col">Opciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ob" items="${lista_clientes}">
                                <tr>
                                    <td>${ob.getNit()}</td>
                                    <td>${ob.getNombre() + ob.getApellido()}</td>
                                    <td>${ob.getTelefono()}</td>
                                    <td>${ob.getCorreo()}</td>
                                    <td>${ob.getNombre_rl() + ob.getApellido_rl()}</td>
                                    <td>${ob.getDoc_rl()}</td>
                                    <td>${ob.getDescripcion()}</td>
                                    <td>
                                        <span id="edit${ob.getId()}">
                                            <a href="ClienteCTO?menu=Producto&accion=edit&id=${ob.getId()}" data-toggle="tooltip" data-placement="top" title="Editar producto">
                                                <i class="fas fa-edit" style="color: #DF691A;"></i>
                                            </a>
                                        </span>

                                            <span id="delete${ob.getId()}">
                                            <a href="ClienteCTO?menu=Producto&accion=del&id=${ob.getId()}" data-toggle="tooltip" data-placement="top" title="Eliminar producto">
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



        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </body>
</html>
