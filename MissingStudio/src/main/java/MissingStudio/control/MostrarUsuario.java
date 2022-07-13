package MissingStudio.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MissingStudio.modelo.AccesoBD;
import MissingStudio.modelo.Usuarios;

/**
 * Servlet implementation class MostrarUsuario
 */
@WebServlet("/html/MostrarUsuario")
public class MostrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		if ((Integer)session.getAttribute("usuario") != null) {
			System.out.println("Estás dentro de usu");
			Usuarios usu = AccesoBD.getInstance().obtenerUsuarioBDPorId((Integer)session.getAttribute("usuario"));
			request.setAttribute("usu", usu);
			System.out.println("Vas a entrar en ModificarUsuario");
			request.getRequestDispatcher("ModificarUsuario.jsp").forward(request, response);
		}
		else {
			System.out.println("Estás FUERA de usu");
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
