
package paqFraccion;

public class Fraccion{
    private int num, den;
    
    //Constructor por defecto
    public Fraccion(){
        //this.num = this.den = 1;
        this(1,1);
    }
    //Contructores sobrecargados
    public Fraccion(int num, int den){ //patron
        this.num = num;
        this.den = den;
    }
    public Fraccion(Fraccion other){
        /*this.num=other.num;
        this.den=other.den;*/
        this(other.num,other.den);
    }
    
    //Método toString
    @Override
    public String toString(){
        return "("+num+" / "+den+")";
    }
    
    //Setters
    public void setNum(int num){
        this.num = num;
    }
    public void setDen(int den){
        this.den = den;
    }
    
    //Getters
    public int getNum(){
        return num;
    }
    public int getDen(){
        return den;
    }
    
    //Método patrón equals
    public boolean equals(Fraccion other){ //patrón
        return (this.num==other.num && this.den==other.den);
    }
    public boolean equals(int num, int den){ //sobrecargado
        return (this.num==num && this.den==den);
    }

    //Método fraccionSuma
    public Fraccion fraccionSuma(Fraccion other){ //patron
        Fraccion suma=new Fraccion();
        suma.num=this.num*other.den+this.den*other.num;
        suma.den=this.den*other.den;
        return suma;
    }
    public Fraccion fraccionSuma(int num, int den){ //sobrecargado
        /*Fraccion suma=new Fraccion(this.num*den+this.den*num, this.den*den);
        return suma;*/
        return this.fraccionSuma(new Fraccion(num,den));
    }
    
    //Método fraccionResta
    public Fraccion fraccionResta(Fraccion other){ //patron
        Fraccion resta=new Fraccion(this.num*den-this.den*num, this.den*den);
        return resta;
    }
    public Fraccion fraccionResta(int num, int den){ //sobrecagado
        return this.fraccionResta(new Fraccion(num, den));
    }

    //Método fraccionProducto
    public Fraccion fraccionProducto(int num, int den){ //patrón
        Fraccion pr=new Fraccion();
        pr.num=this.num*num;
        pr.den=this.den*den;
        return pr;
    }
    public Fraccion fraccionProducto(Fraccion other){ //sobrecargado
        return this.fraccionProducto(other.num, other.den);   
    }
    
    //Método fraccionCociente
    public Fraccion fraccionCociente(int num, int den){ //patrón
        Fraccion coc=new Fraccion();
        coc.num=this.num*den;
        coc.den=this.den*num;
        return coc;
    }
    public Fraccion fraccionCociente(Fraccion other){ //sobrecargado
        return this.fraccionCociente(other.num, other.den);
    }
    
    //En los métodos estaticos no se puede usar el this
    //Método mcd
    public static int mcd(int num, int den){ //patrón
        int mayor=(num>den)?num:den;
        int menor=(num<den)?num:den;
        int mc=0;
        for(int i=menor;i<mayor;i++){
            if(num%i==0 && den%i==0) mc=i;
        }
        return mc;
    }
    public static int mcd(Fraccion other){ //sobrecargado
        return Fraccion.mcd(other.num,other.den); //aquí se sustituye el this por el nombre de la clase, en este caso Fraccion
    }
        
}
