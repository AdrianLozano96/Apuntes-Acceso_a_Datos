package org.adrianl.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;

/*
    Una vez que tenemos las clases ya definidas, lo siguiente es ver el código Java para mapear los objetos
    que definamos de esas clases. Utilizando la anotación @XmlRootElement. Código para conseguir el XML
    //Instanciamos el contexto, indicando la clase que será el RootElement, en nuestro ejemplo es la clase Libreria
    JAXBContext jaxbContext = JAXBContext.newInstance(Libreria.class);
    //Creamos un Marshaller, que es la clase capaz de convertir nuestro JavaBean, en una cadena XML:
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    //Indicamos que vamos a querer el XML con un formato amigable (saltos de línea, sangrado, etc)
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    //Hacemos la conversión llamando al método marshal, pasando una instancia del JavaBean que queramos convertir
    // a XML y un OutpuStream donde queramos que salga el XML, por ejemplo, la salida estándar,
    // o también podría ser un fichero o cualquier otro stream:
    jaxbMarshaller.marshal(unaInstanciaDeUnaClase, System.out);
    //Si ponemos un fichero
    jaxbMarshaller.marshal(unaInstanciaDeUnaClase, new File("./mifichero.xml"));
     */
public class Main {
    private static final String MIARCHIVO_XML = "./libreria.xml";

    public static void marshal() throws JAXBException {    //Pasar del Objetos a XML
        //Se crea la lista de libros
        ArrayList<Libro> libroLista = new ArrayList<>();
        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Alicia Ramos", "Entornos de Desarrollo","Garceta","978-84-1545-297-3" );
        libroLista.add(libro1);
        Libro libro2 = new Libro("Maria Jesús Ramos","Acceso a Datos", "Garceta","978-84-1545-228-7" );
        libroLista.add(libro2);
        // Se crea La libreria y se le asigna la lista, de libros
        Libreria milibreria = new Libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Talavera, como no");
        milibreria.setListaLibro(libroLista);
        //------------------------------------------------------------------CONVERTIR DE OBJETO A XML
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller marshall = context.createMarshaller();
        //Formateamos el xml para que quede bien
        marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        //--------------------------------------------------------------------MOSTRAR CONTENIDO POR TERMINAL
        // Lo visualizamos con system out
        marshall.marshal(milibreria, System.out);
        //----------------------------------------------------------------------------ESCRITURA DEL FICHERO
        // Escribimos en el archivo
        Path p = Path.of(System.getProperty("user.dir") + File.separator + "data" + File.separator + "libros.xml");
        marshall.marshal(milibreria, new File(String.valueOf(p)));
    }

    //Si ahora deseamos hacer lo contrario, es decir, leer los datos del documento XML y
    //convertirlos a objetos Java, utilizaremos las siguientes órdenes:
    public static void unMarshal() throws JAXBException, FileNotFoundException {
        //Se crea la lista de libros
        ArrayList<Libro> libroLista = new ArrayList<>();
        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Entornos de Desarrollo", "Alicia Ramos","Garceta","978-84-1545-297-3" );
        libroLista.add(libro1);
        Libro libro2 = new Libro("Acceso a Datos","Maria Jesús Ramos", "Garceta","978-84-1545-228-7" );
        libroLista.add(libro2);
        // Se crea La libreria y se le asigna la lista, de libros
        Libreria milibreria = new Libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Talavera, como no");
        milibreria.setListaLibro(libroLista);
        //--------------------------------------------------------------------------------------------------------------
        //Instanciamos el contexto, indicando la clase que será el RootElement, en nuestro ejemplo Libreria:
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        //Se crea Unmarshaller en el cotexto de la clase Libreria:
        Unmarshaller unmars = context.createUnmarshaller();
        //Utilizamos el método unmarshal, para obtener datos de un Reader (un File):
        Libreria objeto = (Libreria) unmars.unmarshal(new FileReader("libros.xml"));
        //Recuperamos un atributo del objeto:
        System.out.println(objeto.getNombre());
        //Recuperamos el Arraylist, si lo tiene y visualizamos:
        ArrayList<Libro> lista = objeto.getListaLibro();
        for (Libro obarray : lista) {
            System.out.println("Atributo array: " + obarray.getNombre());
            //En nuestro ejercicio el código para visualizar el contenido del fichero XML es el siguiente:
            // Visualizamos ahora los datos del documento XML creado
            System.out.println(" Leo el XML ");
            //Se crea Unmarshaller en el contexto de la clase Libreria
            Unmarshaller unmars2 = context.createUnmarshaller();
            //Utilizamos el método unmarshal, para obtener datos de un Reader
            Libreria libreria2 =(Libreria) unmars2.unmarshal(new FileReader("./libreria.xml"));
            //Recuperamos los datos y visualizamos
            System.out.println("Nombre de libreria: "+ libreria2.getNombre());
            System.out.println("Lugar de la libreria: " + libreria2.getLugar());
            System.out.println("Libros de la librería: ");
            ArrayList<Libro> lista2 = libreria2.getListaLibro();
            for (Libro libro : lista2) {
                System.out.println("\tTítulo del libro: 11" + libro.getNombre()+ " autora: "+ libro.getAutor());
            }
        }
    }

    public static void unmarshal() throws FileNotFoundException, JAXBException {    //PASAR DE XML A OBJETOS
        //Instanciamos el contexto, indicando la clase que será el RootElement, en nuestro ejemplo Libreria:
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        //Se crea Unmarshaller en el contexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();
        //Utilizamos el método unmarshal, para obtener datos de un Reader
        Path uri = Path.of(System.getProperty("user.dir") + File.separator + "data" + File.separator + "libros.xml");
        Libreria libreria =(Libreria) unmars.unmarshal(new FileReader(String.valueOf(uri)));
        //Recuperamos los datos y visualizamos
        System.out.println("Nombre de libreria: "+ libreria.getNombre());
        System.out.println("Lugar de la libreria: " + libreria.getLugar());
        System.out.println("Libros de la librería: ");
        ArrayList<Libro> lista = libreria.getListaLibro();

        lista.stream().map(Libro::getNombre).forEach(System.out::println);
        lista.forEach((l)->{
            System.out.println("Titulo: "+l.getNombre());
            System.out.println("Autor: "+l.getAutor());
            System.out.println("Editorial: "+l.getEditorial());
        });
    }

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        //marshal();
        System.out.println();
        //unMarshal();
        System.out.println();
        unmarshal();
    }
}





