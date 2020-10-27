
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class NoMas50ProductosVideoclubException extends CapacidadArrayException{
    public NoMas50ProductosVideoclubException() {
        super("ERROR: El videoclub no puede tener más de 50 productos");
    }

    public NoMas50ProductosVideoclubException(String s) {
        super(s);
    }
    
}
