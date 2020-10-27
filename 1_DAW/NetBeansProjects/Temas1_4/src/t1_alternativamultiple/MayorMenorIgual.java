/*Introducir 2 numeros enteros por teclado. Se desea saber cual es el mayor,
cual es el menor, o si son iguales*/
package t1_alternativamultiple;
import java.util.Scanner;

public class MayorMenorIgual {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int x;
        int y;
        
        System.out.print("Introduce un número: ");
        cadena=teclado.nextLine();
        x=Integer.parseInt(cadena);
        System.out.print("Introduce otro número: ");
        cadena=teclado.nextLine();
        y=Integer.parseInt(cadena);
        
        if(x>y){System.out.println(x+" es el mayor");}
        else if(x<y){System.out.println(x+" es el menor");}
        else{System.out.println(x+"="+y+" Son iguales");} 
    }    
}
