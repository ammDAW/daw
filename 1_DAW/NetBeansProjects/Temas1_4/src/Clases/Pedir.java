
package Clases;
import java.util.Scanner;

public class Pedir {
    public static int entero(String mensaje){
        Scanner teclado =new Scanner(System.in);
        String cadena;
        int n;
       
        System.out.print(mensaje);
        cadena=teclado.nextLine();
        n=Integer.parseInt(cadena);
        return n;
    } 
    
    public static double pedirDouble(String mensaje){
        Scanner teclado= new Scanner(System.in);
        String cadena;
        double n=0;
        boolean esDouble=false;
       
        while(esDouble==false){ //while(!esEntero)
            try{            
                System.out.print(mensaje);
                cadena=teclado.nextLine();
                n=Double.parseDouble(cadena);
                esDouble=true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error, no has introducido un número");
            }
        }
        return n;
    }
    public static String frase(String mensaje){
        Scanner teclado=new Scanner(System.in);
        System.out.print(mensaje);
        String cadena=teclado.nextLine();
        return cadena; 
    }           
}
