package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cab_Factura;
import beans.Carrito;
import beans.Pos_Factura;
import beans.Producto;
import interfaces.ICab_FacturaSERVICE;
import interfaces.IPos_FacturaSERVICE;
import interfaces.IProductoSERVICE;
import service.Cab_FacturaSERVICE;
import service.Pos_FacturaSERVICE;
import service.ProductoSERVICE;

/**
 * Servlet implementation class S_Comprar
 */
@WebServlet("/S_Comprar")
public class S_Comprar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S_Comprar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String mensaje="";
		String accion = request.getParameter("accion"); //PARA EL SWITCH
		String usuario= (String)session.getAttribute("usuario"); //SUBO EL USUARIO DE LA SESION, INICIADO EN EL S_LOGIN
		double total= (Double)session.getAttribute("total"); //SUBO EL TOTAL DEL CARRITO
		int accion2 = Integer.parseInt(accion);
		ICab_FacturaSERVICE facturaservice=new Cab_FacturaSERVICE(); //INTERFACES QUE VOY A UTILIZAR
		IPos_FacturaSERVICE factura2service=new Pos_FacturaSERVICE();
		IProductoSERVICE productoservice=new ProductoSERVICE();
		ArrayList<Carrito> carrito = (ArrayList) session.getAttribute("carrito"); //SUBO EL CARRITO
		switch (accion2) {
		case 1: //CASO CANCELAR
			session.invalidate(); //CIERRO Y ELIMINO LA SESION
			mensaje="Ha cerrado la sesion";
			break;
		case 2: //CASO COMPRAR
			int id=facturaservice.add_cab_factura(new Cab_Factura(0,usuario)); //NUEVA FACTURA PARA EL USUARIO DE LA SESION ACTUAL CON ID=AL ID DE FACTURA AUTOINCREMENTADO
			int posicion=1; //PRIMERA POSICION DE LA FACTURA
			String cuerpo=""; //ESTO SERA EL CUERPO DEL EMAIL
			String cuerpoaux="Esta es la Factura numero "+id+" con los siguientes PRODUCTOS: \n"; //ESTO ES LA INTRODUCCION DEL CORREO QUE MANDARE
			String cuerpofin="---------------------------------- \n TOTAL DEL PEDIDO: "+total; //ESTO ES EL FINAL DEL CORREO QUE MANDARE
			for (Carrito carrito2 : carrito) { //RECORRO EL CARRITO
				Pos_Factura p=new Pos_Factura(id,posicion++,carrito2.getId_producto(),carrito2.getCantidad()); //HAGO UNA POSICION DE FACTURA CON LOS DATOS DEL ELEMENTO DEL CARRITO
				factura2service.add_pos_factura(p); //AÑADO DICHA POSICION A LA BBDD
				Producto producto=productoservice.busqueda_by_producto(p.getId_producto()); //BUSCO EL PRODUCTO DEL CARRITO
				producto.setStock(producto.getStock()-carrito2.getCantidad()); //ACTUALIZO EL STOCK DEL PRODUCTO ACTUAL RESTANDOLE LA CANTIDAD QUE HE COMPRADO
				productoservice.modificar_producto(producto); //ACTUALIZO EL STOCK EN LA BBDD DE DICHO PRODUCTO
			    cuerpo+=producto.getDescripcion()+" UNIDADES: "+p.getCantidad()+" PRECIO: "+producto.getPrecio()*p.getCantidad()+"\n"; //SUMATORIO DE LO QUE MANDARE POR CORREO, CON NOMBRE DE PRODUCTO Y SU CANTIDAD COMPRADA, LUEGO EN EL PRECIO COJO EL PRECIO DEL PRODUCTO Y LA CANTIDAD DEL CARRITO
			}
			mensaje="Compra realizada con éxito"; //ESTE MENSAJE SE LO PASAREMOS AL LOGIN
			String destinatario =  "jaumatino2@gmail.com"; //A quien le quieres escribir.
		    String asunto = "FACTURA";
		    cuerpo=cuerpoaux + cuerpo + cuerpofin; //LE SUMO LA INTRODUCCION DEL CORREO AL CORREO
		    enviarConGMail(destinatario, asunto, cuerpo);
			break;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("Index.jsp");
		request.setAttribute("mensaje", mensaje);
		rd.forward(request, response);
	}

	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    final String remitente = "jaumatino2";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "Madafaka8");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "Madafaka8");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
