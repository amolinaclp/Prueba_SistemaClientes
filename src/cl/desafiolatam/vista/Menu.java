package cl.desafiolatam.vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;
import cl.desafiolatam.servicio.ArchivoServicio;
import cl.desafiolatam.servicio.ClienteServicio;
import cl.desafiolatam.utilidades.Utilidad;




public class Menu extends MenuTemplate{
	private Utilidad utilidad=new Utilidad();
	private static ClienteServicio clienteServicio=new ClienteServicio();
	private static ArchivoServicio archivoServicio=new ArchivoServicio();
	
	/*Se supone que scanner viene heredado
	 * por lo cual debiera usarlo con
	 * String opcion = scanner.nextLine();
	 * 
	 * */
	
	
	
	public Menu() {
		super();
		
		// TODO Auto-generated constructor stub
	}



	@Override
	public void listarCliente() {
		 
		 
		 Iterator<Cliente> lsclientes = clienteServicio.getListaClientes().iterator();
	        while (lsclientes.hasNext()) {
	        	utilidad.printLine("-------------Datos del Cliente-------------");
	            Cliente cliente=lsclientes.next();
	            utilidad.printLine("RUN del Cliente: "+cliente.getRunCliente());
	            utilidad.printLine("Nombre del Cliente: "+cliente.getNombreCliente());
	            utilidad.printLine("Apellido del Cliente: "+cliente.getApellidoCliente());
	            utilidad.printLine("Años como Cliente: "+cliente.getAniosCliente());
	            utilidad.printLine("Categoría del Cliente: "+cliente.getNombreCategoria());
	            utilidad.printLine("-------------------------------------------");
	             
	        }
	        
		 
		
	}



	@Override
	public void agregarCliente() {
		// TODO Auto-generated method stub
		utilidad.limpiarPantalla();
		utilidad.printLine("------------- Crear Cliente -------------");
		utilidad.printLine("Ingresa RUN del Cliente");
		String rut=scanner.nextLine();
		
		utilidad.printLine("Ingresa Nombre del Cliente");
		String nombre=scanner.nextLine();
		
		utilidad.printLine("Ingresa Apellido del Cliente");
		String apellido=scanner.nextLine();
		
		
		utilidad.printLine("Ingresa años como Cliente");
		String anio=scanner.nextLine();
		int desde=0;
		 try{
	             desde = Integer.parseInt(anio);
	            
	        }
	        catch (NumberFormatException ex){
	            
	        }
		
		
		
		clienteServicio.agregarCliente(rut, nombre, apellido, desde, CategoriaEnum.Activo);
		utilidad.printLine("Cliente Guardado");
		
	}



