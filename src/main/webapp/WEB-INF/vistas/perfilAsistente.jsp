<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/Login.css" rel="stylesheet">
    <title>Perfil Asistente</title>
</head>

<body class="fondo-login ">
<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="home">AsegurApp</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="perfilUsuario">Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="suscripcion">Suscripción</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container-fluid  mt-5 rounded-3 ">
    <div class="row w-100 bg-light m-auto p-1 justify-content-md-center" style="max-width: 1250px;">
        <div class="col-12 px-1">
            <div class="tab tab-primary">
                <ul class="nav nav-pills nav-pills-sm nav-light mb-2"> <!-- empieza botones-->
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("perfil") ? "active" : ""}"
                           href="perfilUsuario">Perfil de Asistente</a>
                    </li>
                    <%--<li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("historial") ? "active" : ""}"
                           href="mostrar-historial">Mis Contrataciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder"
                           data-bs-toggle="tab" href="#primary-tab-3">Algo</a>
                    </li>--%>
                </ul><!-- Termina botones-->
                <div class="tab-content">
                    <!-- Empieza primer boton-->
                    <div class="tab-pane ${seccion.equals("perfil") ? "active" : ""}" id="primary-tab-1"
                         role="tabpanel">
                        <div class="row w-100 bg-light row w-100 h-100 m-auto justify-content-md-center">
                            <!--  empieza foto perfil-->
                            <div class="bg-danger col-12 col-md-6 d-flex bg-white align-content-center justify-content-center">
                                <div class="d-flex align-items-center flex-column w-75  align-content-center justify-content-center flex-wrap text-center">
                                    <img src="imagenes/perfil.png" alt="Foto Perfil" class="" width=150 height=150/>
                                    <h3 class="mt-3">${asistente.nombre} ${asistente.apellido}</h3>
                                    <p class="text-muted m-0">${asistente.email}</p>
                                    <p class="text-muted m-0">Argentino</p>

                                    <c:if test="${usuarioLogueado}">
                                        <c:if test="${esFavorito}">
                                            <%--<form:form action="validar-login" method="POST" modelAttribute="datosLogin">
                                                <h3 class="form-signin-heading">Taller Web I</h3>
                                                <hr class="colorgraph"><br>

                                                &lt;%&ndash;Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados&ndash;%&gt;
                                                <form:input path="email" id="email" type="email" class="form-control" />
                                                <form:input path="password" type="password" id="password" class="form-control"/>

                                                <button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Login</button>
                                            </form:form>--%>


                                            <form:form action="removerFavorito" method="post" modelAttribute="irAsistentePerfilRequest" cssClass="btn btn-danger mt-4">
                                                <form:input path="asistenteId" id="asistenteId" type="text" value="${asistente.id}" cssStyle="display: none" />
                                                <%--<input path="asistenteId" id="asistenteId" type="number" hidden value="${asistente.id}">--%>
                                                <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Remover Favoritos</button>
                                            </form:form>
                                            <%--<div class="btn btn-danger mt-5">
                                                <a href="removerFavorito?asistente-id=${asistente.id}" class="text-decoration-none text-white">Remover de favoritos</a>
                                            </div>--%>
                                        </c:if>
                                        <c:if test="${esFavorito == false}">
                                            <form:form action="adherirFavorito" method="post" modelAttribute="irAsistentePerfilRequest" cssClass="btn btn-danger mt-4">
                                                <form:input path="asistenteId" id="asistenteId" type="text" value="${asistente.id}" cssStyle="display: none" />
                                                <%--<input path="asistenteId" id="asistenteId" type="number" hidden value="${asistente.id}">--%>
                                                <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Agregar a favoritos</button>
                                            </form:form>

                                            <%--<div class="btn btn-danger mt-5">
                                                <a href="adherirFavorito?asistente-id=${asistente.id}" class="text-decoration-none text-white">Agregar a favoritos</a>
                                            </div>--%>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                            <!-- termina foto perfil-->

                            <!-- empieza tabla -->
                            <div class="col-12 col-md-6 d-flex align-items-center bg-white ">
                                <div class="w-100">
                                    <table class="table table-hover table-borderless mt-2">
                                        <tbody>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Nombre</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${asistente.nombre}
                                                ${asistente.apellido}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Rol</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${asistente.rol.descripcion}</td>
                                        </tr>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Mail</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${asistente.email}</td>
                                        </tr>
                                        <tr class="">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Ciudad</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${asistente.provincia.nombre}
                                            </td>
                                        </tr>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Fecha Alta</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">12/07/2020</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- termina tabla -->

                            <p>Promedio De Calificacion: ${promedio}</p>
                        </div>
                    </div>
                    <!-- Termina primer boton -->
                    <!-- Empieza segundo boton -->
                    <div class="tab-pane ${seccion.equals("historial") ? "active" : ""}" id="primary-tab-2"
                         role="tabpanel">
                        <div class="row w-100  row w-100 h-100 m-auto justify-content-md-center">

                            <div class="col-12 p-2 ">
                                <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">N°
                                        Factura</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Categoria</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Asisitente</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Fecha</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Estado</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Calificacion</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        ¿La pasaste mal Perri?</p>
                                </div>
                                <c:choose>
                                    <c:when test="${empty historial}">
                                        <div class="d-flex justify-content-center align-items-center"
                                             style="width: 100%; height: 24em">
                                            <h4>Todavía no realizaste ninguna contratación</h4>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${historial}" var="prestacion">
                                            <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                                <p class="my-auto" style="width:20%;">#${prestacion.id}</p>
                                                <p class="my-auto"
                                                   style="width:20%;">${prestacion.usuarioAsistente.especialidad.descripcion}</p>
                                                <p class="my-auto"
                                                   style="width:20%;">${prestacion.usuarioAsistente.nombre} ${prestacion.usuarioAsistente.apellido}</p>
                                                <p class="my-auto" style="width:20%;">11/23/22</p>
                                                <c:if test="${prestacion.estado=='activo'}">
                                                    <p class="ps-9 my-auto" style="width:20%;"><span
                                                            class="py-1 px-3 estadoFinalizado font-weight-bold redondeadoEstado">Activo</span>
                                                    </p>
                                                </c:if>
                                                <c:if test="${prestacion.estado=='finalizado'}">
                                                    <p class="ps-9 my-auto" style="width:20%;"><span
                                                            class="py-1 px-3 estadoActivo font-weight-bold redondeadoEstado">Finalizado</span>
                                                    </p>
                                                </c:if>
                                                <c:if test="${prestacion.estado=='cancelado'}">
                                                    <p class="ps-9 my-auto" style="width:20%;"><span
                                                            class="py-1 px-3 estadoCancelado font-weight-bold redondeadoEstado">Cancelado</span>
                                                    </p>
                                                </c:if>

                                                <c:if test="${prestacion.calificacionDadaPorElCliente==1}">
                                                    <p class="my-auto" style="width:20%;"><i
                                                            class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-muted"></i><i
                                                                class="fas fa-star text-muted"></i>
                                                        <i class="fas fa-star text-muted"></i><i
                                                                class="fas fa-star text-muted"></i></p>
                                                </c:if>
                                                <c:if test="${prestacion.calificacionDadaPorElCliente==2}">
                                                    <p class="my-auto" style="width:20%;"><i
                                                            class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-muted"></i>
                                                        <i class="fas fa-star text-muted"></i><i
                                                                class="fas fa-star text-muted"></i></p>
                                                </c:if>
                                                <c:if test="${prestacion.calificacionDadaPorElCliente==3}">
                                                    <p class="my-auto" style="width:20%;"><i
                                                            class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-muted"></i><i
                                                                class="fas fa-star text-muted"></i></p>
                                                </c:if>
                                                <c:if test="${prestacion.calificacionDadaPorElCliente==4}">
                                                    <p class="my-auto" style="width:20%;"><i
                                                            class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-muted"></i></p>
                                                </c:if>
                                                <c:if test="${prestacion.calificacionDadaPorElCliente==5}">
                                                    <p class="my-auto" style="width:20%;"><i
                                                            class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-warning"></i>
                                                        <i class="fas fa-star text-warning"></i><i
                                                                class="fas fa-star text-warning"></i></p>
                                                </c:if>
                                                <c:if test="${prestacion.calificacionDadaPorElCliente==null and prestacion.estado=='activo'}">

                                                    <%-- <form:form  class="" style="width:20%;" action="finalizarPrestacion" method="post" modelAttribute="prestacion">

                                                         <form:input type="hidden" path="id" id="id" value="${prestacion.id}"/>
                                                         <form:input type="hidden" path="estado" id="estado" value="${prestacion.estado}"/>

                                                     <button type="submit" class="my-auto py-1 px-3 finalizar font-weight-bold redondeadoEstado"
                                                             style="width:20%;"> Finalizar
                                                     </button>

                                                     </form:form>--%>
                                                    <a href="irADetallePrestacionFinalida?prestacion=${prestacion.id}"
                                                       class="my-auto py-1 px-3 finalizar font-weight-bold redondeadoEstado"
                                                       style="width:20%;"> Finalizar
                                                    </a>
                                                </c:if>

                                                <c:if test="${prestacion.calificacionDadaPorElCliente==null and prestacion.estado == 'finalizado'}">
                                                    <button class="my-auto py-1 px-3 calificar font-weight-bold redondeadoEstado "
                                                            data-bs-toggle="modal" data-bs-target="#exampleModal1"
                                                            style="width:20%;"> Calificar
                                                    </button>
                                                </c:if>

                                                <c:if test="${prestacion.calificacionDadaPorElCliente==null and prestacion.estado == 'cancelado'}">

                                                    <form:form style="width:20%;"
                                                               action="contratar-prestacion?asistente-id=${prestacion.usuarioAsistente.id}"
                                                               method="get">
                                                        <button class="my-auto py-1 px-3 calificar font-weight-bold redondeadoEstado w-100">
                                                            Calificar
                                                        </button>
                                                    </form:form>
                                                </c:if>
                                                <button class="my-auto py-1 px-3 denunciar font-weight-bold redondeadoEstado"
                                                        style="width:20%;"> Denunciar
                                                </button>
                                            </div>

                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <!-- Termina segundo boton-->
                    <!-- Empieza tercer boton-->
                    <div class="tab-pane" id="primary-tab-3" role="tabpanel">
                        <div class="row w-100 bg-info row w-100 h-100 m-auto justify-content-md-center px-2">
                            <div class="bg-white col-12 d-flex flex-column  p-2 mb-2 mt-2 align-items-center">
                                <h4 class="text-muted"> Proximamente...</h4>
                                <p class=" text-muted"><i class="fas fa-tools"></i> Estamos Trabajando para que quede
                                    bonito <i class="fas fa-tools"></i></p>
                            </div>
                        </div>
                    </div>
                    <!-- Termina tercer boton-->
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="page-footer font-small color-light bg-dark text-light">

    <div>
        <div class="container">

            <div class="col-md-6 col-lg-7 text-center text-md-right">

                <a class="fb-ic">
                    <i class="fab fa-facebook-f white-text mr-4"> </i>
                </a>

                <a class="tw-ic">
                    <i class="fab fa-twitter white-text mr-4"> </i>
                </a>

                <a class="gplus-ic">
                    <i class="fab fa-google-plus-g white-text mr-4"> </i>
                </a>

                <a class="li-ic">
                    <i class="fab fa-linkedin-in white-text mr-4"> </i>
                </a>

                <a class="ins-ic">
                    <i class="fab fa-instagram white-text"> </i>
                </a>

            </div>


        </div>

    </div>

    <div class="container text-center text-md-left mt-5">


        <div class="row mt-3">

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> calle Siempre viva 742, Springfield</p>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-envelope mr-3"></i> info@asegurapp.com</p>
            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-phone mr-3"></i> +011 4444-4444 </p>
            </div>

        </div>

        <div
                class="footer-copyright text-center py-3">© 2021 Copyright: AsegurAPP
        </div>

    </div>

</footer>
<c:if test="${not empty error}">
    <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="toast-error" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <strong class="me-auto">Error</strong>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
               ${error}
            </div>
        </div>
    </div>

    <script>
        window.onload = () => {
            let element = document.querySelector('#toast-error')
            let toast = new bootstrap.Toast(element)
            toast.show()
        }
    </script>

</c:if>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous">
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"
        integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous">
</script>
<script src="js/bootstrap.min.js"
        integrity="sha384-q2kxQ16AaE6UbzuKqyBE9/u/KzioAlnx2maXQHiDX9d4/zp8Ok3f+M7DPm+Ib6IU" crossorigin="anonymous">
</script>
<script src="js/popper.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj"
        crossorigin="anonymous"></script>

</body>

</html>
