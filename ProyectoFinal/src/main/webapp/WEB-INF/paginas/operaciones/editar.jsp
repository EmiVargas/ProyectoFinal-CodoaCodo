<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Editar Celular</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idCelular=${celular.idcelular}" method="POST" class="was-validated">>
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavEdicion.jsp"/>             
                        
       <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Celular</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="modelo">Modelo</label>
                                        <input type="text" class="form-control" name="modelo" required="" value="${celular.modelo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="marca">Marca</label>
                                        <input type="text" class="form-control" name="marca" value="${celular.marca}">
                                    </div>
                                    <div class="form-group">
                                        <label for="memoria">Memoria</label>
                                        <input type="number" class="form-control" name="memoria" required="" value="${celular.memoria}">
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio</label>
                                        <input type="currency" class="form-control" name="precio" required="" value="${celular.precio}">
                                    </div>
                                    <div class="form-group">
                                        <label for="stock">Stock disponible</label>
                                        <input type="number" class="form-control" name="stock" required="" value="${celular.stock}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>