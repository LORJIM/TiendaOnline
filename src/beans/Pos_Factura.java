package beans;

public class Pos_Factura {
	private int id_factura;
	private int pos_factura;
	private int id_producto;
	private int cantidad;
	public Pos_Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pos_Factura(int id_factura, int pos_factura, int id_producto, int cantidad) {
		super();
		this.id_factura = id_factura;
		this.pos_factura = pos_factura;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}
	public int getId_factura() {
		return id_factura;
	}
	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}
	public int getPos_factura() {
		return pos_factura;
	}
	public void setPos_factura(int pos_factura) {
		this.pos_factura = pos_factura;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
