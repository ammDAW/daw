/*Se desea saber el valor de la suma de los 10 primeros numeros (del 1 al 10)
1+2+3...+10=55*/
package t1_bucles;

public class SumaTotal {
    public static void main(String[] args) {
        int suma=0;
        //int i; declaro la varible en el for
        
        for(int i=1;i<=10;i=i+1){
            suma=suma+i;
        }
        System.out.println("La suma total es "+suma);        
    }   
}
