
package t2_ejercicios;

public class EquivalenteASCII {
    public static void main(String[] args) {
        char letra;
        int x;
        String nombre, apellido;

        letra='A';
        System.out.println("El equivalente de 'A' en ASCII es "+(int)letra);
        //(int) es un cast, transformacion de un tipo a otro
        
        letra++; //letra='B';
        System.out.println("El equivalente de '"+letra+"' es "+(int)letra);
        
        x=97;
        System.out.println("El equivalente de 97 en carácter es '"+(char)x+"'");
        
        //SECUENCIAS DE ESCAPE
        nombre="Alberto";
        apellido="Martinez";
        // \" sale comillas; \t tabulador; \n salto de linea;
        System.out.println("El valor de nombre es: \""+nombre+"\"");
        System.out.println(nombre+"\t"+apellido);        
    }    
}
