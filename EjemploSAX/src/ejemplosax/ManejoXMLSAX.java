

package ejemplosax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class ManejoXMLSAX extends DefaultHandler {

    boolean enTitulo = false;
    boolean enAutor = false;
    boolean enAnio = false;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("titulo")) {
            enTitulo = true;
        } else if (qName.equalsIgnoreCase("autor")) {
            enAutor = true;
        } else if (qName.equalsIgnoreCase("anio")) {
            enAnio = true;
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (enTitulo) {
            System.out.println("Título: " + new String(ch, start, length));
            enTitulo = false;
        } else if (enAutor) {
            System.out.println("Autor: " + new String(ch, start, length));
            enAutor = false;
        } else if (enAnio) {
            System.out.println("Año: " + new String(ch, start, length));
            enAnio = false;
        }
    }
}

