package org.adrianl;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ArrayList<Double> aleatorio = new ArrayList<>();
        for(int i=0; i<100; i++){
            aleatorio.add(Math.random()*100+1);
        }
        for(Double ale: aleatorio){

            System.out.println(ale);
        }
        //System.out.println(aleatorio);

        System.out.println( "Hello World!" );
    }
}
