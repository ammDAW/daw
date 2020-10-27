/*Diseñar una clase que pida por teclado 10 elementos de tipo real. Calcular la media
aritmética de todas las notas, y además indicar cuántas notas son superiores,
inferiores o iguales a la media*/
package t4_arrays;

import java.util.Scanner;

public class Ej04_MediaNotas {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        float notas[]=new float[10];
        float media=0; int sup=0,inf=0,igual=0; //float media=0.0f;
        
        for(int i=0;i<10;i++){
            System.out.print("Introduce una nota: ");
            cadena=teclado.nextLine();
            notas[i]=Float.parseFloat(cadena);
            //notas[i]=teclado.nextFloat(); meterlo usando comas en vez de puntos por culpa de NetBeans
            media+=notas[i];
        }
        media=media/10;
        for(int i=0;i<notas.length;i++){
            if(notas[i]>media)sup++;
            else if(notas[i]<media)inf++;
            else igual++;
        }
        System.out.println("La media de las notas es "+media);
        System.out.println("Nº notas por ENCIMA de la media: "+sup);
        System.out.println("Nº notas por DEBAJO de la media: "+inf);
        System.out.println("Nº notas IGUALES a la media: "+igual);
    }
}
