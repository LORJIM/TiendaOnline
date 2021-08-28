package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;
import beans.Producto;
import beans.Usuario;
import interfaces.IProductoDAO;

public class ProductoDAO implements IProductoDAO {
	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;
	private PreparedStatement plantillaSQL;
	public ProductoDAO(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	@Override
	public Producto findbyId(int id_producto) {
		Producto aux=null;
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Productos WHERE ID_PRODUCTO=?");
			plantillaSQL.setInt(1, id_producto);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Producto();
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setDescripcion(resultado.getString("descripcion"));
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setPrecio(resultado.getDouble("precio"));
				aux.setStock(resultado.getInt("stock"));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return aux;
	}

	@Override
	public void add(Producto producto) {
		try {
			plantillaSQL=conexion.prepareStatement("INSERT INTO PRODUCTOS VALUE(?,?,?,?,?)");
			plantillaSQL.setInt(1, producto.getId_producto());
			plantillaSQL.setString(2, producto.getDescripcion());
			plantillaSQL.setInt(3, producto.getId_categoria());
			plantillaSQL.setDouble(4, producto.getPrecio());
			plantillaSQL.setInt(5, producto.getStock());
			System.out.println(plantillaSQL);
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void save(Producto producto) {
		try {
			plantillaSQL=conexion.prepareStatement("UPDATE PRODUCTOS SET DESCRIPCION=?,ID_CATEGORIA=?,PRECIO=?,STOCK=? "+"WHERE ID_PRODUCTO=?");
			plantillaSQL.setInt(5, producto.getId_producto());
			plantillaSQL.setString(1, producto.getDescripcion());
			plantillaSQL.setInt(2, producto.getId_categoria());
			plantillaSQL.setDouble(3, producto.getPrecio());
			plantillaSQL.setInt(4, producto.getStock());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e){
			System.out.println(e);
		}

	}

	@Override
	public Vector<Producto> findAll() {
		Vector<Producto> lista=new Vector();
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Productos");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Producto aux=new Producto();
				aux.setId_producto(resultado.getInt("id_producto"));
				aux.setDescripcion(resultado.getString("descripcion"));
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setPrecio(resultado.getDouble("precio"));
				aux.setStock(resultado.getInt("stock"));
				lista.add(aux);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(int id_producto) {
		try {
			plantillaSQL=conexion.prepareStatement("DELETE FROM PRODUCTOS WHERE id_producto=?");
			plantillaSQL.setInt(1, id_producto);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
