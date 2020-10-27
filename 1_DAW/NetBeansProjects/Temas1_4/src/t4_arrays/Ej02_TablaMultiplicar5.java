/*Declarar y crear un vector de 10 elementos de tipo entero. Generar un vector que
almacene los valores de la tabla de multiplicar del 5. Mostrar los valores del array*/
package t4_arrays;

public class Ej02_TablaMultiplicar5 {
    public static void main(String[] args) {
        int tabla[]=new int[10];
        for(int i=0;i<10;i++){
            tabla[i]=5*(i+1);           
            System.out.println("5*"+(i+1)+"="+tabla[i]);
            //tambien se podría crear otra variable para no tener que estar sumando la i al dar los valores
        }
    }
    
}
