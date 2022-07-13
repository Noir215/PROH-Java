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
 * Servlet implementation class CreaModificaUsuario
 */
@WebServlet("/html/CreaModificaUsuario")
public class CreaModificaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CreaModificaUsuario () {
		super ();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String url = request.getParameter("url");
		Integer uCodigo = null;
		Usuarios u = null;
		
		if (session != null) {
			uCodigo = (Integer)session.getAttribute("usuario");
		}
		
		if (uCodigo != null) {
			int codigo = uCodigo;
			u = AccesoBD.getInstance().obtenerUsuarioBDPorId(codigo);
		}
		
		if (u == null) {
			u = new Usuarios ();
			u.setUsuario("");
			u.setClave("");
			u.setNombre("");
			u.setApellidos("");
			u.setDomicilio("");
			u.setPoblacion("");
			u.setProvincia("");
			u.setCp(0);
			u.setTlf(0);
			u.setCodigo(0);
		}
		
		request.setAttribute("usuario", u);
		request.getRequestDispatcher(url).forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		boolean resultado = false;
		
		String url = request.getParameter("url");
		String uCodigo = request.getParameter("codigo");
		String usuario = request.getParameter("usuario");
		String uClave = request.getParameter("clave");
		String uNombre = request.getParameter("nombre");
		String uApellidos = request.getParameter("apellidos");
		String uDomicilio = request.getParameter("poblacion");
		String uPoblacion = request.getParameter("domicilio");
		String uProvincia = request.getParameter("provincia");
		String uCp = request.getParameter("cp");
		String uTlf = request.getParameter("telefono");
		Usuarios usu = new Usuarios ();
		
		int codigo = 0;
		int tlf = 0;
		int cp = 0;
		
		String clave = "";
		String nombre = "";
		String apellidos = "";
		String domicilio = "";
		String poblacion = "";
		String provincia = "";
		
		if (uCodigo != "") 
			codigo = Integer.parseInt(uCodigo);
		
		if (uClave != "")
			clave = uClave;
		
		if (uNombre != "")
			nombre = uNombre;
		
		if (uApellidos != "")
			apellidos = uApellidos;
		
		if (uDomicilio != "")
			domicilio = uDomicilio;
		
		if (uPoblacion != "")
			poblacion = uPoblacion;
		
		if (uProvincia != "")
			provincia = uProvincia;
		
		if (uCp != "")
			cp = Integer.parseInt(uCp);
		
		if (uTlf != "")
			tlf = Integer.parseInt(uTlf);
		
		if (codigo == 0) {
			resultado = AccesoBD.getInstance().insertarUsuarioBD(usuario, clave, nombre, apellidos, poblacion, domicilio, provincia, "" + cp, "" + tlf);
		}
		else
			resultado = AccesoBD.getInstance().modificarUsuarioBD(usuario, clave, nombre, apellidos, poblacion, domicilio, provincia, "" + cp, "" + tlf, "" + codigo);
		
		//usu = AccesoBD.getInstance().obtenerUsuarioBDPorId(codigo);
		//session.setAttribute("usuario", usu);
		System.out.println("Resultado de la insercion o edicion: " + resultado);
		response.sendRedirect(url);
	}

}
