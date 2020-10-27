/*Introducir las notas de un grupo de alumnos. La introdución de las notas
finalizará cuando la nota sea -1. Se desea saber si hay algún 10 y la cantidad
total de alumnos*/
package t1_bucles;
import java.util.Scanner;

public class Saber10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        float nota=0; 
        int alumTotal=0;
        boolean hay10=false;
        
        //CON WHILE
        /*System.out.print("Dime la nota del alumno: ");
        cadena=teclado.nextLine();
        nota=Float.parseFloat(cadena);
        
        while(nota!=-1){
            alumTotal++;
            if(nota==10){
                hay10=true;
            }
            System.out.print("Dime la nota del alumno: ");
            cadena=teclado.nextLine();
            nota=Float.parseFloat(cadena);
        }*/
        
        //CON DO-WHILE
        do{
            System.out.print("Dime la nota del alumno: ");
            cadena=teclado.nextLine();
            nota=Float.parseFloat(cadena);
            if (nota!=-1){
                alumTotal++;
                if(nota==10){
                    hay10=true;
                }
            }              
        } while(nota!=-1);
        
        System.out.println("Alumnos totales= "+alumTotal);
        System.out.println("¿Hay un 10?");
        if(hay10==true){
            System.out.println("SI");
        }
        else{System.out.println("NO");}       
    }  
}
