<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Busqueda Prestadores</title>
	</head>
	<body>
		<h1>Bienvenido Usuario</h1>
			<form action="especialidadElegida" >
				<label for="listaEspecialidadDesplegable">Seleccione Servicio</label> 
				<select name="listaEspecialidadDesplegable">
					<c:forEach items="${especialidades}" var="especialidad">
						<option value="${especialidad.id}">${especialidad.descripcion}</option>
					</c:forEach>
				</select>
				<label for="listaProvinciaDesplegable">Seleccione Provincia</label> 
				<select name="listaProvinciaDesplegable">
					<c:forEach items="${provincias}" var="provincia">
						<option value="${provincia.id}">${provincia.nombre}</option>
					</c:forEach>
				</select>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
			</form>
			
	</body>
</html>