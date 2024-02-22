package controlador;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "hexagonos"})

public class Planta {
	
	private int cantidadHexagonos;
	private int numeroPlanta;
	protected String id; //id = planta-hexagono
	private ArrayList<Hexagono> hexagonos;
	private Biblioteca biblioteca;
	
	public Planta() {
		
	}
	
	public Planta(Biblioteca biblioteca, int numeroPlanta) {
		this.biblioteca=biblioteca;
		this.numeroPlanta=numeroPlanta;
		this.id=""+numeroPlanta;
		this.cantidadHexagonos=(int) Math.sqrt(biblioteca.getTamanno());
		this.hexagonos  = new ArrayList<Hexagono>();
		for (int i=0; i<Math.sqrt(biblioteca.getTamanno()); i++) {
			this.hexagonos.add(new Hexagono(this, i+1));
		}
	}
	
	@XmlElement
	public String getId() {
		
		return id;
	}
	
	@XmlElement(name="hexagono")
	public ArrayList<Hexagono> getHexagonos() {
		if(hexagonos == null) {
			hexagonos = new ArrayList<Hexagono>();
        }
		return hexagonos;
	}
	
	
	
	

}
