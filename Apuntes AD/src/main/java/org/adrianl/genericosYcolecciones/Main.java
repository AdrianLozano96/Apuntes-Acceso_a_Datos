package org.adrianl.genericosYcolecciones;


import org.adrianl.tdas.Cola;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PaisesComparable españa = new PaisesComparable(34, "España", "español");
        PaisesComparable francia = new PaisesComparable(33, "Francia", "frances");
        PaisesComparable alemania = new PaisesComparable(49, "Alemania", "aleman");
        PaisesComparable reinoUnido = new PaisesComparable(44, "Reino Unido", "ingles");
        PaisesComparable argentina = new PaisesComparable(54, "Argentina", "español");
        PaisesComparable estadosUnidos = new PaisesComparable(1, "Estados Unidos", "ingles");

        //-----------------------------------------LISTAS-----------------------------------------//
        //SON LINEALES, CON LA POSIBILIDAD DE ORDENARLAS Y PERMITEN VALORES REPETIDOS
        System.out.println("Esto es un ArrayList");
        ArrayList<PaisesComparable> paisesList = new ArrayList<PaisesComparable>();
        paisesList.add(españa);
        System.out.println("-----------------------------------------------------------------------------------------");
        //----------------------------------------------COLA----------------------------------------------------------//
        System.out.println("Esto es una cola de paises");
        Cola<PaisesComparable> cola = new Cola<>();
        cola.encolar(españa);
        cola.encolar(francia);
        cola.encolar(alemania);
        cola.encolar(estadosUnidos);

        for (PaisesComparable p: cola) {
            System.out.println(p);
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        //------------------------------------------------------------------------------------------------------------//
        //----------------------------------------------COMPARABLE----------------------------------------------------//
        System.out.println("COMPARABLE");
        List<PaisesComparable> lista = new ArrayList<>();
        lista.add(españa);
        lista.add(francia);
        lista.add(alemania);
        lista.add(estadosUnidos);

        Collections.sort(lista);
        for (PaisesComparable p: lista) {
            System.out.println(p);
        }
        //------------------------------------------------------------------------------------------------------------//
        System.out.println("-----------------------------------------------------------------------------------------");
        //----------------------------------------------COMPARATOR----------------------------------------------------//
        System.out.println("COMPARATOR");
        PaisesComparator pComparator = new PaisesComparator();
        Collections.sort(lista, pComparator);

        for (PaisesComparable p: lista) {
            System.out.println(p);
        }

        // Con Funcional
        System.out.println("COMPARATOR2");
        Comparator<PaisesComparable> prefijos = (v1, v2) -> Integer.compare(v2.getPrefijo(), v1.getPrefijo());
        Collections.sort(lista, prefijos);

        for (PaisesComparable p: lista) {
            System.out.println(p);
        }
        //------------------------------------------------------------------------------------------------------------//
        System.out.println("-----------------------------------------------------------------------------------------");

    }
}
