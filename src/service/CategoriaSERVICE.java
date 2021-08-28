package service;
import util.TransactionManager;
import java.util.Vector;
import dao.CategoriaDAO;
import beans.Categoria;
import beans.Usuario;
import interfaces.ICategoriaDAO;
import interfaces.ICategoriaSERVICE;
import interfaces.IUsuarioDAO;

public class CategoriaSERVICE implements ICategoriaSERVICE {

	@Override
	public void add_categoria(Categoria c) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICategoriaDAO categoriaDAO=manager.getCategoriaDAO();
		categoriaDAO.add(c);
		//AQUI PONDRIAMOS EL COMMIT manager.commit();
		manager.cerrarconexion();
	}

	@Override
	public Vector<Categoria> listado_categoria() {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICategoriaDAO categoriaDAO=manager.getCategoriaDAO();
		Vector<Categoria> lista=categoriaDAO.findAll();
		manager.cerrarconexion();
		return lista;
	}

	@Override
	public Categoria busqueda_by_categoria(int id_categoria) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICategoriaDAO categoriaDAO=manager.getCategoriaDAO();
		Categoria c=categoriaDAO.findbyId(id_categoria);
		manager.cerrarconexion();
		return c;
	}

	@Override
	public void borrar_categoria(int id_categoria) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICategoriaDAO categoriaDAO=manager.getCategoriaDAO();
		categoriaDAO.delete(id_categoria);
		manager.cerrarconexion();
	}

	@Override
	public void modificar_categoria(Categoria categoria) {
		TransactionManager manager=null;
		manager=new TransactionManager();
		ICategoriaDAO categoriaDAO=manager.getCategoriaDAO();
		categoriaDAO.save(categoria);
		manager.cerrarconexion();
	}

}
