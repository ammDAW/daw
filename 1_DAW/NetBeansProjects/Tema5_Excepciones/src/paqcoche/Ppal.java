/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqCoche;

/**
 *
 * @author alumno
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coche cochecito=null;
        
        try{
            cochecito=new Coche("SEAT","ibiza","     blanco     ","DIsddfsESEL","manual", 3,200);
            System.out.println("Coche creado con éxito");
            System.out.println("Cochecito = "+cochecito);
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

        
        Coche nuevo=new Coche();
        System.out.println("Nuevo = "+nuevo);
        System.out.println(cochecito);
        
        try{
            nuevo.setCombustible("DIASEL");
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
 
    
}
