package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;
import beans.Usuario;
import interfaces.ICategoriaDAO;

public class CategoriaDAO implements ICategoriaDAO {
	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;
	private PreparedStatement plantillaSQL;
	public CategoriaDAO(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	@Override
	public Categoria findbyId(int id_categoria) {
		Categoria aux=null;
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Categorias WHERE ID_CATEGORIA=?");
			plantillaSQL.setInt(1, id_categoria);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Categoria();
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setDescripcion(resultado.getString("descripcion"));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return aux;
	}

	@Override
	public void add(Categoria categoria) {
		try {
			plantillaSQL=conexion.prepareStatement("INSERT INTO CATEGORIAS VALUE(?,?)");
			plantillaSQL.setInt(1, categoria.getId_categoria());
			plantillaSQL.setString(2, categoria.getDescripcion());
			System.out.println(plantillaSQL);
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	

	@Override
	public void save(Categoria categoria) {
		try {
			plantillaSQL=conexion.prepareStatement("UPDATE CATEGORIAS SET DESCRIPCION=? "+"WHERE ID_CATEGORIA=?");
			plantillaSQL.setInt(2, categoria.getId_categoria());
			plantillaSQL.setString(1, categoria.getDescripcion());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public Vector<Categoria> findAll() {
		Vector<Categoria> lista=new Vector();
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Categorias");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Categoria aux=new Categoria();
				aux.setId_categoria(resultado.getInt("id_categoria"));
				aux.setDescripcion(resultado.getString("descripcion"));
				lista.add(aux);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(int id_categoria) {
		try {
			plantillaSQL=conexion.prepareStatement("DELETE FROM CATEGORIAS WHERE id_categoria=?");
			plantillaSQL.setInt(1, id_categoria);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
