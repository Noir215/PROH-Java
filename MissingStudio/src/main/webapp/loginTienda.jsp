<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.AccesoBD"
	import = "MissingStudio.modelo.ProductoBD"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>loginTienda</title>
	</head>
	<body>
		<%
			String mensaje = (String)session.getAttribute("mensaje");
			if (mensaje != null)
				session.removeAttribute("mensaje");
		%>
		<h1>
			<%=mensaje%>
		</h1>
		
		<%
			if ((session.getAttribute("usuario") == null) || ((Integer)session.getAttribute("usuario") <= 0)) {
		%>
				<form method="post" onsubmit="ProcesarForm(this, 'Login', 'contenido'); return false">
					<input type="hidden" name="url" value=".html/loginTienda.jsp"/>
					Usuario: <input name="usuario" type="text"/> <br/><br/>
					Contrase&ntilde;a: <input name="clave" type="password"/> <br/><br/>
					<input type="radio" name="tipoAcceso" value="Acceso" checked="checked"/>Acceso
					<input type="radio" name="tipoAcceso" value="Registro"/>Registro <br/><br/>
					<input type="submit" value="Entrar a la Tienda Virtual"/>
				</form>
		<%
			}
			else {
		%>
				<p>Mostraríamos las diferentes opciones</p>
		<%
			}
		%>
	</body>
</html>