//Calcular el factorial de un número entero introducido por teclado
package Tema3;
import java.util.Scanner;

public class Ej04 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int n, i;
        int fact=1;
        
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);

        for(i=1;i<=n;i=i+1){
            fact=(fact*i);
        }
        System.out.println("Su factorial es: "+fact);
        
        i=1;fact=1;  
        while(i<=n){
            fact=(fact*i);
            i++;
        }
        System.out.println("Su factorial es: "+fact);
        
        i=1;fact=1;
        do{
            fact=(fact*i);
            i++;
        } while(i<=n);
        System.out.println("Su factorial es: "+fact);
    }  
}
