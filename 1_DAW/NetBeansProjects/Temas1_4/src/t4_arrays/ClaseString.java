
package t4_arrays;

public class ClaseString {
    public static void main(String[] args) {
        String nombre="Alberto Martinez";
        int longitud=nombre.length();
        System.out.println(nombre +" tiene "+longitud+" letras");
        
        char c=nombre.charAt(4);
        System.out.println("La 5ª letra de "+nombre+" es "+c);
        
        System.out.println("La ultima letra es "+nombre.charAt(nombre.length()-1));
        
        String n1="Juan", n2="Juan";
        if (n1.equals(n2)==true){ //devuelve un booleano. if(n1==n2)
            System.out.println("Iguales");
        }
        else System.out.println("Distintos");
        
        System.out.println(n1.compareTo(n2)); //devuelve un entero. Si es 0 son iguales
        //n1.compareToIgnoreCase(n2) igual que el anterior pero ignorando las mayusculas
        
        String p=String.valueOf(34);
        System.out.println(p);
    }
}
