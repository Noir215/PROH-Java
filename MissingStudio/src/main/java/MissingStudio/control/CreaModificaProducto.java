package MissingStudio.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MissingStudio.modelo.AccesoBD;
import MissingStudio.modelo.ProductoBD;

/**
 * Servlet implementation class CreaModificaProducto
 */

@WebServlet("/CreaModificaProducto")
public class CreaModificaProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pCodigo = request.getParameter("codigo");
		ProductoBD p = null;
		
		if (pCodigo != null) {
			int codigo = Integer.parseInt(pCodigo);
			p = AccesoBD.getInstance().obtenerProductoBDPorId(codigo);
		}
		
		if (p == null) {
			p = new ProductoBD ();
			p.setDescripcion("");
			p.setStock(1);
			p.setPrecio(99.99f);
			p.setId(0);
		}
		
		request.setAttribute("producto", p);
		request.getRequestDispatcher("Productos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean resultado = false;
		
		String pCodigo = request.getParameter("codigo");
		String descripcion = request.getParameter("descripcion");
		String imagen = request.getParameter("imagen");
		String pPrecio = request.getParameter("precio");
		String pExistencias = request.getParameter("existencias");
		
		int codigo = 0;
		int existencias = 0;
		float precio = 0f;
		
		if (pCodigo != null)
			codigo = Integer.parseInt(pCodigo);
		
		if (pExistencias != null)
			existencias = Integer.parseInt(pExistencias);
		
		if (pPrecio != null)
			precio = Float.parseFloat(pPrecio);
		
		if (codigo == 0)
			resultado = AccesoBD.getInstance().insertarProductoBD(descripcion, precio, existencias, imagen);
		else
			resultado = AccesoBD.getInstance().modificarProductoBD(codigo, descripcion, precio, existencias, imagen);
		
		System.out.println("Resultado de la insercion o edicion: " + resultado);
		response.sendRedirect(request.getContextPath() + "Productos_admin.html");
		
	}
}
