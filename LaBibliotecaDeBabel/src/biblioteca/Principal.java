package biblioteca;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException, JAXBException {
		
		
		
		
		  Biblioteca biblioteca = new Biblioteca(12321);
		  
		  biblioteca.buscarLibroPorId("1-1-1-1-1");
		  //biblioteca.buscarLibroPorId("69-69-4-5-32");
		  
		  biblioteca.buscarLibroPorPalabraEnTexto("dios");
		  biblioteca.buscarLibroPorPalabraEnTexto("diablo");
		 
		Principal principal =  new Principal();
		principal.marshal(biblioteca);
	}

	public void marshal(Biblioteca biblioteca) throws JAXBException, IOException {
		
		try {
			
			
		    JAXBContext context;
			context = JAXBContext.newInstance(Biblioteca.class);
			Marshaller mar= context.createMarshaller();
		    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    mar.marshal(biblioteca, new File("./babel.xml"));
		    
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	
}
