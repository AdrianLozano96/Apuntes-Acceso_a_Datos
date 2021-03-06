package org.adrianl.sax;

import lombok.NonNull;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

// @Getter
public class SAXController {
    private static SAXController controller;
    private final String uri;
    private List<Noticia> noticiasList;
    //SINGLETON
    private SAXController(String uri) {
        this.uri = uri;
    }
    public static SAXController getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new SAXController(uri);
        return controller;
    }

    public void loadData() throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance(); //Crea el parser
        SAXParser saxParser = saxParserFactory.newSAXParser();

        NoticiaHandler handler = new NoticiaHandler();//Indica los eventos
        saxParser.parse(this.uri, handler); //Parsea el fichero por eventos
        this.noticiasList = handler.getNoticias();  // Lista de usuarios
    }

    public List<Noticia> getNoticias() {
        return this.noticiasList;
    }

}