/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqCoche;

import java.util.Scanner;

/**
 *
 * @author Profesor
 */
public class Pedir {
    public static int entero(String mensaje)
    {
        Scanner teclado=new Scanner(System.in);
        String cadena;
        
        boolean es_entero=false;
        int n=0;
        
       while(!es_entero)
        {
          try{
             System.out.println(mensaje);
             cadena=teclado.nextLine();
             n=Integer.parseInt(cadena);
             es_entero=true;
          }
          catch(NumberFormatException ex)
          {
              System.out.println("Error, no es un número entero, vuelve a introducirlo ");
              
          }
        }
        return n;
    }
    
    
    public static float realCorto(String mensaje)
    {
        Scanner teclado=new Scanner(System.in);
       String cadena;
        
       boolean es_realCorto=false;
       float f=0.0f;
        
       while(!es_realCorto)
        {
          try{
             System.out.println(mensaje);
             cadena=teclado.nextLine();
             f=Float.parseFloat(cadena);
             es_realCorto=true;
          }
          catch(NumberFormatException ex)
          {
              System.out.println("Error, no es un número float, vuelve a introducirlo ");
              
          }
        }
        return f;
    }
    
    public static double realDoble(String mensaje)
    {
       Scanner teclado=new Scanner(System.in);
       String cadena;
        
       boolean es_realDoble=false;
       double d=0.0;
        
       while(!es_realDoble)
        {
          try{
             System.out.println(mensaje);
             cadena=teclado.nextLine();
             d=Double.parseDouble(cadena);
             es_realDoble=true;
          }
          catch(NumberFormatException ex)
          {
              System.out.println("Error, no es un número real doble, vuelve a introducirlo ");
              
          }
        }
        return d;
    }

    public static char caracter(String mensaje)
    {
       Scanner teclado=new Scanner(System.in);
       String cadena;
        
       char c;
             System.out.println(mensaje);
             cadena=teclado.nextLine();
             c=cadena.charAt(0);
       
        return c;
    }

    public static String frase(String mensaje)
    {
       Scanner teclado=new Scanner(System.in);
       String cadena;
        
       
             System.out.println(mensaje);
             cadena=teclado.nextLine();
       
       
        return cadena;
    }
    
    
    
}
