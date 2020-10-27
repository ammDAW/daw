//Muestra las tablas de multiplicar de los números 3 hasta el 7
package Tema3;

public class Ej10 {
    public static void main(String[] args) {
        int i=0;
        
        //WHILE
        while(i<=7){
            System.out.println("3*"+i+"="+3*i);
            i++;
        }
        
        //DO
        i=0;
        do{
            System.out.println("3*"+i+"="+3*i);
            i++;
        } while(i<=7);
        
        //FOR
        for(i=0;i<=7;i++){
            System.out.println("3*"+i+"="+3*i);
        }
    }    
}
