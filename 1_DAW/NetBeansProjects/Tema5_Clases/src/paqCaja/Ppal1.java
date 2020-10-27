
package paqCaja;

public class Ppal1 {
    public static void main(String[] args) {
        Caja cajita1 = new Caja();
        Caja paco1=new Caja();
        
        cajita1.alto=5;
        cajita1.ancho=2;
        cajita1.profundo=3;
        
        int y=cajita1.getAlto();
        
        paco1.setAncho(y);
        paco1.setAlto(paco1.getAncho()+cajita1.getProfundo());
        
        System.out.println(paco1.ancho);
        
        
        
    }
    
}
