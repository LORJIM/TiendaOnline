package test;

import java.util.Scanner;
import java.util.Vector;

import beans.Categoria;
import interfaces.ICategoriaSERVICE;
import service.CategoriaSERVICE;

public class Test_02 {

	public static void main(String[] args) {
		ICategoriaSERVICE categoriaservice=new CategoriaSERVICE();
		boolean seguir=true;
		while(seguir) {
			System.out.println("1. Añadir una categoria");
			System.out.println("2. Eliminar una categoria"); 
			System.out.println("3. Listar categorias");
			System.out.println("4. Busqueda de una categoria por ID");
			System.out.println("5. Modificar categoria");
			System.out.println("9. Salir");
		Scanner entrada=new Scanner(System.in);
		int opcion=entrada.nextInt();
		switch(opcion) {
		case 1:
			System.out.println("Introduce numero de categoria");
			int idcategoria=entrada.nextInt();
			System.out.println("Introduce nombre de categoria");
			String descripcion=entrada.next();
			try {
			Vector<Categoria> lista=categoriaservice.listado_categoria();
			 for (Categoria categoria : lista) {
				if (idcategoria==categoria.getId_categoria()) throw new Exception("ID de categoria ya existe");
				else {
					Categoria c=new Categoria(idcategoria,descripcion);
					categoriaservice.add_categoria(c);
				}
			}
			}catch(Exception e) {
				System.out.println(e);
				
			}
			break;
		case 2:
			System.out.println("Introduce numero de categoria");
			int idcategoria2=entrada.nextInt();
			Categoria aux=categoriaservice.busqueda_by_categoria(idcategoria2);
			if(aux==null){
			System.out.println("Categoria no existe");
			}else {
			categoriaservice.borrar_categoria(idcategoria2);
			System.out.println("Borrada con exito/nSI SALTA ERROR, ASEGURATE DE QUITAR LOS PRODUCTOS DE DICHA CATEGORIA PRIMERO");
			}
			break;
		case 3:
			Vector<Categoria> lista=categoriaservice.listado_categoria();
			for (Categoria categoria : lista) {
				System.out.println(categoria.toString());
			}
			break;
		case 4:
			System.out.println("Introduce numero de categoria");
			int idcategoria3=entrada.nextInt();
			Categoria aux2=categoriaservice.busqueda_by_categoria(idcategoria3);
			if(aux2==null){
			System.out.println("Categoria no existe");
			}else {
				System.out.println(aux2);
			}
			break;
		case 5:
			System.out.println("Introduce numero de categoria");
			int idcategoria4=entrada.nextInt();
			System.out.println("Introduce nueva descripcion");
			String descripcion2=entrada.next();
			Categoria c2=new Categoria(idcategoria4,descripcion2);
			categoriaservice.modificar_categoria(c2);
			break;
		case 9:
			seguir=false;
	}

}
	}
}
