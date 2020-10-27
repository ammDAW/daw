/*Realizar un método estático: longitudAreaCirculo que devuelva el área de un
círculo o la longitud de una circunferencia, según se especifique en el dato de
entrada. Para distinguir un caso de otro se le pasará el carácter 'a'
(para área) o 'l'(para la longitud). Además hemos de pasarle al método estático 
el radio (valor entero)*/
package t3_metodos;
import java.util.Scanner;

public class Ej08_Circulo {
    public static double longitudAreaCirculo(char a, double r){
        double resultado=0;
        if(a=='a'){resultado=Math.PI*Math.pow(r, 2);}
        else if(a=='l'){resultado=2*Math.PI*r;}
        return resultado;
    }
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;

        System.out.print("Introduzca 'a' para calcular el area o 'l' para calcular la longitud: ");
        cadena=teclado.nextLine();
        char e=cadena.charAt(0);
        System.out.print("Introduzca el radio: ");
        int r=teclado.nextInt();
        
        double resultado=longitudAreaCirculo(e,r);
        if(e=='a'){System.out.println("El area es "+resultado);}
        else if(e=='l'){System.out.println("La longitud es "+resultado);}
    }   
}
