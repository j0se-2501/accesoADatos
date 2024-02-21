package biblioteca;

import javax.xml.bind.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		
		
		
		  Biblioteca biblioteca = new Biblioteca(100);
		  
		  biblioteca.buscarLibroPorId("1-1-1-1-1");
		  //biblioteca.buscarLibroPorId("69-69-4-5-32");
		  
		  //biblioteca.buscarLibroPorPalabraEnTexto("dios");
		  biblioteca.buscarLibroPorPalabraEnTexto("aston");
		 
		Principal principal =  new Principal();
		principal.marshal(biblioteca);
		principal.consultaXpathPorId();
		principal.consultaXpathPorPalabra("aston");
		
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
	
	public void consultaXpathPorId() throws Exception {
		
		// La expresion xpath de busqueda
				String xPathExpression = "//libro[@id='1-1-1-1-1']";
				
		                // Carga del documento xml
		 		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 		DocumentBuilder builder = factory.newDocumentBuilder();
		 		Document documento = builder.parse(new File("babel.xml"));

				// Preparación de xpath
		 		XPath xpath = XPathFactory.newInstance().newXPath();

		 		// Consultas
		 		NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

				for (int i=0;i<nodos.getLength();i++){
					System.out.println(nodos.item(i).getNodeName()+" : " +
		                           nodos.item(i).getAttributes().getNamedItem("id") +"\n\n"+
		                           nodos.item(i).getChildNodes().item(1).getTextContent()+"\n");
		
				}
				
	}
	
	public void consultaXpathPorPalabra(String palabra) throws Exception {
	    // La expresion xpath de busqueda
	    String xPathExpression = "//libro/texto[contains(text(), '"+palabra+"')]/..";

	    // Carga del documento xml
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document documento = builder.parse(new File("babel.xml"));

	    // Preparación de xpath
	    XPath xpath = XPathFactory.newInstance().newXPath();

	    // Consultas
	    NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);

	    for (int i = 0; i < nodos.getLength(); i++) {
	        Node libroElement = nodos.item(i);
	        // Obtener el ID del libro al que pertenece este nodo <libro>
	        String id = nodos.item(i).getAttributes().getNamedItem("id").getTextContent();
	        // Obtener el texto del nodo texto sin espacios en blanco adicionales
	        String texto = nodos.item(i).getChildNodes().item(1).getTextContent();
	        System.out.println("ID: " + id);
	        System.out.println("Texto: " + texto);
	        System.out.println();
	    }
	}
	
	
}
