package org.adrianl.genericosYcolecciones;

import java.util.*;

public class Colecciones {

    public static void main(String[] args) {

        PaisesComparable españa = new PaisesComparable(34, "España", "español");
        PaisesComparable francia = new PaisesComparable(33, "Francia", "frances");
        PaisesComparable alemania = new PaisesComparable(49, "Alemania", "aleman");
        PaisesComparable reinoUnido = new PaisesComparable(44, "Reino Unido", "ingles");
        PaisesComparable argentina = new PaisesComparable(54, "Argentina", "español");
        PaisesComparable estadosUnidos = new PaisesComparable(1, "Estados Unidos", "ingles");
        PaisesComparable atlantis = new PaisesComparable(1230,"Ciudad Perdida de Atlantis", "Antiguo");

        //LIST:         SON LINEALES, CON LA POSIBILIDAD DE ORDENARLAS Y PERMITEN VALORES REPETIDOS
        //----------------------------------------------ARRAYLIST-----------------------------------------------------//
        //Para almacenar y acceder a datos
        System.out.println("Esto es un ArrayList");
        ArrayList<PaisesComparable> paisesList = new ArrayList<>();
        paisesList.add(españa);     //add permite añadir un elemento al ArrayList
        paisesList.add(francia);
        paisesList.add(alemania);
        paisesList.add(reinoUnido);
        paisesList.add(argentina);
        paisesList.add(estadosUnidos);
        System.out.println(paisesList.get(0));      //Obtengo el elemento indicado dentro del ArrayList (España)
        System.out.println(paisesList.size());  //Muestra el tamaño de la lista (cuantos elementos tiene)
        paisesList.set(0,atlantis);   //Cambia el elmento del indice indicado en la lista por otro valor del mismo tipo
        paisesList.remove(4);   //Elimina el valor de la lista indicado en el índice (ya no esta Argentina)
           //Ordena el ArrayList
        for(PaisesComparable i: paisesList){
            System.out.println(i);      //Muestra el ArrayList con un for mejorado recorriendo cada elemento de la lista
        }
        paisesList.clear();     //Vacia la lista por completo (ya no hay más valores)
        System.out.println(paisesList+"Se vacio la lista");     //Muestra la lista de forma simple
        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------LINKEDYLIST---------------------------------------------------//
        //Para manipular datos, muchas insercciones o borrados de elementos (pilas y colas).
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Esto es una LinkedList");   //Ideal para colas
        LinkedList<PaisesComparable> paisesLinked = new LinkedList<>();
        paisesLinked.add(españa);   //Añade valor
        paisesLinked.remove(españa);    //Elimina valor
        //------------------------------------------------------------------------------------------------------------//



        //SET:         NO SOPORTAN ELEMENTOS DUPLICADOS Y TIENEN LA POSIBILIDAD DE ORDENAR LOS ELEMENTOS
        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------HASHSET-------------------------------------------------------//
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Esto es un HashSet");
        HashSet<PaisesComparable> paisesHashSet = new HashSet<>();
        paisesHashSet.add(españa);  //Para añadir elementos
        paisesHashSet.add(atlantis);
        paisesHashSet.add(estadosUnidos);
        System.out.println(paisesHashSet.size());   //Para saber cuantos elementos tengo
        System.out.println(paisesHashSet);  //Para mostrar mis elementos
        //PARA ORDENA USAR UNA LINKEDHASHSET

        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------TREESET-------------------------------------------------------//



        //------------------------------------------------------------------------------------------------------------//
        //MAP:         TIENEN UNA ESTRUCTURA CLAVE, VALOR. CON POSIBILIDAD DE ORDEN DE ELEMENTOS
        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------HASHMAP-------------------------------------------------------//
        //Almacenan datos como pares de clave y valor
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Esto es un HashMap");
        HashMap<PaisesComparable, String> paisesHashMap = new HashMap<PaisesComparable, String>();//<Tipo del key, Tipo del value>
        paisesHashMap.put(españa, "Yo hablo español"); //Añado clave, valor
        paisesHashMap.put(argentina, "Yo hablo español");  //La clave sieempre tiene que ser distinta, el valor no importa
        paisesHashMap.put(alemania, "Yo hablo aleman");
        System.out.println(paisesHashMap.get(españa));//get y la clave permiten acceder al valor correspondiente
        System.out.println(paisesHashMap.containsKey(españa)); //Para saber si existe esa clave
        System.out.println(paisesHashMap.containsValue("Yo hablo español"));  //Para saber si existe ese valor
        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------TREEMAP-------------------------------------------------------//



        //------------------------------------------------------------------------------------------------------------//









    }
}
