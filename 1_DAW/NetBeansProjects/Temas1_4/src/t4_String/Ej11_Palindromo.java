/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t4_String;
import Clases.Cadenas;
import Clases.Pedir;

public class Ej11_Palindromo {
    public static void main(String[] args) {
        String texto=Pedir.frase("dime una frase: ");
        
        String textoMy=texto.toUpperCase();
        textoMy=Cadenas.cadenaSinSp(textoMy);
        
        if(textoMy.equals(Cadenas.invertida(textoMy))) System.out.println("'"+texto+"' es palindroma");
        else System.out.println("'"+texto+"' NO es palindroma");
    }
}
