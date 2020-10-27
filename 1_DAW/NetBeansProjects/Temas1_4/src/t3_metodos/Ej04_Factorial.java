/*Ej4 - Tema3
Calcular el factorial de un número entero introducido por teclado*/
package t3_metodos;
import java.util.Scanner;

public class Ej04_Factorial {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n=teclado.nextInt();
        long factorial=Matematica.factorial(n);
        System.out.println("El factorial de "+n+" es "+factorial);
    }
    
}
