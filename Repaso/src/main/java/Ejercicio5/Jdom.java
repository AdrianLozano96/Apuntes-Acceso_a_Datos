package Ejercicio5;

import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jdom {
    private static Jdom jdom;
    private Document doc;
    private final String uri;

    private Jdom(String uri){this.uri = uri;}
    public static Jdom getInstance(@NonNull String uri){
        if(jdom==null)
            jdom = new Jdom(uri);

        return jdom;
    }

    public void loadData() throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        File xml = new File(uri);
        doc = (Document) builder.build(xml);
    }

    public XMLOutputter preProcesado(){
        XMLOutputter xmlout = new XMLOutputter();
        xmlout.setFormat(Format.getPrettyFormat());
        return xmlout;
    }

    public void escribir(String uril) throws IOException {
        XMLOutputter escritura = preProcesado();
        escritura.output(doc,new FileWriter(uril));
    }

    public List<Noticia> getDatos(){
        Element root = doc.getRootElement();
        Element channel = root.getChild("channel");
        List<Element> item = channel.getChildren("item");
        List<Noticia>noticias = new ArrayList();
        item.forEach(n->{
            Noticia noticia = new Noticia();
            noticia.setTitulo(n.getChildText("title"));
            noticia.setDescripcion(n.getChildText("description"));
            noticia.setCategoria(n.getChildText("category"));
            noticia.setEnlace(n.getChildText("link"));
            noticia.setFecha(n.getChildText("pubDate"));
            noticia.setAuthor(n.getChildText("dc:creator"));
            noticias.add(noticia);
        });
        return noticias;
    }

}
