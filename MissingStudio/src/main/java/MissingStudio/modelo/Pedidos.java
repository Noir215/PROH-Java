package MissingStudio.modelo;

public class Pedidos {
	private int id;
	private int usuario;
	private String fecha;
	private float importe;
	private int estado;
	private String metodo;
	private String poblacion;
	private String provincia;
	private String domicilio;
	private String destinatario;
	
	/*public Pedidos(int id, int usuario, String fecha, float importe, int estado, String metodo, String poblacion, String provincia, String domicilio, String destinatario) {
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.importe = importe;
		this.estado = estado;
		this.metodo = metodo;
		this.poblacion = poblacion;
		this.provincia = provincia;
		this.domicilio = domicilio;
		this.destinatario = destinatario;
	}*/
	
	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public int getId() {
		return id;
	}
	
	public String getPoblacion() {
		return poblacion;
	}
	
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	
	public String getDestinatario() {
		return destinatario;
	}
	
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public float getImporte() {
		return importe;
	}
	
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {
		this.estado = estado;
	}	
}