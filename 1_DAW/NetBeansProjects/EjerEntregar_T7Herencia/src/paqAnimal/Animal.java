
package paqAnimal;
import paqFecha.Fecha;

/**
 *
 * @author ALBERTO
 */
public class Animal{
    protected int peso;
    protected Fecha fechaNac;

//CONSTRUCTORES    
    public Animal(int peso, int dia, int mes, int anyo) throws IllegalArgumentException{
        if (peso<0 || peso>5000)
            throw new IllegalArgumentException("Error. Peso inválido");
        
        this.peso = peso;
        this.fechaNac = new Fecha(dia,mes,anyo);
    }
    
    public Animal(int peso, Fecha f){
        this(peso,f.getDia(),f.getMes(),f.getYear());
    }
    
    public Animal(Animal a) throws IllegalArgumentException{
        this(a.peso,a.fechaNac);
    }
    
    public Animal(){
        this(0,new Fecha());
    }    
//GETTERS
    public int getPeso(){
        return peso;
    }

    public Fecha getFecha(){
        return fechaNac;
    }    
//SETTERS    
    public void setPeso(int peso)throws IllegalArgumentException{
        if (peso<0 || peso>5000)
            throw new IllegalArgumentException("Error. Peso inválido");
        this.peso = peso;
    }

    public void setFecha(Fecha f)throws IllegalArgumentException{
        if(f.getYear()>=1900 && (f.getMes()>=1 && f.getMes()<=12) && (f.getDia()>=1 && f.getDia()<=31))
            throw new IllegalArgumentException("Error en el formato de fecha");
        this.fechaNac = fechaNac;
    }
//TOSTRING
    @Override
    public String toString(){
        return "\tPeso: " + peso + "\tFechaNac: " + fechaNac.toString(2);
    }
    
}
