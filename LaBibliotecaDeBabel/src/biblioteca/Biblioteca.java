package biblioteca;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="biblioteca")

public class Biblioteca {
	
	//existiran el mismo numero de plantas que de hexagonos en cada planta
	//el tamanno total de hexágonos está por definir
	
	protected int tamanno;
	private ArrayList<Planta> plantas;
	
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
		return plantas;
	}

	

	public int getTamanno() {
		return tamanno;
	}

	public void buscarLibroPorId(String id) {
        for (Planta planta : plantas) {
            for (Hexagono hexagono : planta.getHexagonos()) {
                for (LadoHexagono lado : hexagono.getLadosHexagono()) {
                    for (Anaquel anaquel : lado.getAnaqueles()) {
                        for (Libro libro : anaquel.getLibros()) {
                            if (libro.getId().equals(id)) {
                                System.out.println(libro.getId());
                                System.out.println("\n" + libro.getTexto());
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Libro no encontrado.");
    }
	
	

	public void buscarLibroPorPalabraEnTexto(String palabra) {
	    

	    for (Planta planta : plantas) {
	        for (Hexagono hexagono : planta.getHexagonos()) {
	            for (LadoHexagono lado : hexagono.getLadosHexagono()) {
	                for (Anaquel anaquel : lado.getAnaqueles()) {
	                    for (Libro libro : anaquel.getLibros()) {
	                        if (libro.getTexto().contains(palabra)) {
	                            System.out.println(libro.getId()+" contiene: "+palabra);
	                            System.out.println("\n" + libro.getTexto());
	                         }
	                    }
	                }
	            }
	        }
	    }
	    System.out.println("Libro no encontrado.");
	}


}
