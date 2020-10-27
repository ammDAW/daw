/*Ejercicio 13 - Tema 3
Introducir un número por teclado e indica si es o no perfecto. Un
número es perfecto si la suma de sus divisores propios coincide con el
número. Los divisores propios de un número incluye el 1 y excluye el
propio número*/
package t3_metodos;
import java.util.Scanner;

public class Ej13_NumPerfecto {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);        
        System.out.print("Introduce un número y te diré si es perfecto: ");
        int n=teclado.nextInt();
        
        int sumaDivi=Matematica.sumaDivisores(n)-n;
        if(sumaDivi==n){System.out.println("Es perfecto");}
        else{System.out.println("No es perfecto");}
    }  
}
