package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Carrito;
import beans.Producto;

/**
 * Servlet implementation class S_AddCarrito
 */
@WebServlet("/S_AddCarrito")
public class S_AddCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_AddCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		ArrayList<Carrito> carrito= (ArrayList) session.getAttribute("carrito");
		String idproducto=request.getParameter("idproducto");
		boolean existe=false;
		int id=Integer.parseInt(idproducto);
		int idcategoria=0;
		int stock=0;
		int cantidad=1;
		double total=0;
		String descripcion=request.getParameter("descripcion");
		String precio=request.getParameter("precio");
		double precio2=Double.parseDouble(precio);
		for (Carrito carrito2 : carrito) {
			if (carrito2.getId_producto()==id) {
				carrito2.setCantidad(carrito2.getCantidad()+1);
				existe=true;
			}
			total+=carrito2.getCantidad()*carrito2.getPrecio();
		}
		if(existe==false) {
			Carrito producto=new Carrito(id,descripcion,idcategoria,precio2,stock,cantidad);
			carrito.add(producto);
			total+=producto.getCantidad()*producto.getPrecio();
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Productos.jsp");
		session.setAttribute("carrito", carrito);
		session.setAttribute("total",total);
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
