package cl.desafiolatam.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cl.desafiolatam.vista.Menu;
import cl.desafiolatam.vista.MenuTemplate;

public class testMenu {
	MenuTemplate menu=new Menu();
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
	public void menuCorrecto() {
		menu.iniciarMenu();
	}

}
