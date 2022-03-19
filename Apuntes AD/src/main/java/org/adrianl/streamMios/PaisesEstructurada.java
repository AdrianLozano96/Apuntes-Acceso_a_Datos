package org.adrianl.streamMios;

import java.util.ArrayList;
import java.util.List;

public class PaisesEstructurada{

    List<Paises> listaPaises = new ArrayList<>();   //Se crea una lista donde guarda la información (paises en este caso).

    public PaisesEstructurada(){    //Dentro del constructor por defecto se crear las instancias y las añadimos a la lista.
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
        System.out.println(listaPaises);    //Si no se tiene el méto ToString implementado en la clase se mostrarian las
        //referencias a cada objeto de las lista, pero al tener el método ToString en la clase, al imprimir la lista
        //nos muesta el ToString de todos los objetos
        /*for(int i=0;i<listaPaises.size();i++){      //Si no se implementa el método ToString se recorrera la lista
            System.out.println(i+" "+listaPaises.get(i).getPrefijo()+
                    " "+listaPaises.get(i).getNombre()+" "+listaPaises.get(i).getIdioma());
        }*/
        //--------------------------------------------
        System.out.println('\n'+"*** Lista de Paises cuyo nombre empieza por A o E***");
        for (int i=0;i<listaPaises.size();i++){
            if(listaPaises.get(i).getNombre().startsWith("A")){
                System.out.println(listaPaises.get(i).getNombre());
            }
            else if (listaPaises.get(i).getNombre().toLowerCase().startsWith("e")){
                System.out.println(listaPaises.get(i).getNombre());
            }
        }
        //-------------------------------------------------------------------------
        System.out.println('\n'+"*** Número de Paises ***");
        System.out.println(listaPaises.size());
        //--------------------------------------------
        System.out.println('\n'+"*** Nombre de Paises ***");
        for (int i=0;i<listaPaises.size();i++){
            System.out.println(listaPaises.get(i).getNombre());
        }
        //--------------------------------------------
        System.out.println('\n'+"*** Paises con el prefijo mayor a 40 y su idioma sea el ingles ***");
        for (int i=0;i<listaPaises.size();i++){
            if (listaPaises.get(i).getPrefijo()>40 && listaPaises.get(i).getIdioma().toLowerCase()=="ingles"){
                System.out.println(listaPaises.get(i));
            }
        }
        //---------------------------------------------------------------------------------------
        System.out.println('\n'+"*** Mostrar los 2 primeros Paises ***");
        for (int i=0;i<2;i++){
            System.out.println(listaPaises.get(i));
        }
        //----------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más pequeño ***");
        Paises min = listaPaises.get(0);
        for (Paises i : listaPaises){
            min = min.getPrefijo() < i.getPrefijo() ? min : i;
        }
        System.out.println(min);

        //------------------------------------------------------------
        System.out.println('\n'+"*** Pais con el prefijo más grande ***");
        Paises max = listaPaises.get(0);
        for (int i=0;i<listaPaises.size();i++){
            if(max.getPrefijo()<listaPaises.get(i).getPrefijo()){
                max=listaPaises.get(i);
            }
        }
        System.out.println(max);
        //-----------------------------------------------------------
        System.out.println('\n'+"*** Mostrar el primer Pais ***");
        System.out.println("primer: "+listaPaises.get(0));
        //---------------------------------------------------
        System.out.println('\n'+"*** Mostrar el último Pais ***");
        Paises ultimoPais = null;   //También funciona sin if
        if (listaPaises != null && !listaPaises.isEmpty()) {
            ultimoPais = listaPaises.get(listaPaises.size()-1);
        }
        System.out.println(ultimoPais);
        //---------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre contiene una i ***");
        for (Paises p:listaPaises){
            if (p.getNombre().toLowerCase().contains("i")){
                System.out.println(p);
            }
        }
        //--------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga más de 8 carácteres ***");
        for (Paises p: listaPaises){
           if (p.getNombre().length()>8){
               System.out.println(p);
           }
        }
        //-----------------------------------------------------------------------------
        System.out.println('\n'+"*** Paises cuyo nombre tenga 8 carácteres ***");
        for (Paises p: listaPaises){
            if (p.getNombre().length()==8){
                System.out.println(p);
            }
        }
        //-----------------------------------------------------------------------

    }
}
