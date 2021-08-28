package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.Cab_Factura;
import interfaces.ICab_FacturaDAO;

public class Cab_FacturaDAO implements ICab_FacturaDAO {
	private Connection conexion;
	private Statement sentencia;
	private ResultSet resultado;
	private PreparedStatement plantillaSQL;
	public Cab_FacturaDAO(Connection conexion) {
		super();
		this.conexion = conexion;
	}
	@Override
	public int add(Cab_Factura cab_factura) {
		int facturamax=0;
		try {
			plantillaSQL=conexion.prepareStatement("INSERT INTO CAB_FACTURA VALUE(0,?)");
			plantillaSQL.setString(1, cab_factura.getUsuario());
			System.out.println(plantillaSQL);
			plantillaSQL.execute();
			plantillaSQL=conexion.prepareStatement("SELECT MAX(id_factura) AS ID_FACTURA FROM CAB_FACTURA");
			resultado=plantillaSQL.executeQuery();
			
			if (resultado.next()) {
				facturamax=resultado.getInt("id_factura");
			}
			
			}catch (Exception e) {
			System.out.println(e);
			}
			return facturamax;
}
}