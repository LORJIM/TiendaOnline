package interfaces;

import java.util.Vector;

import beans.Usuario;

public interface IUsuarioSERVICE {
	public void add_usuario(Usuario u);
	public Vector<Usuario> listado_usuario();
	public Usuario busqueda_by_usuario(String usuario);
	public void borrar_usuario(String usuario);
	public void modificar_usuario(Usuario usuario);
}
