/*En 'Terra Mítica' se desea saber cuántas personas han pasado en un día.
Deben de decir su edad conforme entren, si su edad es inferior a 4, la
entrada es gratis, si la edad está comprendida entre 4 años y 12 años
(incluídos), la entrada costará 20€, y si la edad supera a 12, la entrada
costará 40€. La taquilla se cerrará cuando la cajera introduzca una edad
igual a -1. Indicad, el número de niños con edades inferiores a 4 años, el
número de niños con edad comprendida entre 4 y 12 años, y adultos.
Indicad también el número total de personas que han entrado y la caja que
se ha hecho al final de la jornada*/
package t1_bucles;
import java.util.Scanner;

public class TerraMitica {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        int pTotal=0, edadMenor4=0, edadEntre=0, edadMayor12=0, edad=0, caja=0;
        
        /*se deberia de hacer preguntando la edad antes de entrar al bucle y
        despues dentro de él al final, despues de los if*/
        while(edad!=-1){
            System.out.print("Introduce la edad del visitante: ");
            cadena=teclado.nextLine();
            edad=Integer.parseInt(cadena);
            
            if(edad<4 && edad>-1){
                edadMenor4++;
                pTotal++;
            }
            else if(edad>=4 && edad<=12){
                edadEntre++;
                pTotal++;
                caja=caja+20;    
            }
            else if(edad>12){
                edadMayor12++;
                pTotal++;
                caja=caja+40;
            }
        }
        /*tmb se podrian hacer los calculos de caja y visitas totales al final:
        caja=edadEntre*20+edadMayor12*40
        pTotal=edadMenor4+edadEntre+edadMayor */
        System.out.println();
        System.out.println("Visitas totales= "+pTotal);
        System.out.println("Menores de 4 años= "+edadMenor4);
        System.out.println("Personas entre 4 y 12 años= "+edadEntre);
        System.out.println("Personas mayores de 12 años= "+edadMayor12);
        System.out.println("Caja total= "+caja);
    }  
}
