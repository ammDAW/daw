/*Mostrar todos los pares comenzando con el 2 hasta el 20 usando 
los tres tipos de bucles*/
package t1_bucles;

public class Pares {
    public static void main(String[] args) {
        int i;
        
        System.out.println("Bucle WHILE");
        i=2;
        while(i<=20){
            System.out.println(i);
            i=i+2;
        }
        
        System.out.println("Bucle DO");
        i=2;
        do{
            System.out.println(i);
            i=i+2;
        } while(i<=20);
        
        System.out.println("Bucle FOR");
        for(i=2;i<=20;i=i+2){
            System.out.println(i);
        }
    }   
}
