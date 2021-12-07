<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">

		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
			  integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="css/Login.css" rel="stylesheet">

	<title>Generar Denuncia</title>
	</head>

	<body class=" h-100">
	<header>
		<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" href="home">AsegurApp</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item">
							<a class="nav-link" aria-current="page" href="home">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="traerEspecialidades">Contratar</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="perfilUsuario">Perfil</a>
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

	<div class=" h-100 w-100">
		<div class="fondo-login container-fluid px-2 h-100 w-100 d-flex justify-content-center">
			<div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="card-body bg-white mb-3">
					<div class="text-center text-decoration-none text-dark fw-bold">
						<h3>Realizar denuncia</h3><br>
					</div>
				<form:form action="denunciaRealizada" method="post" modelAttribute="denunciaRequest">
				<form:input path="prestacionId" name="prestacionId" value="${prestacionId}" cssStyle="display: none" />
				<label class="card-text  fw-bold" for="listaPrestaciones">Estás denunciando a:</label>
				${asistente.nombre} ${asistente.apellido}

				<form:input path="clienteId" name="clienteId" value="${usuarioEnSession.id}" cssStyle="display: none" />
				<form:input path="asistenteId" name="asistenteId" value="${asistente.id}" cssStyle="display: none"/>
					<br>
					<br>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 700px">
					<br>
					<label class="card-text fw-bold" for="listaEspecialidadDesplegable">Seleccione motivo:</label>
					<form:select path="motivoId" name="motivoDenuncia">
						<c:forEach items="${motivoDenuncias}" var="motivoDenuncias">

							<option value="${motivoDenuncias.id}">${motivoDenuncias.descripcion}</option>
						</c:forEach>
					</form:select>
					<br>
					<br>
					<hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 700px">
					<br>
					<br>
					<label style="font-weight: bold">Comentanos lo ocurrido </label>
					<br>
					<br>
					<div style="align-content: center">
					<form:textarea path="comentario" name="comentario" rows="4" cols="50" />
					</div>
					<br>
					<button class=" btn btn-dark border-0 " Type="submit"  >Confirmar</button>
					</form:form>
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
			<div class="footer-copyright text-center py-3">ï¿½ 2021 Copyright: AsegurAPP
			</div>
		</div>

	</footer>


	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>


	</body>
</html>