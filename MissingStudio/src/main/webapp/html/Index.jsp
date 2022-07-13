<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.AccesoBD"
	import = "MissingStudio.modelo.ProductoBD"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<link id="css" rel="stylesheet" href="../css/Estilo.css" type="text/css" />
		<link rel="icon" href="../img/FaviconBlanco.png"/>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

		<script src="../js/libCapas2122.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

		<script src="../js/carrito.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

		<title>The Missing Studio</title>	
	</head>

	<body id=index onload="Cargar('Inicio.html','contenido')">
		<nav class= "cabecera container-fluid">
			<header>
				<a href="#" onclick="Cargar('Inicio.html','contenido')">
					<img src="../img/FaviconBlanco.png" alt="" class="logo">
				</a>
				<a href="#" onclick="Cargar('Productos.jsp','contenido')" class="letras_top">
					Productos
				</a>
				<a href="#" onclick="Cargar('LoginTienda.jsp','contenido')" class="letras_top">
					Usuario
				</a>
				<a href="#" onclick="Cargar('Carrito.html','contenido')" class="letras_top">
					Carrito
				</a>	
				<a href="#" onclick="Cargar('Empresa.html','contenido')" class="letras_top">
					Empresa
				</a>
				<a href="#" onclick="Cargar('Contacto.html','contenido')" class="letras_top">
					Contacto
				</a>	
			</header>
		</nav>
			
		<div id="contenido"></div>
		
		<footer>
			<div class="mt-4 p-1 text-white">
				<div class="row">
					<div class="col-sm-2 text-center">
						<p> &copy; 2022 - &Aacute;ngel Dolz </p>
					</div>
					<div class="col-sm-8 text-center">
					&nbsp;
					</div>
					<div class="col-sm-2 text-center">
						<a href="https://facebook.com/">
							<i class="fa fa-facebook-official" style="font-size:24px"></i>
						</a>
						<a href="https://www.instagram.com/">
							<i class="fa fa-instagram" style="font-size:24px"></i>
						</a>
						<a href="https://www.linkedin.com/">
							<i class="fa fa-linkedin" style="font-size:24px"></i>
						</a>
						<a href="https://twitter.com/">
							<i class="fa fa-twitter" style="font-size:24px"></i>
						</a>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>