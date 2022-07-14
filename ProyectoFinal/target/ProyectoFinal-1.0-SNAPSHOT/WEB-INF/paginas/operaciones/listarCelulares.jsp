<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>

<section id="celulares">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4 class="text-center fw-bold">Celulares</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th class="fst-italic">#</th>
                                <th class="fst-italic">Modelo</th>
                                <th class="fst-italic">Marca</th>
                                <th class="fst-italic">Memoria interna</th>
                                <th class="fst-italic">Precio</th>
                                <th class="fst-italic">Stock</th>
                                <th class="fst-italic">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="celular" items="${celulares}" varStatus="status">
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${celular.modelo}</td>
                                    <td>${celular.marca}</td>
                                    <td>${celular.memoria}</td>
                                    <td><fmt:formatNumber value="${celular.precio}" type="currency"/></td>
                                    <td>${celular.stock}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idcelular=${celular.idcelular}" class="btn btn-secondary warning-link">
                                           <i class="fa-solid fa-pen"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
                <div class="col-md-1"></div>
      
                <div class="col-md-3">
                <div class="card text-center bg-warning text-black mb-3">
                    <div class="card-header fs-5 fw-bold">Cantidad de celulares</div>
                    <div class="card-body">
                        <h8 class="display-4 fs-6 fw-bold">${cantidadCelulares}</h8>
                    </div>
                </div>

                <div class="card text-center bg-warning text-black mb-3">
                     <div class="card-header fs-5 fw-bold">Precio total de celulares</div>
                    <div class="card-body"> 
                        <h6 class="display-4 fs-6 fw-bold"><fmt:formatNumber value="${precioTotal}" type="currency"/></h6>
                    </div>
                </div>
                      <div class="card text-center bg-warning text-black mb-3">
                           <div class="card-header fs-5 fw-bold">Cantidad por marca</div>
                    <div class="card-body">
                        <h5 class="display-4 fs-6 fw-bold text-start">Motorola: ${cantidadMotorola}</h5>
                        <h5 class="display-4 fs-6 fw-bold text-start">Samsung: ${cantidadSamsung}</h5>
                        <h5 class="display-4 fs-6 fw-bold text-start">iPhone: ${cantidadIphone}</h5>
                        <h5 class="display-4 fs-6 fw-bold text-start">Huawei: ${cantidadHuawei}</h5>
                    </div>
                </div>
            </div>
                
        </div>
    </div>
</section>
                      
<jsp:include page="/WEB-INF/paginas/operaciones/agregarCelular.jsp"/>