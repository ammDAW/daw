/*Realizar un programa que lea un caracter por teclado y nos muestre si es
una letra mayúscula o minúscula o un dígito*/
package Tema3;
import java.util.Scanner;

public class Mayus_minus_digito {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        char c;
        
        System.out.print("Introduce un unico caracter: ");
        cadena=teclado.nextLine();
        c=cadena.charAt(0);
        if ((char)c>=65 && (char)c<=90){
            System.out.println("Es una MAYUSCULA");
        }
        else if ((char)c>=97 && (char)c<=122){
            System.out.println("Es una MINUSCULA");
        }
        else if ((char)c>=48 && (char)c<=57){
            System.out.println("Es un DIGITO");
        } 
    }  
}
