/*Introducir un vector de 10 elementos enteros por teclado.
    a. Mostrar cual es el menor de todos y la posición que ocupa.
    b. Mostrar cual es el mayor de todos y las veces que se repite*/
package t4_arrays;
import Clases.Pedir;
import Clases.Vectores;

public class Ej09_MayorMenor {
    public static void main(String[] args) {
        int vec[]=new int[10];
        for(int i=0;i<vec.length;i++){
            vec[i]=Pedir.entero("Dime un número entero: ");
        }
        int men=Vectores.menor(vec);
        System.out.println("Menor = "+men);
        int pos=Vectores.indiceDe(vec, men);
        System.out.println("Posición = "+pos);
        /*int mayor=vec[0], vecesMayor=1, menor=vec[0] ,pMenor=1;
        for(int i=1;i<vec.length;i++){
            if(vec[i]==mayor){vecesMayor++;}
            else if(vec[i]>mayor){mayor=vec[i];vecesMayor=1;}
            else if(vec[i]<menor){menor=vec[i];pMenor=i;}   
        }
        System.out.println("El mayor es "+mayor+" y se repite "+vecesMayor+" veces");
        System.out.println("El menor es "+menor+" y está en la posición "+pMenor);*/
        
    } 
}
