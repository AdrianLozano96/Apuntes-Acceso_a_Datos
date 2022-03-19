package org.adrianl.tdas;

import java.util.Collection;

//Contrato que toda Cola debe cumplir
public interface ICola<E> extends Collection<E> {   //E es generico (element)

    //Encola un item (E es el item a encolar)
    void encolar(E item);

    // Desencola un Item
    E desencolar();
}
