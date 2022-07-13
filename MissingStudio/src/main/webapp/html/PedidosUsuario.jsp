<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "MissingStudio.modelo.*"
    import = "java.util.List"
	import = "java.util.ArrayList"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<title>PedidosUsuario</title>
		<meta charset="utf-8">
	</head>
	<body>
		<h1 class="h1_paginas"> Pedidos </h1>
		
		<div>
			<div class="container"> 
				<div class="row bg mb-3">
					<div class="col">
						<p class="formul text-center rounded">Id Pedido</p>
					</div>
					<div class="col">
						<p class="formul text-center rounded">Fecha Pedido</p>
					</div>
					<div class="col">
						<p class="formul text-center rounded">Importe Pedido</p>
					</div>
					<div class="col">
						<p class="formul text-center rounded">Estado Pedido</p>
					</div>
					<div class="col">
						<p class="formul text-center rounded">Cancelar Pedido</p>
					</div>	
					<div class="col">
						<p class="formul text-center rounded">Detalles Pedido</p>
					</div>
				</div>
			</div>
		<%
			List <Pedidos> pedidos = AccesoBD.getInstance().obtenerPedidosUsuarioBD((Integer)session.getAttribute("usuario"));
		
			for (Pedidos pedido : pedidos) {
				int id = pedido.getId();
				String fecha = pedido.getFecha();
				float importe = pedido.getImporte();
				int estado = pedido.getEstado();
		%>
			<div class="container"> 
				<div class="row bg text-center">
					<div class="col formul">
						<p><%=id %></p>
					</div>
					<div class="col formul pt-3">
						<p><%=fecha %></p>
					</div>
					<div class="col formul pt-3">
						<p><%=importe %> &euro;</p>
					</div>	
					<%
					if (estado == 0) {
					%>
						<div class="col formul pt-3">
							<p>Pendiente</p>
						</div>
					<%
					}
					if (estado == 1) {
					%>
						<div class="col formul pt-3">
							<p>Enviado</p>
						</div>
					<%
					}
					if (estado == 2) {
					%>
						<div class="col formul pt-3">
							<p>Entregado</p>
						</div>
					<%
					}
					if (estado == -1) {
					%>
						<div class="col formul pt-3">
							<p>Cancelado</p>
						</div>
					<%	
					}
					if (estado < 1 && estado > -1) {
					%>
						<div class="col formul pt-3">
							<form method="post" onsubmit="ProcesarForm(this, 'EliminarPedido', 'contenido'); return false">
								<input type="hidden" name="id" value=<%=id%> />
								<p><button class="btn btn-outline-light" type="submit"> Cancelar </button></p>
							</form>
						</div>
					<%
					}
					else {
					%>
						<div class="col formul pt-3">
						<p> - </p>
						</div>
					<%
					}
					%>
					<div class="col formul pt-3">
						<form method="post" onsubmit="ProcesarForm(this, 'MostrarDetalles', 'contenido'); return false">
							<input type="hidden" name="id" value=<%=id%> />
							<p><button class="btn btn-outline-light" type="submit"> Detalles </button></p>
						</form>
					</div>
					<br>
				</div>
			</div>
        </div>
        
		<%
			}
		%>
	</body>