
package paqHora;
import java.util.Scanner;

/**
 *
 * @author ALBERTO
 */
public class Ppal_Hora {
    
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        //int horas, minutos, segundos;
        Hora h1 = new Hora();
        Hora h2 = new Hora(23,25,48);
        Hora h3 = new Hora(4);
        Hora h4 = new Hora(h1.getH(),34);
        
        Hora h5 = new Hora();
        System.out.print("Introduzca una hora: ");
        h5.setH(teclado.nextInt());
        System.out.print("Introduzca los minutos: ");
        h5.setM(teclado.nextInt());
        System.out.print("Introduzca los segundos: ");
        h5.setS(teclado.nextInt());
        
        Hora h6 = new Hora(h4);
        Hora h7 = new Hora(h2.getH(),h3.getM(),h4.getH());
        Hora h8 = new Hora(h7.getH());
        Hora h9 = new Hora(Hora.addSegundos(h7,14));
                
        System.out.println("h1= "+h1);
        System.out.println("h2= "+h2);
        System.out.println("h3= "+h3);
        System.out.println("h4= "+h4);
        System.out.println("h5= "+h5);
        System.out.println("h6= "+h6);
        System.out.println("h7= "+h7);
        System.out.println("h8= "+h8);
        System.out.println("h9= "+h9);
        
        h8.setM(h7.getS());
        h7.setH(h6.getH()); h7.setM(14); h7.setS(h4.getS());
        h9 = new Hora(h4);
        h6 = new Hora(Hora.addSegundos(h4,h5.getS()));    
    }  
}
