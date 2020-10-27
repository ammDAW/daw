
package paqFamilia;

public class Familia {
    private String nombre;
    private int edad;
    private static String DIRECCION="Región de Murcia"; //con 'static' no se puede usar 'this', para llamarlo hay que usar el nombre de la clase
    //si ponemos 'final static', la propiedad sería constante, con lo cual no podría cambiar y el setDIRECCION ya no serviría

    public Familia(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
        //Familia.DIRECCION="Región de Murcia";
    }        

    @Override
    public String toString(){
        return "Nombre: "+nombre+", Edad: "+edad+", Dirección: "+Familia.DIRECCION;
    }
    
    //Getters
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public static String getDIRECCION(){ //darse cuenta de que este get tiene puesto 'static'
        return DIRECCION;
    }
    
    //Setters
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public static void setDIRECCION(String DIRECCION){
        Familia.DIRECCION = DIRECCION;
    }
    
}
