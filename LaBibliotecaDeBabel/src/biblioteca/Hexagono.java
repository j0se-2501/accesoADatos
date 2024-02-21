package biblioteca;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="hexagono")

public class Hexagono {
	
	//de los 6 lados, 4 contienen cinco anaqueles; (los otros 2 sirven para pasar a un hexágono contiguo).
	//es decir, en la práctica cada hexágono tiene 4 lados.
	
	private static final int CANTIDAD_LADOS =4;
	
	private int numeroHexagono;
	protected String id; //id = planta-hexagono
	private ArrayList<LadoHexagono> ladosHexagono;
	private Planta planta;
	
	public Hexagono() {
		
	}
	
	public Hexagono(Planta planta, int numeroHexagono) {
		this.planta=planta;
		this.numeroHexagono=numeroHexagono;
		this.id=planta.getId()+"-"+numeroHexagono;
		this.ladosHexagono  = new ArrayList<LadoHexagono>();
		for (int i=0; i<CANTIDAD_LADOS; i++) {
			this.ladosHexagono.add(new LadoHexagono(this, i+1));
		}
	}
	
	@XmlAttribute
	public String getId() {
		return id;
	}
	
	@XmlElement(name="lados_hexagono")
	public ArrayList<LadoHexagono> getLadosHexagono() {
		return ladosHexagono;
	}
	
	
	
	

}
