/*Método estático: betweenNandM al que se le pasan dos enteros y muestra todos
los números comprendidos entre ellos, inclusive*/
package t3_metodos;
import java.util.Scanner;

public class Ej06_NumComprendidos {
    public static void betweenNandM(int x,int y){
        while(x<=y){
            System.out.println(x);
            x++;
        }
    }
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n1=teclado.nextInt();
        System.out.print("Introduce otro número: ");
        int n2=teclado.nextInt();
        
        if(n1>n2){betweenNandM(n2,n1);}
        else if(n2>n1){betweenNandM(n1,n2);}
        else{System.out.println("Los números son iguales. Repita el programa");}
    }  
}
