<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link href="css/Login.css" rel="stylesheet">
	<title>Exception Error</title>
</head>
<body >

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


<div class=" w-100">
	<div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-centerfondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
		<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-10 col-md-offset-3 col-sm-8 col-sm-offset-2">


			<div class="col-md-6 col-lg-6 mb-3 bg-danger d-none d-md-flex rounded-3 " style="margin-left: 17em;margin-right: 15em;margin-top:1em  ">
				<div class="card text-center text-white bg-danger mb-3">
					<div class="card-header"><i class="fas fa-exclamation-triangle"></i>Ocurrio un Error<i
							class="fas fa-exclamation-triangle"></i></div>
					<div class="card-body">
						<p class="card-text">${error}</p>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-lg-6 mb-3 bg-danger d-none d-md-flex rounded-3 " style="margin-left: 17em;margin-right: 15em;">
				<img src="imagenes/error.jpg" class="h-100 w-100 rounded-3" alt="">
			</div>



			<div class="text-center">
				<a href="traerEspecialidades" style="color:white" >${volver}</a>
			</div>
		</div>
		<br>
		<br>
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
		<div class="footer-copyright text-center py-3">� 2021 Copyright: AsegurAPP
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
