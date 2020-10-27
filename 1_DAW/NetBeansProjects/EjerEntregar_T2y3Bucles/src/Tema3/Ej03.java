/*Muestra los N primeros múltiplos de 4, donde N es un valor introducido
por teclado*/
package Tema3;
import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        String cadena;
        int i=1,n;
        
        System.out.print("Introduce un numero: ");
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);
        
        //WHILE
        while(i<=n){
            if(i%4==0){System.out.println(i);}
            i++;
        }
        i=1;
        
        //DO
        do{
            if(i%4==0){System.out.println(i);}
            i++;  
        } while(i<=n);
        
        //FOR
        for(i=1;i<=n;i++){
           if(i%4==0){System.out.println(i);} 
        }
    }  
}
