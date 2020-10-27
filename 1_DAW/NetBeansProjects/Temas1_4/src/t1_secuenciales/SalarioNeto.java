/*Diseña un algoritmo que calcule el salario neto de un trabajador a partir de
la lectura del nombre, horas trabajadas, precio de la hora, y sabiendo que
los impuestos aplicables son el 10% sobre el salario bruto.*/
package t1_secuenciales;
import java.util.Scanner;

public class SalarioNeto {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        String nombre;
        int horas;
        float precio_horas;
        double sBruto;
        double sNeto;
        
        System.out.print("Nombre del trabajador: ");
        cadena=teclado.nextLine();
        nombre=cadena;
        System.out.print("Horas trabajadas: ");
        cadena=teclado.nextLine();
        horas=Integer.parseInt(cadena);
        System.out.print("Precio/hora: ");
        cadena=teclado.nextLine();
        precio_horas=Float.parseFloat(cadena);
        
        sBruto=horas*precio_horas;
        sNeto=sBruto-sBruto*0.1;
        
        System.out.println("El salario neto de "+nombre+" es de "+sNeto+"€");                          
    }   
}
