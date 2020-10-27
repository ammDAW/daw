//Calcular los segundos totales que hay en una hora introducida
package t1_secuenciales;
import java.util.Scanner;

public class Segundos {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int h;
        int m;
        int s;
        
        System.out.print("Introduce la cantidad de horas: ");
        cadena=teclado.nextLine();
        h=Integer.parseInt(cadena);
        //tambien se podria hacer h=Integer.parseInt(cadena)*3600;
                
        System.out.print("Introduce los minutos: ");
        cadena=teclado.nextLine();
        m=Integer.parseInt(cadena);
        
        System.out.print("Introduce los segundos: ");
        cadena=teclado.nextLine();
        s=Integer.parseInt(cadena);
        
        s=s+m*60+h*3600;
        System.out.println("La hora introducida son "+s+" segundos");        
    }   
}
