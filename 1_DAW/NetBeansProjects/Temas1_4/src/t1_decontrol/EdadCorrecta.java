//Diseñar un algoritmo que nos diga si una edad introducida es correcta o no
package t1_decontrol;
import java.util.Scanner;

public class EdadCorrecta {
    public static void main(String[] args) {
        float edad;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        System.out.print("Introduce una edad: ");
        cadena=teclado.nextLine();
        edad=Float.parseFloat(cadena);
        
        if (edad>0 && edad<123){
            System.out.println("La edad es correcta.");
        }
        else {
            System.out.println("Edad NO es correcta.");    
        }
    }   
}
