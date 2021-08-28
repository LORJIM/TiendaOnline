<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Esto hay k ponerlo siempre k hagamos JSTL -->
<!DOCTYPE html>
<%
	String mensaje = (String) request.getAttribute("mensaje"); //AQUI RECOGEMOS LA CLAVE, EL STRING ENTRE PARENTESIS ES UN CAST, DONDE INFORMAMOS DE QUE ESTAMOS PASANDO UN DATO DE TIPO STRING
%>

<!--ATRIBUTO K VIENE DEL SERVLET Y NOS SIRVE PARA HACER LOS IF, MOSTRAR UNA TABLA U OTRA  -->
<html>
<head>

<meta charset="ISO-8859-1">
<title>CATEGORIAS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="CSS/util.css">
	<link rel="stylesheet" type="text/css" href="CSS/main.css">
<!--===============================================================================================-->
</head>
<body >
<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
 		<h5 align="center">LISTADO DE CATEGORIAS:</h5><br>
		<table class="table-bordered" align="center">
			<thead>
			<tr class="table100-head">
				<th style="width: 20%">Categorias</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="c" items="${categorias}">
				<tr>
					<td class="column1"><a href="S_Productos?idcategoria=${c.id_categoria}&descripcion=${c.descripcion}">${c.descripcion}</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<c:if test="${not empty mensaje}"> <!--lo mismo que en categoria original pero en JSTL, en esta linea comprueba que haya mensaje-->
	${mensaje} <!-- aqui lo imprime por pantalla -->
		<!-- forma alternativa de imprimirlo seria <c:out value="$(mensaje)"/> -->
	</c:if>
	</div>
			</div>
		</div>
	</div>
</body>
</html>