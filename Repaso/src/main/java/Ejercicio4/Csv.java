package Ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.StringTokenizer;

public class Csv {

    public List<CsvModel> leer(List<CsvModel> miLista, String uri) throws IOException {
        Path path = Path.of(uri);
        List<String>lista = Files.readAllLines(path, StandardCharsets.UTF_8);
        for(int i=1; i<lista.size(); i++){
            StringTokenizer tk = new StringTokenizer(lista.get(i), ";");
            CsvModel datos = new CsvModel();
            datos.setComunidadAutonoma(tk.nextToken());
            datos.setGruposEspeciales(tk.nextToken());
            datos.setPeriodo(Integer.parseInt(tk.nextToken()));
            String total = tk.nextToken();
            if(!total.startsWith(".")){
                total = total.replace(",",".");
                datos.setTotal(Double.parseDouble(total));
            } else{
                datos.setTotal(0.0);
            }
            miLista.add(datos);
        }
        return miLista;
    }

    public void escribir(List <CsvModel>miLista, String uri) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(uri));
        bw.write("Comunidad Autónoma"+";"+"Grupos Especiales"+";"+"Periodo"+";"+"Total");

        miLista.forEach(l->{
            try {
                bw.write("\n"+l.getComunidadAutonoma()+";"+l.getGruposEspeciales()+";"+l.getPeriodo()+";"+l.getTotal()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bw.flush();
        bw.close();
    }





}
