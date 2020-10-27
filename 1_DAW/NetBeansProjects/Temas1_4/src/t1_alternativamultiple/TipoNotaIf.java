/*Introducir una nota real por teclado. Se desea saber si es incorrecta, y en
caso de ser correcto, si el alumno está SUSPENSO(0-4'9), APROBADO(5-5'9), 
BIEN(6-7'9), NOTABLE(8-8'9) o SOBRESALIENTE (9-10)*/
package t1_alternativamultiple;
import java.util.Scanner;

public class TipoNotaIf {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        float nota;
        
        System.out.print("Introduce una nota: ");
        cadena=teclado.nextLine();
        nota=Float.parseFloat(cadena);
        
        if(nota>=0 && nota<=10){
            if(nota<5){System.out.println("SUSPENSO");}
            else if(nota<6){System.out.println("APROBADO");}
            else if(nota<8){System.out.println("BIEN");}
            else if(nota<9){System.out.println("NOTABLE");}
            else {System.out.println("SOBRESALIENTE");}
        }
        else {System.out.println("Nota incorrecta");}   
    }   
}
