package Ejercicio6;

import org.jdom2.JDOMException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, JAXBException, JDOMException {
        String uri1 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"02004 (1).csv";
        String uri2 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"02004 (5).csv";
        List<CsvModel> miLista = new ArrayList<>();
        Csv csv = new Csv();
        csv.leer(uri1, miLista);
        miLista.forEach(System.out::println);
        //csv.escribir(uri2, miLista);

        String uri3 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"libros.xml";
        String uri4 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"libreria.xml";
        //Jaxb jaxb = new Jaxb();
        //Libreria biblioteca = jaxb.unmarshal(uri3);
        //jaxb.marshal(uri4, biblioteca);

        String uri5 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"noticias.xml";
        String uri6 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"noticiario.xml";
        Jdom jdom = Jdom.getInstace(uri5);
        //jdom.cargarDatos();
        //jdom.escritura(uri6);
        //List<Noticia> noticias = jdom.getDatos();
        //noticias.forEach(System.out::println);




    }



}
