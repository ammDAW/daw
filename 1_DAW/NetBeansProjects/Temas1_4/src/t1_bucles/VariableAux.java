
package t1_bucles;
import java.util.Scanner;

public class VariableAux {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int n;
        int m;
        int aux;
        
        System.out.print("Escribe un numero entero: ");
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);
        
        System.out.print("Escribe otro numero para que te diga los numeros que hay entre ambos: ");
        cadena=teclado.nextLine();
        m=Integer.parseInt(cadena);
        
        if(n<m){
            aux=n;
            n=m;
            m=aux;
        }
        
        while(n>=m){
            System.out.println(n);
            n=n-1;
        }
    }   
}
