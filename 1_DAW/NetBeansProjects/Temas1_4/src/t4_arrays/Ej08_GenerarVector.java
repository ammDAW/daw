/*Introducir un vector de 10 elementos de tipo entero por teclado. Generar 
a partir de éste, otro vector que contenga los valores de los elementos que 
ocupen las posiciones pares del primero (van desde el índice 1 hasta el 9). 
Mostrar el vector generado.*/
package t4_arrays;
import Clases.Vectores;


public class Ej08_GenerarVector {
    public static void main(String[] args) {
        //int v[]={23,34,45,56,67,78,89,99,12,99};
        int v[]=new int[10];
        v=Vectores.introducirVector(10);
        
        int w[]= new int[5];
        int j=0;
        for (int i=0; i<v.length;i++){
            if(i%2!=0){
                w[j]=v[i];j++; //tambien vale w[j++]=v[i];
            }
        }
        Vectores.mostrarVector(w);
        //for (j=0;j<w.length;j++){System.out.println(w[j]+"\t");}    
    }
}

