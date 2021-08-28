package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import beans.Usuario;
import interfaces.IUsuarioDAO;
import util.ConexionBBDD;

public class UsuarioDAO implements IUsuarioDAO {
	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;
	private PreparedStatement plantillaSQL;
	
	public UsuarioDAO(Connection conexion) {
		super();
		this.conexion = conexion;
	}

	@Override
	public Usuario findbyId(String usuario) {
		Usuario aux=null;
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Usuarios WHERE USUARIO=?");
			plantillaSQL.setString(1, usuario);
			resultado=plantillaSQL.executeQuery();
			System.out.println(plantillaSQL.toString());
			if (resultado.next()) {
				aux=new Usuario();
				aux.setUsuario(resultado.getString("usuario"));
				aux.setPassword(resultado.getString("password"));
				aux.setEmail(resultado.getString("email"));
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return aux;
	}

	@Override
	public void add(Usuario usuario) {
		try {
			plantillaSQL=conexion.prepareStatement("INSERT INTO USUARIOS VALUE(?,?,?)");
			plantillaSQL.setString(1, usuario.getUsuario());
			plantillaSQL.setString(2, usuario.getPassword());
			plantillaSQL.setString(3, usuario.getEmail());
			System.out.println(plantillaSQL);
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void save(Usuario usuario) {
		try {
			plantillaSQL=conexion.prepareStatement("UPDATE USUARIOS SET PASSWORD=?,EMAIL=? "+"WHERE USUARIO=?");
			plantillaSQL.setString(3, usuario.getUsuario());
			plantillaSQL.setString(1, usuario.getPassword());
			plantillaSQL.setString(2, usuario.getEmail());
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e){
			System.out.println(e);
		}

	}

	@Override
	public Vector<Usuario> findAll() {
		Vector<Usuario> lista=new Vector();
		try {
			plantillaSQL=conexion.prepareStatement("SELECT * FROM Usuarios");
			resultado=plantillaSQL.executeQuery();
			while (resultado.next()) {
				Usuario aux=new Usuario();
				aux.setUsuario(resultado.getString("usuario"));
				aux.setPassword(resultado.getString("password"));
				aux.setEmail(resultado.getString("email"));
				lista.add(aux);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return lista;
	}

	@Override
	public void delete(String usuario) {
		try {
			plantillaSQL=conexion.prepareStatement("DELETE FROM USUARIOS WHERE usuario=?");
			plantillaSQL.setString(1, usuario);
			System.out.println(plantillaSQL.toString());
			plantillaSQL.execute();
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
