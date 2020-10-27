/*Diseña el método: esPar, tal que dado un número entero, devuelve true si 
es par o false si es impar*/
package t3_metodos;
import java.util.Scanner;

public class Ej09_Par {
    public static boolean esPar(int x){
        if(x%2==0){return true;}
        else{return false;}
    }
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n=teclado.nextInt();
        if(n==0){System.out.println("El cero no es par ni impar");}
        else if(esPar(n)==true){System.out.println("Es par");}
        else {System.out.println("Es impar");}
    }  
}
