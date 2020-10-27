/*Utilizando el vector del Ejercicio 10, comprueba si un número entero
introducido por teclado se encuentra en el vector, utilizando el método de la 
búsqueda lineal*/
package t4_arrays;
import Clases.Pedir;
import Clases.Vectores;

public class Ej14_BusquedaLineal {
    public static void main(String[] args) {
        int v[]={12,4,5,78,45,67,45,66,77,44};
        int num=Pedir.entero("Introduzca un número entero: ");
        boolean existe=false;
        for (int i=0;i<v.length;i++){
            if(v[i]==num) {existe=true;break;}
        }
        System.out.println("El número"+(existe?" ":" NO ")+"está en el vector");
    } 
}
