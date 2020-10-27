/*Se desea diseñar un algoritmo tal que se introduzcan tres números enteros
que representen la hora, los minutos y los segundos. Se desea que
muestre cuál será la hora cuando haya transcurrido un segundo*/
package t1_alternativamultiple;
import java.util.Scanner;

public class Hora {
    public static void main(String[] args) {
       int s, m, h;
       Scanner teclado = new Scanner(System.in);
       String cadena;
       
        System.out.print("Escribe las horas: ");
        cadena=teclado.nextLine();
        h=Integer.parseInt(cadena);
        System.out.print("Escribe los minutos: ");
        cadena=teclado.nextLine();
        m=Integer.parseInt(cadena);
        System.out.print("Escribe los segundos: ");
        cadena=teclado.nextLine();
        s=Integer.parseInt(cadena);
        
        s++;
        if(s<=59){
            System.out.println(h+":"+m+":"+s);
        }
        else{
            s=0;
            m++;
            if(m<=59){
                System.out.println(h+":"+m+":"+s);
            }
            else{
                m=0;
                h++;
                if(h<=23){
                    System.out.println(h+":"+m+":"+s);
                }
                else{
                    h=0;
                    System.out.println(h+":"+m+":"+s);
                }
            }
        }   
    }  
}
