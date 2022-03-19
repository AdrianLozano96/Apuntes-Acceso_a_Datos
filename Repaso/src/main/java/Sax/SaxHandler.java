package Sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {
    private boolean hasTitulo;
    private boolean hasCategoria;
    private boolean hasDescripcion;
    private boolean hasFecha;
    private boolean hasEnlace;
    private boolean hasAuthor;
    private boolean enEntry;
    private List<Noticia> noticias=null;
    private Noticia noticia=null;
    public List<Noticia> getNoticias() {return noticias;}

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("item")){
            enEntry = true;
        }
        if(enEntry){
            if(noticias==null)
                noticias = new ArrayList<Noticia>();

            if(qName.equalsIgnoreCase("item")){
                noticia = new Noticia();
            }else if(qName.equalsIgnoreCase("title")){
                hasTitulo = true;
            }else if(qName.equalsIgnoreCase("category")){
                hasCategoria = true;
            }else if(qName.equalsIgnoreCase("description")){
                hasDescripcion = true;
            }else if(qName.equalsIgnoreCase("pubDate")){
                hasFecha = true;
            }else if(qName.equalsIgnoreCase("link")){
                hasEnlace = true;
            }else if(qName.equalsIgnoreCase("dc:creator")){
                hasAuthor = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("item")){
            noticias.add(noticia);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(hasTitulo){
            noticia.setTitulo(new String(ch, start, length));
            hasTitulo = false;
        }if(hasDescripcion){
            noticia.setDescripcion(new String(ch, start, length));
            hasDescripcion = false;
        }if(hasCategoria){
            noticia.setCategoria(new String(ch, start, length));
            hasCategoria = false;
        }if(hasFecha){
            noticia.setFecha(new String(ch, start, length));
            hasFecha = false;
        }if(hasEnlace){
            noticia.setEnlace(new String(ch, start, length));
            hasEnlace = false;
        }if(hasAuthor){
            noticia.setAuthor(new String(ch, start, length));
            hasAuthor = false;
        }
    }
}
