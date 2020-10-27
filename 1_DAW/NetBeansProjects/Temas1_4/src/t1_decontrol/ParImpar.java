/*Diseña un algoritmo que tal que dado un número entero, nos indique si es
par o impar*/
package t1_decontrol;
import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        int num;
        int resto;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        num=Integer.parseInt(cadena);
        resto=num % 2;
        //tambien se puede hacer quitando resto y poniendo directamente if(num%2==0)
        if (resto==0){
            System.out.println("El numero es PAR");        
        }
        else {
            System.out.println("El numero es IMPAR");
        }
    }  
}
