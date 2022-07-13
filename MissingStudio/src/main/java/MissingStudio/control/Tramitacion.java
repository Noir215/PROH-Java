package MissingStudio.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MissingStudio.modelo.AccesoBD;
import MissingStudio.modelo.Detalles;
import MissingStudio.modelo.Pedidos;
import MissingStudio.modelo.Producto;
import MissingStudio.modelo.ProductoBD;

/**
 * Servlet implementation class TramitacionPedido
 */
@WebServlet("/html/Tramitacion")
public class Tramitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tramitacion() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		int codigo = (Integer)session.getAttribute("usuario");
		ArrayList <Producto> carrito = new <Producto> ArrayList ();
		carrito = (ArrayList <Producto>) session.getAttribute("carrito");
		int cod_cliente = Integer.parseInt(request.getParameter("codigo"));
		String destinatario = request.getParameter("nombre");
		String pago = request.getParameter("pago");
		String domicilio = request.getParameter("domicilio");
		String provincia = request.getParameter("provincia");
		String poblacion = request.getParameter("poblacion");
		float importe = Float.parseFloat(request.getParameter("importe"));
		
		Pedidos pedido = new Pedidos ();
		
		pedido.setId(codigo);
		pedido.setImporte(importe);
		pedido.setEstado(0);
		pedido.setMetodo(pago);
		pedido.setPoblacion(poblacion);
		pedido.setProvincia(provincia);
		pedido.setDomicilio(domicilio);
		pedido.setDestinatario(destinatario);
		
		AccesoBD con = AccesoBD.getInstance();
		con.insertarPedidoBD(pedido);
		
		Detalles detalle = new Detalles ();
		
		for (Producto prodAct : carrito) {
			detalle.setCodigo(prodAct.getId());
			detalle.setUnidades(prodAct.getCantidad());
			detalle.setPrecio_unitario(prodAct.getPrecio());
			con.insertarDetalleBD(detalle, codigo);
			
			ProductoBD producto = con.obtenerProductoBDPorId(detalle.getCodigo());
			con.modificarProductoBD(producto.getId(), producto.getDescripcion(), producto.getPrecio(), producto.getStock() - prodAct.getCantidad(), producto.getImagen());
		}
		
		carrito = null;
		session.setAttribute("carrito", carrito);
		
		
		response.sendRedirect("Inicio.html");
	}

}
