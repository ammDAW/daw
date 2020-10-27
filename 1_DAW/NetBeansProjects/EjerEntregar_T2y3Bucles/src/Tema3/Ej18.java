/*Un capital c se coloca a un interés anual r. ¿Al cabo de cuántos
años se doblará? El interés producido por un capital al cabo de un 
año es: i=(c*r)/100*/
package Tema3;
import java.util.Scanner;

public class Ej18 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int c, anyos=0, cDoble;
        float r, interes;
        
        //WHILE
        System.out.print("Introduzca el capital: ");
        cadena=teclado.nextLine();
        c=Integer.parseInt(cadena);
        cDoble=c*2;
        System.out.print("Introduzca el interes: ");
        cadena=teclado.nextLine();
        r=Float.parseFloat(cadena);
        
        while(c<cDoble){
              interes=(c*r)/100;
              anyos++;
              c+=interes;
        }
        System.out.println("Años necesarios: "+anyos);
        
        //DO
        anyos=0;
        System.out.print("Introduzca el capital: ");
        cadena=teclado.nextLine();
        c=Integer.parseInt(cadena);
        cDoble=c*2;
        System.out.print("Introduzca el interes: ");
        cadena=teclado.nextLine();
        r=Float.parseFloat(cadena);
        
        do {
              interes=(c*r)/100;
              anyos++;
              c+=interes;
        } while(c<cDoble);
        System.out.println("Años necesarios: "+anyos);
        
        //FOR
        anyos=0;
        System.out.print("Introduzca el capital: ");
        cadena=teclado.nextLine();
        c=Integer.parseInt(cadena);
        cDoble=c*2;
        System.out.print("Introduzca el interes: ");
        cadena=teclado.nextLine();
        r=Float.parseFloat(cadena);
        
        for(anyos=0;c<cDoble;anyos++){
            interes=(c*r)/100;
            c+=interes;
        }
        System.out.println("Años necesarios: "+anyos);
    }  
}
