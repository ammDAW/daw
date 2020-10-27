//Que escriba "Hola Mundo" 8 veces usando los 3 tipos de bucles
package t1_bucles;

public class HolaMundo {
    public static void main(String[] args) {
        int i;
        
        //Bucle Mientras
        i=1;
        while(i<=8){
            System.out.println("Hola Mundo "+i+"WHILE");
            i=i+1;
        }

        //Bucle Repetir
        i=1;
        do{
            System.out.println("Hola Mundo "+i+"DO");
            i=i+1;
        } while(i<=8);

        //Bucle Para/Desde
        for(i=1; i<=8; i=i+1){
            System.out.println("Hola Mundo "+i+"FOR");
        }
    }   
}
