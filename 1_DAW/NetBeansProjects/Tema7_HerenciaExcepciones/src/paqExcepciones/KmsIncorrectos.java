
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class KmsIncorrectos extends RevisionIncorrecta{
    public KmsIncorrectos(){
        super("ERROR: Kms incorrectos");
    }
    
    public KmsIncorrectos(String msj){
        super(msj);
    }
}
