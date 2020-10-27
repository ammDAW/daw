//Introducir un texto, muéstrala de nuevo sin espacios en blanco
package t4_String;
import Clases.Pedir;

public class Ej10_SinEspacios {
    public static void main(String[] args) {
        String texto=Pedir.frase("Dime una frase: ");
        String sinEsp="";
        
        for(int i=0;i<texto.length();i++){
            if(texto.charAt(i)!=' ')sinEsp=sinEsp+texto.charAt(i);
        }
        System.out.println(sinEsp);
    }  
}
