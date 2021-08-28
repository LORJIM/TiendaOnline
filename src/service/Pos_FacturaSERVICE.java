package service;

import beans.Pos_Factura;
import interfaces.IPos_FacturaDAO;
import interfaces.IPos_FacturaSERVICE;
import util.TransactionManager;

public class Pos_FacturaSERVICE implements IPos_FacturaSERVICE {

	@Override
	public void add_pos_factura(Pos_Factura p) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		IPos_FacturaDAO Pos_FacturaDAO=manager.getPos_FacturaDAO();
		Pos_FacturaDAO.add(p);
		manager.cerrarconexion();
	}

}
