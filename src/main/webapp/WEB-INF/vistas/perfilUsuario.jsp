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
    <title>Document</title>
</head>

<body class="fondo-login ">

<!--<div class="container-fluid mt-5 rounded-3">
    <div class="row w-100 bg-light m-auto p-2 justify-content-md-center" style="min-height: 500px; max-width: 1024px;">
        <div class="col-12 col-md-6 d-flex bg-white p-1 align-content-center justify-content-center">
            <div class="d-flex align-items-center flex-column w-75  align-content-center justify-content-center flex-wrap text-center">
                <img src="imagenes/perfil.png" alt="Foto Perfil" class=""
                     width=150 height=150/>
                <h3 class="mt-3">${usuarioEnSession.nombre} ${usuarioEnSession.apellido}</h3>
                <p class="text-muted m-0">${usuarioEnSession.email}</p>
                <p class="text-muted m-0">Argentino</p>
            </div>
        </div>
        <div class="col-12 col-md-6 d-flex align-items-center bg-white ">
            <div class="w-100">
                <table class="table table-hover table-borderless mt-2">
                    <tbody>
                    <tr class="table-primary">
                        <th scope="row">
                            <spa class="text-muted fw-normal">Nombre</spa>
                        </th>
                        <td class="user-avatar fw-bold">${usuarioEnSession.nombre} ${usuarioEnSession.apellido}</td>
                    </tr>
                    <tr>
                        <th scope="row">
                            <spa class="text-muted fw-normal">Rol</spa>
                        </th>
                        <td class="user-avatar fw-bold">${usuarioEnSession.rol.descripcion}</td>
                    </tr>
                    <tr class="table-primary">
                        <th scope="row">
                            <spa class="text-muted fw-normal">Mail</spa>
                        </th>
                        <td class="user-avatar fw-bold">${usuarioEnSession.email}</td>
                    </tr>
                    <tr class="">
                        <th scope="row">
                            <spa class="text-muted fw-normal">Ciudad</spa>
                        </th>
                        <td class="user-avatar fw-bold">${usuarioEnSession.provincia.nombre}</td>
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

        <c:if test="${not empty msgCancelacionExitosa}">
            <div class="bg-success col-12 col-md-10 text-center text-white align-items-center py-1 mt-2">
                <p class="m-0">${msgCancelacionExitosa}</p>
            </div>
        </c:if>
        <c:if test="${not empty msgCancelacionErronia}">
            <div class="bg-danger col-12 col-md-10 text-center text-white align-items-center py-1 mt-2">
                <p class="m-0">${msgCancelacionErronia}</p>
            </div>
        </c:if>


        <div class="bg-white col-12 col-md-10 d-flex flex-column flex-md-row p-2 mb-2 mt-3 align-items-center justify-content-evenly">
            <c:choose>
                <c:when test="${not empty usuarioEnSession.suscripcion.id}">
                    <c:choose>
                        <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                            <div class=" d-flex w-25 align-content-center justify-content-center flex-wrap">
                                <i class="fas fa-shield-alt  fa-6x "></i>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class=" d-flex w-25 align-content-center justify-content-center flex-wrap">
                                <i class="fas fa-khanda fa-6x "></i>
                            </div>
                        </c:otherwise>
                    </c:choose>

                    <div class=" d-flex flex-column ">
                        <h6 class="mb-3 text-sm">${usuarioEnSession.suscripcion.descripcion}</h6>
                        <span class="mb-2 text-xs">Fecha alta: <span
                                class="text-dark font-weight-bold ms-sm-2">${usuarioEnSession.suscripcion.fechaAlta}</span></span>
                        <span class="mb-2 text-xs">Precio: <span
                                class="text-dark ms-sm-2 font-weight-bold">$${usuarioEnSession.suscripcion.precio}</span></span>
                        <span class="text-xs">Servicios: <span class="text-dark ms-sm-2 font-weight-bold">
                        <c:choose>
                            <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                <i class="fas fa-wrench mr-2"></i>
                                <i class="fas fa-ambulance mr-2"></i>
                                <i class="fas fa-truck-pickup mr-2"></i>
                            </c:when>
                            <c:otherwise>
                                <i class="fas fa-wrench mr-2"></i>
                                <i class="fas fa-ambulance mr-2"></i>
                                <i class="fas fa-truck-pickup mr-2"></i>
                                <i class="fas fa-balance-scale-left mr-2"></i>
                                <i class="fas fa-people-arrows mr-2"></i>
                                <i class="fas fa-helicopter mr-2"></i>
                            </c:otherwise>
                        </c:choose>
                    </span></span>

                    </div>

                    <div class="text-end">
                        <form:form action="cancelarSuscripcion" method="POST">
                            <button type="submit" class="btn btn-link text-danger text-gradient px-3 mb-0">
                                <i class="far fa-trash-alt me-2" aria-hidden="true"></i>Dar Baja
                            </button>
                        </form:form>
                        <c:choose>
                            <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                <form:form action="modificarSuscripcionBasicaUsuario" method="POST">
                                    <button type="submit" class="btn btn-link text-success text-gradient px-3 mb-0">
                                        <i class="far fa-arrow-alt-circle-up" aria-hidden="true"></i>UpGrade
                                    </button>
                                </form:form>
                            </c:when>
                            <c:otherwise>
                                <form:form action="modificarSuscripcionPremiumUsuario" method="POST">
                                    <button type="submit" class="btn btn-link text-warning text-gradient px-3 mb-0">
                                        <i class="far fa-arrow-alt-circle-down" aria-hidden="true"></i>DownGrade
                                    </button>
                                </form:form>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="fondo-login col-12 text-center text-white align-items-center py-1 mt-2">
                        <p class="m-0">¡No tienes Suscripcion! Puede contratar uno <a class="text-white"
                                                                                      href="suscripcion">aqui</a>
                        </p>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>-->

