//Calcular la hipotenusa de un triángulo rectángulo
package t1_secuenciales;
import java.util.Scanner;

public class Hipotenusa {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        float catetoA;
        float catetoB;
        double hip;
        
        System.out.print("Introduce el cateto A: ");
        cadena=teclado.nextLine();
        catetoA=Float.parseFloat(cadena);
        System.out.print("Introduce el cateto B: ");
        cadena=teclado.nextLine();
        catetoB=Float.parseFloat(cadena);
        
        hip=Math.sqrt(Math.pow(catetoA,2)+Math.pow(catetoB,2));
        System.out.print("La hipotenusa es "+hip);
    }  
}
