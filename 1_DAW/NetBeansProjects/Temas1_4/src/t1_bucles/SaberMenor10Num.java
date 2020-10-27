//Programa que lee y muestra el menor de 10 numeros enteros.
package t1_bucles;
import java.util.Scanner;

public class SaberMenor10Num {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        String cadena;
        int x,menor;
        
        System.out.print("Escribe un numero: ");
        cadena=teclado.nextLine();
        menor=Integer.parseInt(cadena);
        for(int i=1;i<10;i++){ //preguntas 9 veces porque la 10 esta arriba
            System.out.print("Escribe un numero: ");
            cadena=teclado.nextLine();
            x=Integer.parseInt(cadena);
            if (x<menor){menor=x;}            
        }
        System.out.println("El menor es "+menor);
    }   
}
