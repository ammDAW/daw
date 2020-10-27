/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqCoche;

/**
 *
 * @author Profesor
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Coche cochecito=null;
      
      boolean cocheIncorrecto=true;
      while(cocheIncorrecto)
      {
        try{
          String marca=Pedir.frase("Dime la marca: ");
          String modelo=Pedir.frase("Dime el modelo: ");
          String color=Pedir.frase("Dime el color: ");
          String combustible=Pedir.frase("Dime el combustible: ");
          String tipoCambio=Pedir.frase("Dime el tipo de Cambio: ");
          int numPuertas=Pedir.entero("Dime el número de puertas: ");
          int precio=Pedir.entero("Dime el precio: ");
          cochecito=new Coche(marca,modelo,color,combustible,tipoCambio,numPuertas,precio);          
          System.out.println("Coche creado con éxito");  
          cocheIncorrecto=false;
        }catch(IllegalArgumentException ex){
          System.out.println(ex.getMessage());
        }
      }  
      
      System.out.println("Coche cochecito="+cochecito);
      
      
      Coche nuevo=new Coche();
      System.out.println("nuevo ="+nuevo);
        
       
      
      try{
          nuevo.setCombustible("DIASEL");
      }catch(IllegalArgumentException ex){
          System.out.println(ex.getMessage());
      }
     
      System.out.println(nuevo);//saldrá combustible=GASOLINA
      
      try{
          nuevo.setCambio("MANUEL");
      }catch(IllegalArgumentException ex){
          System.out.println(ex.getMessage());
      }
      
      System.out.println(nuevo);//saldrá cambio=MANUAL
      
      try{
          nuevo.setPrecio(-9000);
      }catch(IllegalArgumentException ex){
          System.out.println("El precio nunca puede ser negativo...");
      }
      
      System.out.println(nuevo);//saldrá precio=0
      
      
    }
    
}
