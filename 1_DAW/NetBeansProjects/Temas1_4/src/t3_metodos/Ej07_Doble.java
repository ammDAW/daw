/*Método estático "doble" que devuelva el doble del valor entero que se le pasa 
como parámetro*/
package t3_metodos;
import java.util.Scanner;

public class Ej07_Doble {
    public static int doble(int x){
        x*=2;
        return x;
    }    
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int n=teclado.nextInt();
        System.out.println("El doble de "+n+" es "+doble(n));
    } 
}
