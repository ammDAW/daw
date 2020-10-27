/*Calcula el número de divisores que tiene un número entero introducido por
teclado y la suma de éstos*/
package Tema3;
import java.util.Scanner;

public class Ej12 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int num,i=1,num_div=0,sum_div=0;
        
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        num=Integer.parseInt(cadena);
        
        //WHILE
        while(i<=num){
            if(num%i==0){num_div++;sum_div+=i;}
            i++;
        }
        System.out.println("La cantidad total de divisores es "+num_div);
        System.out.println("La suma de sus divisores es "+sum_div);
        
        //DO
        i=1; num_div=0; sum_div=0;
        do{
           if(num%i==0){num_div++;sum_div+=i;}
           i++;
        } while(i<=num);
        System.out.println("La cantidad total de divisores es "+num_div);
        System.out.println("La suma de sus divisores es "+sum_div);
    }  
}
