package MissingStudio.modelo;

public class Detalles {
	private int id_pedido;
	private int unidades;
	private int codigo;
	private float precio_unitario;
	
	/*public Detalles (Producto producto, Pedidos pedido) {
		this.codigo = producto.getId();
		this.precio_unitario = producto.getPrecio();
		this.unidades = producto.getCantidad();
		this.id_pedido = pedido.getId();
	}*/

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	
}