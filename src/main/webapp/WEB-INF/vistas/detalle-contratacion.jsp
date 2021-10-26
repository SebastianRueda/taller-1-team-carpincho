<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
         <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
         <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="css/Login.css" rel="stylesheet">
        <title>Detalle de contratación</title>
    </head>

    <body class=" h-100">

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
                             <a class="nav-link" href="perfilUsuario">Perfil</a>
                         </li>
                         <li class="nav-item">
                            <a class="nav-link" href="perfilUsuario">Contrataciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="suscripcion">Suscripción</a>
                        </li>

                    </ul>
            </div>
        </div>
    </nav>
</header>


<div class=" h-100 w-100">
    <div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-centerfondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
        <c:choose>
            <c:when test="${not empty error}">
                <h4 class="text-white mt-5">${error}</h4>
            </c:when>
            <c:when test="${empty error}">
                <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-10 col-md-offset-3 col-sm-8 col-sm-offset-2">

                    <h1>Detalle de contratación</h1>
                    <div class="col-12 col-md-3 p-5 pb-0 p-md-1 bg-white rounded-3 mx-1">
                        <div class="card text-center" style="width: 18rem;">

                            <h5 class="card-title">Cliente</h5>
                            <P class="card-text">${prestacion.usuarioSolicitante.email}</P>
                            <h5 class="card-title">Asistente</h5>
                            <P class="card-text">${prestacion.usuarioAsistente.email}</P>
                            <h5 class="card-title" >Especialidad</h5>
                            <P class="card-text">${prestacion.especialidad.descripcion}</P>
                            <h5 class="card-title">Estado</h5>
                            <P class="card-text">${prestacion.estado}</P>

                            <%--@elvariable id="prestacion" type="ar.edu.unlam.tallerweb1.modelo.Prestacion"--%>
                            <form:form action="finalizarPrestacion" method="post" modelAttribute="prestacion">
                                <input type="number" path="id" id="id" value="${prestacion.id}" >
                                <input type="text" path="estado" id="estado" value="${prestacion.estado}" >

                                <p>${prestacion.id} </p>
                                <button type="submit" class="btn btn-primary">Pagar Suscripcion</button>
                            </form:form>


                        </div>
                    </div>
                </div>
            </c:when>
        </c:choose>
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
            <div class="footer-copyright text-center py-3">© 2021 Copyright: AsegurAPP
            </div>
        </div>

    </footer>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</body>
</html>
