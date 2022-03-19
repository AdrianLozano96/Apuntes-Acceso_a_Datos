package org.adrianl.otros;

import java.util.stream.Collectors;

public class StringsTexto {

    public void estaVacio(String texto) {
        System.out.println(texto.isBlank());
    }

    public void repetir(String texto, int cantidad) {
        var repetido = texto.repeat(cantidad);
        System.out.println(repetido);
    }

    public void convertirLista(String texto) {  //Pasamos de un String a un Array si en el texto pones "1,2,3" sale [1,2,3]
        System.out.println(texto.lines().collect(Collectors.toList()));
    }

    public void removerEspacios(String texto) {
        // Al inicio y final
        System.out.println(texto.strip());  //Elimina los espacios en blanco de los dos lados
        // System.out.println(texto.stripLeading());    //Elimina el primer espacio en blanco
        // System.out.println(texto.stripTrailing());   //Elimina el último espacio en blanco
        System.out.println(texto.trim());
    }

    public static void main(String[] args) {
        StringsTexto texto = new StringsTexto();
    }

}
