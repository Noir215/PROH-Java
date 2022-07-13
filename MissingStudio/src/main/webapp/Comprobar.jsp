<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "MissingStudio.modelo.AccesoBD"
    import = "MissingStudio.modelo.ProductoBD"
    import = "MissingStudio.modelo.*"
    import = "java.util.List"
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Comprobacion de la conexion</title>
	</head>
	<body>
		<h1>Comprobacion de la conexion</h1>
		<%
		AccesoBD modelo = AccesoBD.getInstance();
		Pedidos pedido = new Pedidos ();
		pedido.setUsuario(1);
		pedido.setImporte(200.99f);
		pedido.setFecha("2022-12-12");
		pedido.setEstado(1);
		
		Producto producto = new Producto ();
		producto = modelo.obtenerDetalleProductoBD(2);
		
		Detalles detalle = new Detalles (producto, pedido);
		
		List <Usuarios> resultado = modelo.obtenerUsuariosBD();
		List <Pedidos> res_pedidos = modelo.obtenerPedidosNumBD();
		List <Pedidos> res_ped_usu = modelo.obtenerPedidosUsuarioBD(1);
		//int codigo = modelo.insertarPedidoBD(pedido);
		boolean borrado = modelo.deletePedidosNumBD(6);
		boolean est_mod = modelo.modificarEstadoPedido(7, 2);
		boolean res_det = modelo.insertarDetalleBD(detalle);
		
		
		for (Usuarios usuario: resultado) {
		%>
			 <li><%=usuario.getApellidos() %></li>
		<%
		}
		%>
		
		<%
		for (Pedidos pedido_: res_pedidos) {
		%>
			  <li><%=pedido_.getId() %></li>
		<%
		}
		%>
		
		<%
		for (Pedidos ped: res_ped_usu) {
		%>
			<li><%=ped.getImporte()%></li>
		<%
		}
		%> 
		
		<h2> Borrado: <%=borrado %></h2>
		<h2> Modificado: <%=est_mod %></h2>
		<h2> Detalle: <%=res_det %></h2>
	</body>
</html>