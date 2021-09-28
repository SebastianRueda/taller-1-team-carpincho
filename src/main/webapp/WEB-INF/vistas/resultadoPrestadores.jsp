<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado Prestadores</title>
</head>
<body>
	<%-- <c:if test="${empty resultadoUsuarios}"> --%>
			<form action="usuarioElegido">
				<label for="listaUsuariosDisponibles">Seleccione Especialista</label> 
				<select name="listaUsuariosDisponibles">
					<c:forEach items="${resultadoUsuarios}" var="usuario">
						<option value="${usuario.id}">${usuario.nombre} &nbsp ${usuario.especialidad.descripcion} &nbsp ${usuario.email} </option>
					</c:forEach>
				</select>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Ver Detalle</button>
			</form>	
		<%-- </c:if> --%>
		
</body>
</html>