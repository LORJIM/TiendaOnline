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

/**
 * Servlet implementation class S_Borrar
 */
@WebServlet("/S_Borrar")
public class S_Borrar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S_Borrar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String idproducto = request.getParameter("id_producto");
		int id_producto = Integer.parseInt(idproducto);
		String accion = request.getParameter("accion");
		int accion2 = Integer.parseInt(accion);
		ArrayList<Carrito> carrito = (ArrayList) session.getAttribute("carrito");
		double total = (Double) session.getAttribute("total");
		switch (accion2) { 
		case 1:
			for (Carrito carrito2 : carrito) {
				if (carrito2.getId_producto() == id_producto) {
					carrito2.setCantidad(carrito2.getCantidad() + 1);
					total += carrito2.getPrecio();
				}
			}
			break;
		case 2:
			for (Carrito carrito2 : carrito) {
				if (carrito2.getId_producto() == id_producto) {
					if (carrito2.getCantidad() == 1) {
						carrito.remove(carrito2);
					} else {
						carrito2.setCantidad(carrito2.getCantidad() - 1);
					}
					total -= carrito2.getPrecio();
				}
			}
			break;
		case 3: 
			for (int i = 0; i < carrito.size(); i++) {
				if (carrito.get(i).getId_producto()==id_producto) {
					total-=carrito.get(i).getPrecio()*carrito.get(i).getCantidad();
					carrito.remove(i);
				}
			}
			break;
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Carrito.jsp");
		session.setAttribute("carrito", carrito);
		session.setAttribute("total", total);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
