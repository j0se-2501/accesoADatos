package controlador;

import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="biblioteca")

public class Biblioteca {
	
	//existiran el mismo numero de plantas que de hexagonos en cada planta
	//el tamanno total de hexágonos está por definir
	
	protected int tamanno;
	protected ArrayList<Planta> plantas;
	
	public Biblioteca() {
		
	}
	
	public Biblioteca(int tamanno) {
		
		this.tamanno=tamanno;
		this.plantas=new ArrayList<Planta>();
		for (int i=0; i<Math.sqrt(this.tamanno); i++) {
			plantas.add(new Planta(this, i+1));
		}
		
	}
	
	@XmlElement(name="planta")
	
	public ArrayList<Planta> getPlantas() {
		if(plantas == null) {
            plantas = new ArrayList<Planta>();
        }
		return plantas;
	}

	

	public int getTamanno() {
		return tamanno;
	}

	public Libro buscarLibroPorId(String id) {
        for (Planta planta : plantas) {
            for (Hexagono hexagono : planta.getHexagonos()) {
                for (LadoHexagono lado : hexagono.getLadosHexagono()) {
                    for (Anaquel anaquel : lado.getAnaqueles()) {
                        for (Libro libro : anaquel.getLibros()) {
                            if (libro.getId().equals(id)) {
                                System.out.println(libro.getId());
                                System.out.println("\n" + libro.getTexto()+"\n");
                                return libro;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Libro no encontrado.");
        return null;
    }
	
	

	public void buscarLibroPorPalabraEnTexto(String palabra) {
	    

	    for (Planta planta : plantas) {
	        for (Hexagono hexagono : planta.getHexagonos()) {
	            for (LadoHexagono lado : hexagono.getLadosHexagono()) {
	                for (Anaquel anaquel : lado.getAnaqueles()) {
	                    for (Libro libro : anaquel.getLibros()) {
	                        if (libro.getTexto().contains(palabra)) {
	                            System.out.println(libro.getId()+" contiene: "+palabra);
	                            System.out.println("\n" + libro.getTexto()+"\n");
	                         }
	                    }
	                }
	            }
	        }
	    }
	    System.out.println("Libro no encontrado.");
	}
	
	public void eliminarLibroPorId(String id) {
        Iterator<Planta> plantaIterator = plantas.iterator();
        while (plantaIterator.hasNext()) {
            Planta planta = plantaIterator.next();
            Iterator<Hexagono> hexagonoIterator = planta.getHexagonos().iterator();
            while (hexagonoIterator.hasNext()) {
                Hexagono hexagono = hexagonoIterator.next();
                Iterator<LadoHexagono> ladoIterator = hexagono.getLadosHexagono().iterator();
                while (ladoIterator.hasNext()) {
                    LadoHexagono lado = ladoIterator.next();
                    Iterator<Anaquel> anaquelIterator = lado.getAnaqueles().iterator();
                    while (anaquelIterator.hasNext()) {
                        Anaquel anaquel = anaquelIterator.next();
                        Iterator<Libro> libroIterator = anaquel.getLibros().iterator();
                        while (libroIterator.hasNext()) {
                            Libro libro = libroIterator.next();
                            if (libro.getId().equals(id)) {
                                libroIterator.remove(); // Eliminar el libro actual
                                System.out.println("Libro eliminado con éxito.");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("No se encontró ningún libro con el ID proporcionado.");
    }
	
	public void cambiarTextoLibro(String id, String nuevoTexto) {
		Libro libro=buscarLibroPorId(id);
		libro.setTexto(nuevoTexto);
	}


}
