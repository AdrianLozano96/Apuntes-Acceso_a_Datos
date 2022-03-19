package org.adrianl.otros;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Split {
    public static void main(String[] args) {
        String cadena = "Madrid;;Barcelona;Valencia;Andalucia";
        System.out.println("Sin filtros:");
        String[] conSeparacion = cadena.split(";"); //Segundo parámetro corresponde a cuantas separaciones se harán
        for(String elemento : conSeparacion){
            if(!elemento.equals("")){
                System.out.println(elemento);
            }
        }

        System.out.println("\nCon filtros:");
        List<String> filtro = new ArrayList<>();
        filtro = Stream.of(cadena.split(";")).filter(a->!a.equals("")).collect(Collectors.toList());
        filtro.stream().forEach(System.out::println);

    }

}
