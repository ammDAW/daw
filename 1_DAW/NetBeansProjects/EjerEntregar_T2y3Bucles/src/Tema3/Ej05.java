/*Encontrar el entero positivo más grande (num) para el cual la suma
1+2+3+4+5+....+num sea menor que límite (número entero introducido
por teclado)*/
package Tema3;
import java.util.Scanner;

public class Ej05 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int num, sum=0, i=1;
        
        System.out.print("Introduce un numero: ");
        cadena=teclado.nextLine();
        num=Integer.parseInt(cadena);
        
        //WHILE
        while(sum+i<num){
            sum+=i;
            i++;    
        }
        System.out.println(sum);
        
        //DO
        sum=0; i=1;
        do{
            sum+=i;
            i++;
        }while (sum+i<num);
        System.out.println(sum);
        
        //FOR
        sum=0;
        for(i=1;sum+i<num;i++){
            sum+=i;
        }
        System.out.println(sum);
    }  
}
