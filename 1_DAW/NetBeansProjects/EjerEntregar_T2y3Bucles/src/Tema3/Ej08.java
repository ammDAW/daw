/* Dados 2 números enteros, calcular cuál es el cociente y cuál es el resto
utilizando el método de las restas sucesivas.*/
package Tema3;
import java.util.Scanner;

public class Ej08 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int dividendo, divisor, cociente=0, resto;
        
        System.out.print("Introduce el dividendo: ");
        cadena=teclado.nextLine();
        dividendo=Integer.parseInt(cadena);
        System.out.print("Introduce el divisor: ");
        cadena=teclado.nextLine();
        divisor=Integer.parseInt(cadena);
        
        //WHILE
        resto=dividendo;
        while(divisor<=resto){
            resto-=divisor;
            cociente++;
        }
        System.out.println("El cociente es "+cociente);
        System.out.println("El resto es "+resto);
        
        //DO
        cociente=0;
        resto=dividendo;
        do{
            resto-=divisor;
            cociente++;
        }while(divisor<=resto);
        System.out.println("El cociente es "+cociente);
        System.out.println("El resto es "+resto);
       
        //FOR
        resto=dividendo;
        for(cociente=0;divisor<=resto;cociente++){;
            resto-=divisor;
        }
        System.out.println("El cociente es "+cociente);
        System.out.println("El resto es "+resto);
    } 
}
