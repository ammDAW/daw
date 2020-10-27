/*Ej12 tema3. Hacer un metodo que saque la suma de los divisores de un numero 
introducido por teclado*/
package t3_metodos;
import java.util.Scanner;

public class Ej12_SumaDivisores {
   public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Dime un numero entero: ");
        int n=teclado.nextInt();
        
        int sumaDiv=Matematica.sumaDivisores(n);
        System.out.println("La suma de sus divisores es "+sumaDiv);
    }
    
}
