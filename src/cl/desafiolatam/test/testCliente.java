package cl.desafiolatam.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;
import cl.desafiolatam.servicio.ArchivoServicio;
import cl.desafiolatam.servicio.ClienteServicio;
import cl.desafiolatam.utilidades.Utilidad;

public class testCliente {
	private Utilidad utilidad=new Utilidad();
	private static ClienteServicio clienteServicio=new ClienteServicio();
	private static ArchivoServicio archivoServicio=new ArchivoServicio();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void agregarClienteTest() {
		/*Creo el registro, luego verifico la lista clientes, si == 1 pasa, sino, error*/
		clienteServicio.agregarCliente("10.453.331-0", "Juan Antonio", "Labra", 2, CategoriaEnum.Activo);
		List<Cliente> listaclientes=clienteServicio.getListaClientes();
		
		int obj1=listaclientes.size();
		int obj2=1;
		assertEquals(obj1,obj2);
		
	}
	
	@Test
	public void agrearClienteNullTest() {
		/*Creo el registro, luego verifico la lista clientes, si == 1 pasa, sino, error
		 * Esto no lo puse como un objeto cliente porque la documentación decía que se le debían pasar los parametros
		 * de cliente, no el objeto cliente, por como está redactado no se entiende bien
		 * así que seguí la instrucción tal cual se redactó, en el mundo real primero 
		 * le preguntaria al que generó el requerimiento que estaba pensando cuando redactó eso y despues
		 * de desahogarme con el, lo solucionaría XD
		 * 
		 * En pagina 8 si hace referencia a llenar objeto cliente
		 * Pero en la 9 habla de pasarle parametros de la clase cliente, puedo interpretarlo de 2 formas que fuera objeto o que le pasara
		 * uno a uno los parametros que necesita la clase, para instanciarla como objeto dentro de agregarCliente
		 * lo interpreté como lo segundo.
		 * 
		 * */
		
		clienteServicio.agregarCliente(null,null, null, -1, null);
		List<Cliente> listaclientes=clienteServicio.getListaClientes();
		
		int obj1=listaclientes.size();
		System.out.println(obj1);
		int obj2=1;
		assertEquals(obj1,obj2);
		
	}

}
