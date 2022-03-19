package org.adrianl.streamMios;

import java.util.ArrayList;
import java.util.List;

public class ApuntesFuncional {
    List<Paises> listaPaises = new ArrayList<>();

    public ApuntesFuncional(){
        //----------------------------DENTRO DE UN MÉTODO
        listaPaises.add(new Paises(34, "España", "español"));
        listaPaises.add(new Paises(33, "Francia", "frances"));
        listaPaises.add(new Paises(49, "Alemania", "aleman"));
        listaPaises.add(new Paises(44, "Reino Unido", "ingles"));
        listaPaises.add(new Paises(54, "Argentina", "español"));
        listaPaises.add(new Paises(1, "Estados Unidos", "ingles"));
        listaPaises.add(new Paises(1500,"Atlantis", "antiguo"));
        listaPaises.add(new Paises(1230,"Lyonesse", "ingles"));
        //estructuradaFuncional();
    }

    public void estructuradaFuncional(){

        System.out.println("Programación Estructurada o Imperativa");


        System.out.println("Programación Funcional o Declarativa");
        //MÉTODO COMPARATOR
        /*
        MÉTODO COMPARATOR con Programación Estructurada o Imperativa"
        Collections.sort(listaPaises, new Comparator<Paises>() {
            @Override
            public int compare(Paises o1, Paises o2) {
                return o1.compareTo(o2);
            }
        });
        MÉTODO COMPARATOR con Programación Funcional o Declarativa
        //Collections.sort(listaPaises,lambda );lambda = (parametros) -> expresion a evaluar
        Collections.sort(listaPaises, (Paises p1, Paises p2) -> p1.compareTo(p2) );

        for (Paises p:listaPaises){
            System.out.println(p);
        }
        */
    }

    public void filtrar(){
        //Filtrar los elementos que empiecen por la letra A
        listaPaises.stream().filter(x -> x.getNombre().startsWith("A"))
                .forEach(System.out::println);  //.forEach(x -> System.out.println(x));
    }
    public void ordenar(){
        listaPaises.stream().sorted()
                .forEach(System.out::println);
    }
    public void ordenarInverso(){   //Le paso una expresion lambada para invertirlo
        listaPaises.stream().sorted((x, y) -> y.compareTo(x))
                .forEach(System.out::println);
    }
    public void transformar(){  //map: transforma los elementos de uno a uno segun la expresión indicada
        listaPaises.stream().map(x -> x.getNombre().toUpperCase()).forEach(System.out::println);
    }
    public void limitar(){
        //muestra los dos primeros elementos
        listaPaises.stream().limit(2).forEach(System.out::println);
    }
    public void contar(){
        long x = listaPaises.stream().count();
        System.out.println(x);
    }
    //StreamParalelo
    public void streamparalelo(){
        listaPaises.parallelStream().forEach(System.out::println);  //lo muestra de forma paralela, hilos
    }



        
}
