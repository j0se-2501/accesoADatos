package trabajo;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class LeerXML {
	
	public static ArrayList<Videojuego> leerXML() {

        try {
        	
        	ArrayList<Videojuego> arrayListVideojuegos = new ArrayList<Videojuego>();

            //Buscamos el archivo XML
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("coleccionvideojuegos.xml");

            //Obtenemos todos los nodos "videojuego"
            NodeList listaVideojuegos = document.getElementsByTagName("videojuego");
            
            //Comprobamos que la longitud del nodeList de videojuego es correcto
            System.out.println("Longitud de la lista de videojuego: "+listaVideojuegos.getLength());

            for (int i = 0; i < listaVideojuegos.getLength(); i++) {

            	Element videojuego = (Element) listaVideojuegos.item(i); //de cada videojuego, i

            	String titulo = videojuego.getElementsByTagName("titulo").item(0).getTextContent(); //buscamos la primera y unica iteracion,0, de cada nodo hijo

            	String desarrollador = videojuego.getElementsByTagName("desarrollador").item(0).getTextContent();

            	String director = videojuego.getElementsByTagName("director").item(0).getTextContent();

            	String productor = videojuego.getElementsByTagName("productor").item(0).getTextContent();

            	Genero generoEnum = Genero.valueOf(videojuego.getElementsByTagName("genero").item(0).getTextContent());

            	Subgenero subgeneroEnum = Subgenero.valueOf(videojuego.getElementsByTagName("subgenero").item(0).getTextContent());

            	int pegi = Integer.parseInt(videojuego.getElementsByTagName("pegi").item(0).getTextContent());

            	int anno = Integer.parseInt(videojuego.getElementsByTagName("anno").item(0).getTextContent());

            	String plataforma = videojuego.getElementsByTagName("plataforma").item(0).getTextContent();
            	
            	int enero = Integer.parseInt(videojuego.getElementsByTagName("enero").item(0).getTextContent());
            	int febrero = Integer.parseInt(videojuego.getElementsByTagName("febrero").item(0).getTextContent());
            	int marzo = Integer.parseInt(videojuego.getElementsByTagName("marzo").item(0).getTextContent());
            	int abril = Integer.parseInt(videojuego.getElementsByTagName("abril").item(0).getTextContent());
            	int mayo = Integer.parseInt(videojuego.getElementsByTagName("mayo").item(0).getTextContent());
            	int junio = Integer.parseInt(videojuego.getElementsByTagName("junio").item(0).getTextContent());
            	int julio = Integer.parseInt(videojuego.getElementsByTagName("julio").item(0).getTextContent());
            	int agosto = Integer.parseInt(videojuego.getElementsByTagName("agosto").item(0).getTextContent());
            	int septiembre = Integer.parseInt(videojuego.getElementsByTagName("septiembre").item(0).getTextContent());
            	int octubre = Integer.parseInt(videojuego.getElementsByTagName("octubre").item(0).getTextContent());
            	int noviembre = Integer.parseInt(videojuego.getElementsByTagName("noviembre").item(0).getTextContent());
            	int diciembre = Integer.parseInt(videojuego.getElementsByTagName("diciembre").item(0).getTextContent());

            	Jugadores jugadores = new Jugadores(enero,  febrero,  marzo,  abril,  mayo,  junio,  julio,  agosto,
            	septiembre,  octubre, noviembre,  diciembre);
            	
         
            	/*System.out.println("ID: " + id);
            	System.out.println("Título: " + titulo);
            	System.out.println("Desarrollador: " + desarrollador);
            	System.out.println("Director: " + director);
            	System.out.println("Productor: " + productor);
            	System.out.println("Género: " + generoEnum);
            	System.out.println("Subgénero: " + subgeneroEnum);
            	System.out.println("PEGI: " + pegi);
            	System.out.println("Año de lanzamiento: " + anno);
            	System.out.println("Plataforma: " + plataforma);
            	System.out.println("Jugadores: "+jugadores.toString());
            	System.out.println("----------------------\n");*/
            	

            	Videojuego videojuegoObjeto = new Videojuego(titulo, desarrollador, director, productor, generoEnum,
            			subgeneroEnum, pegi, anno, plataforma, jugadores); //formamos un objeto videojuego

            	arrayListVideojuegos.add(videojuegoObjeto); //y lo añadimos al arraylist
            	
            }
            
            for (Videojuego juego : arrayListVideojuegos) System.out.println(juego.toString()); //listamos el arrayList obtenido

            return arrayListVideojuegos; //devolvemos el arrayList para trabajar con el
            
        } catch (Exception e) {

            e.printStackTrace();

        }
		return null;
		

    }

}
