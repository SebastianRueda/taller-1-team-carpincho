<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<h1>Bienvenido a AsegurApp</h1>
		</div>
		<br>

		<div>
			<h2> Solicitar servicio de Grua</h2>
			<form:form action="contratar-prestacion" method="POST" modelAttribute="contratarPrestacion">

				<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
				<form:label path="descripcion" class="form-label"> Descripcion </form:label>
				<form:input path="descripcion" id="descripcion" type="descripcion" class="form-control" />
				<br>
				<br>
				<form:label path="especialidad" class="form-check"> Especialidad </form:label>
				<form:input path="especialidad" type="especialidad" id="especialidad" class="form-control"/>
				<br>
				<br>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Solicitar</button>
			</form:form>
		</div>



		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>