
package t3_metodos;
import java.util.Scanner;

public class EjerSuma {
    public static void main(String[] args) {
        int a=Matematica.suma(2,5);
        System.out.println("La suma es "+a);
         
        //Contar divisores totales del 6
        int div=Matematica.contarDivisores(6);
        System.out.println("El número 6 tiene "+div+" divisores");
        
        //Mostrar los divisores del 6
        Matematica.divisores(6);
        
        //Ejercicio divisores totales numero por teclado
        Scanner teclado=new Scanner(System.in);
        System.out.print("Dime un número y te diré cuantos divisores tiene: ");
        int num=teclado.nextInt();
        int nDivisores=Matematica.contarDivisores(num);
        System.out.println("Tiene "+nDivisores+" divisores");
        if(nDivisores<=2){System.out.println(num+" es primo");}
    } 
}
