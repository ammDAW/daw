//Introducir un texto, pasadlo a vector de caracteres e indicar si representa un número
package t4_String;
import Clases.Pedir;

public class Ej02_IndicarNumero {
    public static void main(String[] args) {
        String texto=Pedir.frase("Dime una frase y te diré si es un número: ");
        boolean esNumero=true;
        for(int i=0;i<texto.length();i++){
            if(Character.isDigit(texto.charAt(i))==false){
                //no es un digito
                esNumero=false;
                break;
            }
        }
        if(esNumero)System.out.println("'"+texto+"' es un número");
        else System.out.println("'"+texto+"' no es número");
    }  
}
