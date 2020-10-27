/*Introducir un número entero positivo por teclado, indicar el número
de cifras que posee*/
package Tema3;
import java.util.Scanner;

public class Ej17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        int x, nCifras=1, aux=10;
        
        System.out.print("Introduce un numero entero positivo: ");
        cadena=teclado.nextLine();
        x=Integer.parseInt(cadena);
        
        //WHILE
        while(aux<=x){
            if(x>=aux){
                nCifras++;
                aux*=10;
            }
        }
        System.out.println("El numero "+x+" tiene "+nCifras+" cifras");
        
        //DO
        nCifras=1; aux=10;
        do{
            if(x>=aux){
                nCifras++;
                aux*=10;
            }
        } while(aux<=x);
        System.out.println("El numero "+x+" tiene "+nCifras+" cifras");
        
        //FOR
        aux=10;
        for(nCifras=1;aux<=x;){
            if(x>=aux){
                nCifras++;
                aux*=10;
            }
        }
        System.out.println("El numero "+x+" tiene "+nCifras+" cifras");
    }  
}
