package Ejercicio6;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Jaxb {

    public void marshal(String uri, Libreria biblioteca) throws JAXBException { //Escritura
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Marshaller marshal = context.createMarshaller();
        marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshal.marshal(biblioteca, new File(uri));
    }

    public Libreria unmarshal(String uri) throws JAXBException, FileNotFoundException { //Lectura

        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        Unmarshaller unmarshal = context.createUnmarshaller();
        Libreria biblioteca = (Libreria) unmarshal.unmarshal(new FileReader(uri));
        System.out.println("Nombre: "+biblioteca.getNombre());
        System.out.println("Lugar: "+biblioteca.getLugar());
        List<Libro> libros = biblioteca.getListaLibros();
        libros.forEach(l->{
            System.out.println("Autor: "+l.getAutor());
            System.out.println("Nombre: "+l.getNombre());
            System.out.println("Editorial: "+l.getEditorial());
            System.out.println("Isbn: "+l.getIsbn());
        });
        return biblioteca;
    }

}
