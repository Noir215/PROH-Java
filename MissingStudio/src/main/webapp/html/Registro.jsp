<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "MissingStudio.modelo.AccesoBD"
    import = "MissingStudio.modelo.ProductoBD"
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

		<script src="../js/libCapas2122.js"></script>
		<script src="../js/bootstrap.bundle.min.js"></script>
		<script src="../js/carrito.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

		<title>Registro</title>	
	</head>
    <body>
        <h1 class="h1_paginas">Registro</h1>
        <div>
            <form method="post" onsubmit="ProcesarForm(this, 'CreaModificaUsuario', 'contenido'); return false" autocomplete="on" class="registro">
            	<input type="hidden" name="url" value="LoginTienda.jsp" />
            	<input type="hidden" name="codigo" value="" />
				<div class="mb-3 mt-3 one-half">
				  <label for="usuario" class="form-label">Usuario:</label>
				  <input type="text" class="form-control" id="usuario" placeholder="Introduce tu nombre de usuario" name="usuario" required="required">
				</div>
				<div class="mb-3 mt-3 one-half last">
				  <label for="pwd" class="form-label">Contraseña:</label>
				  <input type="password" class="form-control" id="clave" placeholder="Introduce tu usuario" name="clave" required="required">
				</div>
				<div class="mb-3 mt-3 one-half">
					<label for="nombre" class="form-label">Nombre:</label>
					<input type="text" class="form-control" id="nombre" placeholder="Introduce tu nombre" name="nombre" required="required">
				</div>
				<div class="mb-3 mt-3 one-half last">
					<label for="apellidos" class="form-label">Apellidos:</label>
					<input type="text" class="form-control" id="apellidos" placeholder="Introduce tus apellidos" name="apellidos" required="required">
				</div>
				<div class="mb-3 mt-3 one-half">
					<label for="domicilio" class="form-label">Domicilio:</label>
					<input type="text" class="form-control" id="domicilio" placeholder="Introduce tu domicilio" name="domicilio" required="required">
				</div>
				<div class="mb-3 mt-3 one-half last">
					<label for="poblacion" class="form-label">Poblaci&oacute;n:</label>
					<input type="text" class="form-control" id="poblacion" placeholder="Introduce tu poblacion" name="poblacion" required="required">
				</div>
				<div class="mb-3 mt-3 one-half">
					<label for="provicia" class="form-label">Provincia:</label>
					<input type="text" class="form-control" id="provincia" placeholder="Introduce tu provicia" name="provincia" required="required">
				</div>
				<div class="mb-3 mt-3 one-half last">
					<label for="cp" class="form-label">C&oacute;digo postal:</label>
					<input type="number" class="form-control" id="cp" placeholder="Introduce tu c&oacute;digo postal" name="cp" required="required">
				</div>
				<div class="mb-3 mt-3 one-half">
					<label for="telefono" class="form-label">Tel&eacute;fono:</label>
					<input type="number" class="form-control" id="telefono" placeholder="Introduce tu n&uacute;mero de tel&eacute;fono" name="telefono" required="required">
				</div>
				<button type="submit" class="btn btn-primary one-half">Enviar</button>
			  </form>
        </div>
    </body>
</html>