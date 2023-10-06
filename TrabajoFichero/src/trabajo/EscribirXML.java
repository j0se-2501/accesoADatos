package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File; 

public class EscribirXML {
	
    public void escribirXML(Videojuego videojuegoAEscribir) {
    	
        try {
            // Paso 1: Obtén el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("coleccionvideojuegos.xml"));

            // Paso 2: Obtén el elemento raíz
            Element rootElement = doc.getDocumentElement();

            // Paso 3: Busca y actualiza los elementos hijos si ya existen
         // Obtener nodos para los atributos de Videojuego
            Node tituloNode = rootElement.getElementsByTagName("titulo").item(0);
            Node desarrolladorNode = rootElement.getElementsByTagName("desarrollador").item(0);
            Node directorNode = rootElement.getElementsByTagName("director").item(0);
            Node productorNode = rootElement.getElementsByTagName("productor").item(0);
            Node generoNode = rootElement.getElementsByTagName("genero").item(0);
            Node subgeneroNode = generoNode.getFirstChild();
            Node pegiNode = rootElement.getElementsByTagName("pegi").item(0);
            Node annoNode = rootElement.getElementsByTagName("anno").item(0);
            Node plataformaNode = rootElement.getElementsByTagName("plataforma").item(0);
            Node jugadoresNode = rootElement.getElementsByTagName("jugadores").item(0);
           
            
            
            for (int i = 0; i < videojuegoAEscribir.getJugadores().length; i++) {
            
             jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString(videojuegoAEscribir.getJugadores()[i]));
             
            }


            if (tituloNode != null) {
                tituloNode.setTextContent(videojuegoAEscribir.getTitulo());
            }

            if (desarrolladorNode != null) {
                desarrolladorNode.setTextContent(videojuegoAEscribir.getDesarrollador());
            }

            if (directorNode != null) {
                directorNode.setTextContent(videojuegoAEscribir.getDirector());
            }

            if (productorNode != null) {
                productorNode.setTextContent(videojuegoAEscribir.getProductor());
            }

            if (pegiNode != null) {
                pegiNode.setTextContent(Integer.toString(videojuegoAEscribir.getPegi())); // Nuevo valor del PEGI
            }

            if (annoNode != null) {
                annoNode.setTextContent(Integer.toString(videojuegoAEscribir.getAnno())); // Nuevo año
            }

            if (plataformaNode != null) {
                plataformaNode.setTextContent(videojuegoAEscribir.getPlataforma()); // Nuevas plataformas
            }

            if (generoNode != null) {
                generoNode.setTextContent(videojuegoAEscribir.getGenero().toString()); // Nuevo genero
            }
            
            if (subgeneroNode != null) {
                subgeneroNode.setTextContent(videojuegoAEscribir.getSubgenero().toString()); // Nuevo subgenero
            }


            // Paso 4: Guarda el documento XML modificado en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("coleccionvideojuegos.xml"));
            transformer.transform(source, result);

            System.out.println("Datos actualizados en el archivo XML.");

     

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
