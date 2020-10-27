/*Introducir un texto, y mostrar la suma de los caracteres correspondientes a dígitos
pertenecientes a la secuencia almacenada en un String. Por ejemplo, si la cadena es
ABC12m4XYZ, entonces debe devolver el valor numérico entero 7*/
package t4_String;

import Clases.Pedir;

public class Ej12_Suma {
    public static void main(String[] args) {
       String texto=Pedir.frase("Dime una frase: ");
       int suma=0;
       for(int i=0; i<texto.length();i++){
           if(Character.isDigit(texto.charAt(i))){
               suma+=texto.charAt(i)-48;
           }
       }
        System.out.println("La suma es "+suma);
    }   
}
