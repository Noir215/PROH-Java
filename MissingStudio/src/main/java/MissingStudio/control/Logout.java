package MissingStudio.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import MissingStudio.modelo.*;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/html/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Cerrar Sesión");
		
		HttpSession session = request.getSession(true);
		
		Integer usuario = (Integer) session.getAttribute("usuario");
		Pedidos pedido = (Pedidos) session.getAttribute("pedidos");
		ArrayList <Producto> carrito = (ArrayList) session.getAttribute("carrito");
		ArrayList <Pedidos> pedidos = (ArrayList) session.getAttribute("numpedidos");
		String bool = (String) session.getAttribute("registrado");
		
		usuario = null;
		pedido = null;
		carrito = null;
		pedidos = null;
		bool = null;
		
		session.setAttribute("usuario", usuario);
		session.setAttribute("pedidos", pedido);
		session.setAttribute("carrito", carrito);
		session.setAttribute("numpedidos", pedidos);
		session.setAttribute("registrado", bool);
		
		response.sendRedirect("LoginTienda.jsp");
	}

}
