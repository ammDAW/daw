/*Se desea saber la nota de 15 alumnos y si alguna de ellas es un 10. Hay que
dejar de preguntar la nota de los alumnos cuando se llegue al límite de alumnos
o si encuentra algún 10*/
package t1_bucles;
import java.util.Scanner;

public class VariableFlag {
    public static void main(String[] args) {
        int nota; int i;
        boolean existe10=false; //variable flag
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        i=0;
        while(i<15 && existe10==false){
            System.out.print("Dime una nota: ");
            cadena=teclado.nextLine();
            nota=Integer.parseInt(cadena);
            if(nota==10){
                System.out.println("Hay un 10");
                existe10=true;
            }
            else{i++;}
        }
        if (i==15){System.out.println("No hay un 10");}       
        /*for(i=1;i<=15 && existe10==false;i++){
            System.out.print("Dime una nota: ");
            cadena=teclado.nextLine();
            nota=Integer.parseInt(cadena);
            if(nota==10){
                System.out.println("Hay un 10");
                existe10=true;
            }
        }
        if (i=16 && existe10==false){System.out.println("No hay un 10");}*/
    }           
}
