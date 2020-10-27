//Calcular el Indice de Masa Corporal (peso/altura^2)
package t1_secuenciales;
import java.util.Scanner;

public class IMC {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        float peso;
        float altura;
        float imc;
        
        System.out.print("Dime tu peso: ");
        cadena=teclado.nextLine();
        peso=Float.parseFloat(cadena);
        
        System.out.print("Dime tu altura: ");
        cadena=teclado.nextLine();
        altura=Float.parseFloat(cadena);
        
        imc=peso/(altura*altura);
        //imc=peso/Math.pow(altura,2);
        System.out.print("Tu IMC es "+imc);
    }    
}
