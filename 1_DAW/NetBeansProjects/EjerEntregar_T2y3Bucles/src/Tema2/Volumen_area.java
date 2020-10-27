/*Determinar el área y volumen de un cilindro cuyas dimensiones radio y
altura se leen desde el teclado. PI una constante, y es un valor
matemático (utiliza Math.PI)*/
package Tema2;
import java.util.Scanner;

public class Volumen_area {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        double r, h, area, volumen;
        final double pi=Math.PI;
        
        System.out.print("Escribe el radio del cilindro: ");
        cadena=teclado.nextLine();
        r=Double.parseDouble(cadena);
        System.out.print("Escribe la altura: ");
        cadena=teclado.nextLine();
        h=Double.parseDouble(cadena);
        
        area=2*pi*r*(r+h);
        volumen=pi*Math.pow(r,2)*h;
        System.out.println("El area es "+area);
        System.out.println("El volumen es "+volumen);
    }   
}
