package Ejercicio5;

import org.jdom2.JDOMException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws JAXBException, IOException, JDOMException {
        Jaxb jaxb = new Jaxb();
        Libro libro1 = new Libro("Alicia Ramos","Entornos de Desarrollo","Garceta","978-84-1545-297-3");
        Libro libro2 = new Libro("Maria Jesús Ramos","Acceso a Datos","Garceta","978-84-1545-228-7");
        ArrayList libros = new ArrayList();
        libros.add(libro1);
        libros.add(libro2);
        Libreria biblio = new Libreria();
        biblio.setNombre("Mi nueva libreria");
        biblio.setLugar("España");
        biblio.setListaLibro(libros);
        String uri = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"NuevosLibros.xml";
        //jaxb.marshal(uri, biblio);
        //jaxb.unmarshal();
        String uri2 = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada";
        String uri3 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"NuevasNoticias2.xml";
        String uri1 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"NuevasNoticias.xml";
        Jdom jdom = Jdom.getInstance(uri1);
        jdom.loadData();
        jdom.escribir(uri3);
        jdom.getDatos().forEach(System.out::println);

    }
}
