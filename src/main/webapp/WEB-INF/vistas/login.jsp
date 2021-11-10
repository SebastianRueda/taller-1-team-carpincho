<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <link href="css/Login.css" rel="stylesheet">
</head>
<body class=" h-100 w-100">
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
                        <a class="nav-link active" href="login">Login</a>
                    </li>				
                    <li class="nav-item">
                        <a class="nav-link" href="ir-a-registrarme">Registrarte</a>
                    </li>
                    <c:if test="${empty logueado}">
	                    <li class="nav-item">
	                        <a class="nav-link" href="mensajeErrorSuscripcion">Suscripción</a>
	                    </li>
	                </c:if> 
                    
                </ul>
            </div>
        </div>
    </nav>
</header>


<%--


	<div class=" h-100 w-100">
    <div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
<%--<h1>${idUsuario}</h1>
<h1>${emailUsuario}</h1>
<form:form action="validar-login" method="POST" modelAttribute="datosLogin">
<h3 class="form-signin-heading">Bienvenido a AsegurApp</h3>
<hr class="colorgraph"><br>

<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>

<%--<small style="color: white">No compartiremos tu correo electrónico</small>
<br>
<form:label path="password" class="form-label"> Contraseña </form:label>
<form:input path="password" type="password" id="password" class="form-control"/>
<br>
<br>
<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Iniciar sesión</button>
</form:form>
<br>
<br>
    <a style="color: white" href="ir-a-registrarme">Registrarme</a>
<%--Bloque que es visible si el elemento error no esta vacio	--%>
<%--<c:if test="${not empty error}">
    <h4><span>${error}</span></h4>
    <br>
</c:if>
${msg}
</div>
</div>
</div> --%>

<div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
    <div class="row p-0 shadow container-xl m-0 mt-5 h-75 ">
        <div class="col-12 col-md-6 bg-danger d-none d-md-flex rounded-3 p-0">
            <img class="h-100 w-100 rounded-3" src="imagenes/ge.jpg" alt="">
        </div>

        <div class="col-12 col-md-6 p-5 pb-0 p-md-1 bg-white rounded-3">
				
                <form:form class="m-5 mb-3" action="validar-login" method="POST" modelAttribute="datosLogin">
                <h2 class="text-center mb-lg-5">
                    Bienvenido a AsegurApp
                </h2>
                

                    <div class="mb-3 mt-5">
                        <!--<label for="exampleInputEmail1" class="form-label"><i class="fas fa-envelope"></i> Ingrese su Mail</label>
                        <input type="mail" class="form-control rounded-3" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Mail">-->
                        <form:label for="exampleInputEmail1" path="email" class="form-label"><i class="fas fa-envelope colorIconoLogin"></i> Ingrese su Mail </form:label>
                        <form:input path="email" id="email" type="email" class="form-control rounded-3" aria-describedby="emailHelp" placeholder="Mail"/>
                    </div>
                    <div class="mb-3">
                        <!--<label for="exampleInputEmail1" class="form-label">Ingrese su Clave</label>
                        <input type="email" class="form-control rounded-3" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Clave">-->
                        <form:label path="password" class="form-label" for="exampleInputEmail1"><i class="fas fa-key colorIconoLogin"></i> Ingrese su Clave </form:label>
                        <form:input path="password" type="password" id="password" class="form-control rounded-3" aria-describedby="emailHelp" placeholder="Clave"/>
                    </div>
                    <div class="mt-5">
                        <button class="fondo-login rounded-3 btn btn-primary border-0 w-100 shadow-sm ">
                            Login
                        </button>
                    </div>
                </form:form>
                <div class="text-center mt-4">
                <span class="text-">
                    Forgot
                </span>
                    <a class="text-center text-decoration-none text-dark fw-bold" href="#">
                        Username / Password?
                    </a>
                </div>
                <div class="mt-5 text-center ">
                    <a class="text-decoration-none text-dark" href="ir-a-registrarme">
                        Crea tu cuenta
                        <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                    </a>
                </div>

        </div>
    </div>
</div>

<c:if test="${not empty mensaje}">
					<h1>${mensaje}</h1>
				</c:if>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
