
package paqFiguraAbstracta;

/**
 *
 * @author ALBERTO
 */
public class Cuadrado extends Rectangulo{
    public Cuadrado(int lado){
        super(lado, lado);
    }
    
    @Override
    public void setAltura(int altura){
        this.base=this.altura=altura;   
    }
    
    @Override
    public void setBase(int altura){
        this.base=this.altura=altura;
    }
    
    @Override
    public String toString(){
        return"Cuadrado: "+this.base;
    }
    
    /*@Override
    public double area(){
        return 0;
    }*/
}
