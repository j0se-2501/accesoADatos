package trabajo;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.NodeList;

public class LeerXML {
	
	static ArrayList<Videojuego> arrayListVideojuegos = new ArrayList<Videojuego>();
	

    public static ArrayList<Videojuego> leerXML() {

        try {

            // Crear un objeto DocumentBuilderFactory

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();



            // Crear un objeto DocumentBuilder

            DocumentBuilder builder = factory.newDocumentBuilder();



            // Parsear el archivo XML

            Document document = builder.parse("nuevo_ejemplo.xml");



            // Obtener la lista de elementos 'libro'

            NodeList listaVideojuegos = document.getElementsByTagName("Videojuegos");

            //int[] jugadores = new int[12]; //un mes por casilla del array

            // Iterar a través de la lista de libros

            for (int i = 0; i < listaVideojuegos.getLength(); i++) {

            	Element videojuego = (Element) listaVideojuegos.item(i);

            	String titulo = videojuego.getElementsByTagName("titulo").item(0).getTextContent();

            	String desarrollador = videojuego.getElementsByTagName("desarrollador").item(0).getTextContent();

            	String director = videojuego.getElementsByTagName("director").item(0).getTextContent();

            	String productor = videojuego.getElementsByTagName("productor").item(0).getTextContent();

            	genero generoEnum = genero.valueOf(videojuego.getElementsByTagName("genero").item(0).getTextContent());

            	subgenero subgeneroEnum = subgenero.valueOf(videojuego.getElementsByTagName("subgenero").item(0).getTextContent());

            	int pegi = Integer.parseInt(videojuego.getElementsByTagName("pegi").item(0).getTextContent());

            	int anno = Integer.parseInt(videojuego.getElementsByTagName("anno").item(0).getTextContent());

            	String plataforma = videojuego.getElementsByTagName("plataforma").item(0).getTextContent();

            	//jugadores[0]
            	
            	int enero = Integer.parseInt(videojuego.getElementsByTagName("enero").item(0).getTextContent());
            	// Supongamos que tienes un objeto videojuego de tipo Element.
            	// Obtén el contenido de cada mes y conviértelo a un valor entero.
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

            	// Ahora tendrás los valores de cada mes como enteros.

            	
            	Jugadores jugadores = new Jugadores(enero,  febrero,  marzo,  abril,  mayo,  junio,  julio,  agosto,
			 septiembre,  octubre, noviembre,  diciembre);

            	


            	System.out.println("Título: " + titulo);

            	System.out.println("Desarrollador: " + desarrollador);

            	System.out.println("Director: " + director);

            	System.out.println("Productor: " + productor);

            	System.out.println("Género: " + generoEnum);

            	System.out.println("Subgénero: " + subgeneroEnum);

            	System.out.println("PEGI: " + pegi);

            	System.out.println("Año de lanzamiento: " + anno);

            	System.out.println("Plataforma: " + plataforma);

            	System.out.print("Jugadores: "+jugadores.toString());

            	/*for (String jugador : jugador) {

            	    System.out.print(jugadores + " ");

            	}*/

            	System.out.println();



                System.out.println("----------------------");

                

            	System.out.println();

            	Videojuego videojuegoObjeto = new Videojuego(titulo, desarrollador, director, productor, generoEnum,
            			subgeneroEnum, pegi, anno, plataforma, jugadores);

            	arrayListVideojuegos.add(videojuegoObjeto);
            	
            }

            return arrayListVideojuegos;
            
        } catch (Exception e) {

            e.printStackTrace();

        }
		return arrayListVideojuegos;

    }

}
