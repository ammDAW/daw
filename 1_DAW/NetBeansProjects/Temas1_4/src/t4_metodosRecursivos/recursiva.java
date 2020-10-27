
package t4_metodosRecursivos;

public class recursiva {

    public static int fibonacci(int n){
        if(n==0)return 0;
        if(n==1) return 1;
        int suma=0,f0=0,f1=1;
        for(int i=2;i<=n;i++){
            suma=f0+f1;
            f0=f1;
            f1=suma;
        }
        return suma;      
    }
    
    public static int fibonacciR(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        return fibonacciR(n-2)+fibonacciR(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Fibonacci de 5 = "+fibonacci(5));
        System.out.println("FibonacciR de 5 = "+fibonacciR(5));
    }   
}
