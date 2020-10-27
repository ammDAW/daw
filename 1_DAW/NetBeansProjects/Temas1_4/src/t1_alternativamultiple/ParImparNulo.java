//Introducir un número entero e indicar si es positivo, negativo o nulo
package t1_alternativamultiple;
import java.util.Scanner;

public class ParImparNulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        String cadena;
        int num;
        
        System.out.print("Introduce un número entero: ");
        cadena=teclado.nextLine();
        num=Integer.parseInt(cadena);
        if (num>0){
            System.out.println("Número POSITIVO");
        }
        else if (num<0){
            System.out.println("Número NEGATIVO");
        }
        else {System.out.println("Número NULO");}
    }  
}
