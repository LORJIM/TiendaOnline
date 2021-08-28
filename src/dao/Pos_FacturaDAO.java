package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Pos_Factura;
import interfaces.IPos_FacturaDAO;

public class Pos_FacturaDAO implements IPos_FacturaDAO {
	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;
	private PreparedStatement plantillaSQL;
	public Pos_FacturaDAO(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	@Override
	public void add(Pos_Factura pos_factura) {
		try {
			plantillaSQL=conexion.prepareStatement("INSERT INTO POS_FACTURA VALUE(?,?,?,?)");
			plantillaSQL.setInt(1, pos_factura.getId_factura());
			plantillaSQL.setInt(2, pos_factura.getPos_factura());
			plantillaSQL.setInt(3, pos_factura.getId_producto());
			plantillaSQL.setInt(4, pos_factura.getCantidad());
			System.out.println(plantillaSQL);
			plantillaSQL.execute();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
