<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
    <title>Perfil Usuario</title>
</head>

<body class="fondo-login" >

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
                        <a class="nav-link" aria-current="page" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="traerEspecialidades">Contratar</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="perfilUsuario">Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="suscripcion">Suscripción</a>
                    </li>
                    &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
						&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp
                    <form:form action="cerrarSesion" method="POST">              
               			<button>
                   			cerrarSesion
               			</button>
           			</form:form>
                </ul>
            </div>
        </div>
    </nav>
</header>



<div class=" h-100 w-100" >
<div  class="fondo-login container-fluid mt-5 px-2 h-100 w-100 d-flex justify-content-centerfondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
    <div class="row h-100 w-100 bg-light m-auto p-1 justify-content-md-center mb-5" style="max-width: 1250px;">
        <div class="col-12 px-1 ">
            <div class="tab tab-primary">
                <ul class="nav nav-pills nav-pills-sm nav-light mb-2"> <!-- empieza botones-->
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("perfil") ? "active" : ""}"
                           href="perfilUsuario">Mi Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("historial") ? "active" : ""}"
                           href="mostrar-historial">Mis Contrataciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("historialDenuncias") ? "active" : ""}"
                           href="mostrar-denuncias" >Mis Denuncias</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("favoritos") ? "active" : ""}"
                           href="mostrar-favoritos">Mis Favoritos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder"
                           data-bs-toggle="tab" href="#primary-tab-4">Algo</a>
                    </li>
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
                                    <h3 class="mt-3">${usuarioEnSession.nombre} ${usuarioEnSession.apellido}</h3>
                                    <p class="text-muted m-0">${usuarioEnSession.email}</p>
                                    <p class="text-muted m-0">Argentino</p>
                                    <p class="text-muted m-0">Promedio De Calificacion: ${promedio}</p>
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
                                                </td>
                                        </tr>
                                        <tr>
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Apellido</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.apellido}</td>
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
                                                <spa class="text-muted fw-normal">Fecha Alta Suscripcion</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.fechaAltaSuscripcion}</td>
                                        </tr>
                                        <tr class="">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Estado de Suscripcion</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">
                                                <c:if test="${usuarioEnSession.estadoSuscripcion==true}">
                                                    activo
                                                    (${usuarioEnSession.cantidadDediasVencimientoSuscripcion} dias restantes)
                                                </c:if>
                                                <c:if test="${usuarioEnSession.estadoSuscripcion==false}">
                                                    inactivo
                                                    (${usuarioEnSession.cantidadDediasVencimientoSuscripcion} dias restantes)
                                                </c:if>

                                            </td>
                                        </tr>
                                        <tr class="table-primary">
                                            <th scope="row">
                                                <spa class="text-muted fw-normal">Fecha Baja Suscripcion</spa>
                                            </th>
                                            <td class="user-avatar fw-bold">${usuarioEnSession.fechaBajaSuscripcion}</td>
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
                                            <span class="text-xs">Servicios: <span
                                                    class="text-dark ms-sm-2 font-weight-bold">
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

                                        <div class="text-center d-flex flex-column justify-content-center align-content-center">
                                            <c:if test="${usuarioEnSession.estadoSuscripcion == false }">
                                                <!--   <div class="m-auto">
                                                    <p>Cancelaste la suscripcion,<br> puede aprovechar los servicios hasta <br> ${usuarioEnSession.fechaBajaSuscripcion} </p>
                                                    <p class="m-0">Volve a contratar una suscripcion
                                                        <a class="text-white" href="suscripcion">aqui</a>
                                                    </p>
                                                </div>-->
                                                <div style="max-width: 200px">
                                                    <p>Cancelaste la suscripcion,<br> puede aprovechar los servicios hasta <br> ${usuarioEnSession.fechaBajaSuscripcion} </p>
                                                </div>

                                                <div class="fondo-login col-12 text-center text-white align-items-center py-1 mt-2" style="max-width: 200px">
                                                    <p class="m-0"> Puede volver a contratar una nueva suscripcion desde
                                                        <a class="text-white" href="suscripcion">aqui                       </a>
                                                    </p>
                                                </div>
                                            </c:if>
                                            <c:if test="${usuarioEnSession.estadoSuscripcion == true }">
                                                <!-- CANCELAR-->
                                                <form:form action="cancelarSuscripcion" method="POST">
                                                    <button type="button" class="btn btn-link text-danger text-gradient px-3 mb-0 " data-bs-toggle="modal" data-bs-target="#exampleModalDarBaja">
                                                        <i class="far fa-trash-alt me-2" aria-hidden="true"></i>Dar Baja
                                                    </button>

                                                    <div class="modal fade" id="exampleModalDarBaja" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <div class="modal-content">
                                                                <div class="modal-header">
                                                                    <h5 class="modal-title"
                                                                        id="exampleModalLabel" style="text-align: center">Cancelar Suscripción</h5>
                                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                </div>
                                                                <div class="modal-body">
                                                                    <div class="mb-5 mt-5 text-center">
                                                                        <div class="modal-body ">
                                                                            <p>Estas por cancelar tu suscripción, ¿Queres continuar?</p>
                                                                        </div>
                                                                    </div>
                                                                    <div class="modal-footer">
                                                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                            Cancelar
                                                                        </button>
                                                                    <button type="submit" class="btn btn-primary">Cancelar Suscripción</button>


                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>

                                                </div>
                                            </form:form>
                                            <c:choose>
                                                <c:when test="${usuarioEnSession.suscripcion.descripcion=='suscripcion basica'}">
                                                    <form:form action="modificarSuscripcionBasicaUsuario" method="POST">
                                                        <button type="button" class="btn btn-link text-success text-gradient px-3 mb-0 " data-bs-toggle="modal" data-bs-target="#exampleModalUpGrade">
                                                            <i class="far fa-arrow-alt-circle-up" aria-hidden="true"></i>UpGrade
                                                        </button>
                                                        <div class="modal fade" id="exampleModalUpGrade" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title"
                                                                            id="exampleModalLabel" style="text-align: center">Upgradear suscripción</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <div class="mb-5 mt-5 text-center">
                                                                            <div class="modal-body ">
                                                                                <p>Estas por modificar las condiciones de tu suscripción Basica, ¿Queres continuar?</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                                Cancelar
                                                                            </button>

                                                                            <button type="submit" class="btn btn-primary">Upgradear Suscripción</button>


                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>

                                                        </form:form>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!-- PREMIUM A BASICA-->
                                                        <button type="button" class="btn btn-link text-warning text-gradient px-3 mb-0" data-bs-toggle="modal" data-bs-target="#exampleModal222">
                                                            <i class="far fa-arrow-alt-circle-down" aria-hidden="true"></i>DownGrade
                                                        </button>

                                                        <div class="modal fade" id="exampleModal222" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                            <div class="modal-dialog">
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <h5 class="modal-title"
                                                                            id="exampleModalLabel" style="text-align: center">DownGrade</h5>
                                                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                                    </div>
                                                                    <div class="modal-body">
                                                                        <div class="mb-5 mt-5 text-center">
                                                                            <div class="modal-body ">
                                                                                <p>¿No contas con los recursos para la suscripcion Premium?</p>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer">
                                                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                                                                                Cancelar
                                                                            </button>

                                                                                <form:form action="modificarSuscripcionPremiumUsuario" method="POST">
                                                                                <button type="submit" class="btn btn-primary">Bajar a Suscripcion Basica</button>
                                                                                </form:form>

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>

                                                    </c:otherwise>
                                                </c:choose>
                                                <button type="button" class="btn btn-primary text-white text-gradient px-3 mb-0 " >
                                                    <a class="text-white" href="irDetalleAFactura">Ver Factura </a>
                                                </button>
                                            </c:if>

                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="fondo-login col-12 text-center text-white align-items-center py-1 mt-2">
                                            <p class="m-0">¡No tiene Suscripcion! Puede contratar una
                                                <a class="text-white" href="suscripcion">aqui</a>
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
                    <div class="tab-pane ${seccion.equals("historial") ? "active" : ""}" id="primary-tab-2"
                         role="tabpanel">
                        <div class="row w-100 h-100 m-auto justify-content-md-center">

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
                                        ¿Tuviste algun inconveniente?</p>
                                </div>
                                <c:choose>
                                    <c:when test="${empty historial}">
                                        <div class="d-flex justify-content-center align-items-center" style="width: 100%; height: 24em">
                                            <h4>Todavía no realizaste ninguna contratación</h4>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${historial}" var="prestacion">
                                            <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                                <p class="my-auto" style="width:20%;">#${prestacion.id}</p>
                                                <p class="my-auto"
                                                   style="width:20%;">${prestacion.usuarioAsistente.especialidad.descripcion}</p>
                                                <a class="my-auto" href="asistentePerfil?asistente-id=${prestacion.usuarioAsistente.id}"
                                                   style="width:20%;">${prestacion.usuarioAsistente.nombre} ${prestacion.usuarioAsistente.apellido}</a>
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
                                                    <a href="irADetallePrestacionFinalida?prestacion=${prestacion.id}" class="my-auto py-1 px-3 finalizar font-weight-bold redondeadoEstado text-decoration-none text-center" style="width:20%;">
                                                        Finalizar
                                                    </a>
                                                </c:if>

                                                <c:if test="${prestacion.calificacionDadaPorElCliente==null and prestacion.estado == 'finalizado'}">
                                                    <a href="irADetallePrestacionFinalida?prestacion=${prestacion.id}" class="my-auto py-1 px-3 finalizar font-weight-bold redondeadoEstado text-decoration-none text-center"
                                                       style="width:20%;"> Calificar
                                                    </a>
                                                </c:if>

                                                <c:if test="${prestacion.calificacionDadaPorElCliente==null and prestacion.estado == 'cancelado'}">


                                                    <a href="irADetallePrestacionFinalida?prestacion=${prestacion.id}" class="my-auto py-1 px-3 finalizar font-weight-bold redondeadoEstado text-decoration-none text-center"
                                                       style="width:20%;"> Calificar
                                                    </a>
                                                </c:if>
                                                <a href="denunciarAsistente?prestacion-id=${prestacion.id}" class="my-auto py-1 px-3 denunciar font-weight-bold redondeadoEstado" style="width:20%;"   >Denunciar</a>
                                            </div>

                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <!-- Termina segundo boton-->
                    <!-- Favoritos -->
                    <div class="tab-pane ${seccion.equals("favoritos") ? "active" : ""}" id="primary-tab-4"
                         role="tabpanel">
                        <div class="row w-100 h-100 m-auto justify-content-md-center">

                            <div class="col-12 p-2 ">
                                <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">Asistente</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">Servicio</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">Mail</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">Remover</p>
                                </div>
                                <c:choose>
                                    <c:when test="${empty favoritos}">
                                        <div class="d-flex justify-content-center align-items-center" style="width: 100%; height: 24em">
                                            <h4>Todavía no tenés asistentes favoritos</h4>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${favoritos}" var="favorito">
                                            <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                                <p class="my-auto" style="width:20%;">${favorito.asistente.fullName()}</p>
                                                <p class="my-auto" style="width:20%;">${favorito.asistente.especialidad.descripcion}</p>
                                                <p class="my-auto" style="width:20%;">${favorito.asistente.email}</p>

                                                <form:form action="removerFavoritoUsuarioPerfil" method="post" modelAttribute="agregarRemoverAsistenteFavoritoRequest" cssClass="btn btn-danger mt-4">
                                                    <form:input path="asistenteId" id="asistenteId" type="text" value="${favorito.asistente.id}" cssStyle="display: none" />
                                                    <%--<input path="asistenteId" id="asistenteId" type="number" hidden value="${asistente.id}">--%>
                                                    <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Remover Favoritos</button>
                                                </form:form>
                                            </div>

                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                    <!-- Favoritos -->
                    <!-- Empieza tercer boton-->
                    <div class="tab-pane ${seccion.equals("historialDenuncias") ? "active" : ""}" id="primary-tab-3"
                         role="tabpanel">
                        <div class="row w-100 h-100 m-auto justify-content-md-center">
                            <div class="col-12 p-2 ">
                                <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">N°
                                        Denuncia</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Servicio</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Usuario Denunciado</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Motivo De la Denuncia</p>
                                    <p class="text-uppercase text-muted font-weight-bold my-auto" style="width:20%;">
                                        Detalles de la Denuncia</p>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${empty listaDenunciasHechas}">
                                    <div class="d-flex justify-content-center align-items-center" style="width: 100%; height: 24em">
                                        <h4>No tenés ninguna denuncia realizada</h4>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${listaDenunciasHechas}" var="denunciaHechas">
                                        <div class="w-100 sombra d-flex rounded-3 p-2 bg-white mt-3 justify-content-around">
                                            <p class="my-auto" style="width:20%;">N° ${denunciaHechas.id}</p>
                                            <p class="my-auto"
                                               style="width:20%;">${denunciaHechas.usuarioDenunciado.especialidad.descripcion}</p>
                                            <p class="my-auto"
                                               style="width:20%;">${denunciaHechas.usuarioDenunciado.nombre} ${denunciaHechas.usuarioDenunciado.apellido}</p>
                                            <p class="my-auto" style="width:20%;">${denunciaHechas.motivoDenuncia.descripcion}</p>

                                            <form:form action="detalleDenunciaRealizada" method="post" modelAttribute="denunciaDetalleRequest" cssClass="btn btn-danger mt-4">
                                                <form:input path="denunciaId" id="denunciaId" type="text" value="${denunciaHechas.id}" cssStyle="display: none" />
                                                <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Ver Detalles</button>
                                            </form:form>

                                        </div>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <!-- Termina tercer boton-->
                    <!-- Empieza cuarto boton-->
                    <div class="tab-pane" id="primary-tab-4" role="tabpanel">
                        <div class="row h-100 w-100 bg-info row w-100 h-100 m-auto justify-content-md-center px-2">
                            <div class="bg-white col-12 d-flex flex-column  p-2 mb-2 mt-2 align-items-center">
                                <h4 class="text-muted"> Proximamente...</h4>
                                <p class=" text-muted"><i class="fas fa-tools"></i> Estamos Trabajando para que quede
                                    bonito <i class="fas fa-tools"></i></p>

                            </div>
                        </div>
                    </div>
                    <!-- Termina cuarto boton-->
                </div>
            </div>
        </div>
