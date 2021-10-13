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
<header>
    <nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="login">AsegurApp</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="traerEspecialidades">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../vistas/perfilUsuario.jsp">Perfil</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="../vistas/detalles-contrataciones">Contrataciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="suscripcion">Suscripción</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div class="container-fluid mt-5 rounded-3">
    <div class="row w-100 bg-white m-auto p-2 justify-content-md-center" style="min-height: 500px; max-width: 1024px;">
        <div class="col-12 col-md-6 d-flex bg-white p-1 align-content-center justify-content-center">
            <div class="d-flex flex-column w-75  align-content-center justify-content-center flex-wrap text-center">
                <img src="perfil.png" alt="Foto Perfil" class="rounded-circle border border-5 border-primary"
                     width=150 height=150>
                <h3 class="mt-3">${usuarioEnSession.nombre} ${usuarioEnSession.apellido}</h3>
                <p class="text-muted m-0">${usuarioEnSession.email}</p>
                <p class="text-muted m-0">Argentino</p>
            </div>
        </div>
        <div class="col-12 col-md-6 bg-light mt-3">
            <div class="py-3">
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
        <div class="bg-success col-12 col-md-10 text-center text-white align-items-center py-1 mt-2" >
            <p class="m-0">${msgCancelacionExitosa}</p>
        </div>
        </c:if>

        <c:if test="${not empty msgCancelacionErronia}">
            <div class="bg-danger col-12 col-md-10 text-center text-white align-items-center py-1 mt-2" >
                <p class="m-0">${msgCancelacionErronia}</p>
            </div>
        </c:if>

        <div class="bg-light col-12 col-md-10 d-flex flex-column flex-md-row  p-2 mb-2 mt-3 align-items-center">
            <div class=" d-flex w-25 align-content-center justify-content-center flex-wrap">
                <i class="fas fa-khanda fa-6x"></i>
            </div>
            <div class=" d-flex flex-column ">
                <h6 class="mb-3 text-sm">Suscripcion Premium</h6>
                <span class="mb-2 text-xs">Fecha alta: <span
                        class="text-dark font-weight-bold ms-sm-2">20/07/2020</span></span>
                <span class="mb-2 text-xs">Precio: <span
                        class="text-dark ms-sm-2 font-weight-bold">$250</span></span>
                <span class="text-xs">Servicios: <span class="text-dark ms-sm-2 font-weight-bold"> <i
                        class="fas fa-wrench mr-2"></i>
                            <i class="fas fa-ambulance mr-2"></i>
                            <i class="fas fa-truck-pickup mr-2"></i>
                            <i class="fas fa-balance-scale-left mr-2"></i>
                            <i class="fas fa-people-arrows mr-2"></i>
                            <i class="fas fa-helicopter mr-2"></i></span></span>
            </div>

            <div class="text-end">
                    <p> mail: ${usuarioEnSession.email}</p>
                    <p> Suscripcion: ${usuarioEnSession.suscripcion.descripcion}</p>
                <form:form action="cancelarSuscripcion" method="POST">
                    <button type="submit" class="btn btn-link text-danger text-gradient px-3 mb-0">
                        <i class="far fa-trash-alt me-2" aria-hidden="true"></i>Dar Baja
                    </button>
                </form:form>

                <a class="btn btn-link text-dark px-3 mb-0" href="javascript:;"><i
                        class="fas fa-pencil-alt text-dark me-2" aria-hidden="true"></i>Cambiar</a>
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
    </div>


    <div class="container text-center text-md-left mt-5">


        <div class="row mt-3">


            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

                <h6 class="text-uppercase font-weight-bold">Acceso directo</h6>
                <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                <p>
                    <a href="#!">Login</a>
                </p>
                <p>
                    <a href="#!">Registro</a>
                </p>

                <p>
                    <a href="#!">Ayuda</a>
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
