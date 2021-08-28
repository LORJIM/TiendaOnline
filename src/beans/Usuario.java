package beans;

public class Usuario { //un bean hace el mapeo de una tabla de una BBDD, por lo que los parametros deben ser exactamente iguales a los de la tabla
	private String usuario;
	private String password;
	private String email;
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String usuario, String password, String email) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", password=" + password + ", email=" + email + "]";
	}
	
	
}
