package ejemplosax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Principal {

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		
		
	
		        try {
		            // Crea un objeto SAXParserFactory
		            SAXParserFactory factory = SAXParserFactory.newInstance();

		            // Crea un objeto SAXParser
		            SAXParser saxParser = factory.newSAXParser();

		            // Especifica el manejador de eventos personalizado
		            ManejoXMLSAX handler = new ManejoXMLSAX();

		            // Parsea el archivo XML y maneja los eventos
		            saxParser.parse("nuevo_ejemplo.xml", handler);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    
		


	}

}
