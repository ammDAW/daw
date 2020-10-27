/*Realiza una clase que declare una variable de tipo cadena de caracteres
String, llamada "frase". Lee un valor para frase y muéstralo por pantalla
después*/
package Tema2;

import java.util.Scanner;

public class Frase {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String frase, cadena;
        
        System.out.print("Escribe una frase: ");
        cadena=teclado.nextLine();
        frase=cadena;
        System.out.println(frase);
    }   
}
