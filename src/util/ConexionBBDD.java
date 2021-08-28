package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	private static Connection conexion;
	public static Connection conectarbbdd() {
		try {
			String datosconexion="jdbc:mysql://localhost:3306/curso?user=root";
			System.out.println("antes de cargar el driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("despues de cargar el driver");
			conexion=DriverManager.getConnection(datosconexion);
			conexion.setAutoCommit(true); //SI LO PONEMOS A FALSE, NOS OBLIGARA A HACER UN COMMIT CADA VEZ QUE QUERAMOS EJECUTAR UNA CONSULTA/SERVICE, SINO NO SE EJECUTARA
			System.out.println("Conexion establecida");
			return conexion;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	public static void commit() { //ESTE ES EL COMMIT QUE TENDREMOS QUE LLAMAR PARA PODER EJECUTAR, ESTO SERVIRIA PARA CONFIRMAR COMPRAS
		try {
			conexion.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void rollback() { //ESTO NOS PERMITIRIA DESHACER, ESTO SERVIRIA PARA CANCELAR COMPRAS
		try {
			conexion.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void desconectarbbdd() {
		try {
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

