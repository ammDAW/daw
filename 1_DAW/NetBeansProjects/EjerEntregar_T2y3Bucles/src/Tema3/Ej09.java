/*Introduce por teclado 10 números enteros, calcula cuál es el mayor*/
package Tema3;
import java.util.Scanner;

public class Ej09 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int mayor=Integer.MIN_VALUE,num,i=1;
        
        //WHILE
        while(i<=10){
            System.out.print("Introduce un numero: ");
            cadena=teclado.nextLine();
            num=Integer.parseInt(cadena);
            if(num>mayor){mayor=num;}
            i++;
        }
        System.out.println("El numero mayor es "+mayor);
        
        //DO
        mayor=0;i=1;
        do{
            System.out.print("Introduce un numero: ");
            cadena=teclado.nextLine();
            num=Integer.parseInt(cadena);
            if(num>mayor){mayor=num;}
            i++;
        } while(i<=10);
        System.out.println("El numero mayor es "+mayor);
        
        //FOR
        mayor=0;
        for(i=1;i<=10;i++){
            System.out.print("Introduce un numero: ");
            cadena=teclado.nextLine();
            num=Integer.parseInt(cadena);
            if(num>mayor){mayor=num;}
        }
        System.out.println("El numero mayor es "+mayor);
    }  
}
