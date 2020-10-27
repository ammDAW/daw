
package paqVehiculo;

import paqExcepciones.KmsIncorrectos;
import paqExcepciones.PotenciaIncorrecta;
import paqExcepciones.PrecioIncorrecto;
import paqExcepciones.RevisionIncorrecta;
import paqVehiculo.VehiculoConMotor;
import paqVehiculo.Vehiculo;
import paqVehiculo.Moto;

/**
 *
 * @author ALBERTO
 */
public class Ppal {
    public static void main(String[] args) {
        Vehiculo v1=null;
        try{
            v1 = new Vehiculo(15);
        }catch(PrecioIncorrecto p){
            System.out.println(p.getMessage());
        }
        v1.setPrecio(7);
        
        VehiculoConMotor vm = null;
        try{ //poner los catch empezando por el más bajo nivel, es decir, del ultimo lugar de la jerarquía terminando en la madre
            vm = new VehiculoConMotor(-120,-7000);
        }catch(PotenciaIncorrecta ie){
            System.out.println(ie.getMessage());
            //vm = new VehiculoConMotor(0,0);
        }catch(PrecioIncorrecto pi){
            System.out.println(pi.getMessage());
        }catch(Exception ex){
            System.out.println("Error desconocido");
        }
        
        System.out.println("vm= "+vm);
        
        try{
            vm = new VehiculoConMotor(-120,7000);
        }catch(PotenciaIncorrecta | PrecioIncorrecto ie){
            System.out.println(ie.getMessage());
        }catch(Exception ex){
            System.out.println("Error desconocido");
        }
        
        Moto t=null;
        try{
            t=new Moto(2300,120,7000);
        }catch(KmsIncorrectos ki){
            System.out.println(ki.getMessage());
        }catch(RevisionIncorrecta | PotenciaIncorrecta | PrecioIncorrecto n){
            System.out.println(n.getMessage());
        }catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            //System.out.println("Error desconocido");
        }
        
    }
    
}
