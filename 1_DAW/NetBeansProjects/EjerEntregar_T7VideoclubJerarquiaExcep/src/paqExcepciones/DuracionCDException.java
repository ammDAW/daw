
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class DuracionCDException extends DuracionProductosException{

    public DuracionCDException() {
        super("ERROR: La duracion de un CD no puede ser negativa o 0");
    }

    public DuracionCDException(String s) {
        super(s);
    }
    
}
