
package t4_matrices;

public class Edificio {
    public static void main(String[] args) {
        int edificio[][]={{3,4,7},{1,2,3,5},{8,3,5,9,2}};

        /*int edificio[][]=new int[3][];
        int edificio[0]=new int[3];
        int edificio[1]=new int[4];
        int edificio[2]=new int[5];*/
        for(int planta=0; planta<edificio.length; planta++){
                System.out.println(" ");
            for(int piso=0; piso<edificio[planta].length; piso++){
		System.out.print(edificio[planta][piso]+" ");
            }
        }
    }  
}
