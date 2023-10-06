package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException; 

public class EscribirXML {
	
	int nodo;
    boolean flag;
    String titulo;
	
    public void escribirXML(Videojuego videojuegoAEscribir) {
    	
        try {
            // Paso 1: Obtén el documento XML existente
            
            nodo=0;
            flag=false;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
    		
    			doc = builder.parse(new File("coleccionvideojuegos.xml"));
    		

            // Paso 2: Obtén el elemento raíz
            Element rootElement = doc.getDocumentElement();
            
            while(!flag) {
            	
            	

            // Paso 3: Busca y actualiza los elementos hijos si ya existen
         // Obtener nodos para los atributos de Videojuego
            Node tituloNode = rootElement.getElementsByTagName("titulo").item(nodo); //annadir un id a los videojuegos para cambiar
            																		//el nombre
            
            if ((tituloNode.toString().equalsIgnoreCase(videojuegoAEscribir.getTitulo()))||(tituloNode==null)) {
            	
            	escribirDatos(videojuegoAEscribir, factory, builder, doc, rootElement, tituloNode);
            	flag=true;
            
            }else
            nodo++;
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void escribirDatos(Videojuego videojuegoAEscribir,DocumentBuilderFactory factory, DocumentBuilder builder, Document doc, Element rootElement, Node tituloNode){
    	
    	try {
    	
    	tituloNode = rootElement.getElementsByTagName("titulo").item(nodo);
        Node desarrolladorNode = rootElement.getElementsByTagName("desarrollador").item(nodo);
        Node directorNode = rootElement.getElementsByTagName("director").item(nodo);
        Node productorNode = rootElement.getElementsByTagName("productor").item(nodo);
        Node generoNode = rootElement.getElementsByTagName("genero").item(nodo);
        Node subgeneroNode = generoNode.getFirstChild();
        Node pegiNode = rootElement.getElementsByTagName("pegi").item(nodo);
        Node annoNode = rootElement.getElementsByTagName("anno").item(nodo);
        Node plataformaNode = rootElement.getElementsByTagName("plataforma").item(nodo);
        Node jugadoresNode = rootElement.getElementsByTagName("jugadores").item(nodo);
       
        
        
        for (int i = 0; i < videojuegoAEscribir.getJugadores().length; i++) {
        
         jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString(videojuegoAEscribir.getJugadores()[i])); //jugadores de cada mes
         
        }
        
        tituloNode.setTextContent(videojuegoAEscribir.getTitulo()); //nuevo titulo
        
        desarrolladorNode.setTextContent(videojuegoAEscribir.getDesarrollador()); //nuevo desarrollador
        
        directorNode.setTextContent(videojuegoAEscribir.getDirector()); //nuevo director
        
        productorNode.setTextContent(videojuegoAEscribir.getProductor()); //nuevo productor
        
        pegiNode.setTextContent(Integer.toString(videojuegoAEscribir.getPegi())); // Nuevo valor del PEGI
        
        annoNode.setTextContent(Integer.toString(videojuegoAEscribir.getAnno())); // Nuevo año
        
        plataformaNode.setTextContent(videojuegoAEscribir.getPlataforma()); // Nuevas plataformas
        
        generoNode.setTextContent(videojuegoAEscribir.getGenero().toString()); // Nuevo genero
        
        subgeneroNode.setTextContent(videojuegoAEscribir.getSubgenero().toString()); // Nuevo subgenero
        


        // Paso 4: Guarda el documento XML modificado en un archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("coleccionvideojuegos.xml"));
        transformer.transform(source, result);

        System.out.println("Datos actualizados en el archivo XML.");
        
        
    	} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
