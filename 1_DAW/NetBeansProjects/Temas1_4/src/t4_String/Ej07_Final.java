//Introducir un texto, e indicar si está la 'p', comenzando por la última posición
package t4_String;

import Clases.Pedir;

public class Ej07_Final {
    public static void main(String[] args) {
        String texto=Pedir.frase("Dime un texto: ");
        if (texto.lastIndexOf('p')==-1) System.out.println("En el texto NO hay 'p'");
        else System.out.println("En el texto hay 'p'");
        
        System.out.println("En el texto "+(texto.lastIndexOf('p')==-1?"NO":"")+" hay 'p'");
    } 
}
