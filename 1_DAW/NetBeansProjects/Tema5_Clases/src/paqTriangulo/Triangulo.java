package paqTriangulo;

public class Triangulo {
    private int base;
    private int altura;
    
    /*----CONSTRUCTOR----
        Cuando un objeto se creea necesita 'new'
        Public o package  -Lo normal es que el constructor sea público
        No tiene tipo de dato para devolver
        Nombre del método constructor es el mismo que el de la clase
    */
    public Triangulo(int base, int altura){ //este es el constructor
        this.base=base;
        this.altura=altura;
    }
    //da valores al triángulo
    /*public void inicializaTriangulo(int base, int altura){
        this.base=base;
        this.altura=altura;
    }*/
// Esto hay que hacerlo por base y altura son privados
    public int getBase(){
        return this.base;
    }
    public int getAltura(){
        return this.altura;
    }
    
    public void setBase(int base){
        this.base=base;
    }
    public void setAltura(int altura){
        this.altura=altura;
    }
    
    //metodo hipotenusa, privado que devuelve un double
    private double hipotenusa(){
        return Math.hypot(this.base, this.altura);
    }

    public String toString(){
        String cadena="Base = "+this.base+"\tAltura = "+this.altura+"\tHipotenusa = "+this.hipotenusa();
        return cadena;
    }
    
    public boolean equals(Triangulo other){
        if(this.base==other.base && this.altura==other.altura) return true;
        else return false;
    }
    
    public double perimetro(){
        return this.base+this.altura+this.hipotenusa();
    }
    
    public double area(){
        return (this.base*this.altura)/2.0;
    }
    
    //sustituye inicializaTriangulo, sirve para dar/cambiar valores
    public void setTriangulo(int base, int altura){
        this.base=base;
        this.altura=altura;
    }
    
    /*----METODOS SOBRECARGADOS----
        Son métodos que tiene el mismo nombre, devuelven el mismo tipo de dato de salida
        Diferencia: Datos de entrada (número, tio, etc.)
    */
    
    //Método: setTriangulo, cuyo dato de entrada sea otro Triangulo
    public void setTriangulo(Triangulo other){
        this.base=other.base;
        this.altura=other.altura;
    }
    
    //Metodo equals sobrecargado, se le dan 2 enteros la case y la altura
    public boolean equals(int base, int altura){
        if(this.base==base && this.altura==altura) return true;
        else return false;
    }
    
    //Los constructores también se peuden sobrecargar
    public Triangulo(int lado){
        this.base=lado;
        this.altura=lado;
    }
    
}
