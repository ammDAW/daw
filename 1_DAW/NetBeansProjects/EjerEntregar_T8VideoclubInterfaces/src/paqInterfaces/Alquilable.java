
package paqInterfaces;
import paqExcepciones.AlquilarException;

/**
 *
 * @author ALBERTO
 */
public interface Alquilable {
    void alquilar() throws AlquilarException;
    void devolver();
    boolean isAlquilado();
}
