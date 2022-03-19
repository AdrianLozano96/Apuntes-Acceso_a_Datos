package org.adrianl.genericosYcolecciones;

//Las clases Genéricas son clases parametrizadas sobre uno o más tipos. El tipo se asigna en tiempo de compilación.
//Tipos de Párametros: E(elemento), K(clave), V(valor), N(número), T(tipo), S(tipo2), U(tipo3), V(tipo4)...

public class Genericos<T, S>{ //public class Genericos<T extends Number>{   //public class Genericos<T extends A&B>{

    private T obj1;
    private S obj2;

    public void set (T object1, S object2){
        this.obj1 = object1;
        this.obj2 = object2;
    }

    public T getObj1(){
        return obj1;
    }
    public S getObj2(){
        return obj2;
    }

}

//Para instanciar un objeto genérico se hace:
//ClaseGenerica <tipo1, tipo2...> nombreInstancia = new ClaseGenerica<> (valor1, valor2...);
