package dom2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class EscribirDOM {
    public static void main(String[] args) {
        try {
            // Paso 1: Obtén el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("nuevo_ejemplo.xml"));

            // Paso 2: Obtén el elemento raíz
            Element rootElement = doc.getDocumentElement();

            // Paso 3: Busca y actualiza los elementos hijos si ya existen
            Node tituloNode = rootElement.getElementsByTagName("titulo").item(0);
            Node autorNode = rootElement.getElementsByTagName("autor").item(0);
            Node anoNode = rootElement.getElementsByTagName("ano").item(0);

            if (tituloNode != null) {
                tituloNode.setTextContent("Nuevo Título del Libro");
            }

            if (autorNode != null) {
                autorNode.setTextContent("Nuevo Nombre del Autor");
            }

            if (anoNode != null) {
                anoNode.setTextContent("2024");
            }

            // Paso 4: Guarda el documento XML modificado en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("nuevo_ejemplo.xml"));
            transformer.transform(source, result);

            System.out.println("Datos actualizados en el archivo XML.");

            // Paso 5: Mostrar el contenido del archivo XML
            System.out.println("Contenido del archivo XML:");
            NodeList nodeList = rootElement.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String tagName = element.getTagName();
                    String textContent = element.getTextContent();
                    System.out.println(tagName + ": " + textContent);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
