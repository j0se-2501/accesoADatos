package trabajo;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;


public class ActualizarObjetoEnXML {
	
    public static void escribirXML(Videojuego videojuegoAEscribir) {
    	
    	//recibe un videojuego cuyos atributos hayan sido editados ya en java para sobreescribirlo en el XML
    	
        try {
            
        	//Obtenemos el documento XML existente
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("coleccionvideojuegos.xml");
    		

            //Cogemos todos los "id" del xml en una nodeList
            NodeList listaID = doc.getElementsByTagName("id");
            
            //Compruebo el tamanno de la nodeList para ver que se han cogido bien los datos
            System.out.println("Tamaño de la nodelist de id: "+listaID.getLength());
            
            //busco en la nodeList la id que coincida con la del videojuego que entra como argumento
            for (int i=0; i<doc.getElementsByTagName("videojuego").getLength(); i++) {
            
            if (listaID.item(i).getTextContent().equals(String.valueOf(videojuegoAEscribir.getID()))){
            	
            	Node juegoAEscribirEnXML = listaID.item(i).getParentNode(); //cogemos el videojuego que corresponde a la ID
                escribirDatos(videojuegoAEscribir, factory, builder, doc, juegoAEscribirEnXML); //lo paso al metodo que lo escribe en el XML
            	
            }
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirDatos(Videojuego videojuegoAEscribir,DocumentBuilderFactory factory, DocumentBuilder builder, Document doc, Node juegoAEscribirEnXML){
    	
    	try {
    		
    	NodeList hijosVideojuego = juegoAEscribirEnXML.getChildNodes(); //cogemos los nodos hijos de videojuego
    	
    	Node idNode = hijosVideojuego.item(0);
    	Node tituloNode = hijosVideojuego.item(1);
        Node desarrolladorNode = hijosVideojuego.item(2);
        Node directorNode = hijosVideojuego.item(3);
        Node productorNode = hijosVideojuego.item(4);
        Node generoNode = hijosVideojuego.item(5);
        Node subgeneroNode = hijosVideojuego.item(6);
        Node pegiNode = hijosVideojuego.item(7);
        Node annoNode = hijosVideojuego.item(8);
        Node plataformaNode = hijosVideojuego.item(9);
        //Node jugadoresNode = hijosVideojuego.item(10);
        
        
        NodeList mesesEnero = doc.getElementsByTagName("enero");
        Node jugadoresNode = mesesEnero.item(videojuegoAEscribir.getID()).getParentNode(); //cojo así los meses
        																					//porque me daba problema de otra forma
        
        
        System.out.println("longitud nodo meses: "+jugadoresNode.getChildNodes().getLength()); //compruebo de se han cogido bien
        
        //se sobreescriben los datos en el XML con el setTextContent
        
        idNode.setTextContent(Integer.toString(videojuegoAEscribir.getID()));
        
        tituloNode.setTextContent(videojuegoAEscribir.getTitulo());
        
        desarrolladorNode.setTextContent(videojuegoAEscribir.getDesarrollador());
        
        directorNode.setTextContent(videojuegoAEscribir.getDirector());
        
        productorNode.setTextContent(videojuegoAEscribir.getProductor());
        
        generoNode.setTextContent(videojuegoAEscribir.getGenero().toString());
        
        subgeneroNode.setTextContent(videojuegoAEscribir.getSubgenero().toString());
        
        pegiNode.setTextContent(Integer.toString(videojuegoAEscribir.getPegi()));
        
        annoNode.setTextContent(Integer.toString(videojuegoAEscribir.getAnno()));
        
        plataformaNode.setTextContent(videojuegoAEscribir.getPlataforma());
        
        //lo mismo con los jugadores en cada mes
        
        for (int i = 0; i < 12; i++) {
            
        	switch(i) {
            case 0:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getEnero())));
                break;
            case 1:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getFebrero())));
                break;
            case 2:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getMarzo())));
                break;
            case 3:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getAbril())));
                break;
            case 4:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getMayo())));
                break;
            case 5:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getJunio())));
                break;
            case 6:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getJulio())));
                break;
            case 7:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getAgosto())));
                break;
            case 8:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getSeptiembre())));
                break;
            case 9:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getOctubre())));
                break;
            case 10:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getNoviembre())));
                break;
            case 11:
            	jugadoresNode.getChildNodes().item(i).setTextContent(Integer.toString((videojuegoAEscribir.getJugadores().getDiciembre())));
                break;
        	}
        }
        


        //se guarda el documento XML modificado en un archivo
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
