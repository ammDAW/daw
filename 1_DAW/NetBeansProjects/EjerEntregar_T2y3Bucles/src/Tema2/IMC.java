/*Haz una clase que tu "índice de masa corporal", para ello utiliza
variables de tipo entero. Utiliza un cast a float.*/
package Tema2;
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int peso, altura;
        float fPeso, fAltura, imc;
        
        System.out.print("Introduce tu peso: ");
        cadena=teclado.nextLine();
        peso=Integer.parseInt(cadena);
        fPeso=(float)peso;
        System.out.println(fPeso);
        
        System.out.print("Introduce tu altura: ");
        cadena=teclado.nextLine();
        altura=Integer.parseInt(cadena);
        fAltura=(float)altura;
        System.out.println(fAltura);
        
        //imc=fPeso/(fAltura*fAltura);
        imc=fPeso/(fAltura*fAltura)*10000;
        
        System.out.println("Tu IMC es "+imc);
    }  
}
