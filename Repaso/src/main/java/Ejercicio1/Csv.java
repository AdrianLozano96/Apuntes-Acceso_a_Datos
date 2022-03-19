package Ejercicio1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Csv {

    public void leerCsv(String uri, List<String>miLista) throws IOException {
        Path path = Path.of(uri);
        String leer = Files.readString(path);
        //miLista = Stream.of(leer.split(";")).collect(Collectors.toList());
        miLista.stream().forEach(System.out::println);
    }

    public void escribirCsv(String uri, List<String> miLista) throws IOException {
        Path path = Path.of(uri);
        Files.write(path, miLista,StandardOpenOption.CREATE); //Si la lista no es de Objetos
    }

    public void escribirCsvObj(String uri, List<CsvModel> miLista) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(uri));
        for(CsvModel csv: miLista){
            oos.writeObject(csv.toString());
        }
        oos.close();
    }



    public List<CsvModel> meteDatos(String uri, List<CsvModel>modeloList) throws IOException {
        Path path = Path.of(uri);   //Se crea el path con la ubicación del archivo
        List<String>datosCsv = Files.readAllLines(path, StandardCharsets.UTF_8);   //Lista donde almacenar la información del csv
        //List<CsvModel>modeloList = new ArrayList<>();   //Lista de la clase para guardar la información en sus atributos
        for(int i=1; i<datosCsv.size(); i++) {         //Se recorren todos los datosCsv leidos del csv
            //Con StringTokinizer se separan los datosCsv por un delimitador(lista.get(i), delimitador)
            StringTokenizer tk = new StringTokenizer(datosCsv.get(i), ";");
            CsvModel modeloData = new CsvModel();    //Se crea una instancia por recorrido para almacenar los datos
            //Se asigna a cada atributo su token (valor) correspondiente
            modeloData.setComunidadAutonoma(tk.nextToken());
            modeloData.setGruposEspeciales(tk.nextToken());
            modeloData.setPeriodo(tk.nextToken());
            //String token = tk.nextToken();
            String tok = tk.nextToken();
            if(!tok.startsWith(".")) {
                tok = tok.replace(",", ".");
                modeloData.setTotal(Double.parseDouble(tok));
            }else{
                modeloData.setTotal(0.0);
            }
            //modeloData.setTotal(tk.nextToken());
            modeloList.add(modeloData); //Se añade el objeto creado a la lista
        }
        return modeloList;
    }

    public void consultas(List<CsvModel> miLista){
        List<String>madrid = miLista.stream().filter(l->l.getComunidadAutonoma().equals("Madrid (Comunidad)"))
                .map(CsvModel::toString)
                .collect(Collectors.toList());
        madrid.forEach(System.out::println);


    }
    //Guau
    public void pasarCsv(String uri, List<CsvModel>miLista) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(uri));
        miLista.forEach(l->
        {
            try {
                bw.write(l.getComunidadAutonoma()+";"
                        +l.getGruposEspeciales()+";"
                        +l.getPeriodo()+";"
                        +l.getTotal()+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }

    //Meh
    public void leerescribirCsv(String uri, String uri2) throws IOException {
        Path path = Path.of(uri);
        String leer = Files.readString(path);
        List<String> lista = new ArrayList<>();

        lista = Stream.of(leer.split(";")).collect(Collectors.toList());
        lista.stream().forEach(System.out::println);
        Path path2 = Path.of(uri2);
        Files.write(path2,lista,StandardOpenOption.CREATE);
    }

}
