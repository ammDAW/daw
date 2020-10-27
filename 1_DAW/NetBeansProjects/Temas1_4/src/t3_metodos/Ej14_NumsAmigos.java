/*Ej 14 - Tema 3
Introduce 2 números enteros por teclado e indica si son amigos o
no. Dos números son amigos si, la suma de los divisores propios del
primer número coincide con el segundo número, y viceversa, la suma de
los divisores propios del segundo conicide con el primer número. Los
divisores propios de un número incluye el 1 y excluye el propio número*/
package t3_metodos;
import java.util.Scanner;

public class Ej14_NumsAmigos {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n1=teclado.nextInt();
        System.out.print("Introduce otro número: ");
        int n2= teclado.nextInt();
        
        int sumaDiv1=Matematica.sumaDivisores(n1)-n1;
        int sumaDiv2=Matematica.sumaDivisores(n2)-n2;
        if(sumaDiv1==n2 && sumaDiv2==n1){System.out.println(n1+" y "+n2+" son amigos");}
        else{System.out.println(n1+" y "+n2+" no son amigos");}
    }
}
