<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Esto hay k ponerlo siempre k hagamos JSTL -->
<!DOCTYPE html>

<html>
<head>

<meta charset="ISO-8859-1">
<title>PRODUCTOS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<body>
<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
	<h5 align="center">LISTADO DE PRODUCTOS<br>CATEGORIA:${descripcion}</h5><br>
		<table>
		<thead>
			<tr class="table100-head">
				<th class="column1" style="width: 20%">Descripcion</th>
				<th class="column2" style="width: 20%">Precio</th>
				<th class="column3" style="width: 20%">Stock</th>
				<th class="column4" style="width: 20%">Añadir al carrito</th>
			</tr>
		</thead>
			<c:forEach var="p" items="${productos}">
				<tr>
					<td class="column1">${p.descripcion}</td>
					<td class="column2">${p.precio}</td>
					<td class="column3">${p.stock}</td>
						<td class="column4"><button>
							<a href="S_AddCarrito?idproducto=${p.id_producto}&descripcion=${p.descripcion}&precio=${p.precio}">ADD CARRITO</a></button></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			<h5 align="center"><button onclick="location.href='Carrito.jsp'" class="btn btn-success">VER CARRITO</button></h5>
			<h5 align="center"><button onclick="location.href='Categorias.jsp'" class="btn btn-primary">ATRAS</button></h5>
			</div>
			</div>
		</div>
		
			
	</div>
</body>
</html>