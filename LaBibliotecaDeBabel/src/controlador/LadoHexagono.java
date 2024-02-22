package controlador;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "anaqueles"})

public class LadoHexagono {
	
	//cada lado del hexágono contiene 5 anaqueles
	
	private static final int CANTIDAD_ANAQUELES =5;
	private int numero;
	protected String id; // id=planta-hexagono-ladohexagono (1-4 lados por hexagono)
	private ArrayList<Anaquel> anaqueles = new ArrayList<Anaquel>();
	private Hexagono hexagono;
	
	public LadoHexagono() {
		
	}
	
	public LadoHexagono(Hexagono hexagono, int numero) {
		this.numero=numero;
		this.id=hexagono.id+"-"+numero;
		this.hexagono = hexagono;
		this.anaqueles = new ArrayList<Anaquel>();
		for (int i=0; i<CANTIDAD_ANAQUELES; i++) {
			anaqueles.add(new Anaquel(this, i+1));
		}
	}
	
	@XmlElement
	public String getId() {
		
		return id;
	}
	
	@XmlElement(name="anaquel")
	public ArrayList<Anaquel> getAnaqueles() {
		if(anaqueles == null) {
			anaqueles = new ArrayList<Anaquel>();
        }
		return anaqueles;
	}
	
	
	
	
	
	
	
}
