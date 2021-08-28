package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Categoria;
import interfaces.ICategoriaSERVICE;
import service.CategoriaSERVICE;

/**
 * Servlet implementation class S_Categoria
 */
@WebServlet("/S_Categoria")
public class S_Categoria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Categoria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd;
		String id=request.getParameter("idcategoria");//LEEMOS PARAMETROS
		int id2=Integer.parseInt(id);
		String descripcion=request.getParameter("descripcion");
		rd=request.getRequestDispatcher("Fin.jsp"); //INDICO LA PAGINA, QUE PUEDE SER DE EXITO O ERROR, SEGUN EL MENSAJE
		String mensaje="";
		try {
		if (id!=null && descripcion!="") { //COMPROBAMOS SI HAN RELLENADO LOS CAMPOS
			ICategoriaSERVICE categoriaservice=new CategoriaSERVICE();
			Categoria aux2=categoriaservice.busqueda_by_categoria(id2); //COMPROBAMOS SI YA EXISTE
			if(aux2==null){
			System.out.println("Categoria no existe");
			Categoria c=new Categoria(id2,descripcion);
			categoriaservice.add_categoria(c); //AÑADIMOS
			mensaje="Categoria insertada con exito";
			//rd=request.getRequestDispatcher("Exito.html"); //INDICAMOS LA PAGINA DE EXITO
			}else { //SI LA CATEGORIA YA EXISTE
				System.out.println("Categoria ya existe");
				mensaje="No se pudo insertar, la categoria ya existe";
				rd=request.getRequestDispatcher("Categoria.jsp");
				//rd=request.getRequestDispatcher("Categoria.html"); //INDICAMOS LA PAGINA DE ERROR
			}
		}
		else {
			mensaje="No se pudo insertar, campos sin rellenar";
			rd=request.getRequestDispatcher("Categoria.jsp");
		}
		}catch(Exception e) { //SI HAY ALGUN OTRO TIPO DE ERROR
			System.out.println(e);
			mensaje="no se pudo insertar,error impresionante";
			rd=request.getRequestDispatcher("Categoria.jsp");
			//rd=request.getRequestDispatcher("Error.html");
			
		}
		request.setAttribute("mensaje", mensaje);//PASO EL MENSAJE AL JSP, el primero es la clave, el segundo es el valor, el inicializado antes (la frase vaya)
		rd.forward(request, response); //LANZAMOS LA PAGINA
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
