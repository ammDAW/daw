
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class DuracionPeliculaException extends DuracionProductosException{

    public DuracionPeliculaException() {
        super("ERROR: La duración de una película no puede ser negativa o 0");
    }

    public DuracionPeliculaException(String s) {
        super(s);
    }
    
}
