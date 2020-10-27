
package t4_arrays;
import java.util.Scanner;

public class PruebaUnidimensional {

    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        int notas[]=new int[10]; //declaramos que el array es de 20 casillas
        for(int i=0;i<10;i++){
            System.out.print("Introduce un valor: ");
            notas[i]=teclado.nextInt();
        }
        
        System.out.println("Mustra el valor del array ");
        for(int i=0;i<10;i++){
            System.out.print(notas[i]+" ");
        }
        //int ar[]={24,3,5,7}; así se declara un array dándole también valores
        //ar[3]=8; se le da el valor 8 a la posición 4 del array 

        String semana[]={"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        System.out.println("\n\nDías escolares:");
        for(int i=0;i<5;i++)System.out.print(semana[i]+" "); 
        
        System.out.println("\nTodos los días de la semana: ");
        for(int i=0;i<semana.length;i++)System.out.print(semana[i]+"\t");
        //for(int i=nombres.length-1;i>=0;i--) para hacerlo en orden inverso
    }  
}
