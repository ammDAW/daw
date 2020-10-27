
package paqFecha;

/**
 *
 * @author ALBERTO
 */
public class Fecha {
    private int dia, mes, year;
    private final int[] diasMeses = {31,28,31,30,31,30,31,31,30,31,30,31};
    private final String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

//-- CONSTRUCTORES --
    public Fecha(){
        this.dia=1; this.mes=1; this.year=1900;
    }
    public Fecha(int dia, int mes, int year) throws IllegalArgumentException{
        String strDia = String.valueOf(dia);
        if(!strDia.matches("^[1-9][0-9]{0,1}$"))
            throw new IllegalArgumentException("Error, error formato en el dia");
        
        if(dia>diasMeses[mes-1])
            throw new IllegalArgumentException("El día no corresponde con el mes");
        
        String strMes = String.valueOf(mes);
        if (strMes.length()>2)
            throw new IllegalArgumentException("Error en el formato de mes");
        
        String strYear = String.valueOf(year);
        if(!(strYear.length()==4))
            throw new IllegalArgumentException("Error en el formato del año");
        
        if(!fechaCorrecta(dia, mes, year))
            throw new IllegalArgumentException("Error, fecha Incorrecta"); 
        
        this.dia = dia;
        this.mes = mes;
        this.year = year;    
    }
    public Fecha(Fecha other){
        this.dia=other.dia;
        this.mes=other.mes;
        this.year=other.year;
    }
    
    /*public Fecha(Fecha other) throws IllegalArgumentException{
        String strDia = String.valueOf(other.dia);
        if(!strDia.matches("^[1-9][0-9]{0,1}$"))
            throw new IllegalArgumentException("Error, error formato en el dia");
        
        if(dia>diasMeses[mes-1])
            throw new IllegalArgumentException("El día no corresponde con el mes");
        
        String strMes = String.valueOf(other.mes);
        if (strMes.length()>2)
            throw new IllegalArgumentException("Error en el formato de mes");
        
        String strYear = String.valueOf(other.year);
        if(!(strYear.length()==4))
            throw new IllegalArgumentException("Error en el formato del año");
        
        if(!fechaCorrecta(other.dia, other.mes, other.year))
            throw new IllegalArgumentException("Error, fecha Incorrecta"); 
      
        this.dia = other.dia;
        this.mes = other.mes;
        this.year = other.year;

    }*/
        
//-- GETTERS --
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getYear() {
        return year;
    }
    
//-- SETTERS --
    public void setDia(int dia) {
        this.dia = dia;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
//-- TOSTRING --
    public String toString(int n) {
        String anyo=String.valueOf(year).substring(2);
        String dia=String.valueOf(this.dia);
        String mes=String.valueOf(this.mes);
        String cadena;
        if (dia.length()==1) dia="0"+dia;
        if (mes.length()==1) mes="0"+mes;
        switch(n){
            case 1: cadena=dia+"-"+mes+"-"+anyo; break;
            case 2: cadena=dia+"-"+mes+"-"+this.year; break;
            case 3: cadena=dia+"-"+nombresMeses[this.mes-1]+"-"+this.year; break;
            case 4: cadena=dia+" de "+nombresMeses[this.mes-1]+" de "+this.year; break;
            case 5: cadena=dia+"/"+mes+"/"+anyo; break;
            case 6: cadena=dia+"/"+mes+"/"+this.year; break;
            default: cadena="{Día: "+this.dia+"\tMes: "+this.mes+"\tAño: "+this.year+"}";
        }
        return cadena;
    }
    
//-- EQUALS --
    public boolean equals(Fecha f){
        return (this.dia==f.dia && this.mes==f.mes && this.year==f.year);
    }
    public boolean equals(int d, int m, int a){
        return (this.dia==d && this.mes==m && this.year==a);
    }

//-- OTROS METODOS --    
    private boolean fechaCorrecta(int d, int m, int a){
        return(a>=1900 && (m>=1 && m<=12) && (d>=1 && d<=31));
    }

    public boolean bisiesto(int a){
        return((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0)));        
    }
    
    public int toDias(){
        int dTotales=(this.year-1900)*365;
        while(this.year>1900){
            if(bisiesto(this.year)) dTotales++;
            this.year--;
        }
        for(int i=1;i<this.mes;i++){
            dTotales+=diasMeses[i-1];
        }
        dTotales+=(this.dia-1);
        return dTotales;
    }
    
    public Fecha fechaMayor(Fecha other){
        Fecha m = new Fecha(other);
        if(this.year>other.year){m.dia=this.dia;m.mes=this.mes;m.year=this.year;}
        else if(this.year==other.year){
            if(this.mes>other.mes){m.dia=this.dia;m.mes=this.mes;m.year=this.year;}
            else if(this.mes==other.mes){
                if(this.dia>other.dia){m.dia=this.dia;m.mes=this.mes;m.year=this.year;}
            }
        }        
        return m;
    }
    
    public Fecha fechaMenor(Fecha other){
        Fecha m = new Fecha(other);
        if(!this.equals(this.fechaMayor(other))){m.dia=this.dia;m.mes=this.mes;m.year=this.year;}
        return m;
    }
    
    public int diasEntreFechas (Fecha other){
        Fecha actual = new Fecha(this.dia,this.mes,this.year);
        Fecha mayor = actual.fechaMayor(other);
        Fecha menor = actual.fechaMenor(other);
        
        int dTotales=(mayor.year-menor.year)*365;
        while(mayor.year>=menor.year){
            if(bisiesto(mayor.year)) dTotales++;
            mayor.year--;
        }
        if (mayor.mes>menor.mes){
            for(int i=menor.mes;i<mayor.mes;i++)
                dTotales=diasMeses[i-1];
        }
        if (mayor.dia>menor.dia){
            dTotales+=(mayor.dia-menor.dia);
        }
        return dTotales;       
    }
//-- MODIFICACION FECHAS --    
    public void fechaSiguiente(){
        if(this.dia==31 && this.mes==12){this.dia=1;this.mes=1;this.year++;}
        else if(diasMeses[this.mes-1]>this.dia+1)this.dia++;
        else{this.dia=1;this.mes++;}
    }
    public void fechaAnterior(){
        if(this.dia==1 && this.mes==1){this.dia=31;this.mes=12;this.year--;}
        else if(this.dia==1){this.dia=31;this.mes--;}
        else{this.dia--;}
    }
}
