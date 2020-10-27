
package paqPersona;

public class Ppal {
    public static void main(String[] args) {
        Persona pepe=new Persona("Persona Sánchez",23234);
        System.out.println("Pepe = "+pepe);
        
        Persona rodri=new Persona("Rodrigo Arana",45457);
        System.out.println("Rodri = "+rodri);
        
        rodri.setNombre(pepe.getNombre());
        System.out.println("rodri = "+rodri);
    }
    
}
