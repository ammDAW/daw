/*Diseña el método: esMayuscula, tal que dado un carácter considerado como dato
de entrada, devuelve true si es una letra del abecedario y está en mayúscula, o
devuelve false, si no es letra o no está en mayúscula*/
package t3_metodos;
import java.util.Scanner;

public class Ej10_Mayuscula {
    public static boolean esMayuscula(char c){
        if ((char)c>=65 && (char)c<=90){return true;}
        else {return false;}
    }
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce una letra: ");
        String cadena=teclado.nextLine();
        char letra=cadena.charAt(0);
        if(esMayuscula(letra)==true){System.out.println("Es mayúscula");}
        else{System.out.println("No es una letra mayúscula");}
    }   
}
