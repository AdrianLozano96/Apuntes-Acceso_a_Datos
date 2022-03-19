package Ejercicio5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Jaxb {

    public void marshal(String uri, Libreria biblio) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        Path path = Path.of(uri);
        marshaller.marshal(biblio, new FileWriter(String.valueOf(path)));
    }

    public void unmarshal() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Path uri = Path.of(System.getProperty("user.dir") + File.separator + "data" + File.separator + "libros.xml");
        Libreria biblio = (Libreria) unmarshaller.unmarshal(new FileReader(String.valueOf(uri)));
        System.out.println("Nombre libreria "+biblio.getNombre());
        System.out.println("Lugar de la libreria "+biblio.getLugar());
        ArrayList<Libro> libros = biblio.getListaLibro();
        libros.forEach((l)->{
            System.out.println("Autor "+l.getAutor());
            System.out.println("Nombre "+l.getNombre());
            System.out.println("Editorial "+l.getEditorial());
            System.out.println("Isbn "+l.getIsbn());
        });
        //return biblio;
    }





}
