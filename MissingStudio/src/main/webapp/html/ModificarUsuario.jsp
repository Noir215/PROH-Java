<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>ModificarUsuario</title>
	</head>
	<body>
		<%
			Usuarios usuario = (Usuarios) request.getAttribute("usu");
		%>
		<div class="container">
		<h1 class="h1_paginas"> Usuario </h1>
				  
			<form method="post" onsubmit="ProcesarForm(this, 'CreaModificaUsuario', 'contenido'); return false">
				<input class="btn btn-outline-light" type="hidden" name="url" value="ModificarUsuario.jsp" />
				<input class="btn btn-outline-light" type="hidden" name="codigo" value=<%=usuario.getCodigo() %> />
				<input class="btn btn-outline-light" type="hidden" name="usuario" value=<%=usuario.getUsuario() %> />
				
				<div class="row">
					<div class="col">
						<label class="formul"> Usuario: </label>
					   	<input type="text" class="form-control" id="usuario" value=<%=usuario.getUsuario()%> name="usuario" required="required" readonly="readonly"/>
					</div>
					<div class="col">
						<label class="formul"> Nombre: </label>
					   	<input type="text" class="form-control" id="nombre" value="<%=usuario.getNombre()%>" name="nombre" required="required"/>
					</div>
					<div class="col">
						<label class="formul"> Apellidos: </label>
					  	<input type="text" class="form-control" id="apellidos" value="<%=usuario.getApellidos()%>" name="apellidos" required="required"/>
					</div>	
				</div>
				<div class="row">
				  	<div class="col">
				   		<label class="formul"> Domicilio: </label>
				      	<input type="text" class="form-control" id="domicilio" value="<%=usuario.getDomicilio()%>" name="domicilio" required="required"/>
				   	</div>
				   	<div class="col">
				   		<label class="formul"> Provincia: </label>
				      	<input type="text" class="form-control" id="provincia" value=<%=usuario.getProvincia()%> name="provincia" required="required"/>
				   	</div>
				   	<div class="col">
				   		<label class="formul"> Poblaci&oacute;n: </label>
				      	<input type="text" class="form-control" id="poblacion" value=<%=usuario.getPoblacion()%> name="poblacion" required="required"/>
				   	</div>
				</div>
				<div class="row">
				    <div class="col">
				    	<label class="formul"> Codigo Postal: </label>
				      	<input type="number" class="form-control" id="cp" value=<%=usuario.getCp()%> name="cp" required="required"/>
				    </div>
				    <div class="col">
				    	<label class="formul"> Tel&eacute;fono: </label>
				      	<input type="tel" class="form-control" id="telefono" value=<%=usuario.getTlf()%> name="telefono" required="required"/>
				    </div>
				    <div class="col">
				    	<label class="formul"> Contraseña: </label>
				      	<input type="password" class="form-control" id="clave" value="<%=usuario.getClave()%>" name="clave" />
				   </div>
				</div>
				<button type="submit" class="btn btn-outline-light mt-3">Modificar Usuario</button>
			</form>
			
		</div>
	</body>
</html>