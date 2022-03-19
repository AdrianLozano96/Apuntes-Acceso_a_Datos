package prueba;

import Ejercicio6.CsvModel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        String uri="hola;adios;que;tal;vamos;";
        Path path = Path.of(uri);
        //List<String> lista = Files.readAllLines(path, StandardCharsets.UTF_8);

        int count =0;
        //for(int i=1; i<lista.size(); i++) {
            StringTokenizer tk = new StringTokenizer(uri, ";");
            while(tk.hasMoreTokens()) {
                count++;
                System.out.println(tk.nextToken());
                System.out.println(count);
            }
        System.out.println(count);
            /*
            CsvModel csv = new CsvModel();
            csv.setComunidadAutonoma(tk.nextToken());
            csv.setGruposEspeciales(tk.nextToken());
            csv.setPeriodo(Integer.parseInt(tk.nextToken()));
            String total = tk.nextToken();
            if(!total.equals(".")){
                total = total.replace(",",".");
                csv.setTotal(Double.parseDouble(total));
            }else{
                csv.setTotal(0.0);
            }

             */
          //  miLista.add(csv);
       // }
    }


}