</div>
</div>
</div>

<footer class="page-footer font-small color-light bg-dark text-light mt-5">

    <div>
        <div class="container">

            <div class="col-md-6 col-lg-7 text-center text-md-right">

                <a class="fb-ic" href="https://www.facebook.com"/>
                    <i class="fab fa-facebook-f white-text mr-4"> </i>
                </a>

                <a class="tw-ic" href="https://twitter.com"/>
                    <i class="fab fa-twitter white-text mr-4"> </i>
                </a>

                <a class="gplus-ic" href="https://www.google.com.ar"/>
                    <i class="fab fa-google-plus-g white-text mr-4"> </i>
                </a>

                <a class="li-ic" href="https://www.linkedin.com"/>
                    <i class="fab fa-linkedin-in white-text mr-4"  > </i>
                </a>

                <a class="ins-ic"  href="https://www.instagram.com"/>
                    <i class="fab fa-instagram white-text"> </i>
                </a>

            </div>


        </div>

    </div>
    </div>


    <div class="container text-center text-md-left mt-5">


        <div class="row mt-3">


            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                <h6 class="text-uppercase font-weight-bold">Acceso directo</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a href="login">Login</a>
                </p>
                <p>
                    <a href="ir-a-registrarme">Registro</a>
                </p>

                <p>
                    <a href="home">Ayuda</a>
                </p>

            </div>

            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                <h6 class="text-uppercase font-weight-bold">Contacto</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <i class="fas fa-home mr-3"></i> calle Siempre viva 742, Springfield</p>
                <p>
                    <i class="fas fa-envelope mr-3"></i> info@asegurapp.com</p>
                <p>
                    <i class="fas fa-phone mr-3"></i> +011 4444-4444 </p>

            </div>

        </div>
        <div class="footer-copyright text-center py-3">� 2021 Copyright: AsegurAPP
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
