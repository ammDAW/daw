/*Introducir las notas de 10 alumnos, ¿cuántos aprobados hay, cuántos
suspensos? Especificar los porcentajes de aprobados y suspensos.
Además, muestra la nota media de todas las notas*/
package t1_bucles;
import java.util.Scanner;

public class AprobadosSuspensos {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int nota;
        int alumno;
        int nApro=0; int nSus=0;
        int porcentaje_Apro; int porcentaje_Sus;
        float media=0; //se usará como acumulatorio
        
        for(alumno=1;alumno<=10;alumno=alumno+1){
            System.out.print("Introduce la nota del alumno "+alumno+": ");
            cadena=teclado.nextLine();
            nota=Integer.parseInt(cadena);
            media=media+nota;
            
            if(nota>=5){
                nApro=nApro+1;
            }
            else{nSus=nSus+1;}
        }
        /*System.out.println("Número de aprobados: "+nApro);
        System.out.println("Número de suspensos: "+nSus);*/
        porcentaje_Apro=(nApro*100)/10; //10=numero total alumnos
        porcentaje_Sus=(nSus*100)/10;   //10=numero total alumnos
        System.out.println("Aprobados= "+porcentaje_Apro+"%");
        System.out.println("Suspensos= "+porcentaje_Sus+"%");
        
        media=media/10; //10.0f para hacer convertir 10 en float(real)
        System.out.println("La nota media de los 10 alumnos es: "+media);       
    }  
}
