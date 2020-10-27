
package Clases;

public class Cadenas {
    public static String invertida(String cadena){
        String inver="";
        for(int i=cadena.length()-1;i>=0;i--){
            inver=inver+cadena.charAt(i);
        }
        return inver;
    }
    public static String cadenaSinSp(String cadena){
        String sin="";
        for(int i=0;i<cadena.length();i++){
            if(cadena.charAt(i)!=' ')sin=sin+cadena.charAt(i);
        }
        return sin;
    }
}
