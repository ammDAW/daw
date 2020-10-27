//Calcular el area de un rectangulo
package t1_secuenciales;
import java.util.Scanner;

public class AreaRectangulo {
    public static void main(String[] args) {
       int a;
       int b;
       int area;
       Scanner teclado=new Scanner(System.in);
       String cadena;
       
       System.out.print("Introduzca la base del rectángulo: ");
       cadena=teclado.nextLine();
       b=Integer.parseInt(cadena);
       
       System.out.print("Introduzca la altura del rectángulo: ");
       cadena=teclado.nextLine();
       a=Integer.parseInt(cadena);
       
       area=a*b;
       System.out.println("El area es: " +area);   
    }   
}
