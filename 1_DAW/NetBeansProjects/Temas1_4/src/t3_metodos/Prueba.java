/*Diseña un metodo cuyo nombre es: "minino", tal que dados los valores enteros
guardados en variables, devuelva el valor de los dos*/
package t3_metodos;

public class Prueba {
    
    public static int minimo(int x, int y){
        int mn;
        if(x<y){mn=x;}
        else{mn=y;}
        return mn;
    }
    //int es tipo de entrada
    //minimo es nobreMetodo
    //int x,int y es datos de entrada
    //return mn es lo que devuelve
    
    public static void mostrarHolaMundo(int n){
        for(int i=1;i<=n;i++){System.out.println("Hola Mundo");}
    }
    //en un metodo void, no devuelve nada
    
    public static void main(String[] args) {
        int a=19, b=7;
        int c;
        c=Prueba.minimo(a,b);
        System.out.println("El menor es: "+c);
        System.out.println("El menor de 3 y 67 es "+Prueba.minimo(3,67));
    
        mostrarHolaMundo(4); //llamada al metodo que muestra "Hola Mundo"
    }
}
