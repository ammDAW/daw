/*Introduce una cantidad de dinero en euros menor que 100, indica la
forma de pagar es dinero con el menor número de billetes y monedas*/
package Tema3;
import java.util.Scanner;

public class Billetes_monedas {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int euros, bTotal=0, mTotal=0;
        int b50=0, b20=0, b10=0, b5=0, m2=0, m1=0;
        
        System.out.print("Introduce una cantidad entera de € menor que 100: ");
        cadena=teclado.nextLine();
        euros=Integer.parseInt(cadena);
        
        while(euros-50>=0){
            bTotal++;
            b50++;
            euros-=50;
        }
        while(euros-20>=0){
            bTotal++;
            b20++;
            euros-=20;
        }
        while(euros-10>=0){
            bTotal++;
            b10++;
            euros-=10;
        }
        while(euros-5>=0){
            bTotal++;
            b5++;
            euros-=5;
        }
        while(euros-2>=0){
            mTotal++;
            m2++;
            euros-=2;
        }
        while(euros-1>=0){
            mTotal++;
            m1++;
            euros-=1;
        }
        if(bTotal>0){
            System.out.println("BILLETES EN TOTAL: "+bTotal);
            if(b50>0){System.out.println(b50+" billetes de 50€");}
            if(b20>0){System.out.println(b20+" billetes de 20€");}
            if(b10>0){System.out.println(b10+" billetes de 10€");}
            if(b5>0){System.out.println(b5+" billetes de 5€");}
        }
        if(mTotal>0){
            System.out.println("MONEDAS EN TOTAL: "+mTotal);
            if(m2>0){System.out.println(m2+" monedas de 2€");}
            if(m1>0){System.out.println(m1+" monedas de 1€");}
        }  
    }  
}
