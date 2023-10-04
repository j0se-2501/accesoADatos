package dom;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Attr;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class CrearXML {
	 public static void main(String[] args) {
		 try {
			    // Crea un objeto DocumentBuilderFactory
			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			    
			    // Crea un objeto DocumentBuilder
			    DocumentBuilder builder = factory.newDocumentBuilder();
			    
			    // Crea un nuevo documento XML
			    Document document = builder.newDocument();
			    
			    // Crea el elemento raíz
			    Element raiz = document.createElement("libros");
			    
			    // Agrega el elemento raíz al documento
			    document.appendChild(raiz);
			    
			    // Crea elementos y atributos
			    Element libro1 = document.createElement("libro");
			    Element titulo1 = document.createElement("titulo");
			    titulo1.appendChild(document.createTextNode("El Gran Gatsby"));
			    Element autor1 = document.createElement("autor");
			    autor1.appendChild(document.createTextNode("F. Scott Fitzgerald"));
			    Element anio1 = document.createElement("anio");
			    anio1.appendChild(document.createTextNode("1925"));
			    
			    // Agrega elementos hijos al elemento raíz
			    libro1.appendChild(titulo1);
			    libro1.appendChild(autor1);
			    libro1.appendChild(anio1);
			    raiz.appendChild(libro1);
			    
			    Element libro2 = document.createElement("libro");
			    Element titulo2 = document.createElement("titulo");
			    titulo2.appendChild(document.createTextNode("1984"));
			    Element autor2 = document.createElement("autor");
			    autor2.appendChild(document.createTextNode("George Orwell"));
			    Element anio2 = document.createElement("anio");
			    anio2.appendChild(document.createTextNode("1949"));
			    
			    // Agrega elementos hijos al elemento raíz
			    libro2.appendChild(titulo2);
			    libro2.appendChild(autor2);
			    libro2.appendChild(anio2);
			    raiz.appendChild(libro2);
			    
			    // Crea un objeto Transformer para escribir el archivo XML
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
			    Transformer transformer = transformerFactory.newTransformer();
			    
			    // Crea un objeto DOMSource para el documento
			    DOMSource source = new DOMSource(document);
			    
			    // Crea un objeto StreamResult para el archivo XML de salida
			    File archivoXML = new File("nuevo_ejemplo.xml");
			    StreamResult result = new StreamResult(archivoXML);
			    
			    // Transforma el documento a un archivo XML
			    transformer.transform(source, result);
			    
			    System.out.println("Archivo XML creado correctamente en " + archivoXML.getAbsolutePath());
			    
			} catch (Exception e) {
			    e.printStackTrace();
			}

	 }

}
