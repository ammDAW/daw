//Calcular la longitud y el area de un círculo
package t1_secuenciales;
import java.util.Scanner;

public class LongitudAreaCirculo {
    public static void main(String[] args) {
        double longitud;
        double area;
        int radio;
        //final double PI=3.14159; PI seria un variable fija
        Scanner teclado=new Scanner(System.in);
        String cadena;

        System.out.print("Introduzca el radio: ");
        cadena=teclado.nextLine();
        radio=Integer.parseInt(cadena);
        
        longitud=2*Math.PI*radio;
        area=Math.PI*Math.pow(radio,2);
        
        System.out.println("La longitud es "+longitud);
        System.out.println("El area es "+area);   
    }   
}
