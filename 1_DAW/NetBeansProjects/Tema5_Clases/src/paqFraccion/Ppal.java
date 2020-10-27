
package paqFraccion;

public class Ppal {
    public static void main(String[] args) {
        Fraccion f=new Fraccion(25,7); System.out.println("f= "+f);
        Fraccion g=new Fraccion(); System.out.println("g= "+g);
        Fraccion h=new Fraccion(g); System.out.println("h= "+h);

        //fraccionSuma
        Fraccion j=f.fraccionSuma(g); System.out.println("\nj= "+j);
        Fraccion k=f.fraccionSuma(new Fraccion(5,g.getDen())); System.out.println("k= "+k);
                
        //fraccionResta
        Fraccion i=j.fraccionResta(g); System.out.println("\ni= "+i);
        Fraccion l=j.fraccionResta(1,2); System.out.println("l= "+l);
                
        //fraccionProducto
        Fraccion m=j.fraccionProducto(h); System.out.println("\nm= "+m);
        Fraccion n=j.fraccionProducto(2,3); System.out.println("n= "+n);
        
        //fraccionCociente
        Fraccion p=j.fraccionCociente(h); System.out.println("p= "+p);
        
        //Ejercicio 1: Calcular (h*j)/g+p)
        Fraccion ej1=new Fraccion(h.fraccionProducto(j).fraccionCociente(g.fraccionSuma(p)));
        System.out.println("\nEl resultado de calcular (h*j)/(g+p) es: "+ej1);
        
        //mcd (máximo común divisor)
        int mcd=Fraccion.mcd(12,6); System.out.println("El MCD de (12/6) es: "+mcd);
    }    
}
