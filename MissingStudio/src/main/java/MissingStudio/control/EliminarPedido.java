package MissingStudio.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MissingStudio.modelo.AccesoBD;
import MissingStudio.modelo.Detalles;
import MissingStudio.modelo.ProductoBD;

/**
 * Servlet implementation class EliminarPedido
 */
@WebServlet("/html/EliminarPedido")
public class EliminarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Estas borrando el pedido: " + id);
		boolean resultado = false;
		List <Detalles> detalles = AccesoBD.getInstance().obtenerDetallesBD(id);
		
		for (Detalles detalle : detalles) {
			ProductoBD producto = AccesoBD.getInstance().obtenerProductoBDPorId(detalle.getCodigo());
			AccesoBD.getInstance().modificarProductoBD(producto.getId(), producto.getDescripcion(), producto.getPrecio(), producto.getStock() + detalle.getUnidades(), producto.getImagen());
		}
		
		resultado = AccesoBD.getInstance().modificarEstadoPedido(id, -1);
		
		
		// TODO Auto-generated method stub
		//response.sendRedirect("PedidosUsuario.jsp");
		request.getRequestDispatcher("PedidosUsuario.jsp").forward(request, response);
	}

}
