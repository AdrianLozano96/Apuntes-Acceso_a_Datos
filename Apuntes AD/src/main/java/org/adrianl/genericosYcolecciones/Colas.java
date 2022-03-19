package org.adrianl.genericosYcolecciones;


import java.util.LinkedList;
import java.util.Stack;

public class Colas {


    LinkedList<PaisesComparable> paisesLinked = new LinkedList<>();

    public void encolar(PaisesComparable p){
        paisesLinked.add(p);
    }

    public PaisesComparable desencolar(){
        return paisesLinked.remove();
    }

    /*

    //ArrayDeqeue
	
        Stack<Empleado> pila= new Stack<Empleado>();
	//Encolar
        pila.add(empleado1);
        pila.add(empleado2);
	//Desencolar
	Stack<Empleado> pila= (Stack<Empleado>) f.readObject();
            System.out.println(pila.pop().toString());
            System.out.println(pila.pop().toString());
            System.out.println(pila.empty());

     */

}
