package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Categoria;
import beans.Producto;
import interfaces.ICategoriaSERVICE;
import interfaces.IProductoSERVICE;
import service.CategoriaSERVICE;
import service.ProductoSERVICE;

/**
 * Servlet implementation class S_Productos
 */
@WebServlet("/S_Productos")
public class S_Productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Productos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String idcategoria=request.getParameter("idcategoria");
		String descripcion=request.getParameter("descripcion");
		int id_categoria=Integer.parseInt(idcategoria);
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Productos.jsp");
		IProductoSERVICE productoservice=new ProductoSERVICE();
		Vector<Producto> productos=productoservice.listado_producto();
		ArrayList<Producto> productos2=new ArrayList();
		for (Producto producto : productos) {
			if (id_categoria==producto.getId_categoria()){
				productos2.add(producto);
			}
		}
		session.setAttribute("productos", productos2);
		session.setAttribute("descripcion", descripcion);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
