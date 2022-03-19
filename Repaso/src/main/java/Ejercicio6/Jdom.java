package Ejercicio6;

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
    private String uri;
    private Document documento;

    private Jdom(String uri){this.uri = uri;}

    public static Jdom getInstace(@NonNull String uri){
        if(jdom==null)
            jdom = new Jdom(uri);
        return jdom;
    }

    public void cargarDatos() throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(uri);
        documento = builder.build(xmlFile);
    }

    public XMLOutputter preProceso(){
        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.setFormat(Format.getPrettyFormat());
        return xmlOutputter;
    }

    public void escritura(String uri) throws IOException {
        XMLOutputter salida = preProceso();
        salida.output(documento, new FileWriter(uri));
    }

    public List<Noticia> getDatos(){
        Element root = documento.getRootElement();
        Element channel = root.getChild("channel");
        List <Element> item = channel.getChildren("item");
        List<Noticia> noticias = new ArrayList<>();
        item.forEach(n->{
           Noticia noticia = new Noticia();
           noticia.setTitulo(n.getChildText("title"));
           noticia.setDescripcion(n.getChildText("description"));
           noticia.setCategoria(n.getChildText("category"));
           noticia.setEnlace(n.getChildText("link"));
           noticia.setFecha(n.getChildText("pubDate"));
           noticia.setAuthor(n.getChildText("cd:creator"));
           noticias.add(noticia);
        });
        return noticias;
    }

}
