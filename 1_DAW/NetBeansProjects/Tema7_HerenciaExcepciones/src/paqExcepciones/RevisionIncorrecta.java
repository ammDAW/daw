
package paqExcepciones;

/**
 *
 * @author ALBERTO
 */
public class RevisionIncorrecta extends IllegalArgumentException{
    public RevisionIncorrecta(){
        super("ERROR: Revisión incorrecta");
    }
    
    public RevisionIncorrecta(String s){
        super(s);
    }
}
