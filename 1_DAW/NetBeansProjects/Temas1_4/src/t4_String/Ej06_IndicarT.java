/*Dado el texto del ejercicio 4, indicar si está la ‘T’ (en mayúscula o minúscula), y las
posiciones que ocupan (es necesario utilizar un array)*/
package t4_String;

public class Ej06_IndicarT {
    public static void main(String[] args) {
        //String texto=Pedir.frase("Dme una frase: ");
        String texto="Mañana es sabado sabadete y voy a irme a tomar unas copillas por los barrios bajos de Logroño";
        String textoMy=texto.toUpperCase();
        int indX=textoMy.indexOf('T',0);
        int contT=0;
      
        while (indX != -1){
            contT++;
            System.out.println(indX);//muestra la posición
            indX=textoMy.indexOf('T',indX+1);
        }
      
        int arrayPosT[]=new int[contT];
        int j=0; //indice del array arrayPosT
        for(int i=0;i<textoMy.length();i++){
            if(textoMy.charAt(i)=='T') arrayPosT[j++]=(i+1);
        }
        
    }   
}