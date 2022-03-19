package org.adrianl.streamMios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PaisesFuncionalSol {

    List<Paises> listaPaises = new ArrayList<>();   //Se crea una lista donde guarda la información (paises en este caso).

    public PaisesFuncionalSol(){    //Dentro del constructor por defecto se crear las instancias y las añadimos a la lista.
        //Cargamos la lista de paises  nombrelista.add(instancia de la clase)
        listaPaises.add(new Paises(34, "España", "español"));
        listaPaises.add(new Paises(33, "Francia", "frances"));
        listaPaises.add(new Paises(49, "Alemania", "aleman"));
        listaPaises.add(new Paises(44, "Reino Unido", "ingles"));
        listaPaises.add(new Paises(54, "Argentina", "español"));
        listaPaises.add(new Paises(1, "Estados Unidos", "ingles"));
        listaPaises.add(new Paises(1500,"Atlantis", "antiguo"));
        listaPaises.add(new Paises(1230,"Lyonesse", "ingles"));
        //Al llamar al método hago que se ejecute cuando se cree un objeto de esta clase ya que esta
        //junto a las instancias dentro del constructor
        operacionesEstructuradas();

    }
    //Creo un método en el cual guardaré todas la operaciones, busquedas, etc, que quiera hacer sobre mi lista.
    private void operacionesEstructuradas(){
        System.out.println('\n'+"*** Lista de Paises ***");
        listaPaises.stream().forEach(System.out::println);
        //--------------------------------------------
        System.out.println('\n'+"*** Lista de Paises cuyo nombre empieza por A o E***");
        listaPaises.stream().filter((a)->a.getNombre().startsWith("A")||a.getNombre().startsWith("E")).forEach(System.out::println);
        //-------------------------------------------------------------------------
        System.out.println('\n'+"*** Número de Paises ***");
        System.out.println(listaPaises.stream().count());
        //--------------------------------------------
        System.out.println('\n'+"*** Nombre de Paises ***");
        listaPaises.stream().map(a->a.getNombre()).forEach(System.out::println);
        System.out.println('\n'+"*** Nombre de Paises Mayuscula ***");
        listaPaises.stream().map(Paises::getNombre).map(String::toUpperCase).forEach(System.out::println);
        //--------------------------------------------
        System.out.println('\n'+"*** Paises con el prefijo mayor a 40 y su idioma sea el ingles ***");
        listaPaises.stream().filter(a->a.getPrefijo()>40 && a.getIdioma().equalsIgnoreCase("ingles")).forEach(System.out::println);
        //---------------------------------------------------------------------------------------
        System.out.println('\n'+"*** Mostrar los 2 primeros Paises ***");
        listaPaises.stream().limit(2).forEach(System.out::println);
        //----------------------------------------------------------
        System.out.println('\n'+"*** Mostrar los 2 últimos Paises ***");
        listaPaises.stream().skip(listaPaises.size()-2).forEach(System.out::println);
        //----------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más pequeño ***");
        System.out.println(listaPaises.stream().min((p1,p2)->p1.getPrefijo()-p2.getPrefijo()));
        //------------------------------------------------------------
        System.out.println('\n'+"*** Paises con el prefijo de menor a mayor ***");
        listaPaises.stream().sorted((p1,p2)->p1.compareTo(p2)).forEach(System.out::println);
        //------------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más grande ***");
        System.out.println(listaPaises.stream().max((p1,p2)->p1.getPrefijo()- p2.getPrefijo()));
        //-----------------------------------------------------------
        System.out.println('\n'+"*** Paises con el nombre de mayor a menor ***");
        listaPaises.stream().sorted(Comparator.comparing(Paises::getNombre)).forEach(System.out::println);
        //-----------------------------------------------------------
        System.out.println('\n'+"*** Mostrar el primer Pais ***");
        System.out.println(listaPaises.stream().findFirst());
        //---------------------------------------------------
        System.out.println('\n'+"*** Mostrar el último Pais ***");
        System.out.println(listaPaises.stream().reduce((p1,p2)->p2));
        //---------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre contiene una i ***");
        listaPaises.stream().filter(p->p.getNombre().contains("i")).forEach(System.out::println);
        //--------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga más de 8 carácteres ***");
        listaPaises.stream().filter(p->p.getNombre().length()>8).forEach(System.out::println);
        //-----------------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga 8 carácteres ***");
        listaPaises.stream().map(Paises::getNombre).filter(n->n.length()==8).forEach(System.out::println);
        //-----------------------------------------------------------------------

    }


}
