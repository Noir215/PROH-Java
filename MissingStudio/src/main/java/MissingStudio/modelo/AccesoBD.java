package MissingStudio.modelo;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class AccesoBD {
	private static AccesoBD instanciaUnica = null;
	private Connection conexionBD;
	
	//Constructor de la clase
	private AccesoBD() {
		abrirConexionBD();
	}
	
	public static  AccesoBD getInstance () {
		if (instanciaUnica == null)
			instanciaUnica = new AccesoBD();
		
		return instanciaUnica;
	}
	
	public void abrirConexionBD() {
		if (conexionBD == null) {
			String nombreConexionBD = "jdbc:mysql://localhost/bddtv";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexionBD = DriverManager.getConnection(nombreConexionBD,"root","");
			}
			catch(Exception e) {
				System.err.println("No se ha podido conectar a la base de datos");
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void cerrarConexionBD() {
		if (conexionBD != null) {
			try {
				conexionBD.close();
				conexionBD = null;
			}
			catch(Exception e) {
				System.err.println("No se ha podido desconectar de la base de datos");
				System.err.println(e.getMessage());
			}
		}
	}
	
	public boolean comprobarAcceso() {
		abrirConexionBD();
		boolean res = (conexionBD != null);
		cerrarConexionBD();
		
		return res;
	}
	
	
	// OPERACIONES DE PRODUCTO SOBRE LA BD
	public List<ProductoBD> obtenerProductosBD() {
		abrirConexionBD();
		ArrayList<ProductoBD> productos = new ArrayList<>();
		
		try {
			String con = "SELECT codigo,descripcion,precio,existencias,imagen FROM productos";
			Statement s = conexionBD.createStatement();
			ResultSet resultado = s.executeQuery(con);
			while(resultado.next()){
				ProductoBD producto = new ProductoBD();
				producto.setId(resultado.getInt("codigo"));
				producto.setDescripcion(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getFloat("precio"));
				producto.setStock(resultado.getInt("existencias"));
				producto.setImagen(resultado.getString("imagen"));
				productos.add(producto);
			}
		}
		catch(Exception e) {
			System.err.println("Error ejecutando la consulta a la base de datos");
			System.err.println(e.getMessage());
		}
		
		return productos;
	}
	
	public int existenciasProductoBD (int codigo) {
		abrirConexionBD ();
		
		int existencias = 0;
		ResultSet resultado = null;
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT existencias FROM productos WHERE codigo = " + codigo;
			resultado = s.executeQuery(con);
			
			if (resultado.next()) {
				existencias = resultado.getInt("existencias");
			}
		}
		catch (Exception e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return existencias;
	}
	
	public Producto obtenerDetalleProductoBD (int id_prod) {
		abrirConexionBD ();
		
		ResultSet resultado = null;
		Producto producto = new Producto ();
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT codigo, descripcion,precio FROM productos WHERE codigo = " + id_prod; 
			resultado = s.executeQuery(con);
			
			if (resultado.next()) {
				producto.setId(resultado.getInt("codigo"));
				producto.setNombre(resultado.getString("descripcion"));
				producto.setPrecio(resultado.getFloat("precio"));
			}
		}
		catch (Exception e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return producto;
	}
	
	public ProductoBD obtenerProductoBDPorId(Integer id) {
        abrirConexionBD();
        
        ProductoBD producto = null;
        
        try {

            PreparedStatement ps = conexionBD.prepareStatement("SELECT codigo,descripcion,precio,existencias,imagen FROM productos WHERE codigo = ?");
            
            ps.setInt(1, id);
            
            ResultSet resultado = ps.executeQuery();
            
            if (resultado.next()) {
                producto = new ProductoBD();
                producto.setId(resultado.getInt("codigo"));
                producto.setDescripcion(resultado.getString("descripcion"));
                producto.setPrecio(resultado.getFloat("precio"));
                producto.setStock(resultado.getInt("existencias"));
                producto.setImagen(resultado.getString("imagen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return producto;
    }
	
	public boolean insertarProductoBD(String descripcion, double precio, int existencias,String imagen) {
        boolean creado = false;
        
        abrirConexionBD();
        
        
        try {

            PreparedStatement ps = conexionBD.prepareStatement("INSERT INTO productos (codigo,descripcion,precio,existencias,imagen) VALUES (NULL,?,?,?,?)");
            
            ps.setString(1, descripcion);
            ps.setDouble(2, precio);
            ps.setInt(3, existencias);
            ps.setString(4,imagen);
            
            ps.execute();
            
            // En las inserciones y actualizaciones podemos obtener el 
            // número de cambios en la base de datos
            creado = (ps.getUpdateCount()>0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return creado;
    }
	
	public boolean modificarProductoBD(int codigo, String descripcion, double precio, int existencias,String imagen) {
        boolean actualizado = false;
        
        abrirConexionBD();
        
        
        try {

            PreparedStatement ps = conexionBD.prepareStatement("UPDATE productos SET descripcion = ?, precio = ?, existencias = ?, imagen = ? WHERE codigo = ?");
            
            ps.setString(1, descripcion);
            ps.setDouble(2, precio);
            ps.setInt(3,existencias);
            ps.setString(4,imagen);
            ps.setInt(5, codigo);
            
            ps.execute();
            
            // En las inserciones y actualizaciones podemos obtener el 
            // número de cambios en la base de datos
            actualizado = (ps.getUpdateCount()>0);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return actualizado;
    }
	
	
	// OPERACIONES DE USUARIO SOBRE LA BD
	public int comprobarUsuarioBD (String usuario, String clave) {
		abrirConexionBD();
		
		try {
			String con = "SELECT codigo FROM usuarios WHERE usuario = ? AND clave = ?";
			PreparedStatement s = conexionBD.prepareStatement(con);
			s.setString(1, usuario);
			s.setString(2, clave);
			ResultSet resultado = s.executeQuery();
			
			if (resultado.next()) {
				return resultado.getInt("codigo");
			}
		}
		catch (Exception e) {
			System.err.println("Error verificando usuario/clave");
			System.err.println(e.getMessage());
		}
		return -1;
	}
	
	public int comprobarBloqueo (int codigo) {
		abrirConexionBD();
		
		try {
			String con = "SELECT activo FROM usuarios WHERE codigo = ?";
			PreparedStatement s = conexionBD.prepareStatement(con);
			s.setInt(1, codigo);
			ResultSet resultado = s.executeQuery();
			
			if (resultado.next()) {
				return resultado.getInt("activo");
			}
		}
		catch (Exception e) {
			System.err.println("Error verificando activo");
			System.err.println(e.getMessage());
		}
		return -1;
	}
	
	public boolean insertarUsuarioBD (String usu, String clave, String nom, String ape, String dom, String pob, String prov, String cp, String tlf) {
		abrirConexionBD();
		
		boolean resultado = false;
		
		try {
			String con = "INSERT INTO usuarios (codigo, activo, admin, usuario, clave, nombre, apellidos, domicilio, poblacion, provincia, cp, telefono) VALUES (null, 1, 0, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = conexionBD.prepareStatement(con);
			
			pst.setString(1, usu);
			pst.setString(2, clave);
			pst.setString(3, nom);
			pst.setString(4, ape);
			pst.setString(5, dom);
			pst.setString(6, pob);
			pst.setString(7, prov);
			pst.setString(8, cp);
			pst.setString(9, tlf);
			int res = pst.executeUpdate();
			
			if (res >= 0)
				resultado = true;
		}
		catch (SQLException e) {
			System.out.println ("Error ejecutando la consulta a la BD " + e);
		}
		
		return resultado;
	}
	
	public boolean modificarUsuarioBD (String usu, String clave, String nom, String ape, String dir, String pob, String prov, String cp, String tlf, String cod) {
		abrirConexionBD ();
		
		boolean resultado = false;
		
		try {
			String con = "UPDATE usuarios SET usuario = ?, clave = ?, nombre = ?, apellidos = ?, domicilio = ?, poblacion = ?, provincia = ?, cp = ?, telefono = ? WHERE usuarios.codigo = " + cod;
			PreparedStatement pst = conexionBD.prepareStatement(con);
			
			pst.setString(1, usu);
			pst.setString(2, clave);
			pst.setString(3, nom);
			pst.setString(4, ape);
			pst.setString(5, dir);
			pst.setString(6, pob);
			pst.setString(7, prov);
			pst.setString(8, cp);
			pst.setString(9, tlf);
			int res = pst.executeUpdate();
			
			if (res >= 0)
				resultado = true;
			
		}
		catch (SQLException e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return resultado;
	}
	
	public List<Usuarios> obtenerUsuariosBD () {
		abrirConexionBD ();
		
		ResultSet resultado = null;
		ArrayList<Usuarios> usuarios = new ArrayList<>();
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT* FROM usuarios";
			resultado = s.executeQuery(con);
			
			while (resultado.next()) {
				Usuarios usuario = new Usuarios ();
				usuario.setCodigo(resultado.getInt("codigo"));
				usuario.setUsuario(resultado.getString("usuario"));
				usuario.setNombre(resultado.getString("nombre"));
				usuario.setApellidos(resultado.getString("apellidos"));
				usuario.setDomicilio(resultado.getString("domicilio"));
				usuario.setPoblacion(resultado.getString("poblacion"));
				usuario.setProvincia(resultado.getString("provincia"));
				usuario.setCp(resultado.getInt("cp"));
				usuario.setTlf(resultado.getInt("telefono"));
				usuarios.add(usuario);
			}
		}
		catch (Exception e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return usuarios;
	}
	
	public Usuarios obtenerUsuarioBDPorId(Integer id) {
        abrirConexionBD();
        
        Usuarios usuario = null;
        
        try {

            PreparedStatement ps = conexionBD.prepareStatement("SELECT* FROM usuarios WHERE codigo = ?");
            
            ps.setInt(1, id);
            
            ResultSet resultado = ps.executeQuery();
            
            if (resultado.next()) {
                usuario = new Usuarios ();
                usuario.setCodigo(resultado.getInt("codigo"));
                usuario.setClave(resultado.getString("clave"));
                usuario.setUsuario(resultado.getString("usuario"));
                usuario.setNombre(resultado.getString("nombre"));
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setDomicilio(resultado.getString("domicilio"));
                usuario.setPoblacion(resultado.getString("poblacion"));
                usuario.setProvincia(resultado.getString("provincia"));
                usuario.setCp(resultado.getInt("cp"));
                usuario.setTlf(resultado.getInt("telefono"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
    }
	
	
	// OPERACIONES DE PEDIDOS SOBRE LA BD
	public int insertarPedidoBD (Pedidos pedido) {
		abrirConexionBD ();
		
		ResultSet resultado = null;
		
		try {
			System.out.println(pedido.getUsuario());
			String con = "INSERT INTO pedidos (persona, fecha, importe, estado, pago, poblacion, provincia, domicilio, destinatario) VALUES (?, NOW(), ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conexionBD.prepareStatement(con);
			
			
			pst.setString(1, "" + pedido.getId());
			pst.setString(2, "" + pedido.getImporte());
			pst.setString(3, "" + pedido.getEstado());
			pst.setString(4, "" + pedido.getMetodo());
			pst.setString(5, "" + pedido.getPoblacion());
			pst.setString(6, "" + pedido.getProvincia());
			pst.setString(7, "" + pedido.getDomicilio());
			pst.setString(8, "" + pedido.getDestinatario());
			
			pst.executeUpdate();
			con = "SELECT codigo FROM pedidos ORDER BY codigo DESC";
			Statement s = conexionBD.createStatement();
			resultado = s.executeQuery(con);
			resultado.next();
			
			return resultado.getInt("codigo");
		}
		catch (SQLException e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
            return 0;
		}
	}
	
	public List<Pedidos> obtenerPedidosNumBD () {
		abrirConexionBD ();
		
		ResultSet resultado = null;
		List<Pedidos> pedidos = new ArrayList<> ();
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT codigo, persona, fecha, importe, estado FROM pedidos";
			resultado = s.executeQuery(con);
			
			while (resultado.next()) {
				Pedidos pedido = new Pedidos ();
				pedido.setId(resultado.getInt("codigo"));
				pedido.setUsuario(resultado.getInt("persona"));
				pedido.setFecha(resultado.getString("fecha"));
				pedido.setImporte(resultado.getFloat("importe"));
				pedido.setEstado(resultado.getInt("estado"));
				pedidos.add(pedido);
			}
		}
		catch (SQLException e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return pedidos;
	}
	
	public List<Pedidos> obtenerPedidosUsuarioBD (int id_usu) {
		abrirConexionBD ();
		
		ResultSet  resultado = null;
		List <Pedidos> pedidos = new ArrayList<> ();
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT codigo, fecha, importe, estado FROM pedidos WHERE persona =" + id_usu;
			resultado = s.executeQuery(con);
			
			while (resultado.next()) {
				Pedidos pedido = new Pedidos ();
				
				pedido.setId(resultado.getInt("codigo"));
				pedido.setFecha(resultado.getString("fecha"));
				pedido.setEstado(resultado.getInt("estado"));
				pedido.setImporte(resultado.getInt("importe"));
				pedido.setUsuario(id_usu);
				pedidos.add(pedido);
			}
		}
		catch (SQLException e){
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return pedidos;
	}
	
	public boolean deletePedidosNumBD (int id) {
		abrirConexionBD ();
		
		boolean resultado = false;
		
		try {
			String con = "DELETE FROM pedidos WHERE codigo = " + id;
			PreparedStatement pst = conexionBD.prepareStatement(con);
			int res = pst.executeUpdate();
			if (res >= 0)
				resultado = true;
		}
		catch (Exception e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return resultado;
	}
	
	public boolean modificarEstadoPedido (int id_ped, int estado) {
		abrirConexionBD ();
		
		boolean resultado = false;
		
		try {
			String con = "UPDATE pedidos SET estado = ? WHERE codigo = " + id_ped;
			PreparedStatement pst = conexionBD.prepareStatement(con);
			pst.setString(1, "" + estado);
			int res = pst.executeUpdate();
			if (res >= 0) 
				resultado = true;
		}
		catch (Exception e){
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return resultado;
	}
	
	
	// OPERACIONES DE DETALLE SOBRE LA BD
	public boolean insertarDetalleBD (Detalles detalle, int id) {
		abrirConexionBD ();
		
		boolean resultado = false;
		
		try {
			String con = "INSERT INTO detalle (codigo_pedido, codigo_producto, unidades, precio_unitario) VALUES ((SELECT MAX(codigo) FROM pedidos WHERE persona = ?), ?, ?, ?)";
			PreparedStatement pst = conexionBD.prepareStatement(con);
			pst.setString(1, "" + id);
			pst.setString(2, "" + detalle.getCodigo());
			pst.setString(3, "" + detalle.getUnidades());
			pst.setString(4, "" + detalle.getPrecio_unitario());
			int res = pst.executeUpdate();
			if (res >= 0)
				resultado = true;
		}
		catch (SQLException e) {
			System.out.println("Error ejecutando la consulta a la base de datos " + e);
		}
		
		return resultado;
	}
	
	public List<Detalles> obtenerDetallesBD (int pedido) {
		abrirConexionBD ();
		
		ResultSet resultado = null;
		List <Detalles> detalles = new ArrayList<> ();
		
		try {
			Statement s = conexionBD.createStatement();
			String con = "SELECT codigo_pedido, codigo_producto, unidades, precio_unitario FROM detalle WHERE codigo_pedido = " + pedido;
			resultado = s.executeQuery(con);
			
			while (resultado.next()) {
				Detalles detalle = new Detalles ();
				
				detalle.setId_pedido(pedido);
				detalle.setCodigo(resultado.getInt("codigo_producto"));
				detalle.setPrecio_unitario(resultado.getFloat("precio_unitario"));
				detalle.setUnidades(resultado.getInt("unidades"));
				detalles.add(detalle);
			}
		}
		catch (SQLException e){
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return detalles;
	}
	
	public boolean deleteDetallesNumPed (int id) {
		abrirConexionBD ();
		
		boolean resultado = false;
		
		try {
			String con = "DELETE FROM detalle WHERE codigo_pedido = " + id;
			PreparedStatement pst = conexionBD.prepareStatement(con);
			int res = pst.executeUpdate();
			if (res >= 0)
				resultado = true;
		}
		catch (Exception e) {
			System.out.println("Error ejecutando la consulta a la base de datos" + e);
		}
		
		return resultado;
	}
}