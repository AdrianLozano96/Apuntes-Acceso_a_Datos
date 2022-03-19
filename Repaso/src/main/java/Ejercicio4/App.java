package Ejercicio4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        String uri = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"02004 (1).csv";
        String uri2 = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"02004 (4).csv";
        List<CsvModel> miLista = new ArrayList<CsvModel>();
        Csv csv = new Csv();

        csv.leer(miLista, uri);
        miLista.forEach(System.out::println);
        csv.escribir(miLista, uri2);

    }
}
