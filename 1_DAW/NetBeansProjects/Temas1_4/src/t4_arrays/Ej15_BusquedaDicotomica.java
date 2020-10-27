/*Utilizando el vector del Ejercicio 10, comprueba si un número entero
introducido por teclado se encuentra en el vector, utilizando el método de la 
búsqueda dicotómica*/
package t4_arrays;
import java.util.Scanner;

public class Ej15_BusquedaDicotomica {
    public static void main(String[] args) {
	Scanner teclado=new Scanner(System.in);
	String cadena;

	int v[]={12,4,5,78,45,67,45,66,77,44};
	int x;
	boolean encontrado=false;
	int izq=0;
	int der=11;
	System.out.print("Introduce el número que quieres buscar en la array: ");
	cadena=teclado.nextLine();
	x=Integer.parseInt(cadena);

	while (izq<=der){
            int cen=(izq+der)/2;
            if (v[cen]==x){encontrado=true;break;}
            else if (v[cen]<x){izq=cen+1;}
            else{der=cen-1;}
	}		
        if(encontrado=true){System.out.println("Tu número está en el array");}
	else if (encontrado=false){System.out.println("Tu número no está en el array");}
    } 
}
