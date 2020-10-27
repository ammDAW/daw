/*Declarar, crear e inicializar un vector de 17 elementos de tipo entero, 
los valores son: 7, 56,10,-23,0,9,-99,23,10,12,56,0,88,90,33,-2,28.
    a. Contar las veces que se repite el valor 10 dentro del vector.
    b. Contar cuántos elementos poseen valores nulos, positivos y negativos*/
package t4_arrays;

public class Ej03_ContarNumeros {
    public static void main(String[] args) {
        int vector[]={7,56,10,-23,0,9,-99,23,10,12,56,0,88,90,33,-2,28};
        int contar10=0, positivo=0, negativo=0, nulo=0;
        
        for(int i=0;i<vector.length;i++){
            if(vector[i]==10)contar10++;
            if(vector[i]>0)positivo++;
            else if(vector[i]<0)negativo++;
            else nulo++;
        }
        System.out.println("El número 10 se repite "+contar10+" veces");
        System.out.println("Hay "+positivo+" números positivos");
        System.out.println("Hay "+negativo+" números negativos");
        System.out.println("Hay "+nulo+" valores nulos");
    }
    
}
