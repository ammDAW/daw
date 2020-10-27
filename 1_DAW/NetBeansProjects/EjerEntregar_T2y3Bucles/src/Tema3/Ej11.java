/* Muestra por pantalla los divisores de un número entero introducido
por teclado*/
package Tema3;
import java.util.Scanner;

public class Ej11 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int num,i=1;
        
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        num=Integer.parseInt(cadena);
        
        //WHILE
        while(i<=num){
            if(num%i==0){System.out.println(i+" es divisor de "+num);}
            i++;
        }
        
        //DO
        i=1;
        do{
            if(num%i==0){System.out.println(i+" es divisor de "+num);}
            i++; 
        } while(i<=num);
        
        //FOR
        for(i=1;i<=num;i++){
            if(num%i==0){System.out.println(i+" es divisor de "+num);}
        }
    }  
}
