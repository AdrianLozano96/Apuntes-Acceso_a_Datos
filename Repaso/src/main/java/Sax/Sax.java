package Sax;

import org.jdom2.input.sax.SAXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class Sax {
    private static Sax sax;
    private List<Noticia> noticias;
    private String uri;
    private Sax(String uri){
        this.uri = uri;
    }
    public static Sax getInstance(String uri){
        if(sax==null){
            sax = new Sax(uri);
        }
        return sax;
    }

    public void loadData() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(uri, handler);
        noticias = handler.getNoticias();
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }
}
