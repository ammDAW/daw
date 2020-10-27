//Muetra los 10 primeros números naturales (Del 0 al 10)
package t1_bucles;

public class PrimerosNum {
    public static void main(String[] args) {
        int i;
        
        System.out.println("BUCLE REPETIR-HASTA, HACER-MIENTRAS (DO)");
        i=0;        
        do{
            System.out.println(i);
            i=i+1;
        } while(i<10);
    
        System.out.println("BUCLE PARA, DESDE (FOR)");
        for(i=0;i<10;i=i+1){
            System.out.println(i);
        }
        
        System.out.println("BUCLE MIENTRAS (WHILE)");        
        i=0;        
        while(i<10){
            System.out.println(i);
            i=i+1;
        }
    }    
}
