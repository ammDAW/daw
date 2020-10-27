
package t2_ejercicios;
import java.util.Scanner;

public class PruebaConversion {
    public static void main(String[] args) {
        int saber_letra;
        int aux;
        char letra;
        char c;
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce una letra: ");
        String cadena=teclado.nextLine();
        char l=cadena.charAt(0);
        System.out.println((char)l);
        if ((char)l>=65 && (char)l<=90){
            aux=(char)l-65;
            System.out.println("aux="+aux);
            aux+=97;
            System.out.println("Aux+="+aux);
            saber_letra=aux;
            System.out.println("saber_letra="+saber_letra);
            letra=(char)saber_letra;
            System.out.println("letra="+letra);
        }
    } 
}
