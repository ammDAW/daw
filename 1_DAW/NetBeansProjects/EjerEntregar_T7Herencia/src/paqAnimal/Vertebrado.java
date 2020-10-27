
package paqAnimal;
import paqFecha.Fecha;

/**
 *
 * @author ALBERTO
 */
public class Vertebrado extends Animal{
    protected int numVertebras;
    
//CONTRUCTORES
    public Vertebrado(int numv, int peso, int dia, int mes, int anyo) throws IllegalArgumentException{
        super(peso,dia,mes,anyo);
        if (numv<0 || numv>1000)
            throw new IllegalArgumentException("Error. Numero vertebras entre 0 y 1000");      
        this.numVertebras=numv;        
    }  
    
    public Vertebrado(int numv, int peso, Fecha f)throws IllegalArgumentException{
        super(peso,f);        
        if (numv<0 || numv>1000)
            throw new IllegalArgumentException("Error. Numero vertebras entre 0 y 1000");
        this.numVertebras=numv;
    }
    
    public Vertebrado (int numv, Animal a) throws IllegalArgumentException{
        super(a);        
        if (numv<0 || numv>1000)
            throw new IllegalArgumentException("Error. Numero vertebras entre 0 y 1000");       
        this.numVertebras=numv;
    }
    
    public Vertebrado(){
        super();
        this.numVertebras=0;
    }
    
//OTROS METODOS 
    public int getNumVertebras(){
        return numVertebras;
    }

    public void setNumVertebras(int numVertebras){
        this.numVertebras = numVertebras;
    }

    @Override
    public String toString(){
        return super.toString() + "\tNºVertebras: " + numVertebras;
    }

    
}