	@Override
	public void editarCliente() {
		utilidad.printLine("------------- Editar Cliente -------------");
		System.out.println("1.- Cambiar el estado del Cliente\n"+
				"2.- Editar los datos ingresados del Cliente\n"+
				"\n\nIngrese Opción:"
				
			);
		utilidad.printLine("------------------------------------------");
		
		String opcion=scanner.nextLine();
		
		int elegida=0;
		 try{
	             elegida= Integer.parseInt(opcion);
	            
	        }
	        catch (NumberFormatException ex){
	            
	        }
		 
		 Cliente clienteactual;
		 switch(elegida) {
			case 1:
				utilidad.printLine("Ingrese el RUN del Cliente a editar:");
				 
				String run=scanner.nextLine();
				clienteactual = clienteServicio.getListaClientes().stream()
						  .filter(cliente->run.equals(cliente.getRunCliente()))
						  .findAny()
						  .orElse(null);
				if(Objects.isNull(clienteactual)) {
					System.out.println("RUN no encontrado");
				}else {
					utilidad.printLine("-----Actualizando estado del Cliente----");
					utilidad.printLine("El estado actual es: "+clienteactual.getNombreCategoria());
					utilidad.printLine("1.-Si desea cambiar el estado del Cliente a Inactivo");
					utilidad.printLine("2.-Si desea mantener el estado del cliente Activo");
					utilidad.printLine("Ingrese opcion:");
					utilidad.printLine("----------------------------------------");
					
					String estadocliente=scanner.nextLine();
					System.out.println("Estado cliente:"+estadocliente);
					
					int ec=0;
					 try{
				             ec = Integer.parseInt(estadocliente);
				            
				        }
				        catch (NumberFormatException ex){
				            
				        }
					 
					if(ec==1) {
						 
						clienteactual.setNombreCategoria(CategoriaEnum.Inactivo);
					}else {
						 
						clienteactual.setNombreCategoria(CategoriaEnum.Activo);
						 
						 
					}
					int indice=clienteServicio.getListaClientes().indexOf(clienteactual);
					clienteServicio.editarCliente(indice, clienteactual);
					System.out.println("Datos cambiados con éxito");
				}
				
				break;
			case 2:
				
				utilidad.printLine("Ingrese el RUN del Cliente a editar:");
				String elrun=scanner.nextLine();
				
				clienteactual = clienteServicio.getListaClientes().stream()
						  .filter(cliente->elrun.equals(cliente.getRunCliente()))
						  .findAny()
						  .orElse(null);
				if(Objects.isNull(clienteactual)) {
					System.out.println("RUN no encontrado");
				}else {
					utilidad.printLine("-----Actualizando estado del Cliente----");
					utilidad.printLine("1.-El RUN del Cliente es "+clienteactual.getRunCliente());
					utilidad.printLine("2.-El Nombre del Cliente es: "+clienteactual.getNombreCliente());
					utilidad.printLine("3.-El Apellido del Cliente es: "+clienteactual.getApellidoCliente());
					utilidad.printLine("4.-Los años como Cliente son:"+clienteactual.getAniosCliente());
					utilidad.printLine("Ingrese opcion a editar de los datos del cliente:");
					utilidad.printLine("----------------------------------------");
					String opcioncliente=scanner.nextLine();
					int oc=0;
					 try{
				             oc = Integer.parseInt(opcioncliente);
				            
				        }
				        catch (NumberFormatException ex){
				            
				        }
					 
					 String nuevocampo;
					switch(oc) {
					case 1:
						utilidad.printLine("----------------------------------------");
						utilidad.printLine("1.- Ingrese nuevo RUN del Cliente");
						nuevocampo=scanner.nextLine();
						clienteactual.setRunCliente(nuevocampo);
						
						
						utilidad.printLine("----------------------------------------");
						System.out.println("Datos cambiados con éxito");
						break;
					case 2:
						
						 
						utilidad.printLine("1.- Ingrese nuevo Nombre del Cliente");
						nuevocampo=scanner.nextLine();
						clienteactual.setNombreCliente(nuevocampo);
						
						
						utilidad.printLine("----------------------------------------");
						System.out.println("Datos cambiados con éxito");
						break;
					case 3:
						
						 
						utilidad.printLine("1.- Ingrese nuevo Apellido del Cliente");
						nuevocampo=scanner.nextLine();
						clienteactual.setApellidoCliente(nuevocampo);
						
						
						utilidad.printLine("----------------------------------------");
						System.out.println("Datos cambiados con éxito");
						break;
					case 4:
						
						 
						utilidad.printLine("1.- Ingrese años como  Cliente");
						nuevocampo=scanner.nextLine();
						
						int desde=0;
						 try{
					             desde = Integer.parseInt(nuevocampo);
					            
					        }
					        catch (NumberFormatException ex){
					            
					        }
						 
						 
						clienteactual.setAniosCliente(desde);
						
						
						utilidad.printLine("----------------------------------------");
						System.out.println("Datos cambiados con éxito");
						break;
						default:
							System.out.println("Opción Incorrecta");
							break;
					}
					
					 
				}
				break;
				 
			default:
				System.out.println("La selección no es válida");
				break;
		 
			}
		
	}



	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub
		if(System.getProperty("os.name").contains("Windows")) {
			utilidad.printLine("---------Cargar Datos en Windows---------------");
			utilidad.printLine("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
			utilidad.printLine("Ejemplo C:\\usuario\\equipo\\Desktop\\");
		}else {
			utilidad.printLine("---------Cargar Datos en Linux o Mac-----------");
			utilidad.printLine("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
			utilidad.printLine("Ejemplo /home/usuario/Desktop/");
		}
		String laruta=scanner.nextLine();
		
		List<Cliente> listaClientes= archivoServicio.cargarDatos(laruta+"DBClientes.csv");
		 Iterator<Cliente> lsclientes = listaClientes.iterator();
	        while (lsclientes.hasNext()) {
	        	 
	            Cliente cliente=lsclientes.next();
	            
	            clienteServicio.agregarCliente(cliente.getRunCliente(), cliente.getNombreCliente(), cliente.getApellidoCliente(),cliente.getAniosCliente(), cliente.getNombreCategoria());
	             
	        }
		
	        utilidad.printLine("-----------------------------------------------");
	        utilidad.printLine("Datos cargados correctamente en la lista");
	}



	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		utilidad.printLine("---------Exportar Datos---------------");
		utilidad.printLine("1.- Formato csv");
		utilidad.printLine("2.- Formato txt");
		utilidad.printLine("Ingrese una opción para exportar:");
		utilidad.printLine("---------------------------------");
		
		String opcion=scanner.nextLine();
		int op=0;
		 try{
	             op = Integer.parseInt(opcion);
	            
	        }
	        catch (NumberFormatException ex){
	            
	        }
		 
		// TODO Auto-generated method stub
				if(System.getProperty("os.name").contains("Windows")) {
					utilidad.printLine("---------Cargar Datos en Windows---------------");
					utilidad.printLine("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
					utilidad.printLine("Ejemplo C:\\usuario\\equipo\\Desktop\\");
				}else {
					utilidad.printLine("---------Exportar Datos en Linux o Mac-----------");
					utilidad.printLine("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
					utilidad.printLine("Ejemplo /home/usuario/Desktop/");
				}
				String fn;
				String footer;
				if(op==1) {
					fn="clientes.csv";
					footer="Datos de clientes exportados correctamente en formato csv.";
				}else {
					fn="clientes.txt";
					footer="Datos de clientes exportados correctamente en formato txt.";
				}
				String ruta=scanner.nextLine();
				archivoServicio.exportar(ruta+""+fn, ClienteServicio.getListaClientes());
				System.out.println(footer);
		
	}



	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub
		utilidad.limpiarPantalla();
		System.out.println("Gracias por usar nuestro sistema, Hasta Luego");
		System.exit(0);
		
	}


	 
	
	  
	

}
