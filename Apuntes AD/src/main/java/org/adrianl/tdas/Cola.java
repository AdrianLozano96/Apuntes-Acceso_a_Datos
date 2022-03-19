package org.adrianl.tdas;

import java.util.ArrayDeque;

// TDA Cola genérica.
 // Esta clase no es necesaria pues podríamos usar los métodos por defecto de esta clase
 // posiblemente desaparezca en refactorización.           <E> elemento de cola genérica
public class Cola<E> extends ArrayDeque<E> implements ICola<E> {

    //Encola un elemento al final   E item elemento a encolar
    public void encolar(E item) {
        this.add(item);
    }

    //Elimina el elemento al comienzo
    public E desencolar() {
        return this.removeFirst();
    }

}
