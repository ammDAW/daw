/*Diseña una clase donde se realice una validación de entrada de datos,
como por ejemplo, introduce un número que ha de estar comprendido
entre 1 y 12, rechazando los restantes, e indicar su correspondiente en
nombre de mes*/
package Tema3;
import java.util.Scanner;

public class Ej06 {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        int mes;
        
        //WHILE
        System.out.print("Introduce un numero del 1 al 12: ");
        cadena=teclado.nextLine();
        mes=Integer.parseInt(cadena);
        
        while(mes>=1 && mes<=12){
            switch(mes){
                case 1: System.out.println("Enero"); break;
                case 2: System.out.println("Febrero"); break;
                case 3: System.out.println("Marzo"); break;
                case 4: System.out.println("Abril"); break;
                case 5: System.out.println("Mayo"); break;
                case 6: System.out.println("Junio"); break;
                case 7: System.out.println("Julio"); break;
                case 8: System.out.println("Agosto"); break;
                case 9: System.out.println("Septiembre"); break;
                case 10: System.out.println("Octubre"); break;
                case 11: System.out.println("Noviembre"); break;
                case 12: System.out.println("Diciembre"); break;
            }
            System.out.print("Introduce otro numero: ");
            cadena=teclado.nextLine();
            mes=Integer.parseInt(cadena);
        }
        if(mes<1 || mes>12){System.out.println("Numero incorrecto");};
        
        //DO
        System.out.print("Introduce un numero del 1 al 12: ");
        cadena=teclado.nextLine();
        mes=Integer.parseInt(cadena);
        if(mes>=1 && mes<=12){
            do{
            
                switch(mes){
                    case 1: System.out.println("Enero"); break;
                    case 2: System.out.println("Febrero"); break;
                    case 3: System.out.println("Marzo"); break;
                    case 4: System.out.println("Abril"); break;
                    case 5: System.out.println("Mayo"); break;
                    case 6: System.out.println("Junio"); break;
                    case 7: System.out.println("Julio"); break;
                    case 8: System.out.println("Agosto"); break;
                    case 9: System.out.println("Septiembre"); break;
                    case 10: System.out.println("Octubre"); break;
                    case 11: System.out.println("Noviembre"); break;
                    case 12: System.out.println("Diciembre"); break;
                }
                System.out.print("Introduce otro numero: ");
                cadena=teclado.nextLine();
                mes=Integer.parseInt(cadena);
            }while(mes>=1 && mes<=12);
        }
        if(mes<1 || mes>12){System.out.println("Numero incorrecto");};
        
        //FOR
        System.out.print("Introduce un numero del 1 al 12: ");
        cadena=teclado.nextLine();
        mes=Integer.parseInt(cadena);
        
        for(;mes>=1 && mes<=12;){
            switch(mes){
                case 1: System.out.println("Enero"); break;
                case 2: System.out.println("Febrero"); break;
                case 3: System.out.println("Marzo"); break;
                case 4: System.out.println("Abril"); break;
                case 5: System.out.println("Mayo"); break;
                case 6: System.out.println("Junio"); break;
                case 7: System.out.println("Julio"); break;
                case 8: System.out.println("Agosto"); break;
                case 9: System.out.println("Septiembre"); break;
                case 10: System.out.println("Octubre"); break;
                case 11: System.out.println("Noviembre"); break;
                case 12: System.out.println("Diciembre"); break;
            }
            System.out.print("Introduce otro numero: ");
            cadena=teclado.nextLine();
            mes=Integer.parseInt(cadena);
        }
        if(mes<1 || mes>12){System.out.println("Numero incorrecto");};
    }   
}
