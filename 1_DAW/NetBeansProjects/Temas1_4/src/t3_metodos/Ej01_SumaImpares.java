/*Escriba un método estático: sumaImparesN que devuelva la suma de los n
primeros números impares*/
package t3_metodos;
        
import java.util.Scanner;

public class Ej01_SumaImpares {
    public static int sumaImparesN(int n){
        int suma=0;
        int contador=1;
        for(int i=1;contador<=n;i+=2){suma+=i;contador++;}
        return suma;
    }

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n=teclado.nextInt();
        int suma=sumaImparesN(n);
        System.out.println("La suma de los primeros "+n+" impares es "+suma);
    }
}
