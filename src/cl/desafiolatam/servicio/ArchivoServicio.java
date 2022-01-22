package cl.desafiolatam.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.desafiolatam.modelo.CategoriaEnum;
import cl.desafiolatam.modelo.Cliente;

public class ArchivoServicio extends Exportador{

	public List<Cliente> cargarDatos(String fileName) {
		
		//List<List<Cliente>> listaClientes = new ArrayList<>();
		List<Cliente> listaClientes= new ArrayList<>();
		   BufferedReader reader = null; 
		   try { 
		      reader = new BufferedReader(new FileReader(fileName)); 
		      String line = null; 
		      while ((line = reader.readLine()) != null) { 
		         String[] words = line.split(","); 
		         String lala=words[0];
		         int desde=0;
				 try{
			             desde = Integer.parseInt(words[3]);
			            
			        }
			        catch (NumberFormatException ex){
			            
			        }
		        		 
		        //String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente,CategoriaEnum nombreCategoria
		         Cliente cliente=new Cliente(words[0], words[1], words[2], desde,CategoriaEnum.valueOf(words[4]) );
		          
		         listaClientes.add(cliente); 
		      }
		   } catch (FileNotFoundException e) { 
		       
		   } catch (IOException e) { 
		      
		   } finally { 
		      if (reader != null) { 
		         try { 
		           reader.close(); 
		         } catch (IOException e) { 
		           
		         }
		       } 
		   }
		   
		   return listaClientes;
	}

	@Override
	public void exportar(String filename, List<Cliente> listaClientes) {
		ExportadorCsv exportadorcsv=new ExportadorCsv();
		ExportadorTxt exportadortxt=new ExportadorTxt();
		if(filename.contains("txt")) {
			exportadortxt.exportar(filename, listaClientes);
		}else {
			exportadorcsv.exportar(filename, listaClientes);
		}
		
	}
	
	

	public List<List<String>>  importarArchivo(String directorio, String fichero) throws IOException {
		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(directorio+"/"+fichero));) {
		    while (scanner.hasNextLine()) {
		    	List<String> data=getRecordFromLine(scanner.nextLine());
		    	if(!records.contains(data)) {
		    		records.add(data);
		    	}else {
		    		System.out.println("Registro Duplicado");
		    	}
		        
		    }
		}
		
		return records;

	}
	
	private List<String> getRecordFromLine(String line) {
	    List<String> values = new ArrayList<String>();
	    try (Scanner rowScanner = new Scanner(line)) {
	        rowScanner.useDelimiter(",");
	        while (rowScanner.hasNext()) {
	            values.add(rowScanner.next());
	        }
	    }
	    return values;
	}

}
