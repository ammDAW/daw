
package paqCaja;

public class Ppal {

    public static void main(String[] args) {
        Caja cajita;
        cajita=new Caja();
        
        cajita.alto=9;
        cajita.ancho=12;
        cajita.profundo=3;
        
        Caja paco=new Caja();
        paco.alto=2;
        paco.ancho=3;
        paco.profundo=10;
        
        int volCajita=cajita.volumen();
        System.out.println("El volumen de cajita es "+volCajita);
        
        System.out.println("El volumen de paco "+paco.volumen());
        System.out.println("Alto de paco: "+paco.alto);
        
        paco.ancho=cajita.alto;
        System.out.println("Cajita alto-ancho-profundo");
        System.out.println(cajita.alto+"-"+cajita.ancho+"-"+cajita.profundo);
//inicializaValores
        Caja cajon=new Caja();
        cajon.inicializaValores(3,3,3);
        System.out.println("Cajon alto-ancho-profundo");
        System.out.println(cajon.alto+"-"+cajon.ancho+"-"+cajon.profundo);
//mostrarvalores    
        System.out.println("--Cajon--");
        cajon.mostrarValores();
        System.out.println("--Cajita--");
        cajita.mostrarValores();
//duplicaTamanyo()        
        cajon.duplicaTamanyo();
        System.out.println("--Cajon--");
        cajon.mostrarValores();
//devolver
        String cad=cajon.devolverAncho();
        System.out.println("Cajon cad "+cad);
    }       
}
