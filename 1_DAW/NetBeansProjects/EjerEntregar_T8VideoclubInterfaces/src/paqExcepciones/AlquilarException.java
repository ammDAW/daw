
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class AlquilarException extends VideoclubException{
    public AlquilarException() {
        super("ERROR: Al intentar alquilar un producto");
    }

    public AlquilarException(String s) {
        super(s);
    }
    
}
