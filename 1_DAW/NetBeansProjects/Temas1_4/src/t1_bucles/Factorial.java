//Calcula el factorial de un numero introducido por teclado
package t1_bucles;
import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int n;
        int fact=1;
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);

        for(int i=1;i<=n;i=i+1){
            fact=(fact*i);
        }
        System.out.println("Su factorial es: "+fact);
    }   
}
