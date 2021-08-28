package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Categoria;
import beans.Usuario;
import interfaces.IUsuarioSERVICE;
import service.UsuarioSERVICE;

/**
 * Servlet implementation class S_Registro
 */
@WebServlet("/S_Registro")
public class S_Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public S_Registro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//HttpSession session = request.getSession(true);
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String mensaje = "";
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Index.jsp");
		IUsuarioSERVICE usuarioservice = new UsuarioSERVICE();
		Usuario aux = usuarioservice.busqueda_by_usuario(usuario);
		Usuario u = new Usuario(usuario, password, email);
		request.setAttribute("usuario", u);
		if (password.equals(password2)) {
			if (aux == null) {
				usuarioservice.add_usuario(u);
				mensaje = "Usuario registrado con exito";
			} else {
				mensaje = "Ya existe un usuario con ese nombre";
				rd = request.getRequestDispatcher("Registro.jsp");
			}
		}else {
			mensaje="Las contraseñas no coinciden";
			rd = request.getRequestDispatcher("Registro.jsp");
		}
		request.setAttribute("mensaje", mensaje);
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
