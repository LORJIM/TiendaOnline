package beans;

public class Carrito extends Producto {
	public int cantidad;

	

	public Carrito(int id_producto, String descripcion, int id_categoria, double precio, int stock, int cantidad) {
		super(id_producto, descripcion, id_categoria, precio, stock);
		this.cantidad=cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
