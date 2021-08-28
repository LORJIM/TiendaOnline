package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Carrito;
import beans.Categoria;
import beans.Producto;
import beans.Usuario;
import interfaces.ICategoriaSERVICE;
import interfaces.IProductoSERVICE;
import interfaces.IUsuarioSERVICE;
import service.CategoriaSERVICE;
import service.ProductoSERVICE;
import service.UsuarioSERVICE;

/**
 * Servlet implementation class S_Login
 */
@WebServlet("/S_Login")
public class S_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String mensaje="";
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Index.jsp");
		ICategoriaSERVICE categoriaservice=new CategoriaSERVICE();
		Vector<Categoria> categorias=categoriaservice.listado_categoria();
		IUsuarioSERVICE usuarioservice = new UsuarioSERVICE();
		Usuario aux = usuarioservice.busqueda_by_usuario(usuario);
		if (aux==null) {
			mensaje="Usuario incorrecto";
		}else {
			if (password.equals(aux.getPassword())) {
				mensaje="Bienvenido "+usuario;
				rd = request.getRequestDispatcher("Categorias.jsp");
			}else {
				mensaje="Contraseña incorrecta";
			}
		}
		if (request.getParameter("recordar")!=null) { //EL VALUE DE RECORDAR ES RECORDAR CUANDO ESTA CLICKAO
//			CREO LAS COOKIES    NOTA: IMPORTAR EL PAQUETE DE COOKIES SERVLET
			Cookie usuario_sesion=new Cookie("usuario",usuario); //usuario es el nombre de la cookie que puedo llamar en html
			Cookie password_sesion=new Cookie("pass_sesion",password);
			usuario_sesion.setMaxAge(8000); //duracion de las cookies
			password_sesion.setMaxAge(8000);
//			GUARDO LAS COOKIES
			response.addCookie(usuario_sesion);
			response.addCookie(password_sesion);
		}
		ArrayList<Carrito> carrito=new ArrayList();
		session.setAttribute("carrito", carrito);
		session.setAttribute("mensaje", mensaje);
		session.setAttribute("usuario",usuario);
		session.setAttribute("categorias",categorias);
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
