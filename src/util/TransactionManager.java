package util;
import dao.Cab_FacturaDAO;
import dao.CategoriaDAO;
import dao.Pos_FacturaDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import interfaces.ICab_FacturaDAO;
import interfaces.ICategoriaDAO;
import interfaces.IPos_FacturaDAO;
import interfaces.IProductoDAO;
import interfaces.IUsuarioDAO;

import java.sql.Connection;

public class TransactionManager {
	private Connection conexion;

	public TransactionManager() {
		super();
		conexion=ConexionBBDD.conectarbbdd();
	}
	public IUsuarioDAO getUsuarioDAO(){
		return new UsuarioDAO(conexion);
	}
	public ICategoriaDAO getCategoriaDAO() {
		return new CategoriaDAO(conexion);
	}
	public IProductoDAO getProductoDAO() {
		return new ProductoDAO(conexion);
	}
	public ICab_FacturaDAO getCab_FacturaDAO() {
		return new Cab_FacturaDAO(conexion);
	}
	public IPos_FacturaDAO getPos_FacturaDAO() {
		return new Pos_FacturaDAO(conexion);
	}
	public void cerrarconexion() {
		ConexionBBDD.desconectarbbdd();
	}
	public void commit() {
		ConexionBBDD.commit();
	}
	public void rollback() {
		ConexionBBDD.rollback();
	}
}
