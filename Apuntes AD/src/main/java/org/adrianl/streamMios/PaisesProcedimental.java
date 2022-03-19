package org.adrianl.streamMios;

import java.util.ArrayList;
import java.util.List;

public class PaisesProcedimental {
    List<Paises> listaPaises = new ArrayList<>();   //Se crea una lista donde guarda la información (paises en este caso).

    public PaisesProcedimental(){    //Dentro del constructor por defecto se crear las instancias y las añadimos a la lista.
        //Cargamos la lista de paises  nombrelista.add(instancia de la clase)
        Paises p1 = new Paises(34, "España", "español");
        Paises p2 = new Paises(33, "Francia", "frances");
        Paises p3 = new Paises(49, "Alemania", "aleman");
        Paises p4 = new Paises(44, "Reino Unido", "ingles");
        Paises p5 = new Paises(54, "Argentina", "español");
        Paises p6 = new Paises(1, "Estados Unidos", "ingles");
        Paises p7 = new Paises(1500,"Atlantis", "antiguo");
        Paises p8 = new Paises(1230,"Lyonesse", "ingles");
        listaPaises.add(p1);
        listaPaises.add(p2);
        listaPaises.add(p3);
        listaPaises.add(p4);
        listaPaises.add(p5);
        listaPaises.add(p6);
        listaPaises.add(p7);
        listaPaises.add(p8);
        //Al llamar al método hago que se ejecute cuando se cree un objeto de esta clase ya que esta
        //junto a las instancias dentro del constructor
        operacionesEstructuradas();

    }
    //Creo un método en el cual guardaré todas la operaciones, busquedas, etc, que quiera hacer sobre mi lista.
    private void operacionesEstructuradas(){
        System.out.println("Pogramación Procedimental, es decir como se haria en MySQL");

        System.out.println('\n'+"*** Lista de Paises ***");
        System.out.println("SELECT * FROM paises");
        //--------------------------------------------
        System.out.println('\n'+"*** Lista de Paises cuyo nombre empieza por A o E***");
        System.out.println("SELECT * FROM paises WHERE nombre LIKE \"A%\" \n" +
                "UNION \n" +
                "SELECT * FROM paises WHERE nombre LIKE \"E%\"");
        //-------------------------------------------------------------------------
        System.out.println('\n'+"*** Número de Paises ***");
        System.out.println("SELECT COUNT(*) FROM paises");
        //--------------------------------------------
        System.out.println('\n'+"*** Paises con el prefijo mayor a 40 y su idioma sea el ingles ***");
        System.out.println("SELECT * FROM paises WHERE prefijo > 40 AND idioma = \"ingles\"");
        //---------------------------------------------------------------------------------------
        System.out.println('\n'+"*** Mostrar los 2 primeros Paises ***");
        System.out.println("SELECT * FROM paises LIMIT 2");
        //----------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más pequeño ***");
        System.out.println("SELECT * FROM paises ORDER BY prefijo ASC LIMIT 1");
        //------------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más grande ***");
        System.out.println("SELECT * FROM paises ORDER BY prefijo DESC LIMIT 1");
        //-----------------------------------------------------------
        System.out.println('\n'+"*** Mostrar el primer Pais ***");
        System.out.println("SELECT * FROM paises LIMIT 1");
        //---------------------------------------------------
        System.out.println('\n'+"*** Mostrar el último Pais ***");
        //VER
        //---------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre contiene una i ***");
        System.out.println("SELECT * FROM paises WHERE nombre LIKE \"%i%\"");
        //--------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga más de 8 carácteres ***");
        System.out.println("SELECT * FROM paises WHERE CHAR_LENGTH(nombre)>8");
        //-------------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga 8 carácteres ***");
        System.out.println("SELECT * FROM paises WHERE CHAR_LENGTH(nombre)=8");
        //------------------------------------------------------------------

    }
}
