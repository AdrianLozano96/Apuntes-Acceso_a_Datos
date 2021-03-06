package org.adrianl.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class DomApp
{
    public static void main( String[] args )
    {
        String INPUT_XML = "https://feeds.elpais.com/mrss-s/pages/ep/site/elpais.com/portada";
        String OUTPUT_XML = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"noticias.xml";
        System.out.println(INPUT_XML);
        // Cargamos el controlador e iniciamos el DOM
        try {
            System.out.println("Cargamos nuestros Datos y DOM desde fichero");
            DOM controller = DOM.getInstance(INPUT_XML);
            controller.loadData();
            System.out.println("Exportamos los datos a un XML");
            controller.printXML();
            System.out.println("Listado");
            System.out.println("Todos");
            controller.getNoticias().forEach(System.out::println);
            System.out.println();

            System.out.println("*** DOM XML *** "); //Nuevo xml
            List<Noticia> noticiasList = controller.getNoticias();
            System.out.println("");
            controller.initData();
            for (Noticia noticias:noticiasList) {
                controller.addNewsItem(noticias);
            }
            controller.printXML();
            controller.writeXMLFile(OUTPUT_XML);    //Lo escribe en el nuevo xml

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e) {
            System.err.println("ERROR:" + e.getMessage());
        }
    }
}
