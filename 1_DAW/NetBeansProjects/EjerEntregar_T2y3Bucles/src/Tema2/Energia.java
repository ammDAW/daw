/*Realiza una clase que calcule la teoría de la relatividad. E=mc2, donde.m
es la masa (int) y c la velocidad de la luz (299729458 m/s). Pide la masa
por teclado y muestra la energía*/
package Tema2;
import java.util.Scanner;

public class Energia {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int m, c=299729458;
        double E;
        
        System.out.print("Dime la masa: ");
        cadena=teclado.nextLine();
        m=Integer.parseInt(cadena);
        
        E=m*Math.pow(c,2);
        System.out.println("Teoria de la relatividad = "+E);
    } 
}
