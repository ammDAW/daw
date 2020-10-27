/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqClases;

import java.util.ArrayList;

/**
 *
 * @author Profesor
 */
public class UsoFunciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcion f1=new Funcion("El barbero de Sevilla",34);
        Funcion f2=new Funcion("El rey león",34.5);
        Funcion f3=new Funcion("El fantasma de la ópera",24.9);
        Funcion f4=new Funcion();
        Funcion f5=new Funcion(f1);
        
        System.out.println("Función 1="+f1);
        System.out.println("Función 2="+f2);
        System.out.println("Función 3="+f3);
        System.out.println("Función 4="+f4);
        System.out.println("Función 5="+f5);
        
        ArrayList <Funcion> funciones=new ArrayList();
        //añadir las funciones a la lista funciones
        funciones.add(f1);
        funciones.add(f2);
        funciones.add(f3);
        funciones.add(f4);
        funciones.add(f5);
        
        //Listado de FUNCIONES del arrayList funciones
        System.out.println("LISTADO ----- for");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        
        System.out.println("LISTADO ----- FOREACH");
        for(Funcion f: funciones)
            System.out.println(f);
        
        //Listado de los nombres de aquellas funciones cuyo precio sea inferior a 30
        System.out.println("LISTADO ----- for----nombre de funciones con precio >= 34");
        for(int i=0; i< funciones.size(); i++)
            if (funciones.get(i).getPrecio() >=34)
                System.out.println(funciones.get(i).getNombre());

        System.out.println("LISTADO ------------FOREACH");
        for(Funcion f: funciones)
            if (f.getPrecio()>=34)
                System.out.println(f.getNombre());
        /*
        //Borrar la función que contenga el precio 0.0
        for(int i=0; i<funciones.size(); i++)
            if (funciones.get(i).getPrecio() ==0)
                funciones.remove(i);
        
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
       */
        //Otra forma
        System.out.println("---BORRAR con REMOVE en un Bucle---");
        for(Funcion f : funciones)
            if (f.getPrecio()==0)
             funciones.remove(f);
                
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        
        
        //Comprueba si la funcion f1 está, si es así, la borra
        if (funciones.contains(f1))
            funciones.remove(f1);
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        
        
        //Comprobar si el array está vacío o no
        if (funciones.isEmpty())
            System.out.println("NO hay funciones");
        
        //Se cambia una función por otra (NUEVA, 78), la segunda
        funciones.set(1, new Funcion("NUEVA",78));
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        
        //En qué índice está la función: f2
        int p=funciones.indexOf(f2);
        if (p!=-1)
            System.out.println(f2+" está en la "+(p+1)+" posición");
        else 
            System.out.println("No existe "+f2+" en funciones");
        
       
        //Borrar todas las funciones
        funciones.clear();
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        
        f1.setPrecio(56);
        System.out.println("f1= "+f1);
        
        
        //La función f1 es El barbero de Sevilla con 56€
        funciones.add(new Funcion(f1));
        for(int i=0;i<funciones.size();i++)
            if (funciones.get(i).getNombre()=="El barbero de Sevilla"){
                funciones.get(i).setPrecio(0.0);                
            }
         
        System.out.println("COMPROBACIÓN-----");
        for(int i=0; i< funciones.size(); i++)
            System.out.println(funciones.get(i));
        

        System.out.println("f1="+f1);
        
        
   } 
}
