
package paqJeraquiaClases;

/**
 *
 * @author ALBERTO
 */
public class A {
    protected int x;
    public A(int x){this.x=x;}
    
    public int getX(){return this.x;}
    public void setX(int x){this.x=x;}

    @Override
    public String toString() {
        return "[x=" + this.x+']';
    }
//los metodos finales no se pueden sobreescribir en los hijos
    /*El método mostrar es final
    las clases
    */    
    public final void mostrar(){
        System.out.println("Clase final mostrar en A");
    }
}
