
package paqCaja;
    
public class Caja {
    //Miembros: Propiedades o Atributos o Variables
    
    //--public-- 
    /*el miembro (propiedad o método) se puede acceder desde cualquier
    clase dentro del mismo paquete y de todos los paquetes del proyecto
    #Propiedad-> su valor se peude ver desde cualquier punto del proyecto
    #Método-> se puede ejecutar desde cualquier punto del proyecto*/
    
    //Modificador de acceso: friendly, amigable o packkage
    /*la propiedad o el método es accesible desde cualquier punto dentro del
    mismo paquete*/
    
    //Modificador de acceso: private
    /*La propiedad o el método solo se puede utilizar dentro de la propia clase */
    public int alto; //private int alto
    int ancho;
    int profundo;
    
    //Miembros: Operaciones o Métodos o Funciones
    int volumen(){
        int v=alto*ancho*profundo;
        return v;
    }
    
    void inicializaValores(int nuevoAlto, int nuevoAncho, int nuevoProfundo){
        alto=nuevoAlto;
        ancho=nuevoAncho;
        profundo=nuevoProfundo;
    }
    
    void mostrarValores(){
        System.out.println(ancho+" "+alto+" "+profundo);
    }
    
    void duplicaTamanyo(){
        alto*=2;
        ancho=ancho*2;
        profundo*=2;
    }
    //hacer esto cuando se queire acceder a una propiedad para usarla en otra clase
    //cuando la propiedad es privada
    String devolverAncho(){
        return "Ancho= "+ancho;
    }
    //get para obtener
    int getAncho(){
        return ancho;
    }
    int getAlto(){
        return alto;
    }
    int getProfundo(){
        return ancho;
    }
    //set para cambiar
    void setAncho(int nuevoAncho){
        ancho=nuevoAncho;
    }
    void setAlto(int nuevoAlto){
        //setAlto(int alto){
        //this.alto=alto} --> el this hace referencia a la propiedad para diferenciarlo
        alto=nuevoAlto;
    }
    void setProfundo(int profundo){
        this.profundo=profundo;
    } 
    
}
