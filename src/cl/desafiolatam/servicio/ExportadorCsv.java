package cl.desafiolatam.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.modelo.Cliente;
 

public class ExportadorCsv extends Exportador{
	 
	 

	@Override
	public void exportar(String filename, List<Cliente> listaClientes) {
		  
		

		 try {
			 File archivo = new File(filename);  
	         archivo.createNewFile();
	         if(archivo.exists()==true) {
	        	 FileWriter fileW = new FileWriter(archivo);
	 			BufferedWriter bufferedWriter = new BufferedWriter(fileW);
	 				String lnproducto="";
	 				 
	 			       
	 			for (int counter = 0; counter < listaClientes.size(); counter++) { 		      
	 		          lnproducto=listaClientes.get(counter).getRunCliente()+","+listaClientes.get(counter).getNombreCliente()+","+listaClientes.get(counter).getApellidoCliente()+","+listaClientes.get(counter).getAniosCliente()+","+listaClientes.get(counter).getNombreCategoria();
	 		          bufferedWriter.write(lnproducto);
	 			      bufferedWriter.newLine();		         
	 		      }
	 			
	 			  
	 		         
	 		       System.out.println("Datos de productos exportados correctamente en formato .csv");

	 			bufferedWriter.close();
	 			
	         }else {
	        	 System.out.println("No existe la ruta");
	         }
	         
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
	}
	
	
	
 

	 

}
