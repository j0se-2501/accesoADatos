package controlador;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "libros"})

public class Anaquel {
	
	//cada anaquel contiene 32 libros
	
	private static final int CANTIDAD_LIBROS = 32;
	protected String id; // id=planta-hexagono-ladohexagono-anaquel (1-5 anaqueles por lado)
	private int numero;
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private LadoHexagono ladoHexagono;
	
	public Anaquel() {
		
	}
	
	public Anaquel(LadoHexagono ladoHexagono, int numero) {
		this.ladoHexagono=ladoHexagono;
		this.numero=numero;
		this.id=ladoHexagono.id+"-"+numero;
		libros = new ArrayList<Libro>();
		for (int i=0; i<CANTIDAD_LIBROS; i++) {
			libros.add(new Libro(this, i+1));
		}
	}
	
	@XmlElement
	public String getId() {
		
		return id;
	}
	
	@XmlElement(name="libro")
	public ArrayList<Libro> getLibros() {
		if(libros == null) {
			libros = new ArrayList<Libro>();
        }
		return libros;
	}

	
	
	
	
	
	
}
