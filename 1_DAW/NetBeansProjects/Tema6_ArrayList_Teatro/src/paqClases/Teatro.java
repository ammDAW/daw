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
public class Teatro {
    private String nombre;
    private ArrayList<Funcion> listaFunciones;

    public Teatro(String nombre) {
        this.nombre = nombre;
        this.listaFunciones=new ArrayList();
    }

    public Teatro(String nombre, ArrayList<Funcion> listaFunciones) {        
        this.nombre = nombre;
        this.listaFunciones = new ArrayList(listaFunciones);        
    }
    
    public Teatro(){
        this("");
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<Funcion> getListaFunciones() {
        return this.listaFunciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaFunciones(ArrayList<Funcion> listaFunciones) {
        this.listaFunciones = new ArrayList(listaFunciones);
    }
    
    @Override
    public String toString()
    {
        String cadena="\nNombre "+this.nombre;
        if (this.listaFunciones.isEmpty())
            cadena+="\n El teatro todavía no tiene funciones";
        else
        {
            cadena+="\n\n-----LISTADO DE FUNCIONES ----------";
            for(int i=0; i<this.listaFunciones.size(); i++)
                cadena+="\n"+this.listaFunciones.get(i);
        }
        
        return cadena;
    }
    
    public void addFuncion(Funcion f){
        this.listaFunciones.add(new Funcion(f));
    }
    
    public boolean contieneFuncion(Funcion f){
        
        boolean encontrado=false;
        for(Funcion g: this.listaFunciones)
            if (g.equals(f)) //Nombre y precio coinciden
            {
                encontrado=true;
                break;
            }
        return encontrado;
        /*
        if (this.listaFunciones.contains(f))
            return true;
        else
            return false;
        */
    }
    
    public void removeFuncion(Funcion f)throws IllegalArgumentException
    {
       boolean encontrado=false;
       for(int i=0;i<this.listaFunciones.size();i++)
          if (f.equals(this.listaFunciones.get(i)))
          {
              encontrado=true;
              this.listaFunciones.remove(i);
              break;
          }
        if (!encontrado) 
            throw new IllegalArgumentException("La función "+f+" no se puede eliminar, no existe");
    }
}
