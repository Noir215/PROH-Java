<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LoginAdmin</title>
	</head>
	<body>
        <div>
        	<%
				String mensaje = (String)session.getAttribute("mensaje");
				if (mensaje != null)
					session.removeAttribute("mensaje");
				
				if (mensaje != null) {
			%>
				<h1>
					<%=mensaje%>
				</h1>
			
			<%
				}
				if ((session.getAttribute("usuario") == null)) { //|| ((Integer)session.getAttribute("usuario") <= 0)) {
				//action="http://localhost/login.php"
			%>
					<h1 class="h1_paginas">Iniciar sesi&oacute;n</h1>
		            <form method="post" onsubmit="ProcesarForm(this, 'Login', 'contenido'); return false" autocomplete="on" class="registro">
					<input type="hidden" name="url" value="Inicio_admin.html"/>
						<div class="mb-3 mt-3 one-half">
						  <label for="usuario" class="form-label">Nombre de usuario:</label>
						  <input type="text" class="form-control" id="usuario" placeholder="Introduce tu usuario" name="usuario" required="required">
						</div>
						<div class="mb-3 mt-3 one-half last">
						  <label for="pwd" class="form-label">Contraseña:</label>
						  <input type="password" class="form-control" id="pwd" placeholder="Introduce tu contraseña" name="clave" required="required">
						</div>
						<input type="submit" class="btn btn-primary one-half" value="Entrar">
					</form>
		</div>
			<%
				}
				else {
					AccesoBD acceso = AccesoBD.getInstance();
		    		Usuarios usuario = (Usuarios) session.getAttribute("usuario");
			%>
					<header>
						<img src="../img/FaviconBlanco.png" alt="" class="corp">
						<h1 class="titulo_admin"> The Missing Studio </h1>
						<h2 class="h2_paginas"> P&aacute;gina de administración</h2>
					</header>
			        <div>
			            <a href="#" onclick="Cargar('Usuarios_admin.html','contenido')">
			                <div class="usu_admin">
			                    <h2> Usuarios </h2>
			                </div>
			            </a>
			            <a href="#" onclick="Cargar('Productos_admin.html','contenido')">
			                <div class="prod_admin">
			                    <h2> Productos </h2>
			                </div>
			            </a>
			            <a href="#" onclick="Cargar('Pedidos_admin.html','contenido')">
			                <div class="pedid_admin">
			                    <h2> Pedidos </h2>
			                </div>
			            </a>
			        </div>
		<%
			}
		%>
    </body>
</html>