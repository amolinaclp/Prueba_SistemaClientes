package cl.desafiolatam.vista;
 
import cl.desafiolatam.servicio.ArchivoServicio;
import cl.desafiolatam.servicio.ClienteServicio;
import cl.desafiolatam.servicio.ExportadorCsv;
import cl.desafiolatam.servicio.ExportadorTxt;
import cl.desafiolatam.utilidades.Utilidad;

public class Menu extends MenuTemplate{
	private Utilidad utilidad=new Utilidad();
	private static ClienteServicio clienteServicio=new ClienteServicio();
	private static ArchivoServicio archivoServicio=new ArchivoServicio();
	private static ExportadorCsv exportadorcsv=new ExportadorCsv();
	private static ExportadorTxt exportadortxt=new ExportadorTxt();
	private String fileName="Clientes";
	private String fileName1="DBClientes.csv";
	/*Scanner y iniciar Menu vienen heredados de MenuTemplate*/ 
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarCliente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void terminarPrograma() {
		// TODO Auto-generated method stub
		
	}

 
	
	  
	

}
