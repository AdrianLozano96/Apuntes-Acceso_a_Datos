package org.adrianl.patrones;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    //Las clases singleton nos sirven en el caso de que solo se quiera tener una instancia de la misma clase
    //Para relizar una instancia de una clase singleton es Clase nombre = Clase.getInstance en vez de Clase nombre = new Clase();

    private static Singleton singleton = null;  //Se crea una varible privada y estática de la clase y se le asigna null

    public static Singleton getInstance(){  //para realizar las instancias de la clase, único método público

        if(singleton == null){  //En caso de no existir una instancia de la clase

            singleton = new Singleton();    //Se crea una única instacia de la clase

        }   //En caso de haber ya una instancia no hace nada

        return singleton;   //Devuelve la instancia

    }

    private Singleton(){    //Con el constructor privado se evita crear más instancias
                            //Obligandonos crear la instancia única con el método getInstance
    }

    //Una lista Crea una lista con unos valores que no cambiarán y la devuelve
    private List miLista = null;

    public List getLista(){
        if(miLista == null){
            miLista = new ArrayList();

            Singleton s1 = new Singleton(); //Si el constructor tiene parámetros se le pueden pasar argumentos
            Singleton s2 = new Singleton();
            Singleton s3 = new Singleton();

            miLista.add(s1);
            miLista.add(s2);
            miLista.add(s3);


        }
        return miLista;
    }


}