<div class="container-fluid  mt-5 rounded-3 ">
    <div class="row w-100 bg-light m-auto p-1 justify-content-md-center" style="max-width: 1024px;">
        <div class="col-12 px-1">
            <div class="tab tab-primary">
                <ul class="nav nav-pills nav-pills-sm nav-light mb-2"> <!-- empieza botones-->
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 active fw-bolder me-2"
                           data-bs-toggle="tab" href="#primary-tab-1">Mi Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2"
                           data-bs-toggle="tab" href="#primary-tab-2">Mis Contrataciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder"
                           data-bs-toggle="tab" href="#primary-tab-3">Algo</a>
                    </li>
                </ul><!-- Termina botones-->
                <div class="tab-content">
                    <!-- Empieza primer boton-->
                    <div class="tab-pane active" id="primary-tab-1" role="tabpanel">
                        <div class="row w-100 bg-light row w-100 h-100 m-auto justify-content-md-center">
                            <!--  empieza foto perfil-->
                            <div class="bg-danger col-12 col-md-6 d-flex bg-white align-content-center justify-content-center">
                                <div class="d-flex align-items-center flex-column w-75  align-content-center justify-content-center flex-wrap text-center">
                                    <img src="imagenes/perfil.png" alt="Foto Perfil" class="" width=150 height=150 />
                                    <h3 class="mt-3">${usuarioEnSession.nombre} ${usuarioEnSession.apellido}</h3>
                                    <p class="text-muted m-0">${usuarioEnSession.email}</p>
                                    <p class="text-muted m-0">Argentino</p>
                                </div>
                            </div>
                            <!-- termina foto perfil-->

                            <!-- empieza tabla-->
                            <div class="col-12 col-md-6 d-flex align-items-center bg-white ">
                                <div class="w-100">
                                    <table class="table table-hover table-borderless mt-2">
                                        <tbody>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Nombre</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.nombre}
                                                ${usuarioEnSession.apellido}</td>
                                        </tr>
                                        <tr>
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Rol</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.rol.descripcion}</td>
                                        </tr>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Mail</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.email}</td>
                                        </tr>
                                        <tr class="">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Ciudad</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.provincia.nombre}
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
                            <!--termina tabla-->

                            <!-- empieza suscripcion-->
                            <div class="bg-white col-12 col-md-10 d-flex flex-column flex-md-row p-2 mb-2 mt-3 align-items-center justify-content-evenly">
                                <c:choose>
                                    <c:when test="${not empty usuarioEnSession.suscripcion.id}">
                                        <c:choose>
                                            <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                                <div class=" d-flex w-25 align-content-center justify-content-center flex-wrap">
                                                    <i class="fas fa-shield-alt  fa-6x "></i>
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class=" d-flex w-25 align-content-center justify-content-center flex-wrap">
                                                    <i class="fas fa-khanda fa-6x "></i>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>

                                        <div class=" d-flex flex-column ">
                                            <h6 class="mb-3 text-sm">${usuarioEnSession.suscripcion.descripcion}</h6>
                                            <span class="mb-2 text-xs">Fecha alta: <span
                                                    class="text-dark font-weight-bold ms-sm-2">${usuarioEnSession.suscripcion.fechaAlta}</span></span>
                                            <span class="mb-2 text-xs">Precio: <span
                                                    class="text-dark ms-sm-2 font-weight-bold">$${usuarioEnSession.suscripcion.precio}</span></span>
                                            <span class="text-xs">Servicios: <span class="text-dark ms-sm-2 font-weight-bold">
                        <c:choose>
                            <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                <i class="fas fa-wrench mr-2"></i>
                                <i class="fas fa-ambulance mr-2"></i>
                                <i class="fas fa-truck-pickup mr-2"></i>
                            </c:when>
                            <c:otherwise>
                                <i class="fas fa-wrench mr-2"></i>
                                <i class="fas fa-ambulance mr-2"></i>
                                <i class="fas fa-truck-pickup mr-2"></i>
                                <i class="fas fa-balance-scale-left mr-2"></i>
                                <i class="fas fa-people-arrows mr-2"></i>
                                <i class="fas fa-helicopter mr-2"></i>
                            </c:otherwise>
                        </c:choose>
                    </span></span>

                                        </div>

                                        <div class="text-end">
                                            <form:form action="cancelarSuscripcion" method="POST">
                                                <button type="submit" class="btn btn-link text-danger text-gradient px-3 mb-0">
                                                    <i class="far fa-trash-alt me-2" aria-hidden="true"></i>Dar Baja
                                                </button>
                                            </form:form>
                                            <c:choose>
                                                <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                                    <form:form action="modificarSuscripcionBasicaUsuario" method="POST">
                                                        <button type="submit" class="btn btn-link text-success text-gradient px-3 mb-0">
                                                            <i class="far fa-arrow-alt-circle-up" aria-hidden="true"></i>UpGrade
                                                        </button>
                                                    </form:form>
                                                </c:when>
                                                <c:otherwise>
                                                    <form:form action="modificarSuscripcionPremiumUsuario" method="POST">
                                                        <button type="submit" class="btn btn-link text-warning text-gradient px-3 mb-0">
                                                            <i class="far fa-arrow-alt-circle-down" aria-hidden="true"></i>DownGrade
                                                        </button>
                                                    </form:form>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="fondo-login col-12 text-center text-white align-items-center py-1 mt-2">
                                            <p class="m-0">¡No tienes Suscripcion! Puede contratar uno <a class="text-white"
                                                                                                          href="suscripcion">aqui</a>
                                            </p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <!--termina suscripcion-->
                        </div>
                    </div>
                    <!-- Termina primer boton-->
                    <!-- Empieza segundo boton-->
                    <div class="tab-pane " id="primary-tab-2" role="tabpanel">
                        <div class="row w-100 bg-info row w-100 h-100 m-auto justify-content-md-center px-2">
                            <div class="bg-white col-12 d-flex flex-column p-2 mb-2 mt-2 align-items-center justify-content-evenly">
                                <h4 class="text-muted"> Proximamente...</h4>
                                <p class="text-muted"><i class="fas fa-tools"></i> Estamos Trabajando para que quede bonito <i class="fas fa-tools"></i></p>
                            </div>
                        </div>
                    </div>
                    <!-- Termina segundo boton-->
                    <!-- Empieza tercer boton-->
                    <div class="tab-pane" id="primary-tab-3" role="tabpanel">
                        <div class="row w-100 bg-info row w-100 h-100 m-auto justify-content-md-center px-2">
                            <div class="bg-white col-12 d-flex flex-column  p-2 mb-2 mt-2 align-items-center">
                                <h4 class="text-muted"> Proximamente...</h4>
                                <p class=" text-muted"><i class="fas fa-tools"></i> Estamos Trabajando para que quede bonito <i class="fas fa-tools"></i></p>
                            </div>
                        </div>
                    </div>
                    <!-- Termina tercer boton-->
                </div>
            </div>
        </div>
    </div>

</div>


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
