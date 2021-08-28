package beans;

public class Cab_Factura {
	private int id_factura;
	private String usuario;
	
	public Cab_Factura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cab_Factura(int id_factura, String usuario) {
		super();
		this.id_factura = id_factura;
		this.usuario = usuario;
	}

	public int getId_factura() {
		return id_factura;
	}

	public void setId_factura(int id_factura) {
		this.id_factura = id_factura;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
