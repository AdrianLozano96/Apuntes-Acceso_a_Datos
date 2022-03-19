package org.adrianl.nio2;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Ejemplos {

    public static void main(String[] args) throws IOException {

        //Crea un fichero vacío si aún no existe
        Path emptyFile = Paths.get("/examples/emptyFile.txt");
        if (Files.notExists(emptyFile)) {
            Files.createDirectories(emptyFile);   //Crear directorio
            //Files.createFile(Paths.get("/examples/emptyFile.txt")); //Crear archivo
        }
        Files.createDirectories(emptyFile);
        //Lee el contenido de un fichero de texto a una cadena
        String content = new String(Files.readAllBytes(Paths.get("/examples/sampleText.txt")),
                StandardCharsets.UTF_8);
        System.out.println(content);

        //Lee el contenido de un fichero de texto línea a línea
        List<String> lines = Files.readAllLines(Paths.get("/examples/sampleText.txt"),
                StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }

        //Escribe un String a un fichero de texto, sobreescribiéndolo si ya existiera
        String text = "Esto es una cadena de prueba";
        Files.write(Paths.get("/examples/writeText.txt"), text.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        //Escribe una lista de String a un fichero de texto, sobreescribiéndolo si ya existiera
        List<String> textLines = Arrays.asList("Línea 1", "Línea 2", "Línea 3");
        Files.write(Paths.get("/examples/writeLines.txt"), textLines, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        //Crear una estructura de directorios de forma recursiva. Si algún directorio ya existiera no lanzará excepción
        Files.createDirectories(Paths.get("/examples/level1/level2/level3"));

        //Limpia el contenido de un directorio borrando de forma recursiva todos los ficheros contenidos en el mismo
        //Files.walk(Paths.get("/to_be_cleared")).parallel().filter(p -> p.toFile().isFile()).forEach(File::delete);

        //Borra de forma recursiva un directorio y todo su contenido
        Files.walk(Paths.get("/to_be_deleted")).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);

        //Copia un directorio con todo su contenido desde un origen a un destino
        Path from = Paths.get("/examples/source_dir");
        Path dest = Paths.get("/examples/dest_dir");
        try (Stream<Path> stream = Files.walk(from)) {
            stream.forEachOrdered(source -> {
                try {
                    Files.copy(source, dest.resolve(from.relativize(source)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        //Mueve un directorio con todo su contenido
        Files.move(Paths.get("/examples/source_dir"), Paths.get("/examples/dest_dir"),
                StandardCopyOption.REPLACE_EXISTING);

        //Convierte de Path a File y de File a Path
        //File file = onePath.toFile();
        //Path path = oneFile.toPath();



    }

}
