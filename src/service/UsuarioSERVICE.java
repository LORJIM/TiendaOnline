package service;
import util.TransactionManager;
import java.util.Vector;
import interfaces.IUsuarioDAO;
import beans.Usuario;
import interfaces.IUsuarioSERVICE;
import util.TransactionManager;

public class UsuarioSERVICE implements IUsuarioSERVICE {

	@Override
	public void add_usuario(Usuario u) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IUsuarioDAO usuarioDAO=manager.getUsuarioDAO();
		usuarioDAO.add(u);
		manager.cerrarconexion();
	}

	@Override
	public Vector<Usuario> listado_usuario() {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IUsuarioDAO usuarioDAO=manager.getUsuarioDAO();
		Vector<Usuario> lista=usuarioDAO.findAll();
		manager.cerrarconexion();
		return lista;
	}

	@Override
	public Usuario busqueda_by_usuario(String usuario) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IUsuarioDAO usuarioDAO=manager.getUsuarioDAO();
		Usuario u=usuarioDAO.findbyId(usuario);
		manager.cerrarconexion();
		return u;
	}

	@Override
	public void borrar_usuario(String usuario) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IUsuarioDAO usuarioDAO=manager.getUsuarioDAO();
		usuarioDAO.delete(usuario);
		manager.cerrarconexion();
	}

	@Override
	public void modificar_usuario(Usuario usuario) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IUsuarioDAO usuarioDAO=manager.getUsuarioDAO();
		usuarioDAO.save(usuario);
		manager.cerrarconexion();
	}

}
