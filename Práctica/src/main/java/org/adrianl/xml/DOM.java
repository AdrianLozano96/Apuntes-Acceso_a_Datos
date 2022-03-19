package org.adrianl.xml;

import lombok.NonNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM {

    //1º VARIABLES
    private final String uri;
    private static DOM controller;
    private Document data;

    //2º SINGLETON
    private DOM(String uri) {   //COMENTAR
        this.uri = uri;
    }
    //Obtener instancia del DOM
    public static DOM getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new DOM(uri);
        return controller;
    }

    //3º CARGAR LOS DATOS   Obtencion de la informacion de un archivo según la uri
    public void loadData() throws ParserConfigurationException, IOException, SAXException {
        //File xmlFile = new File(this.uri);    //Si la uri a leer es un XML y no un RSS
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        // Cargamos el documento normalizado
        dBuilder = dbFactory.newDocumentBuilder();
        this.data = dBuilder.parse(uri);    //this.data = dBuilder.parse(xmlFile);
        this.data.getDocumentElement().normalize();
    }

    //4º MOSTRAR EL DOM POR CONSOLA
    public void printXML() throws TransformerException {
        Transformer transformer= this.preProcess();
        DOMSource source = new DOMSource(this.data);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
    }

    //5º PASAR LA INFORMACIÓN A UNA CLASE
    //Obtencion de los hijos (item) de un Nodo del DOM
    private Noticia getNoticia(@NonNull Node node) {
        Noticia noticias = new Noticia();
        for(Node n = node.getFirstChild(); n != null; n = n.getNextSibling()){  //IMPORTANTE
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                if (n.getNodeName().equals("title"))
                    noticias.setTitulo(n.getTextContent());
                if (n.getNodeName().equals("category"))
                    noticias.setCategoria(n.getTextContent());
                if (n.getNodeName().equals("description"))
                    noticias.setDescripcion(n.getTextContent());
                if (n.getNodeName().equals("dc:creator"))
                    noticias.setAuthor(n.getTextContent());
                if (n.getNodeName().equals("pubDate"))
                    noticias.setFecha(n.getTextContent());
                if (n.getNodeName().equals("link"))
                    noticias.setEnlace(n.getTextContent());
            }
        }
        return noticias;
    }
    //Obtener lista de noticias del DOM
    public List<Noticia> getNoticias() {
        // Recorremos y obtenemos todos los ususarios obteniendo todos los nodos user reiniciando la lista
        List<Noticia> noticiaList = new ArrayList<Noticia>();
        NodeList nodeList = this.data.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++) {
            noticiaList.add(getNoticia(nodeList.item(i)));
        }
        return noticiaList;
    }
//-------------------------------------------------------------------------------------------
    //6º CREACIÓN DE UN NUEVO ARCHIVO XML CON LA INFORMACIÓN DE NOTICIAS GUARDADA EN LA CLASE
    //Creación de un fichero nuevo, vacio don guardar la información
    public void initData() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        this.data = dBuilder.newDocument();
        // Creamos el elemento raíz
        Element rootElement = this.data.createElement("Noticias"); //Elemento padre a crear
        // Lo añadimos al ducumento
        this.data.appendChild(rootElement);
    }

    //7º SE AÑADEN LAS NOTICIAS DE NUESTRA CLASE
    //CAMBIAR NOMBRES
    private Node createNewsElements(String name, String value){
        Element node = this.data.createElement(name);
        node.appendChild(this.data.createTextNode(value));
        return node;
    }
    private Node createNewsElement(Noticia noticia){
        Element element = this.data.createElement("item");
        element.appendChild(createNewsElements("title",noticia.getTitulo()));
        element.appendChild(createNewsElements("category",noticia.getCategoria()));
        element.appendChild(createNewsElements("description",noticia.getDescripcion()));
        element.appendChild(createNewsElements("creator",noticia.getAuthor()));
        element.appendChild(createNewsElements("pubDate",noticia.getFecha()));
        element.appendChild(createNewsElements("link",noticia.getEnlace()));
        return element;
    }
    public void addNewsItem(Noticia noticia){
        Element rootElement = (Element) this.data.getElementsByTagName("Noticias").item(0);
        rootElement.appendChild(createNewsElement(noticia));
    }

    //8º SE ESCRIBE LA INFORMACIÓN EN UN XML
    //PreProcesado del XML para imprimir (parámetros)
    private Transformer preProcess() throws TransformerConfigurationException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        return transformer;
    }
    //Guarda el DOM el el fichero xml indicado
    public void writeXMLFile(String uri) throws TransformerException {
        Transformer transformer= this.preProcess();
        DOMSource source = new DOMSource(this.data);
        StreamResult file = new StreamResult(new File(uri));
        transformer.transform(source, file);
        System.out.println("Fichero XML generado con éxito");
    }
}
