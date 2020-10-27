//Comprobar si la nota del alumno introducida por teclado está aprobada o no
package t1_decontrol;
import java.util.Scanner;

public class NotaAprobada {
    public static void main(String[] args) {
        float nota;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        System.out.print("Introduce la nota del alumno: ");
        cadena=teclado.nextLine();
        nota=Float.parseFloat(cadena);
        
        if (nota>=5){
            System.out.println("¡¡APROBADO!!");
        }
        else{
            System.out.println("¡¡SUSPENSO!!");
        }
    }  
}
