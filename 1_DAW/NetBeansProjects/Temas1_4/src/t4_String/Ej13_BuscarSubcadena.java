/*Partiendo de la cadena String "En mi proxima vida, creere en la reencarnacion"
declarada e inicializada como variable primitiva, mostrar por si se encuentra 
la subcadena "creere"*/
package t4_String;

public class Ej13_BuscarSubcadena {
    public static void main(String[] args) {
        String texto="En mi proxima vida, creere en la reencarnacion";
        String palabraBuscar="creere";
        
        if(texto.indexOf(palabraBuscar)==-1) System.out.println("'"+palabraBuscar+"' NO se encuentra en \""+texto+"\"");
        else System.out.println("'"+palabraBuscar+"' SI se encuentra en \""+texto+"\"");  
    }   
}
