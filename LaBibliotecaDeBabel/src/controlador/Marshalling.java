package controlador;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Marshalling {
	
	Biblioteca biblioteca;
	
	
	/*public static void main(String[] args) throws Exception {
		
		Marshalling principal =  new Marshalling();
		//Biblioteca biblioteca = principal.unmarshal();
		
		
		Biblioteca biblioteca = new Biblioteca(1024);
		
		
		
		//biblioteca.eliminarLibroPorId("1-1-1-1-1");
		 
		
		principal.marshal(biblioteca);
		//principal.consultaXpathPorId("1-1-1-1-3"); 
		//biblioteca.buscarLibroPorId("1-1-1-1-1");
		  //biblioteca.buscarLibroPorId("69-69-4-5-32");
		  
		//biblioteca.buscarLibroPorPalabraEnTexto("dios");
		//biblioteca.buscarLibroPorPalabraEnTexto("sevilla");
		//principal.consultaXpathPorId("1-1-1-1-2");
		principal.consultaXpathPorPalabra("sakura");
		
	}*/
	
	public Marshalling() {
		
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
	
	public Biblioteca unmarshal() throws JAXBException, IOException {
	    // Crear el contexto JAXB con la clase raíz Biblioteca
	    JAXBContext context = JAXBContext.newInstance(Biblioteca.class);

	    // Crear un unmarshaller a partir del contexto
	    Unmarshaller unmarshaller = context.createUnmarshaller();

	    // Deserializar el XML
	    File xmlFile = new File("babel.xml");
	    Biblioteca biblioteca = (Biblioteca) unmarshaller.unmarshal(xmlFile);

	    // Devolver el objeto deserializado
	    return biblioteca;
	}

	
	public String consultaXpathPorId(String id) throws Exception {
	    // Expresión XPath de búsqueda
		String xPathExpression = "//libro/id[text()='" + id + "']/..";
	    
	    // Carga del documento XML
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document documento = builder.parse(new File("babel.xml"));
	    
	    // Preparación de XPath
	    XPath xpath = XPathFactory.newInstance().newXPath();
	    
	    // Consultas
	    NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
	    
	    
	        Node libroNode = nodos.item(0);
	        
	        if (libroNode!=null) {
	        // Obtener el ID del libro
	        String libroId = libroNode.getChildNodes().item(1).getTextContent();
	        // Obtener el texto del libro
	        String texto = libroNode.getChildNodes().item(3).getTextContent();
	        System.out.println("ID: " + libroId);
	        System.out.println("Texto: " + texto);
	        System.out.println();
	        return texto;
	        } else {
	        	System.out.println("No existe este libro");
	        	return "...";
	        }
	}

	public String consultaXpathPorPalabra(String palabra) throws Exception {
	    // Expresión XPath de búsqueda
	    String xPathExpression = "//libro/texto[contains(text(), '" + palabra + "')]/..";
	    
	    // Carga del documento XML
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document documento = builder.parse(new File("babel.xml"));
	    
	    // Preparación de XPath
	    XPath xpath = XPathFactory.newInstance().newXPath();
	    
	    // Consultas
	    NodeList nodos = (NodeList) xpath.evaluate(xPathExpression, documento, XPathConstants.NODESET);
	    
	    
	        Node libroNode = nodos.item(0);
	        if (libroNode!=null) {
	        // Obtener el ID del libro
	        String id = libroNode.getChildNodes().item(1).getTextContent();
	        // Obtener el texto del libro
	        String texto = libroNode.getChildNodes().item(3).getTextContent();
	        System.out.println("ID: " + id);
	        System.out.println("Texto: " + texto);
	        System.out.println();
	        return id;
	        } else {
	        	System.out.println("No se encuentra un libro que contenga la palabra "+palabra);
	        	return "No existe.";
	        }
	    
	}

	
	
	
	
	
	

	
	
	
}
