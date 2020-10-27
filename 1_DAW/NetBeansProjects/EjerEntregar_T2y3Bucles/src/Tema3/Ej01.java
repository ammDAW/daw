/*Halla la suma de los pares comprendidos entre 50 y 500, muestra los
múltiplos de 3 y cuenta los múltiplos de 5. Hacedlo de 3 formas distintas
de for*/
package Tema3;

public class Ej01 {
    public static void main(String[] args) {
        //FORMA FOR 1
        int i, suma=0, multi5=0;
        for(i=50;i<=500;i+=2){
            suma+=i;
            if(i%3==0){System.out.println(i);}
            if(i%5==0){multi5++;}
        }
        System.out.println("La suma total de los pares es: "+suma);
        System.out.println("La cantidad de multiplos de 5 es: "+multi5);
        
        //FORMA FOR 2
        suma=0; i=50; multi5=0;
        for(;;){
            if(i>500) break;
            suma+=i;
            if(i%3==0){System.out.println(i);}
            if(i%5==0){multi5++;}
            i+=2;
        }
        System.out.println("La suma total de los pares es: "+suma);
        System.out.println("La cantidad de multiplos de 5 es: "+multi5);
        
        //FORMA FOR 3
        suma=0; i=50; multi5=0;
        for(;i<=500;i+=2){
            suma+=i;
            if(i%3==0){System.out.println(i);}
            if(i%5==0){multi5++;}
        }
        System.out.println("La suma total de los pares es: "+suma);
        System.out.println("La cantidad de multiplos de 5 es: "+multi5);
        
        //WHILE
        suma=0;i=50;multi5=0;
        while(i<=500){
            suma+=i;
            if(i%3==0){System.out.println(i);}
            if(i%5==0){multi5++;}
            i+=2;            
        }
        System.out.println("La suma total de los pares es: "+suma);
        System.out.println("La cantidad de multiplos de 5 es: "+multi5);
        
        //DO
        suma=0;i=50;multi5=0;
        do{
           if(i%3==0){System.out.println(i);}
           if(i%5==0){multi5++;}
           suma+=i;
           i+=2;
        } while (i<=500);
        System.out.println("La suma total de los pares es: "+suma);
        System.out.println("La cantidad de multiplos de 5 es: "+multi5);   
    }
}
