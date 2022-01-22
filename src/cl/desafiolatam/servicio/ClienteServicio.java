package cl.desafiolatam.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;

 
 

public class ClienteServicio {
	private static List<Cliente> listaClientes;

	
	public ClienteServicio() {
		super();
		//Se pidio qie la lista clientes sea una nueva ArrayList
		listaClientes = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public void retornoListarClientes() {
		
	}
		
	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, int anio,
			CategoriaEnum nombreCategoria) {
		listaClientes.add(new Cliente(runCliente, nombreCliente, apellidoCliente, anio,nombreCategoria));
	}
	public void editarCliente(int index, Cliente cliente) {
		System.out.println(index);
		System.out.println(cliente);
		listaClientes.set(index, cliente);
		
	}
	
	public static List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public static void setListaClientes(List<Cliente> listaClientes) {
		ClienteServicio.listaClientes = listaClientes;
	}
	
	 
	
	
	
	 
	
	 

}
