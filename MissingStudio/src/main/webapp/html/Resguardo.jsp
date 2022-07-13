<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import = "MissingStudio.modelo.*"
	import = "java.util.List"
	import = "java.util.ArrayList"
%>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>LoginTienda</title>
	</head>
	<body>
		<%
		
		if ((session.getAttribute("usuario") != null)) {
			Usuarios usuario = AccesoBD.getInstance().obtenerUsuarioBDPorId((Integer)session.getAttribute("usuario"));
			ArrayList <Producto> carrito = new <Producto> ArrayList ();
			carrito = (ArrayList <Producto>) session.getAttribute("carrito");
			float importe = 0.0f;
		%>
		<div class="container">
			<h1 class="h1_paginas"> Resguardo </h1>
				  
			<form method="post" onsubmit="ProcesarForm(this, 'Tramitacion', 'contenido'); return false">
				<input type="hidden" name="url" value="ModificarUsuario.jsp" />
				<input type="hidden" name="codigo" value=<%=usuario.getCodigo() %> />
				
				<div class="row">
					<div class="col">
						<label class="formul"> Destinatario: </label>
					   	<input type="text" class="form-control" id="nombre" value="<%=usuario.getNombre()%> <%=usuario.getApellidos()%>" name="nombre" required="required"/>
					</div>
					<div class="col">
					</div>
					<div class="col">
						<label class="formul"> M&eacute;todo de pago: </label>
					  	<select name="pago" required="required" class="form-control">
					  		<option value="tarjeta" selected="selected"> Tarjeta </option>
					  		<option value="transferencia"> Transferencia </option>
					  	</select>
					  	
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
		<%
			for(Producto producto : carrito) {
				int cantidad = producto.getCantidad();
				float precio = producto.getPrecio();
				String nombre = producto.getNombre();
				importe += precio * cantidad;
		%>
					<div>
					<br>
					
						<table class="carrito">
			                <thead>
			                    <tr>
			                        <td>Descripci&oacute;n</td><td>Precio</td><td>Cantidad</td>
			                    </tr>
			                </thead>
			                <tbody>
			                    <tr>
			                    	<td><%=nombre %></td><td><%=precio %></td><td><%=cantidad %></td>
			                    </tr>
			                </tbody>
			            </table>
			        </div>
		<%
			}
		%>
				<br>
				<p class="carrito"> Importe: <%=importe %></p>
				<input type="hidden" name="importe" value=<%=importe %>>
        		<button  class="btn btn-outline-light" type="submit" class="btn btn-primary mt-3" onclick="localStorage.clear()">Pasar a finalizar compra</button>
        	</form>	
        </div>
		<%
		}
		else {
			request.getRequestDispatcher("LoginTienda.jsp").forward(request, response);
		}
		%>
	</body>