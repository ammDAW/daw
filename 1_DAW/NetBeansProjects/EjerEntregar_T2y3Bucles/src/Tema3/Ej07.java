//Calcular el factorial de los 5 primeros números naturales
package Tema3;

public class Ej07 {
    public static void main(String[] args) {
        //FOR
        int i, fact=1;
        for(i=1;i<=5;i=i+1){
            fact=(fact*i);
        }
        System.out.println("El factorial es: "+fact);
        
        //WHILE
        i=1;fact=1;  
        while(i<=5){
            fact=(fact*i);
            i++;
        }
        System.out.println("El factorial es: "+fact);
        
        //DO
        i=1;fact=1;
        do{
            fact=(fact*i);
            i++;
        } while(i<=5);
        System.out.println("El factorial es: "+fact);
    }  
}
