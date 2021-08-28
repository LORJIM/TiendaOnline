<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String mensaje = (String) request.getAttribute("mensaje"); //AQUI RECOGEMOS LA CLAVE, EL STRING ENTRE PARENTESIS ES UN CAST, DONDE INFORMAMOS DE QUE ESTAMOS PASANDO UN DATO DE TIPO STRING
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="JS/Registro.js"></script>
</head>
<body>
	<form id="registro" name="registro" method="get" action="S_Registro" align="center">
	<h5 align="center">Usuario</h5>
	<div class="form-group" align="center">
		<input type="text" name="usuario" required="required" value="${usuario.usuario}"/><br>
		</div>
		<h5 align="center">Password</h5>
		<div class="form-group" align="center">
		<input type="password" name="password" required="required" /><br>
		</div>
		<h5 align="center">Repetir password</h5>
		<div class="form-group" align="center">
	
		<input type="password" name="password2" required="required" /><br>
		</div>
		<h5 align="center">Email</h5>
		<div class="form-group" align="center">
		<input type="email" id="email" name="email"
			pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2, 3}$"
			required="required" value="${usuario.email}"> <br> 
			</div>
			<input type="submit" name="registrar" value="registrar" onClick="return validarFormulario();"/>
			<input type="button"
class="botonNegativo" value="Reiniciar"
onClick="reiniciarFormulario();">
	</form>
	<c:if test="${not empty mensaje}">
		<!--lo mismo que en categoria original pero en JSTL, en esta linea comprueba que haya mensaje-->
	${mensaje} <!-- aqui lo imprime por pantalla -->
		<!-- forma alternativa de imprimirlo seria <c:out value="$(mensaje)"/> -->
	</c:if>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>