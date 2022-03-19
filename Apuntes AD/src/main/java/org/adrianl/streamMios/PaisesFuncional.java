package org.adrianl.streamMios;

import java.util.ArrayList;
import java.util.List;

public class PaisesFuncional {

    List<Paises> listaPaises = new ArrayList<>();   //Se crea una lista donde guarda la información (paises en este caso).

    public PaisesFuncional(){    //Dentro del constructor por defecto se crear las instancias y las añadimos a la lista.
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
        
        //--------------------------------------------
        System.out.println('\n'+"*** Lista de Paises cuyo nombre empieza por A o E***");

        //-------------------------------------------------------------------------
        System.out.println('\n'+"*** Número de Paises ***");

        //--------------------------------------------
        System.out.println('\n'+"*** Nombre de Paises ***");

        //--------------------------------------------
        System.out.println('\n'+"*** Paises con el prefijo mayor a 40 y su idioma sea el ingles ***");

        //---------------------------------------------------------------------------------------
        System.out.println('\n'+"*** Mostrar los 2 primeros Paises ***");

        //----------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más pequeño ***");

        //------------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más grande ***");

        //-----------------------------------------------------------
        System.out.println('\n'+"*** Mostrar el primer Pais ***");

        //---------------------------------------------------
        System.out.println('\n'+"*** Mostrar el último Pais ***");

        //---------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre contiene una i ***");

        //--------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga más de 8 carácteres ***");

        //-----------------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga 8 carácteres ***");

        //-----------------------------------------------------------------------

    }


}
