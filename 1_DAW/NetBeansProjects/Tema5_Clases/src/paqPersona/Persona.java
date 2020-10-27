
package paqPersona;

public class Persona {
    private String nombre;
    private int nre;
    
    //Constructor
    public Persona(String nombre, int nre){
        this.nombre = nombre;
        this.nre = nre;
    }
    
    //Getter
    public String getNombre() {
        return nombre;
    }
    public int getNre() {
        return nre;
    }

    //Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNre(int nre) {
        this.nre = nre;
    }
    
    @Override
    public String toString(){
       return "Nombre: "+this.nombre+"\tNRE: "+this.nre;
    }
}
