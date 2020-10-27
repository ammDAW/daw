/*Diseñar un método estático maximo que tenga como parámetros dos números
enteros, y que devuelva el máximo de los dos*/
package t3_metodos;
import java.util.Scanner;

public class Ej03_Maximo {
    public static int maximo(int x, int y){
        int max=(x>y)?x:y;
        return max;
        /*if(x>y){System.out.println(x+" es el mayor");}
        else if(x<y){System.out.println(y+" es el mayor");}
        else{System.out.println("Son iguales");}*/
    }
    
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n1=teclado.nextInt();
        System.out.print("Introduce otro número: ");
        int n2=teclado.nextInt();
        
        System.out.println("El máximo de ambos números es "+maximo(n1,n2));
    }
    
}
