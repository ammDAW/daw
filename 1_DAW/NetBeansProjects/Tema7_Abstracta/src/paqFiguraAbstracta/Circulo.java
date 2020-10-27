
package paqFiguraAbstracta;

import paqFigura.*;

/**
 *
 * @author ALBERTO
 */
public class Circulo extends Figura{
    protected int radio;
    
    public Circulo(int radio){
        this.radio=radio;
    }
    
    public int getRadio(){return this.radio;}
    public void setRadio(int radio){this.radio=radio;}
    
    @Override
    public String toString(){
        return "["+this.radio+"]";
    }
    
    @Override
    public double area(){
        return Math.PI*this.radio;
    }
    
    @Override
    public double perimetro(){
        return 2*(Math.PI*this.radio);
    }
}
