
package t4_expRegulares;

public class prueba {
    public static void main(String[] args) {
        String texto="Mi tio Tomas quiere tomar cafe";
        
        String exp=".";
        if(texto.matches(".")) System.out.println("Tiene un carácter");
        else System.out.println("Tiene muchos caracteres");
        
        String texto2="i";
        if(texto2.matches("i")) System.out.println("Lo cumple");
        else System.out.println("No lo cumple");
        
        //.*i.* = 0 o más caracteres cualquiera antes de la i y pueden o no haber caracteres despues de la i
        if(texto.matches(".*i.*")) System.out.println("Lo cumple");
        else System.out.println("No lo cumple");
        
        String texto3="mi tio tomas quiere mate";
        //el interrogante indica si esa cadena está 0 o 1 vez
        if(texto.matches("mate?$")) System.out.println("Aparece");
        else System.out.println("No aparece");
        
        if(texto3.matches("^mi.*mate$")) System.out.println("Lo cumple");
        else System.out.println("No lo cumple");
        
        String fecha="^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        String dni="[0-9]{8}";
        
        if(!((dni.length()==10) && (dni.matches("^[0-9]{8}+-[ABCDEFGHIJJLMNOPQRSTUVWXYZ]$")) || (dni.length()==9) && (dni.matches("^[0-9]{8}[ABCDEFGHIJJLMNOPQRSTUVWXYZ]$"))))
            System.out.println("ERROR: Dni incorrecto");
    }
}
