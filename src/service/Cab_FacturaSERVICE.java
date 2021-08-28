package service;

import beans.Cab_Factura;
import interfaces.ICab_FacturaDAO;
import interfaces.ICab_FacturaSERVICE;
import interfaces.IUsuarioDAO;
import util.TransactionManager;

public class Cab_FacturaSERVICE implements ICab_FacturaSERVICE {

	@Override
	public int add_cab_factura(Cab_Factura c) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICab_FacturaDAO Cab_FacturaDAO=manager.getCab_FacturaDAO();
		int idfactura=Cab_FacturaDAO.add(c);
		manager.cerrarconexion();
		return idfactura;
	}

}
