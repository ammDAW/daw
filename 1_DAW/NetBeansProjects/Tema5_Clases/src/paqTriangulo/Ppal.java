package paqTriangulo;

public class Ppal {
    public static void main(String[] args) {
        //Triangulo t1=new Triangulo(); crear el objeto trinagulo
        //Triangulo t2=new Triangulo(); crear el objeto triangulo
        Triangulo t1=new Triangulo(4,10); //crear el constructor
        Triangulo t2=new Triangulo(6,10);
        
        /*no es necesario porque al declarar el constructor se le meten los valores
        t1.inicializaTriangulo(4,10);
        t2.inicializaTriangulo(6, 10);*/
        
        //Mostrar triángulos
        System.out.println("Triángulo t1: "+t1.toString());
        System.out.println("Triángulo t2: "+t2); //llama automaticamente a toString alponerlo en un sout
        
        //Comparar triángulos
        if(t1.equals(t2)==true)
            System.out.println("Los triángulos t1 y t2 son iguales");
        else
            System.out.println("Los triángulos t1 y t2 NO son iguales");
        
        //Calcular perímetro del triángulo
        System.out.println("Perímetro de t1= "+t1.perimetro());
        
        //Calcular área del triángulo
        System.out.println("Area de t2= "+t2.area());
        
        //--METODOS SOBRECRGADOS--
        //cambiar valores
        t1.setTriangulo(23, 10);
        System.out.println("t1: "+t1);
        
        //diferenciar metodos
        t1.setTriangulo(t2);
        t1.setTriangulo(t2.getBase(),t2.getAltura());
        
        //comparar
        if (t2.equals(9,12)==true) System.out.println("(9,12)Son iguales");
        else System.out.println("(9,12)Son distintos");

     
        Triangulo t3=new Triangulo(9,3);
        Triangulo t4=new Triangulo(6);//constructor sobrecargado
        System.out.println("t3: "+t3);
        System.out.println("t4: "+t4);

    }
}
