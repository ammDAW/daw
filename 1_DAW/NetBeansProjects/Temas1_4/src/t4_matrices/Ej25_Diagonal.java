//Sacar las diagonales de una matriz
package t4_matrices;

public class Ej25_Diagonal {
    public static void main(String[] args) {
        int m[][]={{7,14,24},{3,9,19},{32,22,25}};
        
        System.out.println("Diagonal Principal");
        for(int i=0;i<m.length;i++){
            System.out.println(m[i][i]);
        }
        
        System.out.println("Diagonal Inversa");
        for(int i=0;i<m.length;i++){
            System.out.println(m[i][(m.length-1)-i]);
        }
    }   
}
