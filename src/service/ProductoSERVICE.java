package service;

import java.util.Vector;

import beans.Producto;
import beans.Usuario;
import interfaces.IProductoDAO;
import interfaces.IProductoSERVICE;
import interfaces.IUsuarioDAO;
import util.TransactionManager;

public class ProductoSERVICE implements IProductoSERVICE {

	@Override
	public void add_producto(Producto p) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IProductoDAO productoDAO=manager.getProductoDAO();
		productoDAO.add(p);
		manager.cerrarconexion();
	}

	@Override
	public Vector<Producto> listado_producto() {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IProductoDAO productoDAO=manager.getProductoDAO();
		Vector<Producto> lista=productoDAO.findAll();
		manager.cerrarconexion();
		return lista;
	}

	@Override
	public Producto busqueda_by_producto(int id_producto) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IProductoDAO productoDAO=manager.getProductoDAO();
		Producto p=productoDAO.findbyId(id_producto);
		manager.cerrarconexion();
		return p;
	}

	@Override
	public void borrar_producto(int id_producto) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IProductoDAO productoDAO=manager.getProductoDAO();
		productoDAO.delete(id_producto);
		manager.cerrarconexion();

	}

	@Override
	public void modificar_producto(Producto producto) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IProductoDAO productoDAO=manager.getProductoDAO();
		productoDAO.save(producto);
		manager.cerrarconexion();

	}

}
