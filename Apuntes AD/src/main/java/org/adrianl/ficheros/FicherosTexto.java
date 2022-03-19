package org.adrianl.ficheros;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FicherosTexto {

    public static void testEscribirFicheroTexto() {
        File fichero = null;
        PrintWriter f = null;
        String carpeta = null;
        String nombreArchivo = null;
        String uri = null;  //Se puede pasar por parámetros una ubicación completa
        String fecha = new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime());
        String extension = null;
        File ficheroNew;
        String directorio = System.getProperty("user.dir")+File.separator+carpeta+File.separator+nombreArchivo;
        try
        {
            ficheroNew = new File(uri+File.separator+nombreArchivo+fecha+extension);
            fichero = new File("prueba.txt");
            System.out.println("Escribiendo en el fichero:"+fichero.getAbsolutePath());

            // Creamos el buffer y le asociamos el fichero
            // Usamos PrintWriter y no BufferedWriter porque tiene mejores metodos
            // Pero podríamos usar BufferedWriter y usar \n
            f = new PrintWriter(new FileWriter(fichero,true));  // al poner FileWriter -> true no sobrescribimos

            // Escribimos diez lineas
            for (int i = 0; i < 10; i++){
                f.println("Linea:"+i);
                f.append("Añadido: "+i);
            }
            // vamos a escribir la propia ruta del fichero en el fichero
            // usamos la clase file

            f.println(fichero.getAbsolutePath());   //PrintWritter.println(File.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (f != null)
                    f.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void testLeerFicheroTexto() {
        File fichero = null;
        BufferedReader f = null;
        try
        {
            fichero = new File("prueba.txt");
            System.out.println("Leyendo del fichero:"+fichero.getAbsolutePath());

            // Creamos el buffer y le asociamos el fichero
            f = new BufferedReader(new FileReader(fichero));

            //leemos hasta el final del fichero linea a línea
            /*
            String linea = f.readLine();
            while(linea!=null){
                System.out.println(linea);
                linea = f.readLine();
            }
             */

            //Otra forma más corta
            String linea;
            String linea2=null;
            while((linea=f.readLine())!=null){
            System.out.println(linea);
            linea2+=linea;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (f != null)
                    f.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
