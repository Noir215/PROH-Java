package MissingStudio.control;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MissingStudio.modelo.*;

/**
 * Servlet implementation class RecogerCarrito
 */
@WebServlet("/html/RecogerCarrito")
public class RecogerCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecogerCarrito() {
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
		ArrayList <Producto> carrito = new <Producto>ArrayList();
        HttpSession session = request.getSession();
        JsonReader jsonReader = Json.createReader(new InputStreamReader(request.getInputStream()));
        JsonObject jobj = jsonReader.readObject();

        for (String key : jobj.keySet()) { // Se recorren todos los productos pasados en el JSON
            JsonObject prod = (JsonObject)jobj.getJsonObject(key);
            Producto nuevo = new Producto();
            
            ProductoBD prodSelec = AccesoBD.getInstance().obtenerProductoBDPorId(prod.getInt("codigo"));
            
            if (prodSelec.getStock() < prod.getInt("cantidad")) {
            	throw new RuntimeException ("No hay suficiente STOCK");
            }
            
            if (prodSelec.getId() != prod.getInt("codigo")) {
            	throw new RuntimeException("El código no coincide");
            }
            
            if (prodSelec.getPrecio() != Float.parseFloat("" + prod.get("precio"))) {
            	throw new RuntimeException("El  precio no coincide");
            }
            
            nuevo.setId(prod.getInt("codigo"));
            nuevo.setNombre(prod.getString("descripcion"));
            nuevo.setCantidad(prod.getInt("cantidad"));
            nuevo.setPrecio(Float.parseFloat("" + prod.get("precio")));
            
            carrito.add(nuevo);
        }
        
        session.setAttribute("carrito", carrito);
        request.getRequestDispatcher("Resguardo.jsp").forward(request, response);
	}

}
