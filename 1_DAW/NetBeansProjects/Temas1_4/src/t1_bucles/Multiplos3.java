package t1_bucles;

public class Multiplos3 {
    public static void main(String[] args) {
        int contador=0;
        int i;

//Escribir los múltiplos de 3 y contar cuantos hay comprendidos entre 24 y 45         
       for (i=24;i<=45;i++){
            if (i%3==0){
                System.out.println(i+" es múltiplo de 3");
                contador++;
            }
        }
        System.out.println("Hay "+contador+" múltiplos");

//Ecribir los 5 primeros múltiplos de 3 desde el 19 hasta 49;
        contador=0;
        for(i=19;i<=49 && contador<5;i++){
            if(i%3==0){
                System.out.println(i+" es múltiplo de 3");
                contador++;
            }
        }   
    }
}

