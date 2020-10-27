
package paqFechaPrueba;

/**
 *
 * @author alumno
 */
public class Fecha {
    private int dia, mes, year;
    private final String nombreMes[]={"Enero","Febrero","Marzo","Abril","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    private static int diasMes[]={31,28,31};
    
    public Fecha(int dia, int mes, int year) throws IllegalArgumentException{
        String strDia = String.valueOf(dia);
        if(!strDia.matches("^[1-9][0-9]{0,1}$"))
            throw new IllegalArgumentException("Error, error formato en el dia");
        
        String strMes = String.valueOf(mes);
        if (strMes.length()>2)
            throw new IllegalArgumentException("Error en el formato de mes");
        
        String strYear = String.valueOf(year);
        if(!(strYear.length()==4))
            throw new IllegalArgumentException("Error en el formato del año");
        
        if(!Fecha.fechaCorrecta(dia, mes, year))
            throw new IllegalArgumentException("Error, fecha Incorrecta"); 
      
        this.dia = dia;
        this.mes = mes;
        this.year = year;    
    }

    private static boolean fechaCorrecta(int dia, int mes, int year){
        return true;
    }
    
    public String toString(int n) {
        String anyo=String.valueOf(year).substring(2);
        String dia=String.valueOf(this.dia);
        String mes=String.valueOf(this.mes);
        String cadena;
        if (dia.length()==1) dia="0"+dia;
        if (mes.length()==1) mes="0"+mes;
        switch(n){
            case 1: cadena=dia+"/"+mes+"/"+anyo; break;
            case 2: cadena=this.dia+ " de "+nombreMes[n-1]+" de "+this.year; break; //fecha.nombreMes[]
            case 3: cadena=this.dia+"/"+this.mes+"/"+this.year; break;
            default: cadena="Día: "+this.dia+"\tMes: "+this.mes+"\tAño: "+this.year; break;
        }
        return cadena;
    }  
}
