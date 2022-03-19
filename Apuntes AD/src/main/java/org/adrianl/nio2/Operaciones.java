package org.adrianl.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operaciones {


    public void operacionesConFile(String nombre, String operacion) throws IOException {
        String directorio = System.getProperty("user.dir")+ File.separator+"data"+File.separator+nombre;    //Ruta

        Path path = Paths.get(directorio);  //Referencia al directorio
        Path pathCopiado = Paths.get(directorio+"copi");

        switch(operacion){
            case "existe":
                //Se le pasa el path y unas opciones para buscar si el archivo se encuentra en el directorio
                //boolean existe = Files.exists(path, new LinkOption[]{ LinkOption.NOFOLLOW_LINKS}); //Evita porej accesos directos
                //Se debe guardar en un boleano
                boolean existe = Files.exists(path);    //Mira si existe un directorio o archivo
                System.out.println("Existe este archivo? "+existe);
                break;
            case "crear directorio":
                //Se ha de almacenar en una variable de tipo Path
                Path nuevoPath = Files.createDirectories(path); //Crea un directorio
                break;
            case "crear archivo":
                Path emptyFile = Paths.get("/examples/emptyFile.txt");
                if (Files.notExists(emptyFile)) {
                    //Files.createDirectories(emptyFile);   Crear directorio
                    emptyFile = Files.createFile(Paths.get("/examples/emptyFile.txt")); //Crear archivo
                }

                break;
            case "copiar":
                //Path origen y path destino (tienen que tenerdistinto nombre)
                Files.copy(path, pathCopiado);
                break;
            case "mover":
                Files.move(path, pathCopiado);
                break;
            case "eliminar":
                Files.delete(pathCopiado);
                break;
        }

    }

    public void leer(String nombre){


    }

    public void escribir(){

    }


    public static void main(String[] args) throws IOException {
        Operaciones op = new Operaciones();
        //op.operacionesConFile("prueba.txt","existe");
        //op.operacionesConFile("prueba.txt","crear directorio");
        //op.operacionesConFile("prueba.txt","crear archivo");
        //op.operacionesConFile("prueba.txt","copiar");
        //op.operacionesConFile("prueba.txt","mover");
        //op.operacionesConFile("prueba.txt","eliminar");
        /*
        Path relative = Paths.get("");
        Path absolute = relative.toAbsolutePath().normalize();
        System.out.println("relativa: "+relative);
        System.out.println("Absoluta: "+absolute);
        System.out.println();
        System.out.println("# ls -la ordenado por nombre");
        Files.walk(relative, 1).sorted((p1, p2) -> {
            return p1.getFileName().toString().compareTo(p2.getFileName().toString());
        }).forEach(path -> {
            try {
                System.out.println(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

         */

        System.out.println("");
        System.out.println("LEER");
        String directorio = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"products.csv";    //Ruta
        Path file = Paths.get(directorio);
        Files.readAllLines(file).stream().forEach(System.out::println);



    }

}
