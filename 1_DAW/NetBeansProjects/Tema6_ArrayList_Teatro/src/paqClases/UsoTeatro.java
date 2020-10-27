/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqClases;

/**
 *
 * @author Profesor
 */
public class UsoTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion f1=new Funcion("Comedia sin título",15);
        Teatro romea=new Teatro("ROMEA");
        
        //añadir la función f1 al teatro romea
        romea.addFuncion(f1);
        
        System.out.println("Teatro :"+romea.toString());
        
        if (romea.contieneFuncion(f1)) System.out.println("Sí está");
        else System.out.println("NO está");
        
        romea.removeFuncion(f1);
        System.out.println(romea);
        
        
    }
    
}
