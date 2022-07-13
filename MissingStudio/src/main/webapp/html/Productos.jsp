<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "MissingStudio.modelo.AccesoBD"
    import = "MissingStudio.modelo.ProductoBD"
    import = "java.util.List"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>Productos</title>
		<meta charset="utf-8">
	</head>
	<body>
	<%
	AccesoBD con = AccesoBD.getInstance();
	List <ProductoBD> productos = con.obtenerProductosBD ();
	%>
		<header>
			<h1 class="h1_paginas"> Productos </h1>
			<div class="container">
			<div class="row">
				<%
				for (ProductoBD producto : productos) {
					int codigo = producto.getId();
					String descripcion = producto.getDescripcion ();
					float precio = producto.getPrecio ();
					int existencias = producto.getStock ();
					String imagen = producto.getImagen ();
				%>
					<div class="col-2 formul m-2 pb-2 rounded text-center">
						<div>
							<img src=<%=imagen%> alt="" style="width:30%; padding-top: 20px;">
						</div>
						<br>
						<p><%=descripcion%></p>
						<p><%=precio%> &euro;</p>
						
						<% 
						if (existencias > 0) {
						%>
							<p><%=existencias%> unidades</p>
							<button class="btn btn-outline-light" type="button" onclick="addProducto(<%=producto.getId()%>, '<%=producto.getDescripcion()%>', <%=producto.getPrecio()%>, 1)">A&ntilde;adir al carrito</button>
						<%
						}
						else {
						%>
							<p style="padding-bottom: 40px;"> AGOTADO </p>
						<%
						}
						%>
					</div>
				<%
				}
				%>
			</div>
			</div>
		</header>
	</body>
</html>