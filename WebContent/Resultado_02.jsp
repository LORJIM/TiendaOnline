<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String option = (String) request.getAttribute("option");
%>
<!--ATRIBUTO K VIENE DEL SERVLET Y NOS SIRVE PARA HACER LOS IF, MOSTRAR UNA TABLA U OTRA  -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado Listado</title>
</head>
<body>
	<c:if test="${option==1 }">
	LISTADO DE USUARIOS:
	<table border="1">
			<tr>
				<th>Nombre Usuario</th>
				<th>Contraseña</th>
				<th>Email</th>
			</tr>
			<c:forEach var="u" items="${usuarios}">
				<!-- LLAVES JAIME LLAVES EN JSTL SIEMPRE LLAVES -->
				<!-- Esto es un for each mediante JSTL, siendo u cada elemento y usuarios el array que recorro y me viene del servlet-->
				<tr>
					<td>${u.usuario}</td>
					<!-- con llamar a los atributos, los getters y setters se hacen automaticamente -->
					<td>${u.password}</td>
					<td>${u.email}</td>
					<td><button><a href="S_Borrar?usuario=${u.usuario}">Eliminar</a></button></td>
				</tr>

			</c:forEach>
		</table>
	</c:if>
	<c:if test="${option==2 }">
	LISTADO DE PRODUCTOS:
		<table border="1">
			<tr>
				<th>ID Producto</th>
				<th>Descripcion</th>
				<th>ID Categoria</th>
				<th>Precio</th>
				<th>Stock</th>
			</tr>
			<c:forEach var="p" items="${productos}">
				<tr>
					<td>${p.id_producto}</td>
					<td>${p.descripcion}</td>
					<td>${p.id_categoria}</td>
					<td>${p.precio}</td>
					<td>${p.stock}</td>
						<td><button>
							<a href="S_Borrar?idproducto=${p.id_producto}">Eliminar</a></button></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>