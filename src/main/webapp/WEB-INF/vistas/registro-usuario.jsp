<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="css/Login.css" rel="stylesheet">
</head>
<body class=" h-100">
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
                        <a class="nav-link" href="login">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="ir-a-registrarme">Registrarte</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="mensajeErrorSuscripcion">Suscripción</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>



<div class=" h-100 w-100">
    <div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="card-body bg-light mb-3">
        <form:form action="registrarme" method="POST" modelAttribute="datos">
            <h3 class="card-title">Nuevo Usuario ${parametro}</h3>
            <hr class="colorgraph"><br>

            <form:label for="exampleInputEmail1" path="email" class="form-label"><i class="fas fa-envelope colorIconoLogin"></i> Ingrese su Mail </form:label>
            <form:input path="email" id="email"  type="email" class="form-control" />

            <form:label path="clave" class="form-label" for="exampleInputEmail1"><i class="fas fa-key colorIconoLogin"></i> Ingrese su Clave </form:label>
            <form:input path="clave" type="clave" id="clave" class="form-control"/>

            <form:label path="repiteClave" class="form-label" for="exampleInputEmail1"><i class="fas fa-key colorIconoLogin"></i> Repita su Clave </form:label>
            <form:input path="repiteClave" type="repiteClave" id="repiteClave" class="form-control"/>
            <br>
            <button id="btn-registrarme" class="fondo-login rounded-3 btn btn-primary border-0 w-100 shadow-sm " Type="Submit"/>Registrarme</button>
        </form:form>
            <br>
            <br>
            <a  href="login">Volver al inicio de Sesión</a>

        <c:if test="${not empty msg}">
            <h4><span>${msg}</span></h4>
            <br>
        </c:if>
         </div>
    </div>
    </div>
</div>

<footer class="page-footer font-small color-light bg-dark text-light">

    <div>
        <div class="container">

            <div class="col-md-12 col-lg-12 text-center text-md-right">

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
                    <a href="login">Login</a>
                </p>
                <p>
                    <a href="ir-a-registrarme">Registro</a>
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
        <div class="footer-copyright text-center py-3"> 2021 Copyright: AsegurAPP
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