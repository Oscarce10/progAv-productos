<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Forms</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="js/summernote-bs4.min.css">
        <link href="css/styles.css" rel="stylesheet" type="text/css" />





    </head>

    <body>
        
        <%@include file="index.jsp" %>

        <div class="container" style="margin-top: 80px;">
            <div class="row">
                <div class="col-2"></div>
                <div class="card bg-dark text-white col-9">
                    <div class="card-header bg-dark text-white">Registro Cliente</div>
                    <input type="hidden" class="form-control" id="exampleFormControlInput1" name="id" value="${cli.getId()}">
                    <div class="card-body">
                        <form action="ClienteCTO&menu=Cliente" method="POST">
                            <h3>Datos del cliente</h3>
                            <!-- ---------------------Nombre/Apellido----------------------------->
                            <div class="form-group row">
                                <div class="col">
                                    <label for="name">Nombre</label>
                                    <input type="text" class="form-control" required name="nombre">
                                </div>
                                <div class="col">
                                    <label for="name">Apellido</label>
                                    <input type="text" class="form-control" required name="apellido">
                                </div>
                            </div>
                            <!-- ---------------------Tipo Persona/Razon------------------------>
                            <div class="form-group row">
                                <div class="col-2">
                                    <label for="name">Persona</label>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="persona" value="n" checked>
                                        <label class="form-check-label" for="gridRadios1">
                                            Natural
                                        </label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="persona" value="j">
                                        <label class="form-check-label" for="gridRadios2">
                                            Juridica
                                        </label>
                                    </div>
                                </div>
                                <div class="col-5">
                                    <label for="name">Razon Social (Sin digito de verif.)</label>
                                    <input type="number" class="form-control" name="nit" required>
                                </div>
                                <div class="col-5">
                                    <label for="name">Correo</label>
                                    <input type="email" class="form-control" name="correo" required>
                                </div>

                            </div>
                            <!-- ---------------------Telefono/Celular----------------------------->
                            <div class="form-group row">
                                <div class="col">
                                    <label for="name">Telefono</label>
                                    <input type="number" class="form-control" name="telefono">
                                </div>
                                <div class="col">
                                    <label for="name">Celular</label>
                                    <input type="number" class="form-control" name="celular" max="3900000000">
                                </div>
                            </div>
                            <!-- ---------------------Tipo Persona/Razon------------------------>
                            <div class="form-group">
                                <label for="exampleFormControlTextarea1">Descripcion</label>
                                <textarea id="summernote" name="descripcion"></textarea>

                            </div>
                            <h4>Datos de Representante Legal</h4>
                            <div class="form-group row">
                                <div class="col">
                                    <label for="name">Nombre</label>
                                    <input type="text" class="form-control" name="nombre_rl">
                                </div>
                                <div class="col">
                                    <label for="name">Apellido</label>
                                    <input type="text" class="form-control" name="apellido_rl">
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="col">
                                    <label for="name">Documento</label>
                                    <input type="text" class="form-control" name="documento_rl">
                                </div>
                                <div class="col">
                                    <label for="name">Opciones</label>
                                    <div>
                                        <% if (Boolean.valueOf(request.getParameter("edit"))) {%>
                                        <button type="submit" class="btn btn-secondary" name="accion" value="update">Actualizar</button>
                                        <%} else { %>
                                        <button type="submit" class="btn btn-success" name="accion" value="agregar">Agregar</button>
                                        <%}%>
                                        <a class="btn btn-secondary" href="#" role="button">Volver</a>
                                    </div>

                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous">
    </script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
    </script>
    <!-- Text editor-->

    <script src="js/summernote-bs4.min.js"></script>
    <script src="js/scripts.js"></script>

</body>

</html>