package interfaces;

import java.util.Vector;

import beans.Categoria;
import beans.Usuario;

public interface ICategoriaSERVICE {
	public void add_categoria(Categoria c);
	public Vector<Categoria> listado_categoria();
	public Categoria busqueda_by_categoria(int id_categoria);
	public void borrar_categoria(int id_categoria);
	public void modificar_categoria(Categoria categoria);
}
