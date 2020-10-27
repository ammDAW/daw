
package paqClases;

/**
 *
 * @author ALBERTO
 */
public class Mamifero extends Animal{
    protected int numMamas=5;
    
    @Override
    public void reproducir(){
        System.out.println("MAMIFERO se reproduce");
    }
    
    public void getNumMamas(){
        System.out.println("MAMIFERO tiene "+this.numMamas+" mamas");;
    }
    
}
