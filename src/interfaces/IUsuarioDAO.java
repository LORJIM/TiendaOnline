package interfaces;
import java.util.Vector;

import beans.Usuario;

public interface IUsuarioDAO {
	public Usuario findbyId(String usuario);
	public void add(Usuario usuario);
	public void save(Usuario usuario);
	public Vector<Usuario>findAll();
	public void delete(String usuario);
	
}

