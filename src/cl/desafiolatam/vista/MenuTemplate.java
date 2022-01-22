package cl.desafiolatam.vista;

import java.util.Scanner;

public abstract class MenuTemplate {
	Scanner scanner=new Scanner(System.in);
	
	 
	
	public abstract void listarCliente();
	public abstract void agregarCliente();
	public abstract void editarCliente();
	public abstract void importarDatos();
	public abstract void exportarDatos();
	public abstract void terminarPrograma();
	
	public final void iniciarMenu() {
		int exit=0;
		do{    
			 
			System.out.println("1.- Listar Clientes\n"+
					"2.- Agregar Cliente\n"+
					"3.- Editar Cliente\n"+
					"4.- Cargar Datos\n"+
					"5.- Exportar Datos\n"+
					"6.- Salir\n"
				);
			System.out.println("Selección");
			String seleccion=scanner.nextLine();
			
			switch(seleccion) {
			case "1":
				listarCliente();
				break;
			case "2":
				agregarCliente();
				break;
			case "3":
				editarCliente();
				break;
			case "4":
				importarDatos();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				exit=1;
				terminarPrograma();
				break;
			 
			default:
				System.out.println("La selección no es válida");
				break;
		 
			}
			
	}while (exit==0); 	
		
		
	}
	
	
}
