<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalle Pedido</title>
</head>
<body>
	<div class="container">
		<h1 class="h1_paginas"> Detalle </h1>
			<%
			List <Detalles> detalles = (List) request.getAttribute("detalles");
			for (Detalles detalle : detalles) {
				ProductoBD producto = AccesoBD.getInstance().obtenerProductoBDPorId(detalle.getCodigo());
			%>
				<div class="row">
					<div class="col">
						<label class="formul"> Producto: </label>
						<h2 class=h2_paginas> <%=producto.getDescripcion() %></h2>
					  </div>
					<div class="col">
						<label class="formul"> Cantidad: </label>
						<h2 class=h2_paginas> <%=detalle.getUnidades() %></h2>
					 </div>
					<div class="col">
						<label class="formul"> Precio: </label>
						<h2> <%=detalle.getPrecio_unitario() %></h2>
					 </div>	
				</div>
			<%
			}
			%>
		<div class="col">
			<button class="btn btn-outline-light" onclick="Cargar('PedidosUsuario.jsp','contenido')"> Atr&aacute;s</button>
		</div>	
	</div>
</body>
</html>