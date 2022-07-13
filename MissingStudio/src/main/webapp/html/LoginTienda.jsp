<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LoginTienda</title>
	</head>
	<body>
        <div>
			<%
			if ((session.getAttribute("usuario") == null)) { //|| ((Integer)session.getAttribute("usuario") <= 0)) {
			//action="http://localhost/login.php"
			%>
				<h1 class="h1_paginas">Iniciar sesi&oacute;n</h1>
	        	<form method="post" onsubmit="ProcesarForm(this, 'Login', 'contenido'); return false" autocomplete="on" class="registro">
				<input type="hidden" name="url" value="Inicio.html"/>
					<div class="mb-3 mt-3 one-half">
					  <label for="usuario" class="form-label">Nombre de usuario:</label>
					  <input type="text" class="form-control" id="usuario" placeholder="Introduce tu usuario" name="usuario" required="required">
					</div>
					<div class="mb-3 mt-3 one-half last">
					  <label for="pwd" class="form-label">Contraseña:</label>
					  <input type="password" class="form-control" id="pwd" placeholder="Introduce tu contraseña" name="clave" required="required">
					</div>
					<input type="submit" class="btn btn-primary one-half" value="Entrar">
					<div class="mb-3 one-half last" style="color:black">
						<%
						String mensaje = (String)session.getAttribute("mensaje");
						if (mensaje != null)
							session.removeAttribute("mensaje");
						
						if (mensaje != null) {
						%>
							<h3>
								<%=mensaje%>
							</h3>
						<%
						}
						%>
					</div>
				    <div class="form-check mb-3 one-half">
						<label class="form-check-label">
							No tienes usuario?
						</label>
					<br/>	
						<a href="#" onclick="Cargar('Registro.jsp','contenido')">
							Crear usuario
						</a>
					</div>
				</form>
		</div>
			<%
			}
			else {
			%>
		  		<h1 class="h1_paginas"> Opciones de usuario </h1>
		  		<div class="container">
				<div class="row">
					<div class="col d-flex justify-content-start" >
						<button class="btn btn-outline-light" onclick="Cargar('MostrarUsuario', 'contenido')"> Modificar usuario </button>
					</div>
					<div class="col d-flex justify-content-center">
						<button class="btn btn-outline-light" onclick="Cargar('PedidosUsuario.jsp', 'contenido')"> Gestionar Pedidos </button>
					</div>
					<div class="col d-flex justify-content-end">
						<button class="btn btn-outline-light" type="submit" onclick="Cargar('Logout', 'contenido')">   Cerrar Sesi&oacute;n   </button>
					</div>	
				</div>
				</div>
			<%
			}
			%>
    </body>
</html>