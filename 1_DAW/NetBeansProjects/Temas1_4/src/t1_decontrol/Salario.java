/* Se desea realizar el algoritmo que resuelva el siguiente problema: Cálculo
del salario semanal de un empleado de una empresa, sabiendo que éste se
calcula en base a las horas semanales trabajadas y de acuerdo a un precio
especificado por cada hora. Si se pasa de 40 horas semanales, las horas
extraordinarias se pagarán a razón de 1.5 veces la hora ordinaria*/
package t1_decontrol;
import java.util.Scanner;

public class Salario {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int horas;
        float precio_horas;
        int horas_extras;
        double salario;
        
        System.out.print("Introduce las horas del trabajor: ");
        cadena=teclado.nextLine();
        horas=Integer.parseInt(cadena);
        System.out.print("Introduce el precio de las horas: ");
        cadena=teclado.nextLine();
        precio_horas=Float.parseFloat(cadena);
        
        if (horas>40) {
            horas_extras=horas-40;
            horas=40;
            salario=(horas*precio_horas)+(horas_extras*(precio_horas*1.5));
            System.out.println("El salario semanal es "+salario+"€");        
        }
        else {
            salario=horas*precio_horas;
            System.out.println("El salario semanal es "+salario+"€");
        }
    }    
}
