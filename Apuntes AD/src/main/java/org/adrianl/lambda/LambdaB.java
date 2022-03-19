package org.adrianl.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaB {
    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //1º Forma: una clase que implementa comparator
//		lista.sort(new MayorAMenor());

        //2º Forma: una clase "an�nima"
        //Qué tal si ponemos el cursor sobre la instanciación de la clase
        //anónima y pulsamos Ctrl+1?
        //Eclipse permite convertir esto en una expresión lambda automáticamente
//		lista.sort((o1, o2) -> -(o1.compareTo(o2)));

        //3º Forma: una expresion lambda
        //Los tipos de datos no son obligatorios! Se infieren del contexto
//		lista.sort((Integer n1, Integer n2) -> -(n1.compareTo(n2)));
        lista.sort((n1, n2) -> -(n1.compareTo(n2)));

        lista.forEach((n) -> System.out.println(n));

    }
}
