package controller;

import java.io.IOException;
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
import beans.Usuario;
import interfaces.ICategoriaSERVICE;
import interfaces.IProductoSERVICE;
import interfaces.IUsuarioSERVICE;
import service.CategoriaSERVICE;
import service.ProductoSERVICE;
import service.UsuarioSERVICE;

/**
 * Servlet implementation class S_Listados
 */
@WebServlet("/S_Listados")
public class S_Listados extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Listados() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true); //ESTO INICIA UNA NUEVA SESION PARA PODER CONSEGUIR O TRANSMITIR ATRIBUTOS MEDIANTE SESION
		String option=request.getParameter("listado"); //CONSEGUIMOS EL ATRIBUTO DE LA PAGINA PRINCIPAL SEGUN LO QUE PINCHE EL USUARIO
//		request.setAttribute("option", option); //PREPARO EL ATRIBUTO QUE LE VOY A PASAR A LA PAGINA DE RESULTADO, PARA QUE PUEDA DIFERENCIAR SI SACAR LA TABLA DE USUARIOS O LA DE PRODUCTOS
		session.setAttribute("option", option); //LO MISMO DE LA LINEA DE ARRIBA PERO MEDIANTE SESION
		int option2=Integer.parseInt(option); //PASAMOS EL ATRIBUTO DE LISTADOSJSP A ENTERO PARA PODER HACER EL SWITCH
		RequestDispatcher rd;
		
		rd=request.getRequestDispatcher("Resultado.jsp");
		
		switch (option2) {
		case 1: //SI EL ATRIBUTO ES 1, HACEMOS LA LISTA DE USUARIOS
			IUsuarioSERVICE usuarioservice=new UsuarioSERVICE();
			Vector<Usuario> usuarios=usuarioservice.listado_usuario();
//			request.setAttribute("usuarios", usuarios); //PASO EL ARRAY A LA PAGINA RESULTADO MEDIANTE REQUEST
			session.setAttribute("usuarios", usuarios); //PASO EL ARRAY A LA PAGINA RESULTADO MEDIANTE SESION
		case 2: //2 PUES LA DE PRODUCTOS
			IProductoSERVICE productoservice=new ProductoSERVICE();
			Vector<Producto> productos=productoservice.listado_producto();
//			request.setAttribute("productos",productos);//PASO EL ARRAY A LA PAGINA RESULTADO MEDIANTE REQUEST
			session.setAttribute("productos", productos); //PASO EL ARRAY A LA PAGINA RESULTADO MEDIANTE SESION
		}
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
