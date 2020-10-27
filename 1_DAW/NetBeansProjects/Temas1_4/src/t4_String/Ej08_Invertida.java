//Introduce una cadena, devuelve la invertida.
package t4_String;
import Clases.Cadenas;
import Clases.Pedir;

public class Ej08_Invertida {
    public static void main(String[] args) {
        String texto=Pedir.frase("Dime un frase: ");
        String txtInvertido="";
        for(int i=texto.length()-1;i>=0;i--){
            txtInvertido=txtInvertido+texto.charAt(i);
        }
        System.out.println(txtInvertido);
        //usando un metodo
        texto="aeiou";
        System.out.println("Invertida de: "+texto+" es "+Cadenas.invertida(texto));
    }
}
