package org.adrianl.xml;
import lombok.Getter;
import lombok.NonNull;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class JDOMController {

    //1º VARIABLES
    private static JDOMController controller;   //Se crea el controlador
    private final String uri;   //Para la dirreccion del archivo
    private Document data;  //Documento

    //2º SINGLETON Solo se creará una instancia de la clase    Obtiene una instancia del controlador
    private JDOMController(String uri) {
        this.uri = uri;
    }   //Para dar valor a la uri
    public static JDOMController getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new JDOMController(uri);
        return controller;
    }

    //3º Carga los datos desde un fichero dada su URI
    public void loadData() throws IOException, JDOMException {
        // JDOM Document trabaja con DOM, SAX y STAX Parser Builder classes
        SAXBuilder builder = new SAXBuilder();  //VER SAXBUILDER
        File xmlFile = new File(this.uri);  //uri
        //this.data = (Document) builder.build(xmlFile);//------------------uri
        //Mete en el Document el sax builder con el archivo que tiene la uri
        this.data = (Document) builder.build(uri);
    }

    // 4º SE CRE EL PREPROCESADO
    private XMLOutputter preProcess() {
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        return xmlOutput;
    }

    //5º MUESTRA EL XML
    public void printXML() throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, System.out);
    }


    // 6º ESCRIBE EL XML EN OTRO ARCHIVO
    public void writeXMLFile(String uri) throws IOException {
        XMLOutputter xmlOutput = this.preProcess();
        xmlOutput.output(this.data, new FileWriter(uri));
        System.out.println("Fichero XML generado con éxito");
    }

    // 7º Se obtiene la lista de usuarios del DOM cargado
    public List<Noticia> getNoticias() {
        // Tomamos el elemento raiz y obtenemos sus hijos
        Element root = (Element) this.data.getRootElement();
        Element channel = root.getChild("channel");
        List<Element> listOfNoticias = channel.getChildren("item");
        // Lista de noticias
        List<Noticia> noticiaList = new ArrayList<>();
        // Por cada elemento
        listOfNoticias.forEach(noticiaElement -> {
            Noticia noticia = new Noticia();
            //noticia.setId(Integer.parseInt(noticiaElement.getAttributeValue("id")));
            noticia.setTitulo(noticiaElement.getChildText("title"));
            noticia.setCategoria(noticiaElement.getChildText("category"));
            noticia.setDescripcion(noticiaElement.getChildText("description"));
            noticia.setFecha(noticiaElement.getChildText("pubDate"));
            noticia.setEnlace(noticiaElement.getChildText("link"));
            noticia.setAuthor(noticiaElement.getChildText("dc:creator"));
            noticiaList.add(noticia);
        });
        return noticiaList;
    }









    //----------------------------------------8º Consultas con XPATH

    //Obtener todos los elementos nombre
    public List<String> getAllTitulos() {
        XPathFactory xpath = XPathFactory.instance();
        XPathExpression<Element> expr = xpath.compile("//item/title", Filters.element());
        //XPathExpression<Attribute> expr = xpath.compile("//item/@id", Filters.attribute());
        List<Element> noticias = expr.evaluate(this.data);
        //List<Attribute> noticias = expr.evaluate(this.data);
        List<String> titulos = new ArrayList<String>();
        noticias.forEach(noticia -> titulos.add(noticia.getValue().trim()));
        return titulos;
    }

    //Obtiene el nombre del elemento con indice indicado El primero en este caso
    public String getIndexTitulo(int index) {
        XPathFactory xpath = XPathFactory.instance();
        XPathExpression<Element> expr = xpath.compile("//item["+index+"]/title", Filters.element());
        //XPathExpression<Attribute> expr = xpath.compile("//item[@id='"+id+"']/title", Filters.attribute());
        Element title = expr.evaluateFirst(this.data);  //Element titulo = expr.evaluateFirst(uri);
        return title.getValue();
    }
    //----------------------------------------9º Operaciones CRUD
    //Creación del xml con datos cargados del Rss
    public void initData() {
        // Documento vacío
        this.data = new Document();
        // Nodo raíz
        this.data.setRootElement(new Element("noticias"));//noticias
    }
    //Añade un elemento de la clase Noticia
    private static Element createNoticiaElement(Noticia noticia) {
        Element noticiaElement = new Element("noticia");//Noticia
        noticiaElement.addContent(new Element("title").setText(noticia.getTitulo()));
        noticiaElement.addContent(new Element("category").setText(noticia.getCategoria()));
        noticiaElement.addContent(new Element("description").setText(noticia.getDescripcion()));
        noticiaElement.addContent(new Element("pubDate").setText(noticia.getFecha()));
        //noticiaElement.addContent(new Element("age").setText(Integer.toString(noticia.getAge())));
        noticiaElement.addContent(new Element("link").setText(noticia.getEnlace()));
        noticiaElement.addContent(new Element("creator").setText(noticia.getAuthor()));
        return noticiaElement;
    }

    // Añade una noticia al DOM
    public void addNoticia(Noticia noticia) {
        Element root = (Element) this.data.getRootElement();
        root.addContent(createNoticiaElement(noticia));
    }

    // Añade un nuevo elemento con un determinado tag al usuario
    public void addElement(String tag, String value) {
        Element rootElement = this.data.getRootElement();
        List<Element> listNoticiasElement = rootElement.getChildren("noticia");
        listNoticiasElement.forEach(noticiaElement -> {
            noticiaElement.addContent(new Element(tag).setText(value));
        });
    }

    //Elimina un elemento dado un tag Elimina el autor
    public void deleteElement(String tag) {
        Element rootElement = this.data.getRootElement();
        List<Element> listNoticiasElement = rootElement.getChildren("noticia");
        listNoticiasElement.forEach(noticiaElement -> {
            String name = noticiaElement.getChildText("creator");
            // if (name != null)
            noticiaElement.removeChild(tag);
        });
    }

    //Pasa a mayúsculas el texto de un elemento de texto tag
    public void ValorEnMayuscula(String tag) {
        Element rootElement = this.data.getRootElement();
        List<Element> listNoticiasElement = rootElement.getChildren("noticia");
        listNoticiasElement.forEach(noticiaElement -> {
            String name = noticiaElement.getChildText("title");
            if (name != null)
                noticiaElement.getChild("title").setText(name.toUpperCase());
        });
    }
}