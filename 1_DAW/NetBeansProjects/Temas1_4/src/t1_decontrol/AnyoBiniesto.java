//Diseña un algoritmo que lee un año e indica si es bisiesto.
package t1_decontrol;
import java.util.Scanner;

public class AnyoBiniesto {
    public static void main(String[] args) {
        int anyo;
        Scanner teclado = new Scanner(System.in);
        String cadena;
        
        System.out.print("Introduce un año: ");
        cadena=teclado.nextLine();
        anyo=Integer.parseInt(cadena);
        if((anyo%4==0)&&((anyo%100!=0)||(anyo%400==0))){
            System.out.println("Año bisiesto");
        }
        else {System.out.println("Año NO bisiesto");}
    }
}
