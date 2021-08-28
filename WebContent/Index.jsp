<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	String mensaje = (String) request.getAttribute("mensaje"); //AQUI RECOGEMOS LA CLAVE, EL STRING ENTRE PARENTESIS ES UN CAST, DONDE INFORMAMOS DE QUE ESTAMOS PASANDO UN DATO DE TIPO STRING
%>
<html>
<head>
<style type="text/css">
.adiv {
	margin: 0;
	position: absolute;
	top: 50%;
	left: 50%;
	-ms-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}
</style>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<%
		String usuario = "";
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie aux = cookies[i];
				if (aux.getName().equals("usuario")) {
					usuario = aux.getValue();
				}
			}
		}
	%>
	<div class="adiv">
		<form id="login" name="login" align="center" method="get"
			action="S_Login">
			<div class="form-group">
				Usuario:<input type="text" name="usuario" required="required"
					value='<%=usuario%>' /><br>
			</div>
			<div class="form-group">
				Password:<input type="password" name="password" required="required" /><br>
			</div>
			Recuérdame para este equipo<input type="radio" name="recordar"
				value="recordar"> <input class="btn btn-secondary"
				type="submit" name="entrar" value="entrar" />
		</form>
			<button class="btn btn-primary"
				onclick="location.href='Registro.jsp'" type="button">Registrarse</button>
		<c:if test="${not empty mensaje}">
			<!--lo mismo que en categoria original pero en JSTL, en esta linea comprueba que haya mensaje-->
	${mensaje} <!-- aqui lo imprime por pantalla -->
			<!-- forma alternativa de imprimirlo seria <c:out value="$(mensaje)"/> -->
		</c:if>
	</div>
</body>
</html>