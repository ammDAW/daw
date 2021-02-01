import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 0;
  piezas = [];
  constructor(){
    const pieza1 = { //procesador
      nombre: "AMD Ryzen 5 3600",
      precio: 249.00,
      imagen: "https://thumb.pccomponentes.com/w-530-530/articles/21/213019/5-3.jpg",
      stock: true
    };

    const pieza2 = { //placa base
      nombre: "MSI B550i",
      precio: 179.00,
      imagen: "https://thumb.pccomponentes.com/w-530-530/articles/30/302204/1849-msi-b550-a-pro.jpg",
      stock: false
    };

    this.piezas.push(pieza1, pieza2);
  } //fin de constructor

  removeItem(item: string){
    //va a intentar eliminar un elemtno del array piezas
    console.log("Componente padre: el parámetro es "+ item);
    //this.piezas.shift();
  }
}//fin de clase