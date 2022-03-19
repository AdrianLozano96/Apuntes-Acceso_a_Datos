package Ejercicio6;

import lombok.NonNull;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;

public class Csv {

    //1º VARIABLES
    private final String uri;
    private static Csv controller;
    private Document data;

    //2º SINGLETON
    private Csv(String uri) {   //COMENTAR
        this.uri = uri;
    }
    //Obtener instancia del DOM
    public static Csv getInstance(@NonNull String uri) {
        if (controller == null)
            controller = new Csv(uri);
        return controller;
    }

    //6º CREACIÓN DE UN NUEVO ARCHIVO XML CON LA INFORMACIÓN DE NOTICIAS GUARDADA EN LA CLASE
    //Creación de un fichero nuevo, vacio don guardar la información
    public void initData() throws ParserConfigurationException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        this.data = dBuilder.newDocument();
        // Creamos el elemento raíz
        Element rootElement = this.data.createElement("meteorologia"); //Elemento padre a crear
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

    private Node createNewsElement(List<CsvModel>miLista){
        Element datos = this.data.createElement("datos");
        datos.appendChild(createNewsElements("nombre_ciudad", String.valueOf(miLista.get(0))));
        datos.appendChild(createNewsElements("nombre_ciudad", String.valueOf(miLista.get(1))));
        datos.appendChild(createNewsElements("nombre_ciudad", String.valueOf(miLista.get(2))));
        datos.appendChild(createNewsElements("nombre_ciudad", String.valueOf(miLista.get(3))));
        return datos;
    }




    public void addNewsItem(List<CsvModel> csv ){
        Element rootElement = (Element) this.data.getElementsByTagName("meteorologia").item(0);
        rootElement.appendChild(createNewsElement(csv));
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

    public List<CsvModel> leer(String uri, List<CsvModel>miLista) throws IOException {

        Path path = Path.of(uri);
        List<String>lista = Files.readAllLines(path, StandardCharsets.UTF_8);
        System.out.println("Lista: "+lista.size());
        for(int i=0;i<=1;i++){
            StringTokenizer tk = new StringTokenizer(lista.get(i), ";");

        }
        for(int i=1; i<lista.size(); i++) {
            StringTokenizer tk = new StringTokenizer(lista.get(i), ";");
            CsvModel csv = new CsvModel();
            csv.setComunidadAutonoma(tk.nextToken());
            csv.setGruposEspeciales(tk.nextToken());
            csv.setPeriodo(Integer.parseInt(tk.nextToken()));
            String total = tk.nextToken();
            if(!total.equals(".")){
                total = total.replace(",",".");
                csv.setTotal(Double.parseDouble(total));
            }else{
                csv.setTotal(0.0);
            }
            miLista.add(csv);
        }
        return miLista;
    }

    public void escribir(String uri, List<CsvModel>miLista) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(uri));
        bw.write("Comunidad Autonoma"+";"+"Grupos Especiales"+";"+"Periodo"+";"+"Total");
        miLista.forEach(l->{
            try {
                bw.write("\n"+l.getComunidadAutonoma()+";"+l.getGruposEspeciales()+";"+l.getPeriodo()+";"+l.getTotal());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }



}
