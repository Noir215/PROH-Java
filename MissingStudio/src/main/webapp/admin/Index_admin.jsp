<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link id="css" rel="stylesheet" href="../css/Estilo.css" type="text/css" />
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link rel="icon" href="../img/FaviconBlanco.png"/>

		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

		<script src="../js/libCapas2122.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<script src="../js/carrito.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

		<title>The Missing Studio_admin</title>	
	</head>

	<body onload= "Cargar('Login_admin.jsp','contenido')">
		<nav class= "cabecera">
			<header>
				<a href="#" onclick="Cargar('Login_admin.jsp','contenido')">
					<img src="../img/FaviconBlanco.png" alt="" class="logo">
				</a>
				<a href="#" onclick="Cargar('Usuarios_admin.html','contenido')" class="letras_top">
					Usuarios
				</a>
				<a href="#" onclick="Cargar('Productos_admin.html','contenido')" class="letras_top">
					Productos
				</a>
				<a href="#" onclick="Cargar('Pedidos_admin.html','contenido')" class="letras_top">
					Pedidos
				</a>
			</header>
		</nav>
			
		<div id="contenido"></div>
	</body>
</html>