import { Component } from '@angular/core';
import { AccesoDatosService } from './acceso-datos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 0;
  piezas;

  constructor(private accesoDatos: AccesoDatosService){
    setInterval( 
      () => {this.title = Math.floor(Math.random()*100)},
      2000
    );

    //this.piezas = accesoDatos.getDatos();
    accesoDatos.getDatos().subscribe(
      (data: any[])=>{
        this.piezas = data;
      }
    );
    //otra forma de hacerlo
    /*accesoDatos.getDatos().subscribe(function(data){
      this.piezas = data;  
    }*/
  } 

  removeItem(item: string){
    //va a intentar eliminar un elemento del array piezas
    console.log("Componente padre: el parámetro es "+ item);
    //eliminar el elemento correcto a partir del nombre recibido
    this.piezas = this.piezas.filter(pieza => pieza == item)
  }
}