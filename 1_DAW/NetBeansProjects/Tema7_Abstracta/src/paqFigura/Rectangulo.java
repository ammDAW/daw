
package paqFigura;

/**
 *
 * @author ALBERTO
 */
public class Rectangulo extends Figura{
    protected int base, altura;

    public Rectangulo(int base, int altura){
        this.base = base;
        this.altura = altura;
    }
//*GETTERS
    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }
//SETTERS
    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
//TOSTRING    
    @Override
    public String toString() {
        return "[base: " + base + "\taltura: " + altura + ']';
    }
    
    @Override
    public double area(){
        return this.base*this.altura;
    }
    
    @Override
    public double perimetro(){
        return 2*this.base+2*this.altura;
    }
}
