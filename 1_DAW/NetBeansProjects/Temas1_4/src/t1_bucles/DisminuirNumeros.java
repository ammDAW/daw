//Mostrar desde el 50 hasta el 30 (disminuir) usando los tres tipos de bucles
package t1_bucles;

public class DisminuirNumeros {
    public static void main(String[] args) {
        int i;
        
        System.out.println("Bucle WHILE");
        i=50;
        while(i>=30){
            System.out.print(i+" ");
            i=i-1;
        }
        
        System.out.println(); //Para hacer un salto de linea
        System.out.println("Bucle DO");
        i=50;
        do{
            System.out.print(i+" ");
            i=i-1;
        } while(i>=30);
        
        System.out.println();
        System.out.println("Bucle FOR");
        for(i=50;i>=30;i=i-1){
            System.out.print(i+" ");
        }
    } 
}
