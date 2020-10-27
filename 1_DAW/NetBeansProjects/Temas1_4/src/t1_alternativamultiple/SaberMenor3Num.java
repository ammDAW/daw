//Programa que lee y muestra el menor de tres enteros.
package t1_alternativamultiple;        
import java.util.Scanner;

public class SaberMenor3Num {
    public static void main(String[] args) {
        int x,y,z;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        System.out.print("Escribe un numero entero: ");
        cadena=teclado.nextLine();
        x=Integer.parseInt(cadena);
        System.out.print("Escribe otro numero entero: ");
        cadena=teclado.nextLine();
        y=Integer.parseInt(cadena);
        System.out.print("Escribe el tercer numero entero: ");
        cadena=teclado.nextLine();
        z=Integer.parseInt(cadena);
        
        if (x<=y && x<=z){
            System.out.println("El menor es "+x);
        }
        else if(y<=x && y<=z){
            System.out.println("El menor es "+y);
        }
        else if(z<=x && z<=y){
            System.out.println("El menor es "+z);
        }
        //else{System.out.println("Los 3 numeros son iguales");}
    } 
}
