
package Clases;

import java.util.Scanner;

public class Excepciones {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        String cadena;
        int n;
        boolean esEntero=false;
       
        while(esEntero==false){ //while(!esEntero)
            try{            
                System.out.print("Dime tu nota: ");
                cadena=teclado.nextLine();
                n=Integer.parseInt(cadena);
                System.out.println("Tu nota es: "+n);
                esEntero=true;
            }
            catch(NumberFormatException ex){
                System.out.println("Error, no has introducido un número entero");
            }
        }
        System.out.println("FIN DE PROGRAMA");
    }
}
