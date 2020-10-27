/*Calcular la ecuación de tercer grado: x3–4x2+x+6=0. Tiene tres soluciones
enteras en el intervalo [-10, 10]. Mostrar las soluciones por pantalla*/
package Tema3;

public class Ej16 {
    public static void main(String[] args) {        
        int x;
        //FOR
        for (x=-10; x<=10;x++){
            if(x*x*x-4*x*x+x+6==0){System.out.println("x="+x);}
        }
        
        //WHILE
        x=-10;
        while(x<=10){
            if(x*x*x-4*x*x+x+6==0){System.out.println("x="+x);}
            x++;
        }
        
        //DO
        x=-10;
        do{
           if(x*x*x-4*x*x+x+6==0){System.out.println("x="+x);}
           x++;
        } while(x<=10);
    }    
}
