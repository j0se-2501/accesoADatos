package dom;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class LeerXMLDOM {
    public static void main(String[] args) {
        try {
            // Crear un objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un objeto DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse("nuevo_ejemplo.xml");

            // Obtener la lista de elementos 'libro'
            NodeList listaLibros = document.getElementsByTagName("libro");

            // Iterar a través de la lista de libros
            for (int i = 0; i < listaLibros.getLength(); i++) {
                Element libro = (Element) listaLibros.item(i);
                String titulo = libro.getElementsByTagName("titulo").item(0).getTextContent();
                String autor = libro.getElementsByTagName("autor").item(0).getTextContent();
                String anio = libro.getElementsByTagName("anio").item(0).getTextContent();

                System.out.println("Título: " + titulo);
                System.out.println("Autor: " + autor);
                System.out.println("Año: " + anio);
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

