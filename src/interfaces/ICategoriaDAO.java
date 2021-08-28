package interfaces;

import java.util.Vector;

import beans.Categoria;
import beans.Usuario;

public interface ICategoriaDAO {
	public Categoria findbyId(int id_categoria);
	public void add(Categoria categoria);
	public void save(Categoria categoria);
	public Vector<Categoria>findAll();
	public void delete(int id_categoria);
}
