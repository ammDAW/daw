//Calcular el doble de un numero
package t1_secuenciales;
import java.util.Scanner;

public class DobleNumero {
    public static void main(String[] args) {
        //ENTORNO
        int n;
        int doble;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        //FIN_ENTORNO
        //ALGORITMO
        System.out.println("Dime un número entero: ");
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);
        
        doble=n*2;
        System.out.println("El doble es "+doble); 
        //FIN_ALGORITMO
    }   
}
