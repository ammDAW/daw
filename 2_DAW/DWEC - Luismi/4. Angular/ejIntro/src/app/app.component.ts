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
      stock: true
    };

    const pieza2 = { //placa base
      nombre: "MSI B550i",
      precio: 179.00,
      stock: false
    };
    this.piezas.push(pieza1, pieza2);
  } //fin de constructor
}//fin de clase