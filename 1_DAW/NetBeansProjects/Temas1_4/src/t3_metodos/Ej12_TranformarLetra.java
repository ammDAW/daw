/*Diseña el método: pasarAMinuscula, tal que dado un carácter considerado como
dato de entrada, si es una letra del abecedario y está en Mayúscula lo 
transforma a minúscula, si no es una letra del abecedario o no está en 
minúscula, devuelve el carácter tal como entró al método*/
package t3_metodos;

import java.util.Scanner;

public class Ej12_TranformarLetra {
    public static char pasarAMinuscula(char c){
        int aux;
        char letra;
        if ((char)c>=65 && (char)c<=90){
            aux=(char)c-65;
            aux+=97;
            letra=(char)aux;
        }
        else{letra=c;}
        return letra;
    }

    public static void main(String[] args) {
       Scanner teclado=new Scanner(System.in);
       System.out.print("Introduce una letra: ");
       String cadena=teclado.nextLine();
       char letra=cadena.charAt(0);
       System.out.println(pasarAMinuscula(letra));     
    }  
}
