/*Realiza una clase que lea desde el teclado un número entero, un
número float, uno double y un carácter. Muestra su valor por pantalla.*/
package Tema2;
import java.util.Scanner;

public class Lectura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        int e;
        float f;
        double d;
        char c;
        
        System.out.print("Introduce un numero entero: ");
        cadena=teclado.nextLine();
        e=Integer.parseInt(cadena);
        
        System.out.print("Introduce un numero float: ");
        cadena=teclado.nextLine();
        f=Float.parseFloat(cadena);
        
        System.out.print("Introduce un numero double: ");
        cadena=teclado.nextLine();
        d=Double.parseDouble(cadena);
        
        System.out.print("Introduce un caracter: ");
        cadena=teclado.nextLine();
        c=cadena.charAt(0);
        
        System.out.println(e+" "+" "+f+" "+d+" "+c);
    }  
}
