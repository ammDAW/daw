
package t3_metodos;

public class Matematica {
    //Metodo hacer una suma de dos numero enteros
    public static int suma (int x, int y){
        int s=x+y;
        return s;
    }
    //Metodo numero de divisores de un numero entero
    public static int contarDivisores(int n){
        int contDivisores=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){contDivisores++;}
        }
        return contDivisores;
    }
    //Metodo saber divisores de un numero entero
    public static void divisores(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){System.out.println(i+" es divisor");}
        }
    }
    
    //Metodo saber suma divisores de un numero entero
    public static int sumaDivisores(int n){
        int suma=0;
        for (int i=1;i<=n;i++){
            if (n%i==0){suma+=i;}
        }
        return suma;
    }
    
    //Metodo calcular factorial de un numero entero
    public static long factorial(int n){
        long fact=1;
        for(int i=1;i<=n;i++){
            fact=(fact*i);
        }
        return fact;
    }
}
