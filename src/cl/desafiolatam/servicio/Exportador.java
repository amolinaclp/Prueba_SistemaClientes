package cl.desafiolatam.servicio;

import java.util.List;

import cl.desafiolatam.modelo.Cliente;

public abstract class Exportador {
	public abstract void exportar(String filename,List<Cliente> listaClientes );

}
