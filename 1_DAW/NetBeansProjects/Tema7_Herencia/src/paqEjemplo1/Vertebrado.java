
package paqEjemplo1;

/**
 *
 * @author ALBERTO
 */
public class Vertebrado extends Animal{
    protected int numVertebras;
    //protected String nombre;
    
    //Usos de super:
        //1. super.propiedad --> indica que la propiedad está heredada
        //2. supèr.metodo --> indica que el método está heredado
        //3. super(**); --> llamada al constructor de la clase madre

//CONSTRUCTORES
    public Vertebrado(int numVertebras, String nombre) {
        super(nombre);//tambien se puede poner this.nombre=nombre;
        //super(nombre);
        //llama al constructor: Animal(String nombre)
        //siemrpe se llama a un constructor de la clase inmediatamente superior
        this.numVertebras = numVertebras;
    }
    
    public Vertebrado(int numVertebras){
        /*super();
        this.numVertebras=numVertebras;*/

        this(numVertebras,""); //llama a un constructore de la misma clase
    }
    
    public Vertebrado(int numVertebras, Animal a){
        super(a); //super debe ser la 1ª instruccion de un constructor
        this.numVertebras=numVertebras;
    }
    
    public Vertebrado(Vertebrado other){
        super(other.nombre);
        this.numVertebras=other.numVertebras;
        //this(other.numVertebras, other.nombre);
    }
//GETTER  
    public int getNumVertebras() {
        return numVertebras;
    }
//SETTER
    public void setNumVertebras(int numVertebras) {
        this.numVertebras = numVertebras;
    }
//TOSTRING
    @Override
    public String toString(){
        return '['+super.toString()+"\tNº Vertebras: "+numVertebras+']';
    }
    
      
}
