package Sax;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String uri = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada";
        Sax sax = Sax.getInstance(uri);
        sax.loadData();
        sax.getNoticias().forEach(System.out::println);
    }
}
