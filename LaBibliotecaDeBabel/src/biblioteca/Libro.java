package biblioteca;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="libro")

public class Libro {
    private static int contId = 0;
    private int numero;
    protected String id;
    private Anaquel anaquel;
    private String texto;
    private char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ',', '.'};

    public Libro() {
    	
    }
    
    public Libro(Anaquel anaquel, int numero) {
        super();

        this.numero = numero;
        this.id = anaquel.id + "-" + numero;
        this.anaquel = anaquel;
        this.texto = generarTextoAleatorio();
    }
    
    @XmlAttribute
    public String getId() {
		return id;
	}
    
    @XmlElement(name = "texto")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    

	public String generarStringAleatorio(int longitud) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int index = (int) (Math.random() * caracter.length);
            sb.append(caracter[index]);
            if ((i + 1) % 28 == 0 && i != 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String generarTextoAleatorio() {
        return generarStringAleatorio(280);
    }
}

