
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class IdiomaPeliculaException extends ProductosException{

    public IdiomaPeliculaException() {
        super("ERROR: El idioma de una película no está definido");
    }

    public IdiomaPeliculaException(String s) {
        super(s);
    }
   
}
