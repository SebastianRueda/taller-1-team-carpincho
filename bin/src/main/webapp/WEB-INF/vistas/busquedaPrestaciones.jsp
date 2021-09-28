<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Busqueda Prestaciones</title>
	</head>
	<body>
		
		<h1>Bienvenido Usuario</h1>
	<c:if test="${empty prestaciones}">
		<form action="subcategoriaElegida">
			<label for="listaSubCategoriaDesplegable">Seleccione
				categoria</label> <select name="listaSubCategoriaDesplegable">
				<c:forEach items="${subcategorias}" var="subcategoria">
					<option value="${subcategoria.codigo}">${subcategoria.descripcion}</option>
				</c:forEach>
			</select>
			<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
		</form>
	</c:if>
	<c:if test="${not empty productosDeLaSubcategoria}">
		<form action="guardarProductoNuevo">
			<label for="listaProductosDesplegable">Seleccione producto: </label>
			<select name="listaProductosDesplegable">
				<c:forEach items="${productosDeLaSubcategoria}"
					var="productosubcategoria">
					<option value="${productosubcategoria}">${productosubcategoria.descripcion}</option>
				</c:forEach>
			</select>
			<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
		</form>
	</c:if>
		
		<%-- <c:if test="${empty especialidad}">
			<form:form action="busquedaPrestaciones">
				<label for="seleccionarEspecialidad">Indique la especialidad</label>
				<select name="seleccionarEspecialidad">
					<option value="grua">grua</option>
					<option value="chofer">chofer</option>
					<option value="mecanico">mecanico</option>
				</select>
				<button class="btn btn-lg btn-primary btn-block" Type="Submit">Confirmar</button>
			</form:form>
		</c:if> --%>
	</body>
</html>