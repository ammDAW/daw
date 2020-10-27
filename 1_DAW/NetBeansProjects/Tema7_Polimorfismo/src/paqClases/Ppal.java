
package paqClases;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Animal culebra = new Animal();
        culebra.comer();
        culebra.dormir();
        culebra.reproducir();
      
        Mamifero ballena = new Mamifero();
        System.out.println("\n--Ballena(Mamífero)--");
        ballena.comer();
        ballena.dormir();
        ballena.reproducir();
        ballena.getNumMamas();
        
        Animal corona;
        corona=culebra;
        System.out.println("--Corona = Animal(culebra)--");
        corona.comer();
        corona.dormir();
        corona.reproducir();
        
        corona=ballena;
        System.out.println("\n--Corona = Mamífero(ballena)--");
        corona.comer();
        corona.dormir();
        corona.reproducir();
        //corona.getNumMamas no se puede porque corona no es un objeto de tipo mamifero
        
        Perro toby = new Perro();
        System.out.println("\n--Perro--");
        toby.comer();
        toby.dormir();
        toby.reproducir();
        toby.ladrar();
        toby.gruñir();
        
        corona=toby;
        System.out.println("\n--Corona = Perro(toby)");
        corona.comer();
        corona.dormir();
        corona.reproducir();
        //corona.ladrad() no se puede porque no es un objeto de tipo Perro

    }    
}
