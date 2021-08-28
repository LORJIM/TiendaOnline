package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import beans.Categoria;
import beans.Producto;
import beans.Usuario;
import interfaces.ICategoriaSERVICE;
import interfaces.IProductoSERVICE;
import interfaces.IUsuarioSERVICE;
import service.CategoriaSERVICE;
import service.ProductoSERVICE;
import service.UsuarioSERVICE;
import util.ConexionBBDD;

import java.sql.DriverManager;

public class Test_01 {
	
	
	public static void main(String[] args) {
		IUsuarioSERVICE usuarioservice=new UsuarioSERVICE();
		/*Usuario u=new Usuario("Pepe","pepepass","pepe@gmail.com");
		usuarioservice.add_usuario(u); AÑADIR USUARIO*/
		
		/*Vector<Usuario> lista=usuarioservice.listado_usuario();
		for (Usuario usuario : lista) {
			System.out.println(usuario.toString());
		} LISTAR USUARIOS*/
		
		/*String u="Pepe";
		usuarioservice.borrar_usuario(u); BORRAR USUARIO*/
		
		/*Usuario u=new Usuario("Pepe","pepepass2","pepe@gmail.com");
		usuarioservice.modificar_usuario(u);MODIFICAR USUARIO*/
		
		/*Usuario aux=usuarioservice.busqueda_by_usuario("Pepe");
		if(aux==null){
		System.out.println("Usuario no existe");
		}else {
			System.out.println(aux);
		}BUSCAR POR USUARIO*/
		
		//CATEGORIAS
		ICategoriaSERVICE categoriaservice=new CategoriaSERVICE();
		
		//AÑADIR CATEGORIA
		
		/*Categoria c=new Categoria(3,"teclados");
		categoriaservice.add_categoria(c);*/
		
		//LISTAR CATEGORIAS
		
		/*Vector<Categoria> lista=categoriaservice.listado_categoria();
		for (Categoria categoria : lista) {
			System.out.println(categoria.toString());
		}*/
		
		//BORRAR CATEGORIAS 
		
		/*int c=3;
		categoriaservice.borrar_categoria(c);*/
		
		//MODIFICAR CATEGORIAS
		
		/*Categoria c=new Categoria(2,"Teclados");
		categoriaservice.modificar_categoria(c);*/
		
		//BUSCAR CATEGORIAS
		
		/*Categoria aux=categoriaservice.busqueda_by_categoria(2);
		if(aux==null){
		System.out.println("Categoria no existe");
		}else {
			System.out.println(aux);
		}*/
		
		//PRODUCTOS
		IProductoSERVICE productoservice=new ProductoSERVICE();
		
		//AÑADIR PRODUCTOS
		
		/*try {  //ESTO ES PARA COMPROBAR SI EXISTE LA CATEGORIA, EL PROBLEMA ES QUE SI NO COINCIDE LA PRIMERA VEZ QUE SE EJECUTA, PUES SALTA LA EXCEPCION SIN COMPROBAR EL RESTO DEL ARRAY
			Producto p=new Producto(7,"impresora epson",7,5,10);
			Vector<Categoria> lista=categoriaservice.listado_categoria();
			boolean seguir=true;
			if(seguir==true) {
			for (Categoria categoria : lista) {
				if (p.getId_categoria()==categoria.getId_categoria()) {
					productoservice.add_producto(p);
					break;
				}
				seguir=false;
				
			}
			}
			if (seguir==false) throw new Exception("El ID de categoria no existe");
		}catch(Exception e) {
			System.out.println(e);
		} */
		
		//LISTAR PRODUCTOS
		
		/*Vector<Producto> lista=productoservice.listado_producto();
		for (Producto producto : lista) {
			System.out.println(producto.toString());
		}*/
		
		//BORRAR PRODUCTOS
		
		/*int p=5;
		productoservice.borrar_producto(p);*/
		
		//MODIFICAR PRODUCTOS
		
		/*try {  //ESTO ES PARA COMPROBAR SI EXISTE LA CATEGORIA, EL PROBLEMA ES QUE SI NO COINCIDE LA PRIMERA VEZ QUE SE EJECUTA, PUES SALTA LA EXCEPCION SIN COMPROBAR EL RESTO DEL ARRAY
			Producto p=new Producto(5,"Teclado Mars Gaming",3,5,9);
			Vector<Categoria> lista=categoriaservice.listado_categoria();
			boolean seguir=true;
			if(seguir==true) {
			for (Categoria categoria : lista) {
				if (p.getId_categoria()==categoria.getId_categoria()) {
					productoservice.modificar_producto(p);
					break;
				}
				seguir=false;
				
			}
			}
			if (seguir==false) throw new Exception("El ID de categoria no existe");
		}catch(Exception e) {
			System.out.println(e);
		}*/
		
		//BUSCAR PRODUCTOS
		
		/*Producto aux=productoservice.busqueda_by_producto(2);
		if(aux==null){
		System.out.println("Categoria no existe");
		}else {
			System.out.println(aux);
		}*/
		
		
		
	}

}
