package MissingStudio.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MissingStudio.modelo.AccesoBD;
import MissingStudio.modelo.Detalles;
import MissingStudio.modelo.Usuarios;

/**
 * Servlet implementation class MostrarDetalles
 */
@WebServlet("/html/MostrarDetalles")
public class MostrarDetalles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarDetalles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int codigo = Integer.parseInt(request.getParameter("id"));
		
		if (codigo > 0) { 
			System.out.println("Estás dentro de detalle");
			List <Detalles> detalles = AccesoBD.getInstance().obtenerDetallesBD(codigo);
			request.setAttribute("detalles", detalles);
			request.getRequestDispatcher("DetallesPedido.jsp").forward(request, response);
		}
		else {
			System.out.println("Estás FUERA de detalles");
			request.getRequestDispatcher("Inicio.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
