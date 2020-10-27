//Mostrar el abecedario en Mayusculas;
package t2_ejercicios;

public class Abecedario {
    public static void main(String[] args) {
        char x;
        for(x='A';x<='Z';x++){
            System.out.println(x);
            if(x=='N'){System.out.println("Ñ");}
        }
        
        //USANDO ASCII
        /*int y;
        for(y=65;y<=90;y=y+1){
            System.out.println((char)y);
            if (y==78){System.out.println("Ñ");}
        }*/       
    }
}
