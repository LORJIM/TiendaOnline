package interfaces;

import java.util.Vector;

import beans.Categoria;
import beans.Producto;

public interface IProductoSERVICE {
	public void add_producto(Producto p);
	public Vector<Producto> listado_producto();
	public Producto busqueda_by_producto(int id_producto);
	public void borrar_producto(int id_producto);
	public void modificar_producto(Producto producto);
}
