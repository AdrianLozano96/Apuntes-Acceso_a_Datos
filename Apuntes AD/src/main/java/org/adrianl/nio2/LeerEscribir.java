package org.adrianl.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LeerEscribir {

    public void leer() {
        try {
            String contenido = Files.readString(Path.of("D:/prueba.txt"));  //Se le pasa el path con el contenido
            System.out.println(contenido);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribir() {
        try {
            //con writeString se le pasa la ruta del archivo, el texto del archivo, tipo de operacion (en este caso se añade la info)
            Path path = Files.writeString(Path.of("D:/prueba.txt"), " Suscribete a MitoCode", StandardOpenOption.APPEND);
            //Path path = Files.writeString(Path.of("D:/prueba.txt"), " Suscribete a MitoCode", StandardOpenOption.CREATE_NEW);
            //Se imprime el path
            System.out.println(path);
            //Se lee el Path para ver lo escrito
            String s = Files.readString(path);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
