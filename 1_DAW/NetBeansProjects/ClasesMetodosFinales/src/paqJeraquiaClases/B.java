
package paqJeraquiaClases;

/**
 *
 * @author ALBERTO
 */
public final class B extends A{//si una clase es final no se puede extender, es decir, no puede tener hijos
    private int y;
    public B(int y, int x){
        super(x);
        this.y=y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString()+" [y="+this.y+']';
    }    
}
