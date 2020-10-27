/*Al introducir por teclado un valor, decir a que día de la semana correcponde.
En caso de no ser correcto(Menor que 1 o mayor que 7), decir que no es correcto
*/
package t1_alternativamultiple;
import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int dia;
        
        System.out.print("Introduce el día de la semana: ");
        cadena=teclado.nextLine();
        dia=Integer.parseInt(cadena);
        
        switch(dia){
            case 1: System.out.println("Lunes"); break;
            case 2: System.out.println("Martes"); break;
            case 3: System.out.println("Miércoles"); break;
            case 4: System.out.println("Jueves"); break;
            case 5: System.out.println("Viernes"); break;
            case 6: System.out.println("Sábado"); break;
            case 7: System.out.println("Domingo"); break;
            default: System.out.println("Día incorrecto");
        }
    }    
}
