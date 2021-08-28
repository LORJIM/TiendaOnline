package interfaces;

import java.util.Vector;

import beans.Categoria;
import beans.Producto;

public interface IProductoDAO {
	public Producto findbyId(int id_producto);
	public void add(Producto producto);
	public void save(Producto producto);
	public Vector<Producto>findAll();
	public void delete(int id_producto);
}
