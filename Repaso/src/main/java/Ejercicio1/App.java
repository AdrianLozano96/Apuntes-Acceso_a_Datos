package Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args ) throws IOException {

        String uri = System.getProperty("user.dir")+ File.separator + "data" + File.separator + "02004 (1).csv";
        String uri2 = System.getProperty("user.dir")+ File.separator + "data" + File.separator + "02004 (2).csv";

        CsvModel modelo = new CsvModel(); //Clase donde se guardan los valores (POJO)

        List<String> miLista = new ArrayList<>();
        List<CsvModel>modeloLista = new ArrayList<>();
        Csv csv = new Csv();
        //csv.leerCsv(uri, miLista);
        csv.meteDatos(uri, modeloLista);
        csv.pasarCsv(uri2, modeloLista);
        csv.consultas(modeloLista);
        //System.out.println(modeloLista);
        //csv.escribirCsvObj(uri2, modeloLista);
        //csv.escribirCsv(uri2, modeloLista);
        //csv.leerescribirCsv(uri,uri2);

    }

}
