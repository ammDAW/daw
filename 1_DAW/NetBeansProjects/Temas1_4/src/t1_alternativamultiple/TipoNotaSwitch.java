/*Introducir por teclado una nota (valor entero), e indicar su correspondiente
en texto (suspenso, notable, etc)*/
package t1_alternativamultiple;
import java.util.Scanner;

public class TipoNotaSwitch {
    public static void main(String[] args) {
       Scanner teclado=new Scanner(System.in);
       String cadena;
       int nota;
       
        System.out.print("Introduce una nota entera: ");
        cadena=teclado.nextLine();
        nota=Integer.parseInt(cadena);
        
        switch(nota){
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: System.out.println("SUSPENSO");break;
            case 5: System.out.println("APROBADO");break;
            case 6: System.out.println("BIEN");break;
            case 7: 
            case 8: System.out.println("NOTABLE");break;
            case 9: 
            case 10:System.out.println("SOBRESALIENTE");break;    
            default:System.out.println("Nota incorrecta");
        }      
    }   
}
