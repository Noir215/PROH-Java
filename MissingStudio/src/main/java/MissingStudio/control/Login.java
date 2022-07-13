package MissingStudio.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MissingStudio.modelo.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/html/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getParameter("url");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		//Usuarios usu = new Usuarios ();
		
		HttpSession session = request.getSession(true);
		
		AccesoBD con = AccesoBD.getInstance();
		
		if ((usuario != null) && (clave != null)) {
			int codigo = con.comprobarUsuarioBD(usuario, clave);
			
			if (codigo > 0) {
				//usu = con.obtenerUsuarioBDPorId(codigo);
				int activo= con.comprobarBloqueo(codigo);
				if (activo > 0) {
					session.setAttribute("usuario", codigo);
					response.sendRedirect(url);
				}
				else {
					session.setAttribute("mensaje", "Usuario bloqueado por admin");
					response.sendRedirect("LoginTienda.jsp");
				}
			}
			else {
				session.setAttribute("mensaje", "Usuario y/o clave incorrectos");
				response.sendRedirect("LoginTienda.jsp");
			}
		}
		
	}

}
