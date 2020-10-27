/*Se desea convertir metros a pies y pulgadas (1metro = 39.23 pulgadas;
1 pie=12 pulgadas). Para convertir los metros a pulgadas y pies:
    1. Multiplicar número de metros por 39.37 (pulgadas)
    2. Dividir el resultado anterior por 12.(pies)*/
package Tema2;
import java.util.Scanner;

public class Pulgadas {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        float metros;
        double pies, pulgadas;
        
        System.out.print("Introduce los metros a convertir: ");
        cadena=teclado.nextLine();
        metros=Float.parseFloat(cadena);
        pulgadas=metros*39.37;
        pies=pulgadas/12;
        
        System.out.println(metros+" metros son "+pulgadas+" pulgadas");
        System.out.println(metros+" metros son "+pies+" pies" );    
    }  
}
