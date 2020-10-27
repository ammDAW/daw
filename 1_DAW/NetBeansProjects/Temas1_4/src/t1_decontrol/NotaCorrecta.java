//Comprobar y decir si una nota es correcta o incorrecta
package t1_decontrol;
import java.util.Scanner;

public class NotaCorrecta {
    public static void main(String[] args) {
        float nota;
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        System.out.print("Introduce una nota: ");
        cadena=teclado.nextLine();
        nota=Float.parseFloat(cadena);
        
        if(nota>=0 && nota<=10){System.out.println("Nota CORRECTA");}
        else{System.out.println("Nota INCORRECTA");}
    }    
}
