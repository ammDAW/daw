
package paqCirculo;

public class Circulo {
    private Punto centro;
    private int radio;

//-- CONTRUCTORES CON EXCEPCIONES --
    public Circulo(Punto centro, int radio) throws IllegalArgumentException{
        this.centro = centro;
        if(radio<0){
            IllegalArgumentException ex=new IllegalArgumentException("Error, el radio debe de ser POSITIVO");
            throw ex;
            //también podría ser:
            //throw new IllegalArgumentException("Error, el radio debe de ser POSITIVO");
        }
        this.radio = radio;
    }

    public Circulo() throws IllegalArgumentException{
        /*this.centro=new Punto();
        this.radio=0;*/
        this(new Punto(), 0);
    }
    
    public Circulo(int radio) throws IllegalArgumentException{
        this(new Punto(), radio);
    }
    
    public Circulo(int x, int y, int radio) throws IllegalArgumentException{
        this(new Punto(x,y), radio);
    }
    
    public Circulo(Circulo other) throws IllegalArgumentException{
        this(other.centro, other.radio);
        //this.centro=other.centro;
        //this.radio=other.radio;
    }
    
//-- TOSTRING --    
    @Override
    public String toString() {
        return "{" + "Centro:" + this.centro + "\tRadio:" + this.radio + '}';
    }
    
//-- GETTERS --
    public Punto getCentro() {
        return this.centro;
    }

    public int getRadio() {
        return this.radio;
    }
    
//-- SETTERS --
    public void setCentro(Punto centro) {
        this.centro = new Punto(centro);
    }

    public void setRadio(int radio) throws IllegalArgumentException{
        if (radio<0)
            throw new IllegalArgumentException("Error, radio negativo");
        this.radio = radio;
    }
    
    public void setCirculo(Punto centro, int radio) throws IllegalArgumentException {
        this.setCentro(centro);
        this.setRadio(radio);        
    }
    
    public void setCirculo(int x, int y, int radio) throws IllegalArgumentException {
        //this.setCentro(new Punto(x,y));
        //this.setRadio(radio);        
        this.setCirculo(new Punto(x,y), radio);
    }
    
//-- METODO EQUALS --   
    public boolean equals(Circulo other){
        return (this.centro.equals(other.centro) && this.radio==other.radio);
    }
    
    public boolean equals(Punto q, int radio){
        return (this.centro.equals(q) && this.radio==radio);
    }
    
    public boolean equals(int x, int y, int radio){
        return this.equals(new Punto(x,y), radio);
    }

//-- METODO DISTANCIA --   
    public double distancia(Circulo other){
        double d=this.centro.distancia(other.centro);
        return d;
    }
    
    public double distancia(Punto otherPunto){
        //return this.distancia(new Circulo(otherPunto,0));
        return this.centro.distancia(otherPunto);
    }
    
    public double distancia(int x, int y){
        return this.distancia(new Punto(x,y));
    }

//-- METODO AREA --
    public double area(){
        return Math.PI*this.radio*this.radio;
    }
    
//-- METODO LONGITUD --
    public double longitud(){
        return 2*Math.PI*this.radio;
    }

//-- METODO AMPLIACIRCULO --    
    public void ampliaCirculo(int cantidad) throws IllegalArgumentException{
        if(this.radio+cantidad<0)
            throw new IllegalArgumentException("Error, un círculo NO puede tener radio negativo");
        this.radio+=cantidad;
    }
}
