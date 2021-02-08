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
    )
    
    this.piezas = accesoDatos.getDatos();
  } 

  removeItem(item: string){
    //va a intentar eliminar un elemtno del array piezas
    console.log("Componente padre: el parámetro es "+ item);
    //eliminar el elemento correcto a partir del nombre recibido
    this.piezas = this.piezas.filter(pieza => pieza == item)
  }
}//fin de clase