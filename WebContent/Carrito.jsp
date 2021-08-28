<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Esto hay k ponerlo siempre k hagamos JSTL -->
<!DOCTYPE html>

<html>
<head>

<meta charset="ISO-8859-1">
<title>CARRITO</title>
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
				<div class="table100">Tu Carrito<br><br>
		<table>
		<thead>
			<tr class="table100-head">
				<th class="column1" style="width: 20%">ID</th>
				<th class="column2" style="width: 20%">Nombre</th>
				<th class="column3" style="width: 20%">Precio</th>
				<th class="column4" style="width: 20%">Cantidad</th>
				<th class="column5" style="width: 20%">Añadir uno</th>
				<th class="column6" style="width: 20%">Eliminar uno</th>
				<th class="column7" style="width: 20%">Eliminar</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="p" items="${carrito}"> <!-- NO ME LLEGA EL PRODUCTOOOOOOOOOO -->
				<tr>
					<td class="column1">${p.id_producto}</td>
					<td class="column2">${p.descripcion}</td>
					<td class="column3">${p.precio}</td>
					<td class="column4">${p.cantidad}</td>
					<td class="column5"><button><a href="S_Borrar?id_producto=${p.id_producto}&accion=1">+</a></button></td>
					<td class="column6"><button><a href="S_Borrar?id_producto=${p.id_producto}&accion=2">-</a></button></td>
					<td class="column7"><button><a href="S_Borrar?id_producto=${p.id_producto}&accion=3">Eliminar</a></button></td>
						</tr>
			
			</c:forEach>
			</tbody>
			</table>
			<h5 align="center">TOTAL:${total}</h5><br>
			<h5 align="center"><button class="btn btn-primary" onclick="location.href='Productos.jsp'">ATRAS</button></h5>
			<h5 align="center"><button class="btn btn-danger" onclick="location.href='S_Comprar?accion=1'">CANCELAR</button></h5>
			<h5 align="center"><button class="btn btn-success" onclick="location.href='S_Comprar?accion=2'">COMPRAR</button></h5>
			</div>
			</div>
		</div>
	</div>
			
			
</body>
</html>