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
<div class="container-fluid  mt-5 rounded-3 ">
    <div class="row w-100 bg-light m-auto p-1 justify-content-md-center" style="max-width: 1250px;">
        <div class="col-12 px-1">
            <div class="tab tab-primary">
                <ul class="nav nav-pills nav-pills-sm nav-light mb-2"> <!-- empieza botones-->
                    <li class="nav-item">
                        <a class="nav-link btn btn-active-light btn-color-muted py-2 px-4 fw-bolder me-2 ${seccion.equals("perfil") ? "active" : ""}"
                           href="perfilUsuario">Perfil de Asistente</a>
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
                                    <h3 class="mt-3">${asistente.nombre} ${asistente.apellido}</h3>
                                    <p class="text-muted m-0">${asistente.email}</p>
                                    <p class="text-muted m-0">Argentino</p>

                                    <c:if test="${usuarioLogueado}">
                                        <c:if test="${esFavorito}">
                                            <form:form action="removerFavorito" method="post" modelAttribute="irAsistentePerfilRequest" cssClass="btn btn-danger mt-4">
                                                <form:input path="asistenteId" id="asistenteId" type="text" value="${asistente.id}" cssStyle="display: none" />
                                                <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Remover Favoritos</button>
                                            </form:form>
                                        </c:if>
                                        <c:if test="${esFavorito == false}">
                                            <form:form action="adherirFavorito" method="post" modelAttribute="irAsistentePerfilRequest" cssClass="btn btn-primary mt-4">
                                                <form:input path="asistenteId" id="asistenteId" type="text" value="${asistente.id}" cssStyle="display: none" />
                                                <button type="submit" class="text-white btn btn-link text-decoration-none" style="padding: 0">Agregar a favoritos</button>
                                            </form:form>
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
                            <c:if test="${promedio >= 0}">
                                <p>Promedio De Calificacion: ${promedio}</p>
                            </c:if>
                        </div>
                    </div>
                    <!-- Termina primer boton -->
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
