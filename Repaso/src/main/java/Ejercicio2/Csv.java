package Ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Csv<T> {

    public List<CsvModel> leer(String uri, List<CsvModel> miLista) throws IOException {

        Path path = Path.of(uri);
        List<String> lista = Files.readAllLines(path, StandardCharsets.UTF_8);

        for(int i=1; i<lista.size(); i++) {
            StringTokenizer tk = new StringTokenizer(lista.get(i),";");
            CsvModel datos = new CsvModel();
            datos.setComunidadAutonoma(tk.nextToken());
            datos.setGruposEspeciales(tk.nextToken());
            datos.setPeriodo(Integer.parseInt(tk.nextToken()));
            String total = tk.nextToken();
            if(!total.equals(".")){
                total = total.replace(",",".");
                datos.setTotal(Double.parseDouble(total));
            }else{
                datos.setTotal(0.0);
            }
            miLista.add(datos);
        }
        return miLista;

    }

    public void escribir(String uri, List<CsvModel>miLista) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(uri));
        bw.write("Comunidad autonoma"+";"+"Grupos especiales"+","+"Periodo"+","+"Total");
        miLista.forEach(l->
                {
                    try {
                        bw.write("\n"+
                                l.getComunidadAutonoma()+";"+l.getGruposEspeciales()+";"+l.getPeriodo()+";"+l.getTotal()
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                );
        bw.flush();
        bw.close();
    }

    public void consultas(List<CsvModel>miLista){
        System.out.println("Datos Madrid");
        miLista.stream().filter(l->l.getComunidadAutonoma().equals("Madrid (Comunidad)")).forEach(System.out::println);
        System.out.println("Datos Total 0");
        miLista.stream().filter(l->l.getTotal()==0.0).forEach(System.out::println);
        System.out.println("Datos Totales");
        int total = (int) miLista.stream().count();
        System.out.println("Total: "+total);
        Optional max = miLista.stream().max((x, y)-> (int) (x.getTotal()-y.getTotal()));
        System.out.println("Maximo: "+max);
        Optional min = miLista.stream().min((x,y)-> (int) (x.getTotal()-y.getTotal()));
        System.out.println("Minimo: "+min);
        double sum = miLista.stream().mapToDouble(x->x.getTotal()).sum();
        System.out.println("Suma total: "+sum);
        double sumMadrid = miLista.stream().filter(x->x.getComunidadAutonoma().equals("Madrid (Comunidad)")).mapToDouble(x->x.getTotal()).sum();
        System.out.println("Suma Total de Madrid: "+sumMadrid);
        System.out.println("Datos Madrid 2005-2006");
        miLista.stream().filter(l-> l.getPeriodo()==2005 || l.getPeriodo()==2006)
                .filter(l->l.getComunidadAutonoma().equals("Madrid (Comunidad)")).forEach(System.out::println);

        List<CsvModel>listaa=
        miLista.stream().filter(l-> l.getPeriodo()==2005 || l.getPeriodo()==2006)
                .filter(l->l.getComunidadAutonoma().equals("Madrid (Comunidad)"))
                .filter(l->l.getTotal()<300.00)
                .sorted(CsvModel::compareTo)
                .collect(Collectors.toList());
        System.out.println("Ordenado por el Total");
        listaa.stream().forEach(System.out::println);
        System.out.println("Orden Inverso");
        listaa.stream().sorted((l1,l2)->l2.compareTo(l1)).forEach(System.out::println);
    }





}
